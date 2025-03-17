package controllers;

import dto.*;
import helpers.JsonHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static base.CustomLogger.log;

public class Controllers extends AbstractController {

    public static TestResponse getTest() {
        Response response = isSuccess(getTestRequest(), 200);
        return response.as(TestResponse.class);
    }

    public static Response getTestRequest() {
        log("<<<<<< createPetRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/tests")
                .then()
                .extract().response();
    }

    public static List<SoftwareResponse> getSoftware() {
        Response response = isSuccess(getSoftwareRequest(), 200);
        return JsonHelper.parseJsonList(response.asString(), SoftwareResponse.class);
    }

    public static Response getSoftwareRequest() {
        log("<<<<<< getSoftwareRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/software")
                .then()
                .extract().response();
    }

    public static List<UsersResponse> getUsers() {
        Response response = isSuccess(getUsersRequest(), 200);
        return JsonHelper.parseJsonList(response.asString(), UsersResponse.class);
    }

    public static Response getUsersRequest() {
        log("<<<<<< getUsersRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/users")
                .then()
                .extract().response();
    }

    public static CheckV2Response getCheckV2() {
        Response response = isSuccess(getCheckV2Request(), 200);
        return JsonHelper.parseJson(response.asString(), CheckV2Response.class);
    }

    public static Response getCheckV2Request() {
        log("<<<<<< getCheckV2Request()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/v2/check")
                .then()
                .extract().response();
    }

    public static CheckV1Response getCheckV1() {
        Response response = isSuccess(getCheckV1Request(), 200);
        return JsonHelper.parseJson(response.asString(), CheckV1Response.class);
    }

    public static Response getCheckV1Request() {
        log("<<<<<< getCheckV1Request()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/v2/check")
                .then()
                .extract().response();
    }

    public static Map<String, ProcInfoResponse> getProc() {
        Response response = isSuccess(getProcRequest(), 200);
        return JsonHelper.parseJsonInToMap(response.asString(), ProcInfoResponse.class);
    }

    public static Response getProcRequest() {
        log("<<<<<< getProcRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/proc")
                .then()
                .extract().response();
    }

    public static List<SessionResponse> getSessions() {
        Response response = isSuccess(getSessionsRequest(), 200);
        return JsonHelper.parseJsonList(response.asString(), SessionResponse.class);
    }

    public static Response getSessionsRequest() {
        log("<<<<<< getSessionsRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/sessions")
                .then()
                .extract().response();
    }

    public static ScreenshotsResponse getScreenshots() {
        Response response = isSuccess(getScreenshotsRequest(), 200);
        return response.as(ScreenshotsResponse.class);
    }

    public static Response getScreenshotsRequest() {
        log("<<<<<< getScreenshotsRequest()\n");
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .log().method()
                .log().uri()
                .log().headers()
                .when()
                .get("/screenshots")
                .then()
                .extract().response();
    }
}
