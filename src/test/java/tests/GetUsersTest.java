package tests;

import base.TestBase;
import dto.UsersResponse;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.util.List;

import static base.CustomLogger.step;
import static controllers.Controllers.getUsers;
import static data.FilePath.USERS_PATH;
import static helpers.JsonHelper.readJsonArray;

public class GetUsersTest extends TestBase {

    @Test
    @Description("Проверка получения списка локальных пользователей РМ")
    public void checkUsersTest() {
        step("Отправляем запрос GET /users");
        List<UsersResponse> response = getUsers();
        assert response != null;

        step("Получаем список локальных пользователей РМ из источника");
        //В рамках тестового задания данный шаг заменяет получение данных настройки окружения/данных из БД и тп.
        List<UsersResponse> expectedResponse = readJsonArray(USERS_PATH, UsersResponse.class);

        step("Сравниваем полученные данные из запроса с данными из источника");
        for (int i = 0; i < response.size(); i++) {
            softAssert.assertEquals(response.get(i).getUsername(), expectedResponse.get(i).getUsername());
            softAssert.assertEquals(response.get(i).getFullName(), expectedResponse.get(i).getFullName());
            softAssert.assertEquals(response.get(i).getIsEnabled(), expectedResponse.get(i).getIsEnabled());
            softAssert.assertEquals(response.get(i).getIsLocked(), expectedResponse.get(i).getIsLocked());
            softAssert.assertEquals(response.get(i).getIsAdmin(), expectedResponse.get(i).getIsAdmin());
            softAssert.assertEquals(response.get(i).getPasswordNeverExpires(), expectedResponse.get(i).getPasswordNeverExpires());
            softAssert.assertEquals(response.get(i).getNoChangePassword(), expectedResponse.get(i).getNoChangePassword());
            softAssert.assertEquals(response.get(i).getPasswordAge(), expectedResponse.get(i).getPasswordAge());
            softAssert.assertEquals(response.get(i).getLastLogon(), expectedResponse.get(i).getLastLogon());
            softAssert.assertEquals(response.get(i).getLastLogoff(), expectedResponse.get(i).getLastLogoff());
            softAssert.assertEquals(response.get(i).getBadPasswordCount(), expectedResponse.get(i).getBadPasswordCount());
            softAssert.assertEquals(response.get(i).getNumberOfLogons(), expectedResponse.get(i).getNumberOfLogons());
            softAssert.assertEquals(response.get(i).getSid(), expectedResponse.get(i).getSid());

            softAssert.assertAll();
        }
    }
}
