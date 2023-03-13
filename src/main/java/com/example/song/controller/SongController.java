package com.example.song.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import com.example.song.service.SongJpaService;
import com.example.song.model.Song;

@RestController
public class SongController{
    @Autowired
    public SongJpaService song;

    @GetMapping("/songs")
    public ArrayList<Song> getSongs(){
        return song.getSongs();
    }

    @GetMapping("/song/{songId}")
    public Song getSongById(@PathVariable("songId") int songId){
        return song.getSongById(songId);
    }
}