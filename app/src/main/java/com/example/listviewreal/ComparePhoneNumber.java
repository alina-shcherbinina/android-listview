package com.example.listviewreal;

import java.util.Comparator;

public class ComparePhoneNumber implements Comparator<User> {
    public int compare(User a, User b)
    {
        return a.getPhoneNumber().compareTo(b.getPhoneNumber());
    }
}