package com.backend

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class RamoControllerSpec extends Specification implements ControllerUnitTest<RamoControllerController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
