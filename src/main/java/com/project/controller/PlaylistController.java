package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Playlist;
import com.project.entity.Song;
import com.project.service.PlaylistService;
import com.project.service.SongService;

@Controller
public class PlaylistController {
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/createplaylists")
	public String createplaylist(Model model) {
		List<Song> songList=songService.fetchAllSongs();
		model.addAttribute("songs",songList);
		return "createplaylists";	
	}
	
	@PostMapping("/addplaylist")
	public String addPlaylist(@ModelAttribute Playlist playlist) {
		String name = playlist.getName();
		boolean playlistExists = playlistService.playlistExists(name);

		if (playlistExists==false) {
		    playlistService.addPlaylist(playlist);
		} else {
		    System.out.println("Duplicate entry");
		}
		List<Song>songs=playlist.getSongs();
		
		for(Song song :songs)
		{
			song.getPlaylists().add(playlist);
			songService.updateSong(song);
		}

		return "adminhome";
	}

		@GetMapping("/viewplaylists")
		public String viewplaylists(Model model) {
	    List<Playlist> playlist = playlistService.fetchAllPlaylists();
	    model.addAttribute("playlist", playlist);
	    return "viewplaylists";

	  }
}
