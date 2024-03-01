package com.example.devs.business.concretes;

import com.example.devs.business.abstracts.LanguageService;
import com.example.devs.dataaccess.abstracts.LanguageRepository;
import com.example.devs.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
    @Override
    public void add(Language language) {
        //check if language name already exists
        List<Language> existingLanguages = languageRepository.getAll();
        if(existingLanguages != null){
            for (Language existingLanguage : existingLanguages) {
                if (existingLanguage.getName().equals(language.getName())) {
                    System.out.println("Language already exists!");
                    return;
                }
            }
        }
        languageRepository.add(language);
        System.out.println("Language added: " + language.getName());
    }

    @Override
    public void delete(Language language) {
        languageRepository.delete(language);
        System.out.println("Language deleted: " + language.getName());
    }

    @Override
    public void update(Language language) {
        //get language by id and if the new name is not already taken, update the language
        List<Language> existingLanguages = languageRepository.getAll();
        if (existingLanguages != null){
            for (Language existingLanguage : existingLanguages) {
                if (existingLanguage.getName().equals(language.getName())) {
                    System.out.println("Language already exists!");
                    return;
                }
            }
        }
        languageRepository.update(language);
        System.out.println("Language updated: " + language.getName());
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }
}
