package com.example.albi.praktikum1;
import java.util.HashSet;
import java.util.Set;
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
    public static Set <String> frequentWords(String text, int k){
        Set <String> frequentPatterns = new HashSet<String>();
        int[] count = new int[text.length() - k];
        int maxCount = 0;
        for(int i=0; i < (text.length() - k); i++){
            String pattern = text.substring(i, i + k);
            count[i] = patternCount(text, pattern);
            if(count[i] > maxCount){
                maxCount = count[i];
            }
        }
        for(int i=0; i < (text.length() - k); i++){
            if(count[i] == maxCount){
                frequentPatterns.add(text.substring(i, i + k));
            }
        }
        return frequentPatterns;

    }
}
