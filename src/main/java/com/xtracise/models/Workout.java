/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtracise.models;

/**
 * Represents a workout session in the XTRACISE system. 
 * Contains the workout's unique ID, associated date, user ID, and any additional comments.
 * 
 * These fields can be used to create, retrieve, and modify workout details in the application 
 * or the backend database.
 * 
 * @author aaron
 */
public class Workout {
    /** The unique identifier for this workout. */
    private int id;
    /** The date on which this workout is scheduled or completed. */
    private String forDate;
    /** The user ID associated with this workout. */
    private int idUsuari;
    /** Additional notes or comments about this workout. */
    private String comments;
    
    /**
     * Default constructor for creating an empty Workout instance.
     */
    public Workout() {
    }
    
    /**
     * Retrieves the unique ID of this workout.
     *
     * @return The numeric identifier for this workout.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Assigns the unique ID for this workout.
     *
     * @param id The numeric identifier to set for this workout.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retrieves the date of this workout.
     *
     * @return A string representing the workout date.
     */
    public String getForDate() {
        return forDate;
    }
    
    /**
     * Assigns the date for this workout.
     *
     * @param forDate The date to set for this workout.
     */
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }
    
    /**
     * Retrieves the user ID associated with this workout.
     *
     * @return The numeric ID of the user linked to this workout.
     */
    public int getIdUsuari() {
        return idUsuari;
    }
    
    /**
     * Assigns the user ID for this workout.
     *
     * @param idUsuari The numeric identifier of the user to link to this workout.
     */
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    
    /**
     * Retrieves any additional comments or notes for this workout.
     *
     * @return A string containing comments about this workout.
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Assigns or updates comments for this workout.
     *
     * @param comments The remarks to associate with this workout.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}
