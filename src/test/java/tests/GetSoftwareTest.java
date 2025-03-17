package tests;

import base.TestBase;
import dto.SoftwareResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import java.util.List;

import static base.CustomLogger.step;
import static controllers.Controllers.getSoftware;
import static data.FilePath.SOFTWARE_PATH;
import static helpers.JsonHelper.readJsonArray;

public class GetSoftwareTest extends TestBase {

    @Test
    @Issue("BUG-005")
    @Description("Проверка получения информации о программном обеспечении рабочего места ")
    public void checkSoftwareTest() {
        step("Отправляем запрос GET /software");
        List<SoftwareResponse> response = getSoftware();
        assert response != null;

        step("Получаем данные информации о программном обеспечении рабочего места из источника");
        //В рамках тестового задания данный шаг заменяет получение данных настройки окружения/данных из БД и тп.
        List<SoftwareResponse> expectedResponse = readJsonArray(SOFTWARE_PATH, SoftwareResponse.class);

        step("Сравниваем полученные данные из запроса с данными из источника");
        for (int i = 0; i < response.size(); i++) {
            softAssert.assertEquals(response.get(i).getDisplayName(), expectedResponse.get(i).getDisplayName());
            softAssert.assertEquals(response.get(i).getDisplayVersion(), expectedResponse.get(i).getDisplayVersion());
            softAssert.assertEquals(response.get(i).getArch(), expectedResponse.get(i).getArch());
            softAssert.assertEquals(response.get(i).getPublisher(), expectedResponse.get(i).getPublisher());
            softAssert.assertEquals(response.get(i).getInstallDate(), expectedResponse.get(i).getInstallDate());
            softAssert.assertEquals(response.get(i).getEstimatedSize(), expectedResponse.get(i).getEstimatedSize());
            softAssert.assertEquals(response.get(i).getContact(), expectedResponse.get(i).getContact());
            softAssert.assertEquals(response.get(i).getHelpLink(), expectedResponse.get(i).getHelpLink());
            softAssert.assertEquals(response.get(i).getInstallSource(), expectedResponse.get(i).getInstallSource());
            softAssert.assertEquals(response.get(i).getVersionMajor(), expectedResponse.get(i).getVersionMajor());
            softAssert.assertEquals(response.get(i).getVersionMinor(), expectedResponse.get(i).getVersionMinor());

            softAssert.assertAll();
        }
    }
}
