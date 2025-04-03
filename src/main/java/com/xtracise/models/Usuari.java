/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtracise.models;

/**
 * Represents a user (or client) in the XTRACISE system.
 * Contains user identification and authentication data, as well as
 * flags indicating whether the user is an instructor and which instructor they are assigned to.
 * 
 * The {@code toString()} method provides a concise textual representation
 * of the user's name and email, useful for UI components like lists.
 * 
 * @author aaron
 */
public class Usuari {
    /** The unique ID of the user. */
    private int id;
    /** The name of the user. */
    private String nom;
    /** The email address of the user. */
    private String email;
    /** The hashed password stored for authentication. */
    private String passwordHash;
    /** Flag indicating whether this user is an instructor. */
    private boolean instructor;
    /** The ID of the instructor this user is assigned to (if any). */
    private int assignedInstructor;
    
    /**
     * Default constructor for creating an empty Usuari instance.
     */
    public Usuari() {
    }
    
    /**
     * Overrides the default {@code toString()} method to display the user's name and email.
     *
     * @return A string containing the user's name followed by their email.
     */
    @Override
    public String toString() {
        return nom + " " + email;
    }
    
    /**
     * Retrieves the unique ID of this user.
     *
     * @return The numeric identifier for the user.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Assigns the unique ID for this user.
     *
     * @param id The numeric identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Retrieves the name of this user.
     *
     * @return The name of the user.
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * Assigns or updates the name for this user.
     *
     * @param nom The new name for the user.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Retrieves the email address associated with this user.
     *
     * @return A string representing the user's email address.
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Assigns or updates the email for this user.
     *
     * @param email The new email address to set for the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Retrieves the stored hash of the user's password.
     *
     * @return A string representing the password hash.
     */
    public String getPasswordHash() {
        return passwordHash;
    }
    
    /**
     * Assigns or updates the password hash for this user.
     *
     * @param passwordHash A hashed version of the user's password.
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    
    /**
     * Checks whether this user is flagged as an instructor.
     *
     * @return true if the user is an instructor; false otherwise.
     */
    public boolean isInstructor() {
        return instructor;
    }
    
    /**
     * Sets the user's instructor flag.
     *
     * @param instructor true if the user should be an instructor; false otherwise.
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }
    
    /**
     * Retrieves the ID of the instructor this user is assigned to.
     *
     * @return The numeric ID of the assigned instructor.
     */
    public int getAssignedInstructor() {
        return assignedInstructor;
    }
    
    /**
     * Sets the ID of the instructor that this user is assigned to.
     *
     * @param assignedInstructor The numeric ID of the instructor.
     */
    public void setAssignedInstructor(int assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }
}
