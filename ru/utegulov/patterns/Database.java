package ru.utegulov.patterns;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Database {
    private final List<String> data;
    private final int maxConnections;
    private final List<Connection> connections;
    private final AtomicInteger activeConnectionsCount;

    public Database(int maxConnections) {
        this.maxConnections = maxConnections;
        this.data = new ArrayList<>();
        this.connections = new ArrayList<>();
        this.activeConnectionsCount = new AtomicInteger(0);

        // Инициализация 10 произвольными значениями
        for (int i = 0; i < 10; i++) {
            data.add("Value_" + (i + 1));
        }

        // Предварительное создание подключений
        for (int i = 0; i < maxConnections; i++) {
            connections.add(new Connection(this));
        }
    }

    // Получение свободного подключения или null
    public Connection getConnection() {
        synchronized (connections) {
            for (Connection connection : connections) {
                if (!connection.isInUse()) {
                    connection.setInUse(true);
                    activeConnectionsCount.incrementAndGet();
                    return connection;
                }
            }
        }
        return null; // Нет свободных подключений
    }

    // Освобождение подключения
    public void releaseConnection(Connection connection) {
        connection.setInUse(false);
        activeConnectionsCount.decrementAndGet();
    }

    // Внутренние методы для работы с данными (доступны только Connection)
    String getValueByIndex(int index) {
        if (index >= 0 && index < data.size()) {
            return data.get(index);
        }
        return null;
    }

    void putValue(int index, String value) {
        if (index >= 0 && index <= data.size()) {
            if (index == data.size()) {
                data.add(value);
            } else {
                data.set(index, value);
            }
        }
    }

    // Вспомогательный метод для тестирования
    public int getActiveConnectionsCount() {
        return activeConnectionsCount.get();
    }
}

// Сущность Подключение
class Connection {
    private final Database database;
    private boolean inUse;

    // Конструктор доступен только в пакете
    Connection(Database database) {
        this.database = database;
        this.inUse = false;
    }

    // Возвращает значение из базы данных по индексу
    public String get(int index) {
        if (!inUse) {
            throw new IllegalStateException("Connection is not active");
        }
        return database.getValueByIndex(index);
    }

    // Кладёт новое значение в базу данных
    public void put(int index, String value) {
        if (!inUse) {
            throw new IllegalStateException("Connection is not active");
        }
        database.putValue(index, value);
    }

    // Освобождение подключения
    public void close() {
        if (inUse) {
            database.releaseConnection(this);
        }
    }

    // Методы для управления состоянием подключения
    boolean isInUse() {
        return inUse;
    }

    void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}
