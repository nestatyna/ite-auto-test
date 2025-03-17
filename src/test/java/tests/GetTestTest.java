package tests;

import base.TestBase;
import dto.TestResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static base.CustomLogger.step;
import static controllers.Controllers.getTest;

public class GetTestTest extends TestBase {

    @Test
    @Issue("BUG-001")
    @Description("Получение общей информации о рабочем месте, версии агента, сведениях о системе и т.д.")
    public void checkTestTest() {
        step("Отправляем запрос GET /test на получение общей информации");
        TestResponse response = getTest();

        assert response != null;
        softAssert.assertEquals(response.getVpnUser(), "vpnuser");
        softAssert.assertEquals(response.getVpnVendor(), "CheckPoint");
        softAssert.assertEquals(response.getBiosManufacturer(), "American Megatrends Inc.");
        softAssert.assertEquals(response.getBiosReleaseDate(), "2018-04-11 00:00:00 +0000 UTC");
        softAssert.assertEquals(response.getBiosVersion(), "F24");
        softAssert.assertEquals(response.getCrc(), "3118122546");
        softAssert.assertTrue(response.getDebug());
        softAssert.assertEquals(response.getDomain(), "");
        softAssert.assertEquals(response.getFqdn(), "EGOR-OFFICE");
        softAssert.assertEquals(response.getHostId(), "e0fbafc5-ce68-4896-9526-7b3a7ed0e8f1");
        softAssert.assertEquals(response.getHostName(), "EGOR-OFFICE");
        softAssert.assertEquals(response.getHwUuid(), "032E02B4-0499-0521-3A06-C40700080009");
        softAssert.assertEquals(response.getInnerHostName(), "Egor-Office");
        softAssert.assertEquals(response.getIp1(), "172.17.112.1/20");
        softAssert.assertEquals(response.getIp10(), "fe80::c428:2e47:aeb6:751b/64");
        softAssert.assertEquals(response.getIp11(), "169.254.233.132/16");
        softAssert.assertEquals(response.getIp12(), "fe80::6835:866c:806a:e984/64");
        softAssert.assertEquals(response.getIp13(), "10.102.37.150/30");
        softAssert.assertEquals(response.getIp14(), "169.254.92.204/16");
        softAssert.assertEquals(response.getIp15(), "fe80::7004:6d4a:f465:5ccc/64");
        softAssert.assertEquals(response.getIp16(), "169.254.25.233/16");
        softAssert.assertEquals(response.getIp17(), "fe80::553:764f:ac5:19e9/64");
        softAssert.assertEquals(response.getIp18(), "192.168.147.1/24");
        softAssert.assertEquals(response.getIp19(), "fe80::9906:551c:828d:7644/64");
        softAssert.assertEquals(response.getIp2(), "fe80::7994:70f:463:8cfd/64");
        softAssert.assertEquals(response.getIp20(), "192.168.37.1/24");
        softAssert.assertEquals(response.getIp21(), "fe80::c593:bc2a:42a5:4f62/64");
        softAssert.assertEquals(response.getIp22(), "127.0.0.1/8");
        softAssert.assertEquals(response.getIp23(), "::1/128");
        softAssert.assertEquals(response.getIp3(), "192.168.88.226/24");
        softAssert.assertEquals(response.getIp4(), "fe80::6cf6:de2b:f16f:1bc3/64");
        softAssert.assertEquals(response.getIp5(), "169.254.3.191/16");
        softAssert.assertEquals(response.getIp6(), "fe80::6823:d6f2:3535:3bf/64");
        softAssert.assertEquals(response.getIp7(), "192.168.56.1/24");
        softAssert.assertEquals(response.getIp8(), "fe80::bc62:a2f7:6ce2:ed2a/64");
        softAssert.assertEquals(response.getIp9(), "169.254.117.27/16");
        softAssert.assertEquals(response.getMaintenanceMode(), "false");
        softAssert.assertEquals(response.getManufacturer(), "Gigabyte Technology Co., Ltd.");
        softAssert.assertEquals(response.getModel(), "H110M-H");
        softAssert.assertEquals(response.getModel(), "");
        softAssert.assertEquals(response.getOsArch().intValue(), 64);
        softAssert.assertEquals(response.getOsFamily(), "windows");
        softAssert.assertEquals(response.getOsPlatform(), "Microsoft Windows 10 Pro");
        softAssert.assertEquals(response.getOsVersion(), "10.0.19044 Build 19044");
        softAssert.assertEquals(response.getServerAddress(), "http://sak-tst-srv1:1325");
        softAssert.assertEquals(response.getServiceTag(), "Default string");
        softAssert.assertEquals(response.getTimezone(), "+07");
        softAssert.assertNull(response.getType());
        softAssert.assertEquals(response.getUptime(), "2024-01-10 09:58:00 +0000 UTC");
        softAssert.assertTrue(response.getUseStandalone());
        softAssert.assertEquals(response.getUserId(), "S-1-5-18");
        softAssert.assertEquals(response.getVersion(), "2.11.51");
        softAssert.assertEquals(response.getWorkingDir(), "C:\\Program Files (x86)\\sakura");

        softAssert.assertAll();
    }
}
