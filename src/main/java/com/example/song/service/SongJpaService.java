package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;
import com.example.song.model.Song;

@Service
public class SongJpaService implements SongRepository{
    @Autowired
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song> getSongs(){
        List<Song> songList = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(songList);
        return songs;
    }

    @Override
    public Song getSongById(int songId){
        try{
            Song song = songJpaRepository.findById(songId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
    }
    
    @Override
    public void deleteSongById(int songId){
        try{
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updateSong(Song song, int songId){
        Song s = songJpaRepository.findById(songId).get();
        if(song.getSongName() != null){
            s.setSongName(song.getSongName());
        }
        if(song.getLyricist() != null){
            s.setLyricist(song.getLyricist());
        }
        if(song.getSinger() != null){
            s.setSinger(song.getSinger());
        }
        if(song.getMusicDirector() != null){
            s.setMusicDirector(song.getMusicDirector());
        }
        songJpaRepository.save(s);
        return s;
    }
}