package com.backend

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class CourseControllerSpec extends Specification implements ControllerUnitTest<CourseControllerController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
