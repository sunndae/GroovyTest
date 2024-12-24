package com.backend

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RamoSpec extends Specification implements DomainUnitTest<Ramo> {

     void "test domain constraints"() {
        when:
        Ramo domain = new Ramo()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
