package dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;

@Getter
public class CheckV2Response {

    @JsonProperty("ruleResults")
    private Map<String, CheckV2ResponsePart> ruleResults;
    private ArrayList<Object> scriptResults;
}
