package com.ciastek.collections.stack

import spock.lang.Shared
import spock.lang.Specification

class MyStackImplTest extends Specification {

    @Shared
    MyStack<String> stack
    @Shared
    String firstElement = "Element"

    def setup() {
        stack = new MyStackImpl<>()
    }

    def "should empty return true when stack is created"() {
        when:
        boolean isEmpty = stack.empty()
        then:
        isEmpty
    }

    def "should empty return false when element pushed in stack"() {
        when:
        stack.push(firstElement)
        then:
        !stack.empty()
    }

    def "should return top element on stack when peek"() {
        given:
        stack.push(firstElement)
        when:
        String peekedElement = stack.peek()
        then:
        peekedElement == firstElement
    }

    def "should empty return true when element is popped from stack"() {
        given:
        stack.push(firstElement)
        when:
        stack.pop()
        then:
        stack.empty()
    }

    def "should return top element when pop"() {
        given:
        stack.push(firstElement)
        when:
        String poppedElement = stack.pop()
        then:
        poppedElement == firstElement
    }

    def "should first pushed element be on top when pop"() {
        given:
        String newElement = "New"
        stack.push(firstElement)
        stack.push(newElement)
        stack.pop()
        when:
        String peekedElement = stack.peek()
        then:
        peekedElement == firstElement
    }

    def "should empty return false when two elements pushed to stack and top is popped"() {
        when:
        String newElement = "New"
        stack.push(firstElement)
        stack.push(newElement)
        stack.pop()
        then:
        !stack.empty()
    }

    def "should throw EmptyStackException when pop on empty stack"() {
        when:
        stack.pop()
        then:
        thrown(EmptyStackException)
    }

    def "should throw EmptyStackException when peek on empty stack"() {
        when:
        stack.peek()
        then:
        thrown(EmptyStackException)
    }

    def "should return 1 when searching element is on top"() {
        given:
        stack.push(firstElement)
        when:
        int distance = stack.search(firstElement)
        then:
        distance == 1
    }

    def "should return -1 when searching empty stack"() {
        when:
        int distance = stack.search("element not on stack")
        then:
        distance == -1
    }

    def "should return -1 when searching absent element"() {
        given:
        stack.push(firstElement)
        when:
        int distance = stack.search("element not on stack")
        then:
        distance == -1
    }

    def "should return distance to top when search"(String elementToSearch, int distance) {
        setup:
        stack.push("some element")
        stack.push("other element")
        stack.push("ono more element")
        stack.push(firstElement)
        expect:
        stack.search(elementToSearch) == distance

        where:
        elementToSearch    | distance
        "some element"     | 4
        "other element"    | 3
        "ono more element" | 2
    }

    def "should stack be generic"() {
        given:
        MyStack<Integer> intStack = new MyStackImpl<>()
        Integer element = 5
        Integer secondElement = 10
        intStack.push(element)
        intStack.push(secondElement)
        when:
        Integer popped = intStack.pop()
        Integer peeked = intStack.peek()
        then:
        popped == secondElement
        peeked == element
    }
}
