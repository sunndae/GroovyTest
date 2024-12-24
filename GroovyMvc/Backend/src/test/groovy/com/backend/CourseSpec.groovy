package com.backend

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CourseSpec extends Specification implements DomainUnitTest<Course> {

     void "test domain constraints"() {
        when:
        Course domain = new Course()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
