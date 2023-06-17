package com.marissa.wordcount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WordFrequencyController implements WordFrequencyAnalyzer {

    private final WordFrequencyAnalyzerImpl wordFrequencyAnalyzer;

    public WordFrequencyController() {
        this.wordFrequencyAnalyzer = new WordFrequencyAnalyzerImpl();
    }

    @GetMapping("/highest")
    @Override
    public int calculateHighestFrequency(@RequestParam(value = "text") String text) {
        return wordFrequencyAnalyzer.calculateHighestFrequency(text);
    }

    @GetMapping("/word")
    @Override
    public int calculateFrequencyForWord(@RequestParam(value = "text") String text, @RequestParam(value = "word") String word) {
        return wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);
    }

    @GetMapping("list")
    @Override
    public List<WordFrequency> calculateMostFrequentNWords(@RequestParam(value = "text") String text, @RequestParam(value = "n") int n) {
        return wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);
    }
}
