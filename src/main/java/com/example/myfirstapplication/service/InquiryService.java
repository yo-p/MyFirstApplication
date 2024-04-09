package com.example.myfirstapplication.service;

import com.example.myfirstapplication.entity.Inquiry;

import java.util.List;

public interface InquiryService {
    void insert(Inquiry inquiry);
    List<Inquiry> getAll();
    void update(Inquiry inquiry);
}
