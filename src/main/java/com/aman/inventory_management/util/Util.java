package com.aman.inventory_management.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Util {

    public LocalDate convertDateFromString(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString);
        if (date == null){
            LocalDate.now();
        }
        return date;
    }
}
