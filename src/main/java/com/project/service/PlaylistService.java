package com.project.service;

import java.util.List;

import com.project.entity.Playlist;
import com.project.entity.Song;

public interface PlaylistService {

	List<Playlist> fetchAllSongs();

//	void savePlaylist(Playlist playlist);

	void addPlaylist(Playlist playlist);

	boolean playlistExists(String name);

	List<Playlist> fetchAllPlaylist();

	List<Playlist> getAllPlaylists();

	List<Playlist> fetchAllPlaylists();
}
 