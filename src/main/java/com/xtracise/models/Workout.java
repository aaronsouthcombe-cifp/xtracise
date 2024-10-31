/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtracise.models;

/**
 *
 * @author aaron
 */
public class Workout {
    private int id;
    private String forDate;
    private int idUsuari;
    private String comments;
    
    public Workout() {
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getForDate() {
        return forDate;
    }
    
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }
    
    public int getIdUsuari() {
        return idUsuari;
    }
    
    public void setIdUsuari(int idUsuari) {
        this.idUsuari = idUsuari;
    }
    
    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
}
