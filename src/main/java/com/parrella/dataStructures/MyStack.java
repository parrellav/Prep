package com.parrella.dataStructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MyStack<T> {

    private ArrayList<T> myList = new ArrayList<T>();

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return myList.get(myList.size() - 1);
    }

    public void push(T t) {
        myList.add(t);
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        T top = myList.remove(myList.size() - 1);
        return top;
    }

    public static void main(String[] args) {
        MyStack<Integer> integerMyStack = new MyStack<>();
        System.out.println(integerMyStack.isEmpty());

        integerMyStack.push(5);
        System.out.println(integerMyStack.peek());

        integerMyStack.push(7);
        System.out.println(integerMyStack.peek());

        integerMyStack.pop();
        System.out.println(integerMyStack.peek());

        // boom!
        integerMyStack.pop();
        System.out.println(integerMyStack.peek());



    }

}
