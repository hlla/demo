package com.flatbuffer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class AddressBook implements Serializable {
    private static final long serialVersionUID = -5455411589530407306L;
    public ArrayList<SimplePeople> simplePeoples;
}
