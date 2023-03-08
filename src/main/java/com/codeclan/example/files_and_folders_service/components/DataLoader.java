package com.codeclan.example.files_and_folders_service.components;

import com.codeclan.example.files_and_folders_service.models.File;
import com.codeclan.example.files_and_folders_service.models.Folder;
import com.codeclan.example.files_and_folders_service.models.Person;
import com.codeclan.example.files_and_folders_service.repositories.FileRepository;
import com.codeclan.example.files_and_folders_service.repositories.FolderRepository;
import com.codeclan.example.files_and_folders_service.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component

public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    PersonRepository personRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){

        Person steve = new Person("Steve");
        Person dave = new Person("Dave");
        Person sarah = new Person("Sarah");
        Person megan = new Person("Megan");
        personRepository.save(steve);
        personRepository.save(dave);
        personRepository.save(sarah);
        personRepository.save(megan);

        Folder payroll = new Folder("Payroll", sarah);
        Folder personnel = new Folder("Personnel", dave);
        folderRepository.save(payroll);
        folderRepository.save(personnel);

        File contact = new File("Contact Details", "txt", 1, personnel);
        File paySlips = new File("Pay Slips", "txt", 3, payroll);
        File secretSpyData = new File("Super Secret Spy Images", "img", 100, personnel);
        File unpaidInvoice = new File("Invoice 02/03/22", "pdf", 1, payroll);
        fileRepository.save(contact);
        fileRepository.save(paySlips);
        fileRepository.save(secretSpyData);
        fileRepository.save(unpaidInvoice);
    }

}
