package com.codeclan.example.files_and_folders_service.controllers;

import com.codeclan.example.files_and_folders_service.models.Folder;
import com.codeclan.example.files_and_folders_service.models.Person;
import com.codeclan.example.files_and_folders_service.repositories.FolderRepository;
import com.codeclan.example.files_and_folders_service.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Optional<Person>> getPerson(@PathVariable Long id){
        Optional<Person> optonalPerson = personRepository.findById(id);

        if(optonalPerson.isPresent()){
            return new ResponseEntity<>(optonalPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optonalPerson, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/persons")
    public ResponseEntity<Person> postPerson(@RequestBody Person person){
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
