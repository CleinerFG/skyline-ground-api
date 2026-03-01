CREATE TABLE user_project
(
    user_id    BIGINT       NOT NULL,
    project_id BIGINT       NOT NULL,
    role       project_role NOT NULL DEFAULT 'VIEWER',

    CONSTRAINT pk_user_project PRIMARY KEY (user_id, project_id),

    CONSTRAINT fk_user_project_user FOREIGN KEY (user_id)
        REFERENCES app_user (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_project_project FOREIGN KEY (project_id)
        REFERENCES project (id) ON DELETE CASCADE
);

-- Index required to optimize reverse lookup queries (e.g., "get all users for a specific project")
CREATE INDEX idx_user_project_project_id ON user_project (project_id);