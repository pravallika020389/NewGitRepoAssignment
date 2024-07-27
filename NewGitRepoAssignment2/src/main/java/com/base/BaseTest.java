package com.base;



import org.testng.annotations.BeforeSuite;

import com.utils.EnvironmentDetails;
import com.utils.TestDataUtils;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        EnvironmentDetails.loadProperties();
        TestDataUtils.loadProperties();
    }
}
