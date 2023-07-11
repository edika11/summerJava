/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edika Edmond Junior
 */
public class Admin {
    
    int idAdmin;
    
    public int getIdAdmin(){
        return idAdmin;
    }
    
    public void setIdAdmin(int idAdmin){
        this.idAdmin = idAdmin;
    }
    
    String login;
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    String password;
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    String nom;
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }

    //Constructeur sans parametres
    public Admin() {
    }
    
    //Constructeur avec parametres
    public Admin(int idAdmin, String login, String password, String nom){
        this.idAdmin = idAdmin;
        this.login = login;
        this.password = password;
        this.nom = nom;
    }
    
    //Methode pour sauvegarder un administrateur
    public void save(String login, String password, String nom) throws SQLException{
        //Commande d'insertion dans la BD
            String command = "INSERT INTO admin (login, password, nom) VALUES (?, ?, ?)";
            PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            
            addstmt.setObject(1, login);
            addstmt.setObject(2, password);
            addstmt.setObject(3, nom);
            addstmt.execute();
    }
    
    
    //Methode pour mettre a jour un administrateur
    public void update(int idAdmin, String login, String password, String nom) throws SQLException{
        String command = "UPDATE admin SET login = ?, password = ?, nom = ? WHERE admin.idAdmin = ?";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        
        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, idAdmin);
        addstmt.execute();
    }
    
    //Methode pour supprimer un admministrateur
    public void delete(int idAdmin) throws SQLException{
        String command = "DELETE FROM admin WHERE admin.idAdmin = ?;";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        addstmt.setObject(1, idAdmin);
        addstmt.execute();
    }
    
    //Methode pour recuperer les attributs d'un admin dans la BD connaissant son id et creer un objet
    public Admin getOne(int idAdmin) throws SQLException{
        String command = "SELECT * FROM admin WHERE admin.idAdmin = ?;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        stmt.setObject(1, idAdmin);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        
        return null;
        
    }
    
    //Methode pour recuperer les attributs d'un admin dans la BD connaissant à partir de son login et son password et creer un objet
    public Admin getByLoginAndPassword(String login, String password) throws SQLException{
        String command = "SELECT * FROM admin WHERE login = ? AND password = ?;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        
        stmt.setObject(1, login);
        stmt.setObject(2, password);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
        }
        
        return null;
    }
    
    
    //Methode pour recuperer tous les administrateurs de la BD
    public List<Admin> getAllAdmin() throws SQLException{
        String command = "SELECt * FROM admin;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Admin> listAdmin = new ArrayList<>();
        while(rs.next()){
            listAdmin.add(new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        
        return listAdmin;
    }
    
    //Afficher les attributs de l'adminstrateur
    @Override
    public String toString(){
        return "Admin{ idAmdin = " + idAdmin + ", login = " + login + ", password = " + password + ", nom = " + nom; 
    }
    
    
    public static void main(String arg[]){
        Admin admin = new Admin();
        try{
        //admin.save("chatchuengtchino@gmail.com", "1234", "Tchino Léa");
        //admin.save("junioredika2002@gmail.com", "qwerty", "Edika Edmond");
        //admin.update(2, "junioredika2002@gmail.com", "qwerty", "Edika Edmond Junior");
        String result = admin.getOne(1).toString();
        System.out.println(result);
        
        result = admin.getOne(2).toString();
        System.out.println(result);
        
        result = admin.getByLoginAndPassword("junioredika2002@gmail.com", "qwerty").toString();
        System.out.println(result);
        } catch (SQLException ex){
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
