package com.example.myfirstapplication.service;

import com.example.myfirstapplication.entity.Survey;

import java.util.List;

public interface SurveyService {
    void insert(Survey survey);
    List<Survey> getAll();
}
