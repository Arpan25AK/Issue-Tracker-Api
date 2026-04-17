Create database issuetracker
use issuetracker

create table if not exists issues(
    id VARCHAR(36) PRIMARY KEY ,
    title VARCHAR(255) NOT NULL,
    description Text,
    status VARCHAR(50) NOT NULL,
    priority VARCHAR(50) NOT NULL,
    created_at timestamp DEFAULT CURRENT_TIMESTAMP
    );