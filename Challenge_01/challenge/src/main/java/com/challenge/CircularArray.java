package com.challenge;

import java.util.ArrayList;
import java.util.Iterator;

public class CircularArray<T> implements Iterable<T>{
    private ArrayList<T> array;
    private int start;                  //Start position

    /**
     * Prints the array
     */
    public void printArr(){
        for(T e:this){
            System.out.print(e+" ");
        }
        System.out.print("\n");
    }

    /**
     * To facilitate manual checking while changing the template type
     */
    public void check() {
        //Print array
        printArr();

        //Rotate Array Left
        rotateLeft(1);
        
        //Print array
        printArr();

        //Rotate Array Right
        rotateRight(2);

        //Print array
        printArr();

        //Set the start position ex: index 15
        setStart(15);

        //Print array
        printArr();
    }

    /**
     * Sets the start of array 
     * Checks for going over or under the array size
     * @param start
     */
    public void setStart(int start) {
        this.start =  Math.floorMod(start,array.size());
    }

    /**
     * Rotate in the left direction not allowing going over or under the array size
     * @param moves number of index rotations to the left
     */
    public void rotateLeft(int moves){
        start = Math.floorMod((start - moves),array.size());        
    }

    /**
     * Rotate in the right direction not allowing going over or under the array size
     * @param moves number of index rotations to the right
     */
    public void rotateRight(int moves){
        start = Math.floorMod((start + moves),array.size());

    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = start;       //iterator index
            private int cnt=0;                      //number of moves or iterations

            @Override
            public boolean hasNext() {
                currentIndex=Math.floorMod(currentIndex,array.size());          //limit the range of the index
                return cnt++ < array.size() && array.get(currentIndex) != null; 
            }

            @Override
            public T next() {
                return array.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    // Constructors, Getters and Setters

    public CircularArray(int size) {
        array=new ArrayList<>(size);
        start=0;
    }

    public CircularArray(ArrayList<T> array) {
        this.array = array;
        start = 0;
    }

    public ArrayList<T> getArray() {
        return array;
    }

    public void setArray(ArrayList<T> array) {
        this.array = array;
    }

    public int getSize(){
        return array.size();
    }

    public void addElement(T e){
        array.add(e);
    }

    public int getStart() {
        return start;
    }

}
