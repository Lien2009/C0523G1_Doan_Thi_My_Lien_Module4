package com.example.ex2.service;

import com.example.ex2.dto.SongDto;
import com.example.ex2.model.Song;
import com.example.ex2.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(int id) {
        Song song = songRepository.findById(id).get();
        return song;
    }

    @Override
    public boolean add(Song song) {
        Song song1 = songRepository.save(song);
        return song1!=null;
    }

    @Override
    public boolean update(Song song) {
        Song song1 = songRepository.save(song);
        return true;
    }
}
