package com.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Song;
import com.project.repository.SongRepository;
import com.project.service.SongService;

@Service
public class SongServiceImpl implements SongService{

	@Autowired
	SongRepository songRepository;

	@Override
	public void saveSong(Song song) {
		songRepository.save(song);
	}

	@Override
	public boolean songExists(String name) {

		Song song = songRepository.findByName(name);

		if(song != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = songRepository.findAll();
		return songs;
	}

	@Override
	public void updateSong(Song song) {
		// TODO Auto-generated method stub
		songRepository.save(song);
		
	}

}
