package com.example.song.repository;

import com.example.song.model.Song;
import java.util.*;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song getSongById(int id);
    Song addSong(Song song);
    void deleteSongById(int id);
    Song updateSong(Song song, int id);
}