package com.example.albi.praktikum1;
import java.util.HashSet;
import java.util.Set;
public class FastFrequentWords {
    public static int symbolToNumber(String symbol){ //die Basen zu Zahlen
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

    public static int patternToNumber(String pattern) { //rekursive Funktion zur Umwandlung von Pattern in eine Zahl
        if(pattern.length() == 1) {
            return symbolToNumber(pattern);
        } else {
            return 4*patternToNumber(pattern.substring(0, pattern.length() - 1)) + symbolToNumber(pattern.substring(pattern.length() - 1));
        }
    }
    public static String numberToSymbol(int number){ //Zahlen zu Basen
        switch (number){
            case 0:
                return "A";
            case 1:
                return "C";
            case 2:
                return "G";
            case 3:
                return "T";
            default: System.err.println("Falsche Eingabe!!!");
                return "";
        }
    }
    public static String numberToPattern(int index, int k){ //rekursive Funktion zur Umwandlung von einer Zahl in Basen
        if(k == 1){
            return numberToSymbol(index);
        }
        int prefIndex = index/4;
        int r = index%4;
        String symbol = numberToSymbol(r);
        String prefixPattern = numberToPattern(prefIndex, k - 1);
        return prefixPattern + symbol;
    }
    public static int[] computingFrequencies(String text, int k){ //gibt Vorkommen der Pattern an
        int len = (int) (Math.pow(4,k)); //4^k mit Math.pow(4,k) berechnen
        int[] frequencyArray = new int[len];
        for(int i = 0; i < len; i++){
            frequencyArray[i] = 0;
        }
        for(int i = 0; i <= (text.length() - k); i++){ //den Text durchgehen
            String pattern = text.substring(i, i + k);
            int j = patternToNumber(pattern); //Index des Patterns im Array berechnen
            frequencyArray[j] = frequencyArray[j] + 1; //für jedes Vorkommen für das Pattern inkrementieren wir die Zahl um 1
        }
        return frequencyArray;
    }

    public static Set <String> fasterFrequentwords(String text, int k) { //gibt die am häufigsten vorkommenden Patterns an
        Set<String> frequentPatterns = new HashSet<String>(); //frequentPatterns als Set definieren, um keine Duplikate zu erhalten
        int[] frequencyArray = computingFrequencies(text,k);
        int maxCount = 0; //maxCount initialisieren
        for(int i = 0; i < frequencyArray.length; i++){
            if(frequencyArray[i] > maxCount){ //maxCount berechnen
                maxCount = frequencyArray[i];
            }
        }
        int len = (int) (Math.pow(4,k));
        for(int i = 0; i < len; i++){
            if (frequencyArray[i] == maxCount){
                String pattern = numberToPattern(i, k);
                frequentPatterns.add(pattern); //nur die Pattern die am meisten vorkommen zu frequentPatterns hinzufügen
            }
        }
        return frequentPatterns;
    }
    public static void main(String[] args) {
        String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        for (String item : FastFrequentWords.fasterFrequentwords(text,k)) { //jedes Element im Set frequentPatterns ausgeben
            System.out.println(item);
        }
    }
}
