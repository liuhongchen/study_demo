package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class User implements HttpSessionBindingListener, HttpSessionActivationListener {

    private String username;



    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        httpSessionBindingEvent.getValue();
        httpSessionBindingEvent.getName();
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {

    }
}
