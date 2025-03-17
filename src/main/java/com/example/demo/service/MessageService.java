package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.Message;

@Service
public class MessageService {
    
    public Message getMessage() {
        return new Message("Hello from the backend!");
    }
}