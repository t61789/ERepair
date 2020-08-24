package com.zzu.erepair.utility;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class Utility {

    public DateTimeFormatter timeFormatter;

    public void init(){
        timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public LocalDateTime Stime2Ltime(String time){
        return LocalDateTime.parse(time,timeFormatter);
    }

    public String Ltime2Stime(LocalDateTime time){
        return timeFormatter.format(time);
    }
}
