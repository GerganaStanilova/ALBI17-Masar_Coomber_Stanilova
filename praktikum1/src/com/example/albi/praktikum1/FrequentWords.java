package com.example.albi.praktikum1;

public class FrequentWords {
    public static int patternCount(String text, String pattern){ //die Fkt kriegt als Parameter text und pattern

        int count = 0; //den Counter auf 0 setzen
        for(int i=0; i <= (text.length() - pattern.length()); i++){ //geht alle nötigen Positionen im Text durch
            if ((text.substring(i, i + pattern.length())).equals(pattern)){ // prüft, ob das Pattern dem Substring entpricht
                count++; //falls ja, den Counter mit 1 erhöhen
            }
        }
        return count; // die Anzahl des Vorkommens des Patterns im Text
    }
}
