/**
 *  Copyright 2012 Douglas Campos, and individual contributors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.dynjs.parser.statement;

import me.qmx.jitescript.CodeBlock;
import org.antlr.runtime.tree.Tree;
import org.dynjs.compiler.DynJSCompiler;
import org.dynjs.parser.Statement;
import org.dynjs.runtime.RT;

import static me.qmx.jitescript.util.CodegenUtils.*;

public class OperationAssignmentStatement extends BaseStatement implements Statement {

    private final String operation;
    private final Statement l;
    private final Statement r;

    public OperationAssignmentStatement(final Tree tree, final String operation, final Statement l, final Statement r) {
        super(tree);
        this.operation = operation;
        this.l = l;
        this.r = r;
    }

    @Override
    public CodeBlock getCodeBlock() {
        final ResolveIdentifierStatement resolvable = (ResolveIdentifierStatement) l;
        return new CodeBlock() {{
            append(l.getCodeBlock());
            append(r.getCodeBlock());
            invokedynamic(operation, DynJSCompiler.Signatures.ARITY_2, RT.BOOTSTRAP, RT.BOOTSTRAP_ARGS);
            aload(DynJSCompiler.Arities.THIS);
            swap();
            ldc(resolvable.getName());
            swap();
            invokedynamic("dyn:setProp", sig(void.class, Object.class, Object.class, Object.class), RT.BOOTSTRAP, RT.BOOTSTRAP_ARGS);
        }};
    }
}
