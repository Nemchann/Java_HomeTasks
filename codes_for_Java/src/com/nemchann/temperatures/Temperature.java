package com.nemchann.temperatures;

public enum Temperature {
    COLD("", -50, 10),
    WARM("", 10, 25),
    HOT("", 25, 60);

    private final String name;
    private final int minTemp;
    private final int maxTemp;

    Temperature (String name, int minTemp, int maxTemp){
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getName() {
        return name;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public boolean isApplicable(int temperature) {
        return temperature >= minTemp && temperature <= maxTemp;
    }

    // Метод для получения категории по температуре
    public static Temperature getByTemperature(int temp) {
        for (Temperature t : values()) {
            if (t.isApplicable(temp)) {
                return t;
            }
        }
        // Если температура вне диапазона
        throw new IllegalArgumentException("Температура " + temp +
                " вне допустимого диапазона");
    }

    // Переопределяем toString для красивого вывода
    @Override
    public String toString() {
        return name + " (от " + minTemp + " до " + maxTemp + " градусов)";
    }
}
