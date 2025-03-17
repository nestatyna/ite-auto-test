package dto;

import lombok.Getter;

@Getter
public class ProcInfoResponse {

    private String name;
    private String path;
    private String user;
    private Long createTime;
    private Integer session;
}
