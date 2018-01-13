package com.ciastek.collections.list

import spock.lang.Specification

class MyArrayListTest extends Specification {

    def "should add element at first index"() {
        given:
        MyList list = new MyArrayList()
        when:
        list.add(0)
        then:
        list.get(0) == 0
    }

    def "should throw exception when get with index out of bounds"() {
        given:
        MyList list = new MyArrayList()
        when:
        list.get(20)
        then:
        thrown(IndexOutOfBoundsException)
        // ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException: that's why test passed
    }

    def "should add element at the end of the list and return element at provided index"() {
        given:
        MyList list = new MyArrayList()
        list.add(1)
        list.add(7)
        list.add(0)

        when:
        Integer firstElement = list.get(0)
        Integer secondElement = list.get(1)
        Integer thirdElement = list.get(2)

        then:
        firstElement.equals(1)
        secondElement.equals(7)
        thirdElement.equals(0)
    }
}
