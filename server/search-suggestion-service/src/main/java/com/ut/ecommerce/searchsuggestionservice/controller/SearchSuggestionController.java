package com.ut.ecommerce.searchsuggestionservice.controller;

import com.ut.ecommerce.searchsuggestionservice.dto.SearchSuggestionKeywordInfo;
import com.ut.ecommerce.searchsuggestionservice.service.SearchSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SearchSuggestionController {

    @Autowired
    SearchSuggestionService searchSuggestionService;

    @Autowired
    Environment environment;

    public void loadSearchSuggestions() {
        searchSuggestionService.loadSearchSuggestionToMap();
    }

    @GetMapping("/search-suggestion")
    public ResponseEntity<?> searchKeyword(@RequestParam String q) {
        System.out.println("q : " + q);
        return ResponseEntity.ok(searchSuggestionService.searchKeywordFromMap(q));
    }

    @GetMapping("/default-search-suggestion")
    public ResponseEntity<?> defaultSearchSuggestions() {
    
        List<SearchSuggestionKeywordInfo> resultList
                = searchSuggestionService.getDefaultSearchSuggestions();
                System.out.println("Controller : default-search-suggestion -> " + resultList);
        return ResponseEntity.ok(resultList);
    }
}
