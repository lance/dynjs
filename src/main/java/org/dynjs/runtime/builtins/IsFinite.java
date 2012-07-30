package org.dynjs.runtime.builtins;

import org.dynjs.api.Function;
import org.dynjs.runtime.DynThreadContext;

public class IsFinite implements Function {
    @Override
    public Object call(Object self, DynThreadContext context, Object... arguments) {
        if (arguments.length == 1) {        	
        	if (IsNaN.isNaN(arguments)) { return false; }
        	else { return true; }
        } else {
        	return DynThreadContext.UNDEFINED;
        }
    }

    @Override
    public String[] getParameters() {
        return new String[]{"a"};
    }
    
}
