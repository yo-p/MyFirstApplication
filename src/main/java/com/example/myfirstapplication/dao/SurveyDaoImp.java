package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SurveyDaoImp implements  SurveyDao{
    @Autowired
    private  final JdbcTemplate jdbcTemplate;

    public SurveyDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Survey survey) {
        jdbcTemplate.update("INSERT INTO survey(age, satisfaction, comment, created) VALUES (?, ?, ?, ?)",
                survey.getAge(), survey.getSatisfaction(), survey.getComment(), survey.getCreated());
    }

    @Override
    public List<Survey> getAll() {
        String sql = "SELECT id, age, satisfaction, comment, created FROM survey";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Survey> list = new ArrayList<>();
        for(Map<String, Object> map : resultList) {
            Survey survey = new Survey();
            survey.setId((int) map.get("id"));
            survey.setAge((int) map.get("age"));
            survey.setSatisfaction((int)map.get("satisfaction"));
            survey.setComment((String)map.get("comment"));
            survey.setCreated(((Timestamp) map.get("created")).toLocalDateTime());
            list.add(survey);
        }
        return  list;
    }
}
