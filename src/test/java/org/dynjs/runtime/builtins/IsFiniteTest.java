package org.dynjs.runtime.builtins;

import org.dynjs.runtime.AbstractDynJSTestSupport;
import org.dynjs.runtime.DynThreadContext;
import org.junit.Ignore;
import org.junit.Test;

public class IsFiniteTest extends AbstractDynJSTestSupport {

    @Test
    public void returnsTrueForNull() {
        check( "var result = isFinite(null);", true );
    }
    
    @Test
    public void returnsTrueForBooleanTrue() {
        check( "var result = isFinite(true);", true );
    }
    
    @Test
    public void returnsTrueForBooleanFalse() {
        check( "var result = isFinite(false);", true );
    }
    
    @Test
    public void returnsTrueForEmptyString() {
        check( "var result = isFinite('');", true );
    }

    @Test
    public void returnsTrueForWhiteSpaceString() {
        check( "var result = isFinite(' ');", true );
    }

    @Test
    public void returnsTrueForPositiveInteger() {
        check( "var result = isFinite(12);", true );
    }

    @Ignore
    public void returnsTrueNegativeInteger() {
    	// Until DYNJS-78 is implemented
        check( "var result = isFinite(-12);", true );
    }

    @Test
    public void returnsTrueForFloat() {
        check( "var result = isFinite(12.123);", true );
    }

    @Ignore
    public void returnsTrueForHexValue() {
    	// Until DYNJS-77 is implemented
        check( "var result = isFinite(0x16);", true );
    }

    @Test
    public void returnsFalseForCharacterString() {
        check( "var result = isFinite('abc');", false );
    }

    @Test
    public void returnsUndefinedWhenCalledWithMoreThanOneParameter() {
        check( "var result = isFinite('abc', 234);", DynThreadContext.UNDEFINED );
    }

    @Test
    public void returnsUndefinedWhenCalledWithZeroParameters() {
        check( "var result = isFinite();", DynThreadContext.UNDEFINED );
    }

    @Test
    public void returnsFalseWhenCalledWithNumberPositiveInfinity() {
        check( "var result = isFinite(Number.POSITIVE_INFINITY);", false );
    }

    @Test
    public void returnsFalseWhenCalledWithPositiveInfinity() {
        check( "var result = isFinite(Infinity);", false );
    }

    @Test
    public void returnsFalseWhenCalledWithNumberNegativeInfinity() {
        check( "var result = isFinite(Number.NEGATIVE_INFINITY);", false );
    }

    @Ignore
    public void returnsFalseWhenCalledWithNegativeInfinity() {
    	// Until DYNJS-78 is implemented
        check( "var result = isFinite(-Infinity);", false );
    }
    
}
