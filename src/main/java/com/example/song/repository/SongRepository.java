// Write your code here
package com.example.song.repository;

import com.example.song.model.Song;
import java.util.ArrayList;

public interface SongRepository {

    public ArrayList<Song> getAll();

    public Song addMethod(Song song);

    public Song getById(int songId);

    public Song updatemethod(int songId, Song song);

    public void remove(int songId);
}