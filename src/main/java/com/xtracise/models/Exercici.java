/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xtracise.models;

/**
 *
 * @author aaron
 */
public class Exercici {
    private int id;
    private String nomExercici;
    private String descripcio;
    private String demoFoto;
    
    public Exercici() {
    }
    
    // Getters and setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNomExercici() {
        return nomExercici;
    }
    
    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }
    
    public String getDescripcio() {
        return descripcio;
    }
    
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
    
    public String getDemoFoto() {
        return demoFoto;
    }
    
    public void setDemoFoto(String demoFoto) {
        this.demoFoto = demoFoto;
    }
}
