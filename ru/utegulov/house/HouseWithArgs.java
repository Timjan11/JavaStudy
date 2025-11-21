package ru.utegulov.house;


public class HouseWithArgs {

    final int floors;

    public HouseWithArgs(int floors){
        this.floors = floors;

    }

    @Override
    public String toString() {
        if (floors == 1){
            return "House with " + floors + " floor";
        } else {
            return "House with " + floors + " floors";
        }

    }
}
