package com.api.Issue_Tracker_Api.repository;

import com.api.Issue_Tracker_Api.entity.IssueStatus;
import com.api.Issue_Tracker_Api.entity.Issues;
import com.api.Issue_Tracker_Api.entity.IssuePriority;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class IssueRepo {

    private JdbcTemplate jdbcTemplate;

    public IssueRepo(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public final RowMapper<Issues> issueRowMapper = (rs, rowNum) -> {
        Issues issues = new Issues();
        issues.setId(rs.getString("id"));
        issues.setTitle(rs.getString("title"));
        issues.setDescription(rs.getString("description"));
        issues.setStatus(IssueStatus.valueOf(rs.getString("status")));
        issues.setPriority(IssuePriority.valueOf(rs.getString("priority")));
        issues.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        return issues;
    };
    //this acts as both the save and post service
    public void save(Issues issues){
        String sql = "INSERT INTO issues (id, title, description, status, priority, created_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                issues.getId(),
                issues.getTitle(),
                issues.getDescription(),
                issues.getStatus().name(),
                issues.getPriority().name(),
                issues.getCreated_at());
    }
    //get all users
    public List<Issues> getAll(){
        String sql = "select * from issues";
        return jdbcTemplate.query(sql, issueRowMapper);
    }
    //get users by id
    public Optional<Issues> getById(String id){
        String sql = "select * from issues where id = ?";
        return jdbcTemplate.query(sql, issueRowMapper, id).stream().findFirst();
    }
    // this acts as a put method
    public int update(Issues issues){
        String sql = "update issues set title=? , description=? , status = ?, priority = ? where id = ?";
        return jdbcTemplate.update(sql,
                issues.getTitle(),
                issues.getDescription(),
                issues.getStatus().name(),
                issues.getPriority().name(),
                issues.getId());
    }

    public int deleteById(String id){
        String sql = "Delete from issues where id=?";
        return jdbcTemplate.update(sql,id);
    }
}
