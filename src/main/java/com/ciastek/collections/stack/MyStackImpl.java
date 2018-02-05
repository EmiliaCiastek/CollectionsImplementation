package com.ciastek.collections.stack;

import java.util.EmptyStackException;

public class MyStackImpl<E> implements MyStack<E> {
    private Node<E> top;
    private boolean isEmpty = true;

    @Override
    public E push(E element) {
        if (isEmpty) {
            top = new Node<>(element);
        } else {
            top = new Node<>(element, top);
        }

        isEmpty = false;
        return element;
    }

    @Override
    public E pop() {
        if (isEmpty) {
            throw new EmptyStackException();
        }

        Node<E> currentTop = top;
        top = currentTop.previousNode;
        isEmpty = top == null;

        return currentTop.nodeValue;
    }

    @Override
    public E peek() {
        if (isEmpty) {
            throw new EmptyStackException();
        }

        return top.nodeValue;
    }

    @Override
    public boolean empty() {
        return isEmpty;
    }

    @Override
    public int search(E element) {
        if (isEmpty) {
            return -1;
        } else if (element.equals(top.nodeValue)) {
            return 1;
        } else {
            Node currentNode = top;
            int counter = 1;
            while (currentNode.hasPrevious){
                currentNode = currentNode.previousNode;
                counter++;
                if(currentNode.nodeValue.equals(element)){
                    return counter;
                }
            }
        }

        return -1;
    }

    private class Node<E> {
        private E nodeValue;
        private Node<E> previousNode;
        private boolean hasPrevious = true;

        Node(E nodeValue, Node<E> previousNode) {
            this.nodeValue = nodeValue;
            this.previousNode = previousNode;
        }

        Node(E nodeValue) {
            this(nodeValue, null);
            hasPrevious = false;
        }
    }
}
