package br.com.ldsz.apilanguages;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages")
    public List<Language> obtainLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/languages")
    public Language addLanguage(@RequestBody Language language) {
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

}
