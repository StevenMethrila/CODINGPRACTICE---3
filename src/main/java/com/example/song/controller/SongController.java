/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.song.service.SongJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.song.model.Song;
import java.util.*;

@RestController
public class SongController {

    @Autowired
    SongJpaService sjp;

    @GetMapping("/songs")
    public ArrayList<Song> getMethod() {
        return sjp.getAll();
    }

    @PostMapping("/songs")
    public Song postMethod(@RequestBody Song song) {
        return sjp.addMethod(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getMethodById(@PathVariable("songId") int songId) {
        return sjp.getById(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song putMethod(@PathVariable("songId") int songId, @RequestBody Song song) {
        return sjp.updatemethod(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deleteMethod(@PathVariable("songId") int songId) {
        sjp.remove(songId);
    }
}