package dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TestResponse {

    @JsonProperty("VPNUser")
    private String vpnUser;

    @JsonProperty("VPNVendor")
    private String vpnVendor;

    @JsonProperty("bios.manufacturer")
    private String biosManufacturer;

    @JsonProperty("bios.releasedate")
    private String biosReleaseDate;

    @JsonProperty("bios.version")
    private String biosVersion;

    private String crc;
    private Boolean debug;
    private String domain;
    private String fqdn;

    @JsonProperty("hostid")
    private String hostId;

    @JsonProperty("hostname")
    private String hostName;

    @JsonProperty("hwuuid")
    private String hwUuid;
    private String innerHostName;

    @JsonProperty("ip_1")
    private String ip1;

    @JsonProperty("ip_10")
    private String ip10;
    @JsonProperty("ip_11")
    private String ip11;

    @JsonProperty("ip_12")
    private String ip12;

    @JsonProperty("ip_13")
    private String ip13;

    @JsonProperty("ip_14")
    private String ip14;

    @JsonProperty("ip_15")
    private String ip15;

    @JsonProperty("ip_16")
    private String ip16;

    @JsonProperty("ip_17")
    private String ip17;

    @JsonProperty("ip_18")
    private String ip18;

    @JsonProperty("ip_19")
    private String ip19;

    @JsonProperty("ip_2")
    private String ip2;

    @JsonProperty("ip_20")
    private String ip20;

    @JsonProperty("ip_21")
    private String ip21;

    @JsonProperty("ip_22")
    private String ip22;

    @JsonProperty("ip_23")
    private String ip23;

    @JsonProperty("ip_3")
    private String ip3;

    @JsonProperty("ip_4")
    private String ip4;

    @JsonProperty("ip_5")
    private String ip5;

    @JsonProperty("ip_6")
    private String ip6;

    @JsonProperty("ip_7")
    private String ip7;

    @JsonProperty("ip_8")
    private String ip8;

    @JsonProperty("ip_9")
    private String ip9;

    private String maintenanceMode;
    private String manufacturer;
    private String model;

    @JsonProperty("os.arch")
    private Integer osArch;

    @JsonProperty("os.family")
    private String osFamily;

    @JsonProperty("os.platform")
    private String osPlatform;

    @JsonProperty("os.version")
    private String osVersion;
    private String serverAddress;

    @JsonProperty("servicetag")
    private String serviceTag;
    private String timezone;
    private Object type;
    private String uptime;
    private Boolean useStandalone;

    @JsonProperty("user_id")
    private String userId;
    private String version;

    @JsonProperty("working_dir")
    private String workingDir;
}
