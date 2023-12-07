package org.example.models;

import lombok.Getter;
import org.example.Api;
import org.example.enums.ELangage;
import org.example.enums.Pattern;

import java.util.List;

@Getter
public class Language {
    List<String> languages;
    String userLanguage;
    Api api;
    ELangage userELanguage;

    public Language(Api api) {
        this.api = api;
        languages = api.getLanguages();
    }
    
    public void setUserLanguage(String userLanguage) {
        this.userELanguage = ELangage.getELanguage(userLanguage);
        this.userLanguage = userLanguage;
    }

    public String translateWord(Pattern pattern) {
        return this.userELanguage == null ? api.getTranslationByWord(pattern.french, userLanguage) : pattern.getTranslation(this.userELanguage);
    }
}
