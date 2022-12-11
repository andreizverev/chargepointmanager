package com.homecorp.chargepointmanager

import groovy.util.logging.Slf4j
import spock.lang.Specification

@Slf4j
class SimpleTestSpecification extends Specification {

    def "test"() {
        when:
        log.info("hello")

        then:
        1 == 1
    }
}
