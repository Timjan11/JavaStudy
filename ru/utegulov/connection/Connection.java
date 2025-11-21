package ru.utegulov.connection;

import java.util.Random;

public class Connection {

    String address;
    Boolean isOpen;

    public Connection(String address) {
        if(address == null){
            throw new IllegalArgumentException("Address not found");
        }
        this.address = address;
        this.isOpen = true;
    }

    public String getAddress() {
        return address;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public String request() throws LossOfConect {
        String res = "Попытка подключения";
        Random rand = new Random();
        int randomInt = rand.nextInt(2);
        if(isOpen == false){
            throw new UsingCloseSourseExeption();
        }
        if(isOpen==true && randomInt == 0){
            throw new LossOfConect("Соединение потеряно...");
        }else if(isOpen==true && randomInt == 1){
            res = "test connection";
        }
        return res;
    }

    public void close() {
        setOpen(false);
    }
}
