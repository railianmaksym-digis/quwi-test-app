package com.digis.quwi.test.domain.projects;

import com.digis.quwi.test.data.projects.ProjectsRepository;
import com.digis.quwi.test.domain.UseCase;
import com.digis.quwi.test.domain.states.State;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetProjectsUseCase extends UseCase<Void> {

    private final ProjectsRepository projectsRepository;

    @Inject
    public GetProjectsUseCase(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    protected Observable<State> createObservable(Void params) {
        return projectsRepository.getProjects();
    }
}
