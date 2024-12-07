package com.backend

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class PostSpec extends Specification implements DomainUnitTest<Post> {

     void "test domain constraints"() {
        when:
        Post domain = new Post()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
