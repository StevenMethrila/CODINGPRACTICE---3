/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here
package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.song.repository.SongRepository;
import com.example.song.model.Song;
import com.example.song.repository.SongJpaRepository;
import java.util.*;

@Service
public class SongJpaService implements SongRepository {

	@Autowired
	private SongJpaRepository sjr;

	@Override
	public ArrayList<Song> getAll() {
		List<Song> l = sjr.findAll();
		ArrayList<Song> arr = new ArrayList<>(l);
		return arr;
	}

	@Override
	public Song addMethod(Song song) {
		sjr.save(song);
		return song;
	}

	@Override
	public Song getById(int songId) {
		try {
			Song s = sjr.findById(songId).get();
			return s;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Song updatemethod(int songId, Song song) {
		try {
			Song s = sjr.findById(songId).get();
			if (song.getSongName() != null) {
				s.setSongName(song.getSongName());
			}
			if (song.getLyricist() != null) {
				s.setLyricist(song.getLyricist());
			}
			if (song.getSinger() != null) {
				s.setSinger(song.getSinger());
			}
			if (song.getMusicDirector() != null) {
				s.setMusicDirector(song.getMusicDirector());
			}
			sjr.save(s);
			return s;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void remove(int songId) {
		try {
			sjr.deleteById(songId);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}