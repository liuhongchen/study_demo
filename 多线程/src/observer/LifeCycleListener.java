package observer;

/**
 * ClassName:LifeCycleListener
 * Package:observer
 * Description:
 *
 * @date: 2022-10-13 17:10
 * @author:Hansing liuhongchengege123@gmail.com
 */
public interface LifeCycleListener {

    void onEvent(ObservableRunnable.RunnableEvent runnableEvent);
}
