package com.example.myfirstapplication.service;

import com.example.myfirstapplication.dao.InquiryDao;
import com.example.myfirstapplication.entity.Inquiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InquiryServiceImp implements InquiryService{
    private final InquiryDao dao;
    @Autowired
    InquiryServiceImp(InquiryDao inquiryDao) {
        this.dao = inquiryDao;
    }
    @Override
    public void insert(Inquiry inquiry) {
        dao.insertInquiry(inquiry);
    }

    @Override
    public List<Inquiry> getAll() {
        return dao.getAll();
    }

    @Override
    public void update(Inquiry inquiry) {
        if (dao.updateInquiry(inquiry) == 0) {
            throw new InquiryNotFoundException("can't find the same ID");
        }
    }
}
