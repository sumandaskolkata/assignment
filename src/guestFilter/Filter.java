package guestFilter;

import entities.Guest;

import java.util.ArrayList;

public interface Filter {
    public ArrayList<Guest> call(ArrayList<Guest> list);
}