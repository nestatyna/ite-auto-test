package test;

import base.TestBase;
import dto.SessionResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static base.CustomLogger.step;
import static controllers.Controllers.getSessions;
import static data.FilePath.SESSION_PATH;
import static helpers.JsonHelper.readJsonArray;

public class GetSessionTest extends TestBase {

    @Test(groups = {"mock"})
    @Description("Проверка данных списка текущих сессий")
    public void checkSessionTest() {
        step("Отправляем запрос GET /sessions для получения данных списка текущих сессий");
        List<SessionResponse> response = getSessions();
        assert response != null;

        step("Получаем данные информации о программном обеспечении рабочего места из источника");
        //В рамках тестового задания данный шаг заменяет получение данных настройки окружения/данных из БД и тп.
        List<SessionResponse> expectedResponse = readJsonArray(SESSION_PATH, SessionResponse.class);

        step("Сравниваем полученные данные из запроса с данными из источника");
        for (int i = 0; i < response.size(); i ++) {
            softAssert.assertEquals(response.get(i).getUsername(), expectedResponse.get(i).getUsername());
            softAssert.assertEquals(response.get(i).getDomain(), expectedResponse.get(i).getDomain());
            softAssert.assertEquals(response.get(i).getIsLocal(), expectedResponse.get(i).getIsLocal());
            softAssert.assertEquals(response.get(i).getIsAdmin(), expectedResponse.get(i).getIsAdmin());
            softAssert.assertEquals(response.get(i).getLogonType(), expectedResponse.get(i).getLogonType());
            softAssert.assertEquals(response.get(i).getLogonTime(), expectedResponse.get(i).getLogonTime());
            softAssert.assertEquals(response.get(i).getDnsDomainName(), expectedResponse.get(i).getDnsDomainName());
            softAssert.assertEquals(response.get(i).getSession(), expectedResponse.get(i).getSession());
            softAssert.assertEquals(response.get(i).getSid(), expectedResponse.get(i).getSid());
            softAssert.assertEquals(response.get(i).getState(), expectedResponse.get(i).getState());
            softAssert.assertEquals(response.get(i).getHostcon(), expectedResponse.get(i).getHostcon());
            softAssert.assertEquals(response.get(i).getActivityId(), expectedResponse.get(i).getActivityId());
            softAssert.assertEquals(response.get(i).getConnectionName(), expectedResponse.get(i).getConnectionName());
            softAssert.assertEquals(response.get(i).getClientIp().getIP(), expectedResponse.get(i).getClientIp().getIP());
            softAssert.assertEquals(response.get(i).getClientIp().getPort(), expectedResponse.get(i).getClientIp().getPort());


            softAssert.assertAll();
        }
    }
}
