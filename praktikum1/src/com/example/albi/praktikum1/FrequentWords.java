package com.example.albi.praktikum1;

public class FrequentWords {
    public static int patternCount(){
        String text = "GCGCG";
        String pattern = "GCG";
        int count = 0;
        for(i=0; i <= (text.length() - pattern.length()); i++){
            if ((text.substring(i, pattern.length())).equals(pattern)){
                count++;
            }
        }
        return count;

    }
}
