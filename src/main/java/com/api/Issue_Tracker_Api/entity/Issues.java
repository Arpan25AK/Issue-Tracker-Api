package com.api.Issue_Tracker_Api.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Issues {
    private String id;

    private String title;

    private String description;

    private IssueStatus status;

    private IssuePriority priority;

    private LocalDateTime created_at;

}
