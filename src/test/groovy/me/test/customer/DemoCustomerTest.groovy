package me.test.customer

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import spock.lang.Shared
import spock.lang.Specification

import javax.ws.rs.client.Entity
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * Created by chrislin on 5/30/2014.
 */
//@Component
//@ContextConfiguration(locations = DemoCustomerJersyTestConfig.SPRING_CTX_LOCATION)
//@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = MockBeans.class)
class DemoCustomerTest extends Specification {

    /**
     * the jersey test configuration
     */
    @Shared
    def jt = new DemoCustomerJersyTestConfig()

    /**
     * called each time for each test
     * @return
     */
    @Override
    def setupSpec() {
        jt.setUp()
    }

    /**
     * called each time for each test
     * @return
     */
    @Override
    def cleanupSpec() {
        jt.tearDown()
    }

    /**
     *
     * @return
     */
    def 'list demo customer OK'() {
        setup:

        when:
        def r = jt.target().path('/customers').request(MediaType.APPLICATION_JSON_TYPE).get();

        then:
        r.getStatus() == Response.Status.OK.statusCode
        def s = r.readEntity(String.class)
        def json = new JsonSlurper().parseText(s)
        println(JsonOutput.prettyPrint(s))
        //json.dump()
        json.data.size == 2
        json.data[0].id == 111
        json.data[0].name == 'customer-name-111'
        json.data[0].accounts.size == 2
        json.data[0].accounts[1].id == 'acount-id-y'

    }

    /**
     *
     */
    def 'post to create customer OK'() {
        setup:
        def d = """
                {

                    "name":"customer-name-test-111",
                    "nickName":"customer-test-111",
                    "accounts":
                    [
                        {
                            "id":"acount-id-test-1",
                            "name":"account-test-name",
                            "status":"bankrupted"
                        },
                        {
                            "id":"acount-id-test-2",
                            "name":"account-test-name",
                            "status":"good standing"
                         }
                    ]
                }
                """
        when:
        def r = jt.target().path('/customers').request(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(d))

        then:
        r.getStatus() == Response.Status.CREATED.statusCode
        def s = r.readEntity(String.class)
        def json = new JsonSlurper().parseText(s)
        json.data.id == 1212
        println(JsonOutput.prettyPrint(s))

    }
}
