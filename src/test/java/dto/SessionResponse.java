package dto;

import lombok.Getter;

@Getter
public class SessionResponse {

    private String username;
    private String domain;
    private Boolean isLocal;
    private Boolean isAdmin;
    private Integer logonType;
    private String logonTime;
    private String dnsDomainName;
    private Integer session;
    private String sid;
    private Integer state;
    private String hostcon;
    private String activityId;
    private String connectionName;
    private SessionResponseClientIpPart clientIp;
}
