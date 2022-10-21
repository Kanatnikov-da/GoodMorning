package com.example.goodmorning.utils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Utils {
    public static LocalDate getCurrentDateISO() {
        return LocalDate.now();
    }

    public static BigDecimal getCelsius(BigDecimal degreesKelvin) {
        return degreesKelvin.subtract(BigDecimal.valueOf(273.16));
    }
}
