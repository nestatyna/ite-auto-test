package test;

import base.TestBase;
import dto.ScreenshotsResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static base.CustomLogger.step;
import static controllers.Controllers.getScreenshots;
import static data.FilePath.SCREENSHOTS_PATH;
import static helpers.JsonHelper.readJsonObject;

public class GetScreenshotsTest extends TestBase {

    @Test(groups = {"mock"})
    @Description("Проверка сбора скриншотов всех экранов")
    public void checkScreenshotsTest() {
        step("Отправляем запрос GET /screenshots для получения данных списка текущих сессий");
        ScreenshotsResponse response = getScreenshots();
        assert response != null;

        step("Получаем данные информации о программном обеспечении рабочего места из источника");
        //В рамках тестового задания данный шаг заменяет получение данных настройки окружения/данных из БД и тп.
        ScreenshotsResponse expectedResponse = readJsonObject(SCREENSHOTS_PATH, ScreenshotsResponse.class);

        step("Сравниваем полученные данные из запроса с данными из источника");
        softAssert.assertEquals(response.getTaskGuid(), expectedResponse.getTaskGuid());
        softAssert.assertEquals(response.getSessionId(), expectedResponse.getSessionId());
        softAssert.assertEquals(response.getFilesCount(), expectedResponse.getFilesCount());

        softAssert.assertEquals(response.getFiles().get(0).getName(), expectedResponse.getFiles().get(0).getName());
        softAssert.assertEquals(response.getFiles().get(0).getFile(), expectedResponse.getFiles().get(0).getFile());

        softAssert.assertAll();
    }
}
