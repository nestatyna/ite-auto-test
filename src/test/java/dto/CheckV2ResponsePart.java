package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CheckV2ResponsePart {

    private String id;

    @JsonProperty("rule_type")
    private String ruleType;
    private String name;
    private String message;
    private String command;
    private Integer sessionId;

    @JsonProperty("check_type")
    private String checkType;
}
