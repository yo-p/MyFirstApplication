package com.example.myfirstapplication.service;

public class InquiryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public  InquiryNotFoundException(String message) {
        super(message);
    }
}
