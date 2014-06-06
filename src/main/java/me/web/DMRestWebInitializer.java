package me.web;

import me.demo.resource.DemoCustomerResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by chrislin on 5/28/2014.
 */
@Order(value = 1)
public class DMRestWebInitializer implements WebApplicationInitializer {

    /**
     *
     * @param sc
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext sc) throws ServletException {

        // Create the 'root' Spring application context
        System.out.println("############################################################");

        registerListener(sc);

        registerDispatcherServlet(sc);
    }

    /**
     *
     * @param sc
     * @return
     */
    private ServletContext registerListener (ServletContext sc) {
        sc.setInitParameter("contextConfigLocation", "TO_BE_IGNORED");

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(me.demo.config.DemoSpringSharedBeanConfig.class);
        sc.addListener(new ContextLoaderListener(ctx));
        return sc;
    }

    /**
     *
     * @param sc
     * @return
     */
    private ServletContext registerDispatcherServlet (ServletContext sc) {
        ResourceConfig cfx = new ResourceConfig();
        registerRSResources(cfx);
        registerRSExceptionMapper(cfx);

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = sc.addServlet("dm-jersey-dispatcher", new ServletContainer(cfx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/api/*");

        return sc;
    }

    /**
     *
     * @param cfg
     */
    private ResourceConfig registerRSResources(ResourceConfig cfg) {
        return cfg
                .register(DemoCustomerResource.class);
    }

    /**
     *
     * @param cfg
     * @return
     */
    private ResourceConfig registerRSExceptionMapper(ResourceConfig cfg) {
        return cfg
                .register(me.demo.exceptionmapper.DemoRSExceptionMapper.class)
                .register(me.exceptionmapper.RuntimeExceptionMapper.class);
    }
}