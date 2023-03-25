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

    @GetMapping("/songs/{songId}")
    public Song getSongById(@PathVariable("songId") int id){
        return songJpaService.getSongById(id);
    }
    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songJpaService.addSong(song);
    }
    @DeleteMapping("/songs/{songId}")
    public void deleteSongById(@PathVariable("songId") int id){
        songJpaService.deleteSongById(id);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@RequestBody Song song, @PathVariable("songId") int id){
        return songJpaService.updateSong(song, id);
    }
}