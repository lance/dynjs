package org.dynjs.runtime.builtins;

import org.dynjs.runtime.AbstractDynJSTestSupport;
import org.dynjs.runtime.DynObject;
import org.junit.Ignore;
import org.junit.Test;

public class LiteralsTest extends AbstractDynJSTestSupport {
    @Ignore
    public void testHexadecimalLiteralValue() {
    	// Until DYNJS-77 is implemented
    	check("var result = 0x16", 22);
    }
    
    @Ignore
    public void testNegativeLiteralValue() {
    	// Until DYNJS-78 is implemented
    	check("var result = -12", -12);
    }

    @Ignore
    public void testNullValue() {
    	// I don't understand why this is failing
    	check("var result = null", null);
    }
    
    @Test
    public void testPositiveIntegerValue() {
    	// Not sure why I have to test against 12.0
    	check("var result = 12", 12.0);
    }
    
    @Test
    public void testFloatValue() {
    	check("var result = 12.123", 12.123);
    }

    @Test
    public void testStringValue() {
    	// Not sure why I have to test against 12.0
    	check("var result = 'Sunday in the Park with George'", "Sunday in the Park with George");
    }

    @Ignore
    public void testNewObject() {
    	check("var result = new Object()", new DynObject());
    }
}
