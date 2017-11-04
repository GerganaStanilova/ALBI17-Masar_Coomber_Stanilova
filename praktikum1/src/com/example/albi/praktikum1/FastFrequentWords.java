package com.example.albi.praktikum1;

public class FastFrequentWords {
    public static int symbolToNumber(String symbol){
        switch (symbol){
            case "A": case "a":
                return 0;
            case "C": case "c":
                return 1;
            case "G": case "g":
                return 2;
            case "T": case "t":
                return 3;
            default: System.err.println("Falsche Eingabe!!!");
                return -1;
        }
    }

    public static int patternToNumber(String pattern) {
        if(pattern.length() == 1) {
            return symbolToNumber(pattern);
        } else {
            return 4*patternToNumber(pattern.substring(0, pattern.length() - 1)) + symbolToNumber(pattern.substring(pattern.length() - 1));
        }
    }
}
