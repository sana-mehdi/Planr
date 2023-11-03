package interface_adapter.mainpage;

import interface_adapter.ViewModel;
import interface_adapter.create_task.CreateTaskState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class TaskViewModel extends ViewModel {

    public static final String CREATE_BUTTON_LABEL = "Create Task";

    public static final String TITLE_LABEL = "Task View";

    public static final String CREATE_TASK_LABEL = "Write New Task";


    private CreateTaskState state = new CreateTaskState();

    public TaskViewModel(){super("task view");}

    public void setState(CreateTaskState state){this.state = state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) { support.addPropertyChangeListener(listener);
    }

    public CreateTaskState getState(){return state;}
}
