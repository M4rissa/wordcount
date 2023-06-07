package com.marissa.wordcount;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcesserHelper {

    private static final String WORD_REGEXP = "\\p{L}+";
    private static final Pattern WORD_PATTERN = Pattern.compile(WORD_REGEXP);
    public static Map<String, WordFrequencyImpl> processText(String text) {
        Map<String, WordFrequencyImpl> wordCountMap = new HashMap<>();
        Matcher m = WORD_PATTERN.matcher(text);
        while(m.find()) {
            String word = m.group();
            wordCountMap.computeIfAbsent(word, WordFrequencyImpl::new).count();
        }
        return wordCountMap;
    }
}
