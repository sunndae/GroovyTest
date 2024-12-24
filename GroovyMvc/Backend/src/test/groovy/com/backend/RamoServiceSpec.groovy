package com.backend

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class RamoServiceSpec extends Specification implements ServiceUnitTest<RamoServiceService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
