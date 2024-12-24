package com.backend

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class DepartamentoSpec extends Specification implements DomainUnitTest<Departamento> {

     void "test domain constraints"() {
        when:
        Departamento domain = new Departamento()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
