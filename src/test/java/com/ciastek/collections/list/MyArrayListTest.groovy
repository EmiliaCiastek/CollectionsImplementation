package com.ciastek.collections.list

import spock.lang.Specification

class MyArrayListTest extends Specification {

    def "should return element at given index"() {
        given:
        MyList list = new MyArrayList()
        when:
        Integer actualElement = list.get(0)
        then:
        actualElement == 0
    }

    def "should add element at first index"() {
        given:
        MyList list = new MyArrayList()
        when:
        list.add(0)
        then:
        list.get(0) == 0
    }
}
