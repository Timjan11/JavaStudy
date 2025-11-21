package ru.utegulov.connection;

import java.util.Random;

class ExampleConnector {
    public void register() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Ошибка в методе register");
        }
        System.out.println("register connection");
    }

    public void unregister() {
        System.out.println("unregister connection");
    }

    public void makeConnect(Connection conn) throws LossOfConect {
        register();
        conn.request();
        unregister();
    }
}