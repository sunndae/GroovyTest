package com.backend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class PostServiceServiceSpec extends Specification implements ServiceUnitTest<PostServiceService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
