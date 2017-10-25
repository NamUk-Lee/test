package com.example.controller;

import com.example.domain.Person;
import com.example.service.PersonService;
import com.example.store.PersonRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by existmaster on 2016. 6. 7..
 */
@RestController
@RequestMapping(value = "people")
public class WebController {

    private final Log log = LogFactory.getLog(getClass());

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonService personService;

    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
    public Person personInput(@RequestBody Person person){
        Person result = personRepository.save(person);

        return result;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Person> person(){
         Iterable<Person> result = personRepository.findAll();

        return result;
    }

    @RequestMapping(value="/search", method = RequestMethod.GET)
    public Iterable<Person> personSearch(@RequestParam("name") String name){
        Iterable<Person> result = personRepository.findByName(name);
        for (Person p : result) {
            log.info(personService.sayHello(p));
        }
        return result;

    }

}
