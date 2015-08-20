package common.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CommonListener implements ServletContextListener  {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        
        System.out.println("this is last destroyeed");
        return;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
    	
        event.getServletContext().setAttribute("basePath", "/springmvc");
        
        return;
    }

}
