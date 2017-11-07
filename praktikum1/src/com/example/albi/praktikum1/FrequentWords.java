package com.example.albi.praktikum1;
import java.util.ArrayList;
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
    public static ArrayList <String> frequentWords(String text, int k){
        ArrayList <String> frequentPatterns = new ArrayList<>(); //
        int[] count = new int[text.length() - k];              //Länge des Arrays count festlegen
        int maxCount = 0;                                      //maxCount initialisieren
        for(int i=0; i < (text.length() - k); i++){            //geht alle nötigen Positionen im Text durch
            String pattern = text.substring(i, i + k);         //bestimmt k-mere
            count[i] = patternCount(text, pattern);            //speichert Anzahl der Vorkommen im array count
            if(count[i] > maxCount){                           //findet die maximale Anzahl der Vorkommen für
                maxCount = count[i];                           //die häufigsten k-mere
            }
        }
        for(int i=0; i < (text.length() - k); i++){            //die häufigsten k-mere im Set frequentPatterns
            if(count[i] == maxCount){                          //speichern
                frequentPatterns.add(text.substring(i, i + k));
            }
        }
        for(int i=0; i < frequentPatterns.size(); i++){
            for(int j=i+1; j < frequentPatterns.size(); j++){
                if(frequentPatterns.get(i).equals(frequentPatterns.get(j))){
                    frequentPatterns.remove(j);
                }
            }
        }
        return frequentPatterns;

    }
    public static void main(String[] args) {
        String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        for (String item : FrequentWords.frequentWords(text,k)) { //jedes Element im Set frequentPatterns ausgeben
            System.out.println(item);
        }

    }
}
