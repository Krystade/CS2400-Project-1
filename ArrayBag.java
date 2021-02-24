//
// Name: 
// Homework: #1
// Due: 02/18/2021
// Course: cs-2400-03-sp21
//
// Description:
// Create an interface and implement it for the bag ADT. Then use the created bag ADT to hold Java keywords, pulled from a file,
// and then check if arguments passed through the command line are included in the bag
//
public final class ArrayBag<T> implements BagInterface<T>{
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;

    //Creates a bag with the size of DEFAULT_CAPACITY
    public ArrayBag(){ //default constructor
        this(DEFAULT_CAPACITY);
    }

    //Creates a bag with the size requested by the user
    public ArrayBag(int capacity){ //constructor with specified size
        //Suppress the unchecked cast warning
        @SuppressWarnings("unchecked")
        //Create a new bag object that will be assigned to bag
        T[] tempBag = (T[])new Object[capacity];
        //Set bag equal to this newly created temporary bag
        bag = tempBag;
        //Set the number of entries to 0 because it's empty so far
        numberOfEntries = 0;
    }

    //Add a new item to the bag
    public boolean add(T newEntry) {
        //If the bag isn't full, add the new item and increase the number of entries by one
        if(!isFull()){
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        //If the bag is full return false and don't change the bag
        }else{
            return false;
        }
    }

    public T[] toArray() {
        //Suppress the unchecked cast warning
        @SuppressWarnings("unchecked")
        //Create a new bag object that will have the exact size to fit each entry from bag
        T[] bagArray = (T[])new Object[numberOfEntries];
        //Fill up the new array
        for(int i = 0; i < numberOfEntries; i++){
            bagArray[i] = bag[i];
        }
        //return the new array
        return bagArray;
    }

    public int getCurrentSize() {
        return numberOfEntries;
    }

    public boolean isEmpty() {
        return numberOfEntries == 0;
    } 

    public T remove() {
        //Pull the most recently added entry out of the bag
        T removed = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        //decrease the known number of entries in the bag
        numberOfEntries--;
        //return the removed item
        return removed;
    }

    public boolean remove(T anEntry) {
        //Loop through all the items in the bag from first to last based on time added
        for(int i = 0; i < numberOfEntries; i++){
            if(bag[i].equals(anEntry)){
                //move the last item in the bag to the removed item's position
                bag[i] = bag[numberOfEntries - 1];
                //set the final item in the bag to null because it was moved
                bag[numberOfEntries - 1] = null;
                //decrease the known number of entries in the bag
                numberOfEntries--;
                //return true since the entry was found and removed
                return true;
            }
        }
        //If the entry isn't found in the whole bag return false
        return false;
    }

    public void clear() {
        while(!isEmpty()){
            remove();
        }
    }

    public int getFrequencyOf(T anEntry) {
        //initialize a count for how many times an item is in the bag
        int count = 0;
        //Check each item in the bag to see if it is what we are looking for
        for(int i = 0; i < numberOfEntries; i++){
            if(bag[i].equals(anEntry)){
                //if it is increase the frequency counter
                count++;
            }
        }
        //return how many times the item was found
        return count;
    }

    public boolean contains(T anEntry) {
        //Check each item in the bag to see if it is what we are looking for
        for(int i = 0; i < numberOfEntries; i++){
            if(bag[i].equals(anEntry)){
                //if it is return true
                return true;
            }
        }
        //return false if the item isn't found
        return false;
    }

    public boolean isFull() {
        return (numberOfEntries >= bag.length - 1);
    }

    public void removeEvery(T entry){
        while(contains(entry)){
            remove(entry);
        }
    }
}