package com.example.myfirstapplication.dao;

import com.example.myfirstapplication.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class InquryDaoImp implements  InquiryDao{
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public InquryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertInquiry(Inquiry inquiry) {
        jdbcTemplate.update("INSERT INTO  inquiry(name, email, contents, created) VALUES (?, ?, ?, ?)",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());
    }

    @Override
    public int updateInquiry(Inquiry inquiry) {
        return jdbcTemplate.update("UPDATE inquiry SET name = ?, email = ?, contents = ? WHERE id = ?",
                inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getId());
    }

    @Override
    public List<Inquiry> getAll() {
        String sql = "SELECT id, name, email, contents, created FROM inquiry";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
        List<Inquiry> list = new ArrayList<>();
        for (Map<String, Object> map : resultList) {
            Inquiry inquiry = new Inquiry();
            inquiry.setId((int)map.get("id"));
            inquiry.setName((String) map.get("name"));
            inquiry.setEmail((String) map.get("email"));
            inquiry.setContents((String) map.get("contents"));
            inquiry.setCreated(((Timestamp) map.get("created")).toLocalDateTime());
            list.add(inquiry);
        }
        return list;
    }

}
