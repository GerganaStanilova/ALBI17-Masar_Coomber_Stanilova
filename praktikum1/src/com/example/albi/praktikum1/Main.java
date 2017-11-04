package com.example.albi.praktikum1;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Hallo Welt
        String text = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        for (String item : FrequentWords.frequentWords(text,k)) {
            System.out.println(item);
        }
    }
}
