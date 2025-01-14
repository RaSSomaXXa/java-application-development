package com.acme.dbo.txlog.iteration03;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    //region given
    @Before
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @After
    public void tearDown() {
        resetOut();
    }
    //endregion

    /*

    @Test
    public void shouldLogIntegersArray() throws IOException {
        //region when
        Facade.log(new int[] {-1, 0, 1});
        //endregion

        //region then
        assertSysoutEquals(
                "primitives array: {-1, 0, 1}" + System.lineSeparator()
        );
        //endregion
    }


    @Test
    public void shouldLogIntegersMatrix() throws IOException {
        //region when
        Facade.log(new int[][] {{-1, 0, 1}, {1, 2, 3}, {-1, -2, -3}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives matrix: {" + System.lineSeparator() +
                "{-1, 0, 1}" + System.lineSeparator() +
                "{1, 2, 3}" + System.lineSeparator() +
                "{-1, -2, -3}" + System.lineSeparator() +
            "}" + System.lineSeparator()
        );
        //endregion
    }


    @Test
    public void shouldLogIntegersMulitidimentionalArray() throws IOException {
        //region when
        Facade.log(new int[][][][] {{{{0}}}});
        //endregion

        //region then
        assertSysoutEquals(
            "primitives multimatrix: {" + System.lineSeparator() +
                "{" + System.lineSeparator() + "{" + System.lineSeparator() + "{" + System.lineSeparator() +
                    "0" + System.lineSeparator() +
                "}" + System.lineSeparator() + "}" + System.lineSeparator() + "}" + System.lineSeparator() +
            "}" + System.lineSeparator()
        );
        //endregion
    }


    @Test
    public void shouldLogStringsWithOneMethodCall() throws IOException {
        //region when
        Facade.log("str1", "string 2", "str 3");
        //endregion

        //region then
        assertSysoutContains("str1" + System.lineSeparator() + "string 2" + System.lineSeparator() + "str 3");
        //endregion
    }

    @Test
    public void shouldLogIntegersWithOneMethodCall() throws IOException {
        //region when
        Facade.log(-1, 0, 1, 3);
        //endregion

        //region then
        assertSysoutContains("3");
        //endregion
    }



    @Test
    public void shouldCorrectDealWithIntegerOverflowWhenOneMethodCall() throws IOException {
        //region when
        Facade.log(1);
        Facade.log("str");
        Facade.log(Integer.MAX_VALUE - 10);
        Facade.flushInteger();
        Facade.log(11);
        Facade.flushInteger();
        //endregion

        //region then
        assertSysoutContains("1");
        assertSysoutContains("str");
        assertSysoutContains(String.valueOf(Objects.toString(Integer.MAX_VALUE - 10)));
        assertSysoutContains(String.valueOf("11"));
        //endregion
    }

     */

}
