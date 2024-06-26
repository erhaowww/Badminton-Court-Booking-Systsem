package ADT;

import java.util.Iterator;

/**
 * QueueInterface.java An interface for the ADT queue.
 *
 * @author Frank M. Carrano
 * @version 2.0
 */
public interface QueueInterface<T> {

    public Iterator<T> getIterator();

    /**
     * Task: Adds a new entry to the back of the queue.
     *
     * @param newEntry an object to be added
     */
    public void enqueue(T newEntry);

    /**
     * Task: Removes and returns the entry at the front of the queue.
     *
     * @return either the object at the front of the queue or, if the queue is
     * empty before the operation, null
     */
    public T dequeue();

    /**
     * Task: Retrieves the entry at the front of the queue.
     *
     * @return either the object at the front of the queue or, if the queue is
     * empty, null
     */
    public T getFront();

    /**
     * Task: Detects whether the queue is empty.
     *
     * @return true if the queue is empty, or false otherwise
     */
    public boolean isEmpty();

    //    Task: Display all the entry in ascending order
    public void displayLinkedQueue();

    //    Task: Display all the entry in descending order
    public void displayReverseLinkedQueue();

    //    Task: Return number of entry
    public int size();

    //    Task: Search the specific entry by using No entered by user
    public T searchByNo(int selectedEntryNo);

    //    Task: Replace the whole entry by using No entered by user
//    @return QueueInterface<T> to the entity
    public QueueInterface<T> replaceQueueByNo(int selectedEntryNo, T updatedEntry);

    //    Task: Replace the whole entry in adt by using No entered by user
    public boolean replaceNodeByNo(int selectedEntryNo, T updatedEntry);

    //    Task: Replace the whole entry by using entry id entered by user
//    @return QueueInterface<T> to the entity
    public QueueInterface<T> replaceQueueById(T oldEntry, T updatedEntry);

    //    Task: Replace the whole entry in adt by using entry id entered by user
    public boolean replaceNodeById(T oldEntry, T updatedEntry);

    //    Task: Remove the entry by using No entered by user
    public void removeByNo(int selectedEntryNo);

    //    Task: Remove the entry by using table No range entered by user
    public void removeByNoRange(int start, int end);

    //    Task: Remove the entry by using entry id entered by user
    public void removeById(T entry);

    //    Task: Search the specific entry by using entry id entered by user
    public T searchById(String id);

    /**
     * Task: Removes all entries from the queue.
     */
    public void clear();
} // end QueueInterface
