package com.jpetstore.tests;

import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void setUpTest() {
        System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/windows/msedgedriver.exe");
    }

    @After
    public void tearDown() {
        System.clearProperty("webdriver.edge.driver");
    }
}
