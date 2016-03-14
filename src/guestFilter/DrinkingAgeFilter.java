package guestFilter;

import entities.Guest;

import java.util.ArrayList;

public class DrinkingAgeFilter implements Filter {
    private final int drinkingAge;

    public DrinkingAgeFilter(int drinkingAge) {
        this.drinkingAge = drinkingAge;
    }


    @Override
    public ArrayList<Guest> call(ArrayList<Guest> list) {
        ArrayList<Guest> filteredGuest = new ArrayList<>();
        for (Guest guest : list) {
            if (guest.isLegalDrinker(drinkingAge)) {
                filteredGuest.add(guest);
            }
        }
        return filteredGuest;
    }
}
