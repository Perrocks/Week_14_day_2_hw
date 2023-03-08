package com.codeclan.example.files_and_folders_service.controllers;

import com.codeclan.example.files_and_folders_service.models.File;
import com.codeclan.example.files_and_folders_service.models.Folder;
import com.codeclan.example.files_and_folders_service.repositories.FileRepository;
import com.codeclan.example.files_and_folders_service.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public class FolderController {


    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/folders")
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/folders/{id}")
    public ResponseEntity<Optional<Folder>> getfolder(@PathVariable Long id){
        Optional<Folder> optonalFolder = folderRepository.findById(id);

        if(optonalFolder.isPresent()){
            return new ResponseEntity<>(optonalFolder, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(optonalFolder, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/folders")
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

}

