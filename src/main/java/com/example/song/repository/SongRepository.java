package com.example.song.repository;

import com.example.song.model.Song;
import java.util.*;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song getSongById(int songId);
    Song addSong(Song song);
    void deleteSongById(int songId);
    Song updateSong(Song song, int songId);
}