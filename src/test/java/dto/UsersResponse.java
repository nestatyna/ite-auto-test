package dto;

import lombok.Getter;

@Getter
public class UsersResponse {

    private String username;
    private String fullName;
    private Boolean isEnabled;
    private Boolean isLocked;
    private Boolean isAdmin;
    private Boolean passwordNeverExpires;
    private Boolean noChangePassword;
    private String passwordAge;
    private String lastLogon;
    private String lastLogoff;
    private Integer badPasswordCount;
    private Integer numberOfLogons;
    private String sid;
}
