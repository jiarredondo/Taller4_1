package com.example.taller4;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.taller4.Models.Persona;

import java.util.List;

@Dao
public interface PersonaDao {

        @Insert
        public void insert(Persona... personas);

        @Update
        public void update(Persona... personas);

        @Delete
        public void delete(Persona... personas);

        @Query("SELECT * FROM personas")
        public List<Persona> getItems();

    @Query("SELECT count(id) FROM personas")
    public int getCount();
    }
