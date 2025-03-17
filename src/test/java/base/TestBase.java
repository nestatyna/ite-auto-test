package base;

import mock.MockServer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

public class TestBase {

    public static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void setupMockServer(ITestResult testResult) {
        MockServer.start();
    }

    @AfterMethod
    public void stopMockServer() {
        MockServer.stop();
    }
}
