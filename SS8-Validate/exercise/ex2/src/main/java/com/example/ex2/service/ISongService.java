package com.example.ex2.service;

import com.example.ex2.dto.SongDto;
import com.example.ex2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    Song findById(int id);
    boolean add(Song song);
    boolean update(Song song);
}
