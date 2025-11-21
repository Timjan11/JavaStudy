package ru.utegulov.connection;

public class DataReaderService {

    public void readData() {

        Connection connection = null;

        try {
            connection = new Connection("ermakov.edu");


            for (int i = 0; i < 10; i++) {
                try {
                    String data = connection.request();
                    System.out.println("Данные " + (i + 1) + ": " + data);
                } catch (LossOfConect e) {
                    System.out.println("Ошибка при запросе " + (i + 1) + ": " + e.getMessage());
                }
            }

        } catch (UsingCloseSourseExeption e) {
            System.out.println("Ошибка подключения: " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }
}