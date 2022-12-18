package com.homecorp.chargepointmanager

import com.homecorp.chargepointmanager.utils.StringToDateTimeConverter
import groovy.util.logging.Slf4j
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDateTime

@Slf4j
class DateConverterSpecification extends Specification {

    @Unroll
    def "convert string to date: #str -> #expected"(String str, LocalDateTime expected) {

        when:
        LocalDateTime observed = StringToDateTimeConverter.convert(str)

        then:
        observed == expected

        where:
        str                   | expected
        '2020/03/02 02:02:02' | LocalDateTime.of(2020, 03, 02, 2, 2, 2)
        '2020/03/05 13:10'    | LocalDateTime.of(2020, 03, 05, 13, 10, 0)
        '2020/03/05 13'       | LocalDateTime.of(2020, 03, 05, 13, 0, 0)
        '2020/03/05'          | LocalDateTime.of(2020, 03, 05, 0, 0, 0)
        '2020/03'             | LocalDateTime.of(2020, 03, 01, 0, 0, 0)
        '20'                  | LocalDateTime.of(20, 01, 01, 0, 0, 0)
        '2020 13'             | LocalDateTime.of(2020, 01, 01, 13, 0, 0)
        '2020/03 13'          | LocalDateTime.of(2020, 03, 01, 13, 0, 0)
        '2020/03 13:02'       | LocalDateTime.of(2020, 03, 01, 13, 2, 0)
        '2020/03 13:02:02'    | LocalDateTime.of(2020, 03, 01, 13, 2, 2)

        '2020-03-02 02:02:02' | LocalDateTime.of(2020, 03, 2, 2, 2, 2)
        '2020-03-05 13:10'    | LocalDateTime.of(2020, 03, 05, 13, 10, 0)
        '2020-03-05 13'       | LocalDateTime.of(2020, 03, 05, 13, 0, 0)
        '2020-03-05'          | LocalDateTime.of(2020, 03, 05, 0, 0, 0)
    }

    @Unroll
    def "when convert invalid string '#str' then exception is thrown: #msg"(String str, String msg) {
        when:
        StringToDateTimeConverter.convert(str)

        then:
        def e = thrown(IllegalArgumentException)
        e.message == msg

        where:
        str      | msg
        '20 1 1' | 'More then 2 parts are specified by empty space.'
        'a'      | 'No numbers provided.'
    }
}
