package com.example.devs.webapi.controllers;

import com.example.devs.business.abstracts.LanguageService;
import com.example.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/add")
    public void add(Language language) {
        languageService.add(language);
    }

}
