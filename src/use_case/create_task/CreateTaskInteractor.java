package use_case.create_task;

import entity.TaskI;
import entity.TaskFactory;

public class CreateTaskInteractor implements CreateTaskInputBoundary{
    final CreateTaskDataAccessInterface taskDataAccessObject;

    final CreateTaskOutputBoundary taskPresenter;

    final TaskFactory taskFactory;


    public CreateTaskInteractor(CreateTaskDataAccessInterface taskDataAccessObject,
                                CreateTaskOutputBoundary taskPresenter,
                                TaskFactory taskFactory){
        this.taskDataAccessObject = taskDataAccessObject;
        this.taskPresenter = taskPresenter;
        this.taskFactory = taskFactory;
    }

    public void execute(CreateTaskInputData createTaskInputData){
        if (createTaskInputData.getCreateTask() == ""){
            taskPresenter.prepareFailView("An Empty Task Can't Be Added");
        } else{
            TaskI taskI = taskFactory.create(createTaskInputData.getCreateTask(), false);
            taskDataAccessObject.save(taskI);

            taskDataAccessObject.addTask(taskI);

            CreateTaskOutputData createTaskOutputData = new CreateTaskOutputData(taskI.getName());
            taskPresenter.prepareSuccessView(createTaskOutputData);
        }
    }



}