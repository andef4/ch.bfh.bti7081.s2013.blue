package ch.bfh.bti7081.s2013.blue.utils;

import javax.servlet.ServletException;

import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

public class CustomVaadinServlet extends VaadinServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -7794729750751450744L;
    
    
    @Override
    protected void servletInitialized() throws ServletException {
        super.servletInitialized();
        getService().addSessionInitListener(new SessionInitListener() {
            private static final long serialVersionUID = 3860367923616543807L;

            @Override
            public void sessionInit(SessionInitEvent event) {
                event.getSession().addBootstrapListener(new BootstrapListener() {
                    private static final long serialVersionUID = -1310693428657267029L;

                    @Override
                    public void modifyBootstrapPage(BootstrapPageResponse response) {
                        response.getDocument().head().append("<meta name=\"viewport\" content=\"width=300\" />");
                    }
                    
                    @Override
                    public void modifyBootstrapFragment(BootstrapFragmentResponse response) {
                    }
                });
            }
        });
    }

}
