package observer;

/**
 * ClassName:Main
 * Package:observer
 * Description:
 *
 * @date: 2022-10-13 17:18
 * @author:Hansing liuhongchengege123@gmail.com
 */
public class Main {
    public static void main(String[] args) {

        Thread thread=
                new Thread(new ObservableRunnable(new ThreadLifeCycleObserver()));
        thread.start();
    }
}
