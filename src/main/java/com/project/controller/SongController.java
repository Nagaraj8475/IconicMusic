package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Song;
import com.project.service.SongService;

@Controller
public class SongController {

	@Autowired
	SongService songService;

	@PostMapping("/addsongs")
	public String addSong(@ModelAttribute Song song) {

		String name = song.getName();

		boolean songExists = songService.songExists(name); 

		if(songExists == false) {
			songService.saveSong(song);

		}else {
			System.out.println("Duplicate entry");
		}

		return "adminhome";
	}



	@GetMapping("/viewsongs")
	public String viewSongs(Model model) {
		
		List<Song> songslist =  songService.fetchAllSongs();
		model.addAttribute("songs", songslist);
		System.out.println(songslist);
		return "viewsongs";
		
	}
	
	
	
	@GetMapping("/playsongs")
	public String playSongs(Model model) 
	{
		boolean premium = false;
		if(premium)
		{
			List<Song> songslist =  songService.fetchAllSongs();
			model.addAttribute("songs", songslist);
			System.out.println(songslist);
			return "viewsongs";
		}
		else 
		{
			return "pay";
	    }
	}

	
	

}




