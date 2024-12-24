package com.backend

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ProfesorControllerSpec extends Specification implements ControllerUnitTest<ProfesorControllerController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
