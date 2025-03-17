package test;

import base.TestBase;
import dto.CheckV1Response;
import dto.CheckV2Response;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;

import static base.CustomLogger.step;
import static controllers.Controllers.getCheckV1;
import static controllers.Controllers.getCheckV2;
import static org.testng.Assert.assertTrue;

public class GetCheckV2Test extends TestBase {

    @Test
    @Issue("BUG-004")
    @Description("V1. Проверка отчёта проверки правил контроля")
    public void checkCheckV1Test() {
        //В рамках тестового задания делаю предположение, что ответ относится к первой версии запроса.
        step("Отправялем запрос GET /v2/check для получения отчёта проверки правил контроля");
        CheckV1Response response = getCheckV1();

        //ТК у нас нет возможности влиять на результат в имитации, то берём просто лист из всех возможных значений.
        List<String> expected = List.of(
                "{\"violation\":\"Найдено запрещенное сетевое соединение\"}",
                "{\"violation\":\"Найдено запрещенное USB-устройство\"}",
                "{\"violation\":\"Антивирусное ПО устарело\"}",
                "{\"violation\":\"Запущен запрещенный процесс\"}",
                "{\"violation\":null}"
        );

        assert response != null;
        assertTrue(expected.contains(response.getRuleResults().toLine()));
    }

    @Test
    @Issue("BUG-003")
    @Description("V2. Проверка отчёта проверки правил контроля")
    public void checkCheckV2Test() {
        step("Отправялем запрос GET /v2/check для получения отчёта проверки правил контроля");
        CheckV2Response response = getCheckV2();

        assert response != null;
        softAssert.assertEquals(response.getRuleResults().get("50767435").getId(), "05376357-4c95-11e9-914f-000c29bc93aa");
        softAssert.assertEquals(response.getRuleResults().get("50767435").getRuleType(), "processlist");
        softAssert.assertEquals(response.getRuleResults().get("50767435").getName(), "calc");
        softAssert.assertEquals(response.getRuleResults().get("50767435").getMessage(), "Найден хотя бы один из следующих запрещенных процессов: Calculator.exe ");
        softAssert.assertEquals(response.getRuleResults().get("50767435").getCommand(), "stop");
        softAssert.assertEquals(response.getRuleResults().get("50767435").getSessionId().intValue(), 2);
        softAssert.assertEquals(response.getRuleResults().get("50767435").getCheckType(), "stop");
        softAssert.assertEquals(response.getScriptResults().size(), 0);

        softAssert.assertAll();
    }
}
