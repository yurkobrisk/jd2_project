package it.academy.web;

import it.academy.config.DataConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebDocumentInitializer extends
            AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DataConfiguration.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebDocumentConfiguration.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }


//        ServletContainerInitializer {
//
//    @Override
//    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
//
//        AnnotationConfigWebApplicationContext rootContext =
//                new AnnotationConfigWebApplicationContext();
//        rootContext.register(WebDocumentConfiguration.class);
//
//        ctx.addListener(new ContextLoaderListener(rootContext));
//
//        DispatcherServlet servlet =
//                new DispatcherServlet(rootContext);
//
//        final ServletRegistration.Dynamic dispatcher =
//                ctx.addServlet("dispatcher", servlet);
//        dispatcher.setLoadOnStartup(1);
//        dispatcher.addMapping("/");

//    }
}
