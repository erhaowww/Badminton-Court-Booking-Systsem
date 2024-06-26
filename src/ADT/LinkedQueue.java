package ADT;

import java.util.Iterator;

/**
 * LinkedQueue.java A class that implements the ADT queue by using a chain of
 * nodes that has both head and tail references.
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    private Node firstNode; // references node at front of queue
    private Node lastNode;  // references node at back of queue
    private int length;

    public LinkedQueue() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        length++;
    }

    public T getFront() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
        }

        return front;
    }

    public T dequeue() {
        T front = null;

        if (!isEmpty()) {
            front = firstNode.data;
            firstNode = firstNode.next;

            if (firstNode == null) {
                lastNode = null;
            }
        }

        length--;
        return front;
    } // end dequeue

    public void removeByNo(int selectedEntryNo) {
        Node currentNode = firstNode;
        Node helperFirstNode = null;
        Node helperLastNode = null;

        for (int i = 0; currentNode != null; i++) {
            if (i == (selectedEntryNo - 1)) {
                currentNode = currentNode.next;
                if (i == (length - 1) && helperFirstNode != null) {
                    helperLastNode.next = currentNode;
                    helperLastNode = currentNode;
                }
                continue;
            }

            if (helperFirstNode == null) {
                helperFirstNode = currentNode;
            } else {
                helperLastNode.next = currentNode;
            }

            helperLastNode = currentNode;
            currentNode = currentNode.next;
        }
        firstNode = helperFirstNode;
        length--;
    }

    public void removeByNoRange(int start, int end) {
        Node currentNode = firstNode;
        Node helperFirstNode = null;
        Node helperLastNode = null;

        for (int i = 0; currentNode != null; i++) {
            if (i >= (start - 1) && i <= (end - 1)) {
                currentNode = currentNode.next;
                if (i == (length - 1) && helperFirstNode != null) {
                    helperLastNode.next = currentNode;
                    helperLastNode = currentNode;
                }
                continue;
            }

            if (helperFirstNode == null) {
                helperFirstNode = currentNode;
            } else {
                helperLastNode.next = currentNode;
            }

            helperLastNode = currentNode;
            currentNode = currentNode.next;
        }
        firstNode = helperFirstNode;
        length = length - ((end-start)+1);
    }

    public void removeById(T entry) {
        Node currentNode = firstNode;
        Node helperFirstNode = null;
        Node helperLastNode = null;

        for (int i = 0; currentNode != null; i++) {
            if (currentNode.data.equals(entry)) {
                currentNode = currentNode.next;
                if (i == (length - 1) && helperFirstNode != null) {
                    helperLastNode.next = currentNode;
                    helperLastNode = currentNode;
                }
                continue;
            }

            if (helperFirstNode == null) {
                helperFirstNode = currentNode;
            } else {
                helperLastNode.next = currentNode;
            }

            helperLastNode = currentNode;
            currentNode = currentNode.next;
        }
        firstNode = helperFirstNode;
        length--;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        length = 0;
    }

    public void displayLinkedQueue() {
        Node currentNode = firstNode;
        int i = 1;
        while (currentNode != null) {
            System.out.println((i) + "\t" + currentNode.data);
            currentNode = currentNode.next;
            i++;
        }
    }

    public void displayReverseLinkedQueue() {
        Node currentNode = firstNode;
        T[] reverseT = (T[]) new Object[size()];
        int i = 0;
        while (currentNode != null) {
            reverseT[i] = currentNode.data;
            currentNode = currentNode.next;
            i++;
        }
        i = 1;
        for (int j = reverseT.length - 1; j >= 0; j--) {
            System.out.println((i) + "\t" + reverseT[j]);
            i++;

        }
    }

    public T searchByNo(int selectedEntryNo) {
        T entry = null;
        Node currentNode = firstNode;
        for (int i = 0; i < selectedEntryNo && currentNode != null; i++) {
            if (i == (selectedEntryNo - 1)) {
                entry = currentNode.data;
                break;
            }
            currentNode = currentNode.next;
        }
        return entry;
    }

    public T searchById(String id) {
        T entry = null;
        Node currentNode = firstNode;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.data.toString().contains(id)) {
                entry = currentNode.data;
                break;
            }
            currentNode = currentNode.next;
        }
        return entry;
    }

    public QueueInterface<T> replaceQueueByNo(int selectedEntryNo, T updatedEntry) {
        QueueInterface<T> entry = new LinkedQueue<T>();
        Node currentNode = firstNode;
        for (int i = 0; currentNode != null; i++) {
            if (i == (selectedEntryNo - 1)) {
                currentNode.setData(updatedEntry);
            }
            entry.enqueue(currentNode.data);
            currentNode = currentNode.next;
        }
        return entry;
    }

    public boolean replaceNodeByNo(int selectedEntryNo, T updatedEntry) {
        Node currentNode = firstNode;
        Node helperFirstNode = null;
        Node helperLastNode = null;

        boolean isReplace = false;
        for (int i = 0; currentNode != null; i++) {
            if (i == (selectedEntryNo - 1)) {
                currentNode.setData(updatedEntry);
                isReplace = true;
            }
            if (i == 0) {
                helperFirstNode = currentNode;
            } else {
                helperLastNode.next = currentNode;
            }
            helperLastNode = currentNode;
            currentNode = currentNode.next;
        }
        firstNode = helperFirstNode;
        return isReplace;
    }

    public QueueInterface<T> replaceQueueById(T oldEntry, T updatedEntry) {
        QueueInterface<T> entry = new LinkedQueue<T>();
        Node currentNode = firstNode;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.data.equals(oldEntry)) {
                currentNode.setData(updatedEntry);
            }
            entry.enqueue(currentNode.data);
            currentNode = currentNode.next;
        }
        return entry;
    }

    public boolean replaceNodeById(T oldEntry, T updatedEntry) {
        Node currentNode = firstNode;
        Node helperFirstNode = null;
        Node helperLastNode = null;

        boolean isReplace = false;
        for (int i = 0; currentNode != null; i++) {
            if (currentNode.data.equals(oldEntry)) {
                currentNode.setData(updatedEntry);
                isReplace = true;
            }
            if (i == 0) {
                helperFirstNode = currentNode;
            } else {
                helperLastNode.next = currentNode;
            }
            helperLastNode = currentNode;
            currentNode = currentNode.next;
        }
        firstNode = helperFirstNode;
        return isReplace;
    }

    public Iterator<T> getIterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {

        private Node currentNode;

        public LinkedQueueIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T returnData = currentNode.data;
                currentNode = currentNode.next;
                return returnData;
            } else {
                return null;
            }
        }
    }

    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
            this.next = null;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setData(T data) {
            this.data = data;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
