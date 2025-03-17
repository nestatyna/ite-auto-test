package dto;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Getter;

import static helpers.JsonHelper.toJsonStringInLine;

@Getter
public class CheckV1ResponsePartRuleResult {

    private String violation;

    public String toLine() {
        return toJsonStringInLine(this);
    }
}
