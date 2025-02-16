package org.example.censor_words;

import java.util.regex.Pattern;

public class CensorBadWords {
    public static void main(String[] args) {
        String sentence = "This is a damn bad example with some stupid words.";
        String[] badWords = {"damn", "stupid"};

        String censoredSentence = censorBadWords(sentence, badWords);
        System.out.println(censoredSentence);
    }

    public static String censorBadWords(String text, String[] badWords) {
        for (String word : badWords) {
            // Use word boundaries to match full words only
            String regex = "\\b" + Pattern.quote(word) + "\\b";
            text = text.replaceAll(regex, "****");
        }
        return text;
    }
}

