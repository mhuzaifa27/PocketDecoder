package com.jexample.pocketdecoder.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to manage Anagram with words loading and words searching for entered letters
 */
public class Anagram {

    private static final String DICT = "dict";
    // list of words loaded for searching anagrams
    private static final List<String> WORDS = new ArrayList<>();
    // Boolean indicating if words are loaded or no
    private static boolean LOADED = false;

    public static boolean isLoaded() {
        return LOADED;
    }

    // Method for loading words from assets
    public static void loadWords(Context context) {
        BufferedReader buf = null;

        try {
            buf = new BufferedReader(new InputStreamReader(context.getAssets().open(DICT)));

            String line = null;

            // we read file line by line to store words
            while ((line = buf.readLine()) != null) {
                // we set words in upper case to make
                // things easier when searching anagrams for entered letters
                WORDS.add(line.toUpperCase());
            }

            LOADED = true;

        } catch (IOException ioe) {
            // ...
        } finally {
            if (buf != null) {
                try {
                    buf.close();
                } catch (IOException e) {
                    // ...
                }
            }
        }
    }

    // Method for comparing two strings and returning true if they have same letters
    public static boolean sameLetters(String a, String b) {
        if (a == null)
            return b == null;
        if (b == null)
            return false;

        char[] left = a.toCharArray();
        char[] right = b.toCharArray();

        // we sort caracters of each String
        Arrays.sort(left);
        Arrays.sort(right);

        // we compare both sorted arrays
        return Arrays.equals(left, right);
    }

    // Method returning all anagrams for entered letters
    public static List<String> listWords(String letters) {
        List<String> list = new ArrayList<>();

        for (String word : WORDS) {
            if (sameLetters(word.toUpperCase(), letters.toUpperCase()))
                list.add(word);
        }
        return list;
    }
}