package test;

import base.TestBase;
import dto.ProcInfoResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.Map;

import static base.CustomLogger.step;
import static controllers.Controllers.getProc;

public class GetProcTest extends TestBase {

    @Test(groups = {"mock"})
    @Description("Проверка отчёта проверки правил контроля")
    public void checkProcTest() {
        step("Отправляем запрос GET /proc для получения отчёта проверки правил контроля");
        Map<String, ProcInfoResponse> response = getProc();

        assert response != null;
        softAssert.assertEquals(response.get("11728").getName(), "svchost.exe");
        softAssert.assertEquals(response.get("11728").getPath(), "C:\\Windows\\System32\\svchost.exe");
        softAssert.assertEquals(response.get("11728").getUser(), "NT AUTHORITY\\LOCAL SERVICE");
        softAssert.assertEquals(response.get("11728").getCreateTime().longValue(), 1627614234175L);
        softAssert.assertEquals(response.get("11728").getSession().intValue(), 0);

        softAssert.assertEquals(response.get("11820").getName(), "slack.exe");
        softAssert.assertEquals(response.get("11820").getPath(), "C:\\Users\\lei\\AppData\\Local\\slack\\app-4.18.0\\slack.exe");
        softAssert.assertEquals(response.get("11820").getUser(), "WSPAVELLK\\lei");
        softAssert.assertEquals(response.get("11820").getCreateTime().longValue(), 1627607459958L);
        softAssert.assertEquals(response.get("11820").getSession().intValue(), 2);

        softAssert.assertEquals(response.get("11940").getName(), "chrome.exe");
        softAssert.assertEquals(response.get("11940").getPath(), "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        softAssert.assertEquals(response.get("11940").getUser(), "WSPAVELLK\\lei");
        softAssert.assertEquals(response.get("11940").getCreateTime().longValue(), 1627618726418L);
        softAssert.assertEquals(response.get("11940").getSession().intValue(), 2);
    }
}
