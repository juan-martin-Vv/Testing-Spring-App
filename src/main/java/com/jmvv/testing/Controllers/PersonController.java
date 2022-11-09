package com.jmvv.testing.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jmvv.testing.Models.Person;
import com.jmvv.testing.Services.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/person/")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService pService;

    @GetMapping("")
    public ResponseEntity <?> getAll(){
        List<Person> list = pService.getAllPerson();
        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
    }
    @PostMapping("save")
    public ResponseEntity <?> savePerson(@RequestBody Person person){
        Person p_save=pService.savePerson(person);
        return  new ResponseEntity<Person>(p_save,HttpStatus.OK);
    }
    @GetMapping("id:{num-id}")
    public ResponseEntity <?> getPersonById(@RequestParam(name = "num-id",defaultValue = "0") int number_id){
        return new ResponseEntity<Person>(pService.getPerson(number_id), HttpStatus.OK);
    }
}
