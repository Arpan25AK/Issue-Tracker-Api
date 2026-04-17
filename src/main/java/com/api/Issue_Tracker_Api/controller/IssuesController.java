package com.api.Issue_Tracker_Api.controller;

import com.api.Issue_Tracker_Api.dto.IssueRequestDTO;
import com.api.Issue_Tracker_Api.dto.IssueResponseDTO;
import com.api.Issue_Tracker_Api.service.IssueService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/issues")
public class IssuesController {

    private final IssueService issueService;

    public IssuesController(IssueService issueService){
        this.issueService = issueService;
    }

    @GetMapping
    public ResponseEntity<List<IssueResponseDTO>> getAllIssues(){
        return ResponseEntity.ok(issueService.getAllIssues());
    }

    @PostMapping
    public ResponseEntity<IssueResponseDTO> createIssue(@Valid @RequestBody IssueRequestDTO requestDTO){
        IssueResponseDTO issues = issueService.createIssue(requestDTO);
        return new ResponseEntity<>(issues,HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<IssueResponseDTO> updateIssue(@PathVariable String id, @RequestBody IssueRequestDTO requestDTO){
        IssueResponseDTO updatedIssue = issueService.updateIssue(id, requestDTO);
        return ResponseEntity.ok(updatedIssue);
    }
}
