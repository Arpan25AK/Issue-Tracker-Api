package com.api.Issue_Tracker_Api.service;

import com.api.Issue_Tracker_Api.dto.IssueRequestDTO;
import com.api.Issue_Tracker_Api.dto.IssueResponseDTO;
import com.api.Issue_Tracker_Api.entity.IssueStatus;
import com.api.Issue_Tracker_Api.entity.Issues;
import com.api.Issue_Tracker_Api.repository.IssueRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class IssueService {

    private final IssueRepo issueRepo;

    public IssueService(IssueRepo issueRepo){
        this.issueRepo = issueRepo;
    }

    public IssueResponseDTO createIssue(IssueRequestDTO requestDTO){
        Issues issues = new Issues();
        issues.setId(UUID.randomUUID().toString());
        issues.setTitle(requestDTO.getTitle());
        issues.setDescription(requestDTO.getDescription());
        issues.setPriority(requestDTO.getPriority());

        issues.setStatus(IssueStatus.OPEN);
        issues.setCreated_at(LocalDateTime.now());

        issueRepo.save(issues);

        return mapToResponseDTO(issues);
    }

    public List<IssueResponseDTO> getAllIssues(){
        return issueRepo.getAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public IssueResponseDTO getIssuedById(String id){
        Issues issues = issueRepo.getById(id).orElseThrow(() -> new RuntimeException("issue with id :" + id + "doesnt exists"));
        return mapToResponseDTO(issues);
    }

    public void DeleteIssueById(String id){
        int issues = issueRepo.deleteById(id);
        if(issues == 0) throw new RuntimeException("could not delete by id . issue not found");
    }

    public IssueResponseDTO updateIssue(String id, IssueRequestDTO requestDTO){
        Issues existingIssue = issueRepo.getById(id).orElseThrow(() -> new RuntimeException("the issue with id :" + id + "does not exists"));

        existingIssue.setTitle(requestDTO.getTitle());
        existingIssue.setDescription(requestDTO.getDescription());
        existingIssue.setStatus(requestDTO.getStatus());
        existingIssue.setPriority(requestDTO.getPriority());

        issueRepo.save(existingIssue);

        return mapToResponseDTO(existingIssue);
    }


    private IssueResponseDTO mapToResponseDTO(Issues issues){
        IssueResponseDTO responseDTO = new IssueResponseDTO();
        responseDTO.setId(issues.getId());
        responseDTO.setTitle(issues.getTitle());
        responseDTO.setDescription(issues.getDescription());
        responseDTO.setStatus(issues.getStatus());
        responseDTO.setPriority(issues.getPriority());
        responseDTO.setCreated_at(issues.getCreated_at());
        return responseDTO;
    }
}
