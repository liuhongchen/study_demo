package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent hsbe) {
        hsbe.getName();
        hsbe.getValue();
        hsbe.getSession();
        hsbe.getSource();
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent hsbe) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent hsbe) {

    }
}
