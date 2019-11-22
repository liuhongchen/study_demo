package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyHttpServletListener  implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        ServletContext servletContext1 = (ServletContext) servletContextEvent.getSource();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
