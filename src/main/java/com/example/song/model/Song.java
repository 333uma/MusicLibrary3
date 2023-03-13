package com.example.song.model;
import javax.persistence.*;


@Entity
@Table(name = "playlist")
public class Song{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songid")
    private int songId;

    @Column(name = "songname")
    private String songName;

    @Column(name = "lyricist")
    private String lyricist;

    @Column(name = "singer")
    private String singer;

    @Column(name = "musicdirector")
    private String musicDirector;

    public Song(){}
}
