package me.test.customer

import me.demo.service.DemoCustomerService
import me.demo.service.DemoCustomerServiceMockData
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import spock.lang.Specification

/**
 * Created by chrislin on 6/3/2014.
 */
@Configuration
class DemoCustomerMockBeans extends Specification{

    /**
     * use annotation to mock the service beans
     * @return
     */
    @Bean()
    DemoCustomerService mockDemoCustomerService() {
        def m = Mock(DemoCustomerService)
        m.listCustomers() >> DemoCustomerServiceMockData.mockCustomerList()
        m
    }

}
