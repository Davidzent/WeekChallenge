package com.challenge;

/**
 * Weekly Coding Challenge:
 * Pls provide the link to your solution in the comments section not later than Friday morning.
 * Circular Array: Implement a CircularArray class that supports an array-like data structure 
 * which can be efficiently rotated. 
 * If possible, the class should use a generic type (also called a template), 
 * and should support iteration via the standard f or (Obj o : circularArray) notation.
*/
public final class App {

    public static void main(String[] args) {
        //Create array
        int size = 100;
        CircularArray<Integer> a=new CircularArray<>(size);

        //Add values to the array
        for(int i=0;i<size;i++){
            a.addElement(i,i);
        }

        a.check(); //Used for manual checking

    }
}
