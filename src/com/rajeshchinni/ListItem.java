package com.rajeshchinni;

public abstract class ListItem {

    protected ListItem next = null;
    protected ListItem prev = null;
    protected Object value;  // defined it generically as we are not sure about data type

    //constructor
    public ListItem(Object value) {
        this.value = value;
    }

    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);

    //setter and getter
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
