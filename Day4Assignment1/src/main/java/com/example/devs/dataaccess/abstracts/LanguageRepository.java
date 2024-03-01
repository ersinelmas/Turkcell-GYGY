package com.example.devs.dataaccess.abstracts;

import com.example.devs.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    void add(Language language);

    void delete(Language language);

    void update(Language language);

    List<Language> getAll();

    Language getById(int id);
}
