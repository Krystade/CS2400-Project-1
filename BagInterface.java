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
public interface BagInterface<T> {
    public int getCurrentSize();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean remove(T anEntry);
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();
    public boolean isFull();
}
