package com.yg.learning.system.api.controller;

import com.yg.learning.system.model.pojo.Dictionary;
import com.yg.learning.system.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SystemController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionary/all")
    public List<Dictionary> getAllDictionaryList() {
        return dictionaryService.queryAll();
    }
}
