package com.api.Issue_Tracker_Api.dto;

import com.api.Issue_Tracker_Api.entity.IssueStatus;
import com.api.Issue_Tracker_Api.entity.IssuePriority;
import lombok.Data;

@Data
public class IssueRequestDTO {
    private String title;
    private String description;
    private IssueStatus status;
    private IssuePriority priority;

}
