package com.rajeshchinni;

import java.util.List;

public interface NodeList {

    ListItem getHead();   // return the first element of the list of nodes
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem head);
}
