package dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SoftwareResponse {

    private String displayName;
    private String displayVersion;
    private String arch;
    private String publisher;
    private Integer estimatedSize;

    @JsonProperty("installDate")
    private String installDate;

    @JsonProperty("Contact")
    private String contact;

    @JsonProperty("HelpLink")
    private String helpLink;

    @JsonProperty("InstallSource")
    private String installSource;

    @JsonProperty("VersionMajor")
    private Integer versionMajor;

    @JsonProperty("VersionMinor")
    private Integer versionMinor;
}
