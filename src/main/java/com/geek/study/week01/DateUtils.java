package com.geek.study.week01;

import java.time.LocalDateTime;

public class DateUtils {

    public static String getDate(){
        System.out.println("this is a statid method");
        return LocalDateTime.now().toString();

    }
}
