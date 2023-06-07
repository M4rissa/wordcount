package com.marissa.wordcount;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WordFrequencyAnalyserImpl implements WordFrequencyAnalyzer {


    @Override
    public int calculateHighestFrequency(String text) {
        return TextProcesserHelper.processText(text).values()
                .stream()
                .mapToInt(WordFrequencyImpl::getFrequency)
                .max()
                .orElse(0);
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        return TextProcesserHelper.processText(text).get(word).getFrequency();
    }

    //TODO moet top x zijn. Geeft sortering hoogste of laagste eerst?
    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        return TextProcesserHelper.processText(text).values().stream()
                .sorted(Comparator.comparingInt(WordFrequencyImpl::getFrequency))
                .collect(Collectors.toList());
    }
}
