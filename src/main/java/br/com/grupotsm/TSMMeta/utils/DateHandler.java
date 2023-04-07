package br.com.grupotsm.TSMMeta.utils;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateHandler {

    public static LocalDate getLastDayOfMonth(LocalDate date){
        return date.withMonth(date.getMonth().getValue()).with(TemporalAdjusters.lastDayOfMonth());

    }
    public static LocalDate getFirstDayOfMonth(LocalDate date) {
        return date.withMonth(date.getMonth().getValue()).with(TemporalAdjusters.firstDayOfMonth());
    }
}
