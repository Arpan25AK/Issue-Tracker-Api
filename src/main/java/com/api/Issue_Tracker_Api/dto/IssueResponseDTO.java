package com.api.Issue_Tracker_Api.dto;

import com.api.Issue_Tracker_Api.entity.IssueStatus;
import com.api.Issue_Tracker_Api.entity.IssuePriority;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IssueResponseDTO {
    private String id;
    private String title;
    private String description;
    private IssueStatus status;
    private IssuePriority priority;
    private LocalDateTime created_at;
}
