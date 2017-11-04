package com.example.albi.praktikum1;
import java.util.HashSet;
import java.util.Set;
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
    public static String numberToSymbol(int number){
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
    public static String numberToPattern(int index, int k){
        if(k == 1){
            return numberToSymbol(index);
        }
        int prefIndex = index/4;
        int r = index%4;
        String symbol = numberToSymbol(r);
        String prefixPattern = numberToPattern(prefIndex, k - 1);
        return prefixPattern + symbol;
    }
    public static int[] computingFrequencies(String text, int k){
        int len = (int) (Math.pow(4,k));
        int[] frequencyArray = new int[len];
        for(int i = 0; i < len; i++){
            frequencyArray[i] = 0;
        }
        for(int i = 0; i <= (text.length() - k); i++){
            String pattern = text.substring(i, i + k);
            int j = patternToNumber(pattern);
            frequencyArray[j] = frequencyArray[j] + 1;
        }
        return frequencyArray;
    }

    public static Set <String> fasterFrequentwords(String text, int k) {
        Set<String> frequentPatterns = new HashSet<String>();
        int[] frequencyArray = computingFrequencies(text,k);
        int maxCount = 0;
        for(int i = 0; i < frequencyArray.length; i++){
            if(frequencyArray[i] > maxCount){
                maxCount = frequencyArray[i];
            }
        }
        int len = (int) (Math.pow(4,k));
        for(int i = 0; i < len; i++){
            if (frequencyArray[i] == maxCount){
                String pattern = numberToPattern(i, k);
                frequentPatterns.add(pattern);
            }
        }
        return frequentPatterns;
    }
}
