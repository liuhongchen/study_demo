package observer;

/**
 * ClassName:ObservableRunnable
 * Package:observer
 * Description:
 *
 * @date: 2022-10-13 17:06
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class ObservableRunnable implements Runnable {

    final protected LifeCycleListener listener;
    public ObservableRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }
    protected void notify(RunnableEvent event){
        listener.onEvent(event);
    }

    public static class RunnableEvent{
         final RunnableStatus runnableStatus;
         final Thread thread;
         final Throwable cause;
        public RunnableEvent(RunnableStatus runnableStatus, Thread thread, Throwable cause) {
            this.runnableStatus = runnableStatus;
            this.thread = thread;
            this.cause = cause;
        }
    }

    public enum RunnableStatus{
        RUNNING,ERROR,DOWN
    }

    @Override
    public void run() {
        //开始运行
        notify(new RunnableEvent(RunnableStatus.RUNNING,Thread.currentThread(),null));

        try {
            System.out.println(10/0);
        }catch (Exception e){
            //运行出错
            try {
                Thread.sleep(3_000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            notify(new RunnableEvent(RunnableStatus.ERROR,
                    Thread.currentThread(),e));
        }

        //运行结束
        notify(new RunnableEvent(RunnableStatus.DOWN,Thread.currentThread(),
                null));


    }
}
