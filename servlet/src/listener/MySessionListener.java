package listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        HttpSession session1= (HttpSession) hse.getSource();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {

    }
}
