package me.test

import org.glassfish.jersey.server.ResourceConfig
import org.glassfish.jersey.server.spring.SpringLifecycleListener
import org.glassfish.jersey.server.spring.scope.RequestContextFilter
import org.glassfish.jersey.test.JerseyTest
import org.glassfish.jersey.test.TestProperties

import javax.ws.rs.core.Application

/**
 * Created by chrislin on 6/2/2014.
 */
abstract class AbstractJersyTestConfig  extends JerseyTest {
    static String CTX_LOCATION_KEY = 'contextConfigLocation'

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC)
        enable(TestProperties.DUMP_ENTITY)

        def r = new ResourceConfig().register(SpringLifecycleListener.class).register(RequestContextFilter.class)
        configResource(r)
    }

    abstract ResourceConfig configResource(ResourceConfig resourceConfig)
}
