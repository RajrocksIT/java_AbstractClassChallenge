package com.rajeshchinni;

public class Node extends ListItem {

    // constructor
    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem next() {
        return this.next;  // manually added
    }

    @Override
    ListItem setNext(ListItem item) {
        this.next = item;  // manually added
        return this.next;  // manually added
    }

    @Override
    ListItem previous() {
        return this.prev;   // manually added
    }

    @Override
    ListItem setPrevious(ListItem item) {
        this.prev = item;   // manually added
        return this.prev;   // manually added
    }
// 9
    @Override
    int compareTo(ListItem item) {
        if(item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}
