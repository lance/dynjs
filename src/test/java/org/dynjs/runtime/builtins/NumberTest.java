package org.dynjs.runtime.builtins;

import org.dynjs.runtime.AbstractDynJSTestSupport;
import org.junit.Ignore;
import org.junit.Test;

public class NumberTest extends AbstractDynJSTestSupport {
    @Ignore
    public void testNumberAsFunction() {
    	check("var result = Number(22)", 22);
    }
    
    @Ignore
    public void testNumberAsFunctionWithoutParameters() {
    	check("var result = Number()", 0);
    }
    
    @Test
    public void testNumberNaN() {
    	check("var result = Number.NaN", Double.NaN);
    }
    
    @Test
    public void testNumberPositiveInfinity() {
    	check("var result = Number.POSITIVE_INFINITY", Double.POSITIVE_INFINITY);
    }
    
    @Test
    public void testNumberNegativeInfinity() {
    	check("var result = Number.NEGATIVE_INFINITY", Double.NEGATIVE_INFINITY);
    }
    
}
