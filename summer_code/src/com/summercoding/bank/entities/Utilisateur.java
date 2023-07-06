/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.entities;

import com.summercoding.bank.utils.JDBC;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edika Edmond Junior
 */
public class Utilisateur {
    int idUser;
    String login;
    String password;
    String nom;
    String prenom;
    LocalDate dateNaissance;
    String genre;
    int idAdmin;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    //Constructeur sans paramètre
    public Utilisateur() {
    }
    
    //Constructeur avec paramètres

    public Utilisateur(int idUser, String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.genre = genre;
        this.idAdmin = idAdmin;
    }
    
    //Methode pour sauvegarder un utilisateur dans la BD
    public void save(String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        String command = "INSERT INTO utilisateur (login, password, nom, prenom, dateNaissance, genre, idAdmin) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            
        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, prenom);
        addstmt.setObject(5, dateNaissance);
        addstmt.setObject(6, genre);
        addstmt.setObject(7, idAdmin);
        addstmt.execute();
    }
    
    //Methode pour mettre à jour un utilisateur
    public void update(int idUser, String login, String password, String nom, String prenom, LocalDate dateNaissance, int idAdmin) throws SQLException{
        String command = "UPDATE utilisateur SET login = ?, password = ?, nom = ?, prenom = ?, dateNaissance = ?, idAdmin = ? WHERE utilisateur.idUser = ?;";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        
        addstmt.setObject(1, login);
        addstmt.setObject(2, password);
        addstmt.setObject(3, nom);
        addstmt.setObject(4, prenom);
        addstmt.setObject(5, dateNaissance);
        addstmt.setObject(6, idAdmin);
        addstmt.setObject(7, idUser);
        addstmt.execute();
    }
    
    //Methode pour supprimer un utilisateur
    public void delete(int idUser) throws SQLException{
        String command = "DELETE FROM utilisateur WHERE utilisateur.idUser = ?;";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        
        addstmt.setObject(1, idUser);
        addstmt.execute();
    }
    
    //Methode pour recuperer les attributs d'un utilisateur ayant son id et creer un objet
    public Utilisateur getOne(int idUser) throws SQLException{
        String command = "SELECT * FROM utilisateur WHERE utilisateur.idUser = ?;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        stmt.setObject(1, idUser);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8));
        }
        
        return null;
    }
    
    //Methode pour recuperer les attributs d'un utilisateur ayant son login et son password et creer un objet
    public Utilisateur getByLoginAndPassword(String login, String password) throws SQLException{
        String command = "SELECT * FROM utilisateur WHERE utilisateur.login = ? AND utilisateur.password = ?;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        stmt.setObject(1, login);
        stmt.setObject(2, password);
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8));
        }
        
        return null;
    }
    
    //Methode pour recuperer tous les utilisateurs de la BD
    public List<Utilisateur> getAllUser() throws SQLException{
        String command = "SELECT * FROM utilisateur";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        ResultSet rs = stmt.executeQuery();
        
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        while(rs.next()){
            listUtilisateur.add(new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6).toLocalDate(), rs.getString(7), rs.getInt(8)));
        }
        
        return listUtilisateur;
    }
    
    //Methode pour afficher les attributs de l'utilisateur
    @Override
    public String toString() {
        return "utilisateur{idUser =  " + idUser + ", login = " + login + ", password = " + password + ", nom = " + nom + ", prenom = " + prenom + ", date de naissance = " + dateNaissance + ", genre = " + genre + ", idAdmin = " + idAdmin;
    }
    
    
    
    public static void main(String arg[]){
        Utilisateur utilisateur = new Utilisateur();
        try{
            //utilisateur.save("biltchatcho@gmail.com", "1234", "Tchatcho", "Bil", LocalDate.of(2003, Month.JUNE, 12), "M", 1);
            String result = utilisateur.getOne(1).toString();
            System.out.println(result);
        } catch(SQLException ex){
            Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
