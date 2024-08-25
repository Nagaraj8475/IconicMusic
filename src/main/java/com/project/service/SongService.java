package com.project.service;

import java.util.List;

import com.project.entity.Song;

public interface SongService {

	void saveSong(Song song);

	boolean songExists(String name);

	List<Song> fetchAllSongs();

	void updateSong(Song song);

	

	

}
