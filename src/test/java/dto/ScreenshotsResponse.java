package dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ScreenshotsResponse {

    private String taskGuid;
    private Integer sessionId;
    private ArrayList<ScreenshotsResponseFilePart> files;
    private Integer filesCount;
}
