package com.restapi.restapi.controller;

import com.restapi.restapi.exception.ResourceNotFoundException;
import com.restapi.restapi.model.Note;
import com.restapi.restapi.repository.NoteRepository;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

//@RestController annotation is a combination of Spring’s @Controller and @ResponseBody annotations.
@RestController
@RequestMapping("/api/v1") 
@Api(value = "Note Controller", description = "Operations pertaining to Note in Note Application", produces = "application/json")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @ApiOperation(value = "View a list of available notes", produces = "application/json")
    @GetMapping("/notes") //or boleh buat @RequestMapping(value="/notes", method=RequestMethod.GET).
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/country/{country}")
    public String getCountry(@PathVariable(value = "country") String country) {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://api-nazmi-test-nazmi-project.apps.ocp.tmrnd.com.my/country/" + country;
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        String body = response.getBody();
        return body;
    }
    @GetMapping("/home")
    public String getHome() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://10.10.44.26:8080/";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        String body = response.getBody();
        return body;
    }

    //The @RequestBody annotation is used to bind the request body with a method parameter.
    @ApiOperation(value = "Create a new note", response = Note.class, consumes = "application/json")
    @PostMapping("/notes")
    public Note createNote(@ApiParam(name ="title", value = "String", required = true)  @Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @ApiOperation(value = "View a note by id", produces = "application/json")
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @ApiOperation(value = "Update a note by id", produces = "application/json")
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                                           @Valid @RequestBody Note noteDetails) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }
}