package com.project.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Playlist;
import com.project.entity.Song;
import com.project.repository.PlaylistRepository;
import com.project.service.PlaylistService;

@Service
public class PlaylistServiceImpl implements PlaylistService{

	@Autowired
	PlaylistRepository playlistRepository;

	@Override
	public List<Playlist> fetchAllSongs() {
		List<Playlist> songs = playlistRepository.findAll();
		return null;
	}

//	@Override
//	public void savePlaylist(Playlist playlist) {
//		// TODO Auto-generated method stub
//		playlistRepository.save(playlist);
//		
//	}

	@Override
	public void addPlaylist(Playlist playlist) {
		
		playlistRepository.save(playlist);
	}

	@Override
	public boolean playlistExists(String name) {
		Playlist playlist = playlistRepository.findByName(name);

		if(playlist != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Playlist> fetchAllPlaylist() {
		List<Playlist> songs = playlistRepository.findAll();
		return null;
	}

	@Override
	public List<Playlist> getAllPlaylists() {
		// TODO Auto-generated method stub
		return playlistRepository.findAll();
	}

	@Override
	public List<Playlist> fetchAllPlaylists() {
		 List<Playlist> playlist= playlistRepository.findAll();
		 return playlist;
	}
	  
}
   