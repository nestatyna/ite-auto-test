package data;

import lombok.Getter;

@Getter
public enum FilePath {

    USERS_PATH("src/test/resources/expected-response/expectedUsersResponse.json"),
    SOFTWARE_PATH("src/test/resources/expected-response/expectedSoftwareResponse.json"),

    SESSION_PATH("src/test/resources/mock-response/sessionResponse.json"),
    SCREENSHOTS_PATH("src/test/resources/mock-response/screenshotsResponse.json");

    final String path;

    FilePath(String path) {
        this.path = path;
    }
}
