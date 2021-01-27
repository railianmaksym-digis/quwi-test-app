package com.digis.quwi.test.domain.projects;

import com.digis.quwi.test.data.projects.ProjectsRepository;
import com.digis.quwi.test.domain.UseCase;
import com.digis.quwi.test.domain.states.State;

import javax.inject.Inject;

import io.reactivex.Observable;

public class UpdateProjectUseCase extends UseCase<UpdateProjectParams> {

    private final ProjectsRepository projectsRepository;

    @Inject
    public UpdateProjectUseCase(ProjectsRepository projectsRepository) {
        this.projectsRepository = projectsRepository;
    }

    @Override
    protected Observable<State> createObservable(UpdateProjectParams params) {
        return projectsRepository.updateProject(params);
    }
}
