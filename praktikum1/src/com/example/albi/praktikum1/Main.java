package com.example.albi.praktikum1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Hallo Welt
        String text = "GCGCG";
        String pattern = "GCG";
        int c = FrequentWords.patternCount(text, pattern);
        System.out.println(c);
    }
}
