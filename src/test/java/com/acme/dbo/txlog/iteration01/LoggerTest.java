package com.acme.dbo.txlog.iteration01;

import com.acme.dbo.txlog.Facade;
import com.acme.dbo.txlog.SysoutCaptureAndAssertionAbility;
import com.acme.dbo.txlog.service.LogOperationException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void shouldLogInteger() throws IOException, LogOperationException{
        //region when
        Facade.log(1);
        Facade.flush();
        Facade.log(0);
        Facade.flush();
        Facade.log(-1);
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutEquals("primitive: 1" + System.lineSeparator() + "primitive: 0" + System.lineSeparator() + "primitive: -1" + System.lineSeparator());
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException, LogOperationException{
        //region when
        Facade.log((byte)1);
        Facade.flush();
        Facade.log((byte)0);
        Facade.flush();
        Facade.log((byte)-1);
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }

    @Test
    public void shouldLogChar() throws IOException, LogOperationException {
        //region when
        Facade.log('a');
        Facade.fullflush();
        Facade.log('b');
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("char: ");
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }


    @Test
    public void shouldLogString() throws IOException, LogOperationException {
        //region when
        Facade.log("test string 1");
        Facade.flush();
        Facade.log("other str");
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("string: ");
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }


    @Test
    public void shouldLogBoolean() throws IOException, LogOperationException {
        //region when
        Facade.log(true);
        Facade.flush();
        Facade.log(false);
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("primitive: ");
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }


    @Test
    public void shouldLogReference() throws IOException, LogOperationException {
        //region when
        Facade.log(new Object());
        Facade.fullflush();
        //endregion

        //region then
        assertSysoutContains("reference: ");
        assertSysoutContains("@");
        //endregion
    }


    @Test
    public void exceptionTest() throws LogOperationException {
        Facade.log(null);
    }

}