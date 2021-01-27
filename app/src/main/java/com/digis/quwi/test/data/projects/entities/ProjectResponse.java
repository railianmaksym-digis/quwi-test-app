package com.digis.quwi.test.data.projects.entities;

import com.digis.quwi.test.domain.entities.Project;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectResponse {
    @SerializedName("project") private final Project project;

    public ProjectResponse(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}
