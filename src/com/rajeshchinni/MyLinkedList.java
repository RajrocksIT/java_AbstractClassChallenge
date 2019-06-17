package com.rajeshchinni;

public class MyLinkedList implements NodeList {

    private ListItem head = null;  //header


    //constructor
    public MyLinkedList(ListItem root) {
        this.head = root;
    }

    @Override
    public ListItem getHead() {
        return this.head;
    }

    // 8 7 6 5 4 3 2 1
    //9
    //
    @Override
    public boolean addItem(ListItem newItem) {
        if(this.head == null) {
            // The list was empty, so this item becomes the head of the list
            this.head = newItem;
            return true;
        }

        ListItem currentItem = this.head;
        while(currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if(comparison <0) {
                // newItem is greater, move right if possible
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if(comparison >0) {
                // newItem is less, insert before
                if(currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);    // Make the next of prev_node as new_node
                    newItem.setNext(currentItem.previous());
                    newItem.setNext(currentItem);          // Make next of new node as next of prev_node
                    currentItem.setPrevious(newItem);     // Make prev_node as previous of new_node
                } else {
                    // the node with a previous is the head
                    newItem.setNext(this.head);        // Make next of new node as head
                    this.head.setPrevious(newItem);   // change prev of head node to new node
                    this.head = newItem;   // move the head to point to the new node
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null){
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.head;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if (comparison == 0){
                // found the item to delete
                if (currentItem == this.head){
                    this.head = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }

                }
                return true;

            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else {
                //comparision is > 0
                // we are at an item greater than the one to be deleted
                // so the item is not in the list
                return false;
            }
        }
        // we have reached the end of the list
        // without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem head) {
        if (head == null){
            System.out.println("The list is empty");
        } else {
            while (head != null){
                System.out.println(head.getValue());
                head = head.next();
            }
        }

    }
}
