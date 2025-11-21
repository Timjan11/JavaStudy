package ru.utegulov.connection;

import ru.utegulov.connection.ExampleConnector;
import ru.utegulov.student.*;

public class ConnectionManager {

    public static void main(String[] args) throws LossOfConect {
        ExampleConnector connector = new ExampleConnector();
        Connection connection = new Connection("ermakov.edu");

        callMakeConnect(connector, connection);
    }

    public static void callMakeConnect(ExampleConnector connector, Connection connection) throws LossOfConect {
        try {

            connector.makeConnect(connection);

        } catch (RuntimeException | LossOfConect e) {

            if (isExceptionFromRegister((RuntimeException) e)) {

                System.out.println("Исключение в register проигнорировано: " + e.getMessage());

            } else if (isExceptionFromNextString((RuntimeException) e)) {

                System.out.println("Исключение в nextString: " + e.getMessage());
                connector.unregister();

            } else {

                throw e;
            }
        }
    }


    private static boolean isExceptionFromRegister(RuntimeException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getMethodName().equals("register") &&
                    element.getClassName().equals("ExampleConnector")) {
                return true;
            }
        }
        return false;
    }


    private static boolean isExceptionFromNextString(RuntimeException e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getMethodName().equals("nextString") &&
                    element.getClassName().equals("Connection")) {
                return true;
            }
        }
        return false;
    }
}
