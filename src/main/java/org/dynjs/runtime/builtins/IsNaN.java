package org.dynjs.runtime.builtins;

import org.dynjs.api.Function;
import org.dynjs.runtime.DynThreadContext;

public class IsNaN implements Function {
    @Override
    public Object call(Object self, DynThreadContext context, Object... arguments) {
        if (arguments.length == 1) {
            return isNaN(arguments);
        }
        return DynThreadContext.UNDEFINED;
    }

    @Override
    public String[] getParameters() {
        return new String[]{"a"};
    }
    
	static boolean isNaN(Object... arguments) {
		if (isNullOrBooleanOrWhiteSpace(arguments[0].toString().trim())) { return false; }
		return (ParseInt.parseInt( arguments ).equals(Double.NaN));
	}

    private static boolean isNullOrBooleanOrWhiteSpace(String value) {
        return (value.equals( "" ) || value.equals("null") || value.equals( "true" ) || value.equals( "false" ) );
    }
}
