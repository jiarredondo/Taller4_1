package com.example.taller4;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.content.ClipData;

import com.example.taller4.Models.Persona;

    @Database(entities = {Persona.class}, version = 1)
     public abstract class AppDatabase extends RoomDatabase {
        public abstract PersonaDao getItemDAO();

}
