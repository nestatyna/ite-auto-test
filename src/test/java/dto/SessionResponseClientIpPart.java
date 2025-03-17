package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SessionResponseClientIpPart {

    @JsonProperty("IP")
    public String iP;
    @JsonProperty("Port")
    public int port;
}
