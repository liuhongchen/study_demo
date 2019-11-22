package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MyHttpServletAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent sae) {
        sae.getName();
        sae.getValue();
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent sae) {

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent sae) {

    }
}
