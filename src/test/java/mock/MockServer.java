package mock;

import com.github.tomakehurst.wiremock.WireMockServer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class MockServer {
    private static WireMockServer wireMockServer ;

    public static void start() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(8888);
            wireMockServer.start();

            wireMockServer.stubFor(any(anyUrl())
                    .willReturn(aResponse()
                            .proxiedFrom("http://localhost:4567")));
            setupMocks();

            System.out.println("WireMock запущен на порту 8888 и проксирует в http://localhost:4567");
        }
    }

    public static void stop() {
        if (wireMockServer != null) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }

    private static void setupMocks() {
        mockEndpoint("/proc", "mock-response/procResponse.json");
        mockEndpoint("/sessions", "mock-response/sessionResponse.json");
        mockEndpoint("/screenshots", "mock-response/screenshotsResponse.json");
    }

    private static void mockEndpoint(String url, String responseFilePath) {
        try {
            String response = new String(Files.readAllBytes(Paths.get("src/test/resources/" + responseFilePath)));
            wireMockServer.stubFor(get(urlEqualTo(url))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")
                            .withBody(response)));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки мок-ответа: " + responseFilePath, e);
        }
    }
}

