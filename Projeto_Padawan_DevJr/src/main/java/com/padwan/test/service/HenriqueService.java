package com.padwan.test.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HenriqueService {

    public List<String> skills(){
        List<String> skills = new ArrayList<>();
        skills.add("banco de dados");
        skills.add("python");
        skills.add("linux");
        skills.add("c++");
        skills.add("ingles");
        return skills;
    }

}
