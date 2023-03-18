package com.example.song.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import com.example.song.service.SongJpaService;
import com.example.song.model.Song;

@RestController
public class SongController{
    @Autowired
    public SongJpaService songJpaService;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return songJpaService.getSongs();
    }

    @GetMapping("/songs/{id}")
    public Song getSongById(@PathVariable("id") int id){
        return songJpaService.getSongById(id);
    }
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songJpaService.addSong(song);
    }
    @DeleteMapping("/songs/{id}")
    public void deleteSongById(@PathVariable("id") int id){
        songJpaService.deleteSongById(id);
    }

    @PutMapping("/songs/{id}")
    public Song updateSong(@RequestBody Song song, @PathVariable("id") int id){
        return songJpaService.updateSong(song, id);
    }
}