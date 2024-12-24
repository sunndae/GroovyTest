package com.backend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProfesorServiceSpec extends Specification implements ServiceUnitTest<ProfesorServiceService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
