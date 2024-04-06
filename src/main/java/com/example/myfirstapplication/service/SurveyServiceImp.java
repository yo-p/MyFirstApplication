package com.example.myfirstapplication.service;

import com.example.myfirstapplication.dao.SurveyDao;
import com.example.myfirstapplication.entity.Survey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImp implements SurveyService{
    private final SurveyDao dao;

    public SurveyServiceImp(SurveyDao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(Survey survey) {
        dao.insert(survey);
    }

    @Override
    public List<Survey> getAll() {
        return dao.getAll();
    }
}
