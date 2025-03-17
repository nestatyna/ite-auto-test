package dto;

import lombok.Getter;

import java.util.ArrayList;

import static helpers.JsonHelper.toJsonStringInLine;

@Getter
public class CheckV1Response {

    private CheckV1ResponsePartRuleResult ruleResults;
    private ArrayList<Object> scriptResults;
}
