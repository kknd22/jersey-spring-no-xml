package me.test.customer

import me.test.AbstractJersyTestConfig
import me.test.TestConstants
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.AnnotationConfigApplicationContext

/**
 * Created by chrislin on 5/30/2014.
 * This is a workaround for JerseyTest calling overridable method in thier contractor - a big NO NO
 *
 * A quote from Effective Java 2nd Edition, Item 17: Design and document for inheritance, or else prohibit it:
 * There are a few more restrictions that a class must obey to allow inheritance. Constructors must not invoke
 * overridable methods, directly or indirectly. If you violate this rule, program failure will result.
 * The superclass constructor runs before the subclass constructor, so the overriding method in the subclass
 * will be invoked before the subclass constructor has run. If the overriding method depends on any initialization
 * performed by the subclass constructor, the method will not behave as expected.
 */
class DemoCustomerJersyTestConfig extends AbstractJersyTestConfig {

    @Override
    ResourceConfig configResource(ResourceConfig r) {
        r.register(me.demo.resource.DemoCustomerResource.class)
         .property(TestConstants.CTX_CONFIG_BEANS_KEY, new AnnotationConfigApplicationContext(DemoCustomerMockBeans.class))

    }
}