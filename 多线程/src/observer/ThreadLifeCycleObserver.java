package observer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:ThreadLifeCycleObserver
 * Package:observer
 * Description:
 *
 * @date: 2022-10-13 17:13
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {


    @Override
    public void onEvent(ObservableRunnable.RunnableEvent runnableEvent) {
        StringBuilder sbb=new StringBuilder(new SimpleDateFormat("yyyy-MM-dd " +
                "hh:mm:ss").format(new Date()));
        sbb.append(" ");
        sbb.append(runnableEvent.thread)
                .append("-")
                .append(runnableEvent.runnableStatus);
        if (runnableEvent.cause!=null){
            sbb.append("-").append(runnableEvent.cause.getMessage());
        }
        System.out.println(sbb.toString());
    }
}
