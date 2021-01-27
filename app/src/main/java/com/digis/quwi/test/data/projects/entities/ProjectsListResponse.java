package com.digis.quwi.test.data.projects.entities;

import com.digis.quwi.test.domain.entities.Project;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProjectsListResponse {
    @SerializedName("projects") private final List<Project> projects;

    public ProjectsListResponse(List<Project> projects) {
        this.projects = projects;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
