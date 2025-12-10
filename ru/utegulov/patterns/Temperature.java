package ru.utegulov.patterns;
import java.util.HashMap;
import java.util.Map;

public class Temperature {
    private final String name;
    private final int minTemp;
    private final int maxTemp;

    // Приватный конструктор
    private Temperature(String name, int minTemp, int maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    // Проверка, подходит ли температура под данный диапазон
    public boolean matches(int temperature) {
        return temperature >= minTemp && temperature <= maxTemp;
    }

    @Override
    public String toString() {
        return name + " (" + minTemp + "°C до " + maxTemp + "°C)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Temperature that = (Temperature) obj;
        return minTemp == that.minTemp &&
                maxTemp == that.maxTemp &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + minTemp;
        result = 31 * result + maxTemp;
        return result;
    }

    // Единая точка доступа - синглтон менеджер температур
    public static class TemperatureManager {
        private static TemperatureManager instance;
        private final Map<String, Temperature> temperatures;

        // Предопределенные температурные диапазоны
        public static final String COLD = "Холодно";
        public static final String NORMAL = "Нормально";
        public static final String HOT = "Жарко";

        private TemperatureManager() {
            temperatures = new HashMap<>();

            // Создаем только разрешенные объекты температур
            temperatures.put(COLD, new Temperature(COLD, -50, 10));
            temperatures.put(NORMAL, new Temperature(NORMAL, 10, 25));
            temperatures.put(HOT, new Temperature(HOT, 25, 60));

            System.out.println("Менеджер температур инициализирован");
        }

        // Синхронизированный метод для получения экземпляра
        public static synchronized TemperatureManager getInstance() {
            if (instance == null) {
                instance = new TemperatureManager();
            }
            return instance;
        }

        // Получить температуру по имени
        public Temperature getTemperature(String name) {
            Temperature temp = temperatures.get(name);
            if (temp == null) {
                throw new IllegalArgumentException("Неизвестный тип температуры: " + name);
            }
            return temp;
        }

        // Получить все доступные температуры
        public Temperature[] getAllTemperatures() {
            return temperatures.values().toArray(new Temperature[0]);
        }

        // Получить описание температуры по числовому значению
        public Temperature getTemperatureForValue(int tempValue) {
            for (Temperature temp : temperatures.values()) {
                if (temp.matches(tempValue)) {
                    return temp;
                }
            }
            throw new IllegalArgumentException("Температура " + tempValue + "°C не попадает ни в один диапазон");
        }

        // Проверить, доступен ли тип температуры
        public boolean isTemperatureAvailable(String name) {
            return temperatures.containsKey(name);
        }

        // Получить количество доступных температур
        public int getAvailableTemperaturesCount() {
            return temperatures.size();
        }
    }
}