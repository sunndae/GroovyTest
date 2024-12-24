package com.backend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class CourseServiceSpec extends Specification implements ServiceUnitTest<CourseServiceService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
