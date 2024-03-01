package com.example.devs.dataaccess.concretes;

import com.example.devs.dataaccess.abstracts.LanguageRepository;
import com.example.devs.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<Language>();
        languages.add(new Language(1, "Java"));
        languages.add(new Language(2, "C#"));
        languages.add(new Language(3, "Python"));
        languages.add(new Language(4, "JavaScript"));
        languages.add(new Language(5, "C++"));
    }
    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void delete(Language language) {
        languages.remove(language);
    }

    @Override
    public void update(Language language) {
        Language languageToUpdate = languages.stream().filter(l -> l.getId() == language.getId()).findFirst().orElse(null);
        languageToUpdate.setName(language.getName());

        System.out.println("Language updated: " + language.getName());
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public Language getById(int id) {
        return languages.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
    }
}
