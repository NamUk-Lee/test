package com.example.service;

import com.example.domain.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public String sayHello(Person p){
        return p.getName() + " Hello!";
    }

}
