package com.example.albi.praktikum1;

public class Main {

    public static void main(String[] args) {
        /*String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        for (String item : FrequentWords.frequentWords(text,k)) { //jedes Element im Set frequentPatterns ausgeben
            System.out.println(item);
        }
        //String pattern = "AGT";
        //System.out.println(FastFrequentWords.patternToNumber(pattern));
        //System.out.println(FastFrequentWords.numberToPattern(11,3));

        for (int item : FastFrequentWords.computingFrequencies("AAGCAAAGGTGGG",2)) { //jedes Element im Set frequentPatterns ausgeben
            System.out.println(item);
        }*/
        String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        for (String item : FastFrequentWords.fasterFrequentwords(text,k)) { //jedes Element im Set frequentPatterns ausgeben
            System.out.println(item);
        }
    }
}
