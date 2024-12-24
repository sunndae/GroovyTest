package com.backend

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class DepartamentoControllerSpec extends Specification implements ControllerUnitTest<DepartamentoControllerController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
