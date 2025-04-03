/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtracise.models;

/**
 * Represents an exercise that can be included in a workout.
 * Contains the exercise's ID, name, description, and a demo photo reference.
 * Provides methods for getting and setting these values.
 * 
 * Instances of this class can be used to display exercise details
 * in UI components or to store data within the application's database.
 * 
 * This class also overrides {@code toString()} to provide
 * a human-readable string representation for debugging and UI purposes.
 * 
 * @author aaron
 */
public class Exercici {
    /** The unique ID of the exercise. */
    private int id;
    /** The name of the exercise. */
    private String nomExercici;
    /** A brief description of the exercise. */
    private String descripcio;
    /** A reference (path or URL) to a demo photo of the exercise. */
    private String demoFoto;
    
    /**
     * Default constructor for creating an empty Exercici instance.
     */
    public Exercici() {
    }
    
    /**
     * Overrides the default string representation to include exercise name and description.
     * 
     * @return A string containing the exercise name and description.
     */
    @Override
    public String toString() {
        return nomExercici + " - " + descripcio;
    }
    
    /**
     * Retrieves the unique ID of the exercise.
     *
     * @return The numeric identifier for this exercise.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Assigns a unique ID to this exercise.
     *
     * @param id The numeric identifier to set for this exercise.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retrieves the name of the exercise.
     *
     * @return The name of this exercise.
     */
    public String getNomExercici() {
        return nomExercici;
    }
    
    /**
     * Assigns a new name to this exercise.
     *
     * @param nomExercici The exercise name to set.
     */
    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }
    
    /**
     * Retrieves the descriptive text for this exercise.
     *
     * @return A brief description of the exercise.
     */
    public String getDescripcio() {
        return descripcio;
    }
    
    /**
     * Assigns or updates the description for this exercise.
     *
     * @param descripcio A brief description of the exercise.
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    /**
     * Retrieves the reference (path/URL) of the demo photo associated with this exercise.
     *
     * @return A string representing the exercise's demo photo reference.
     */
    public String getDemoFoto() {
        return demoFoto;
    }
    
    /**
     * Assigns or updates the reference for the demo photo of this exercise.
     *
     * @param demoFoto A string that specifies the path or URL of the exercise's demo image.
     */
    public void setDemoFoto(String demoFoto) {
        this.demoFoto = demoFoto;
    }
}
