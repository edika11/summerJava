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
public class Compte {
    int idCompte;
    double solde;
    int idUser;
    int idAdmin;

    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }
    
    //Constructeur sans parametre
    public Compte(){
    }
    
    //Constructeur avec parametres
    public Compte(int idCompte, double solde, int idUser, int idAdmin) {
        this.idCompte = idCompte;
        this.solde = solde;
        this.idUser = idUser;
        this.idAdmin = idAdmin;
    }
    
    //Methode pour sauvegarder un compte
    public void save(double solde, int idUser, int idAdmin) throws SQLException {
        //Commande d'insertion dans la BD
        String command = "INSERT INTO compte (solde, idUser, idAdmin) VALUES (?, ?, ?)";
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
            
        addstmt.setObject(1, solde);
        addstmt.setObject(2, idUser);
        addstmt.setObject(3, idAdmin);
        addstmt.execute();
    }
    
    //Methode pour mettre a jour un comtpe
    public void update(int idCompte, double solde, int idUser, int idAdmin) throws SQLException{
        String command = "UPDATE compte SET solde = ?, idUser = ?, idAdmin = ? WHERE compte.idCompte = ?;";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        addstmt.setObject(1, solde);
        addstmt.setObject(2, idUser);
        addstmt.setObject(3, idAdmin);
        addstmt.setObject(4, idCompte);
        addstmt.execute();
    }
    
    //Methode pour supprimer un compte
    public void delete(int idCompte) throws SQLException{
        String command = "DELETE FROM compte WHERE compte.idCompte = ?;";
        
        PreparedStatement addstmt = JDBC.getConnexion().prepareStatement(command);
        addstmt.setObject(1, idCompte);
        addstmt.execute();
    }
    
    //Methode pour recuperer les attributs d'un compte dans la BD connaissant son id et creer un objet
    public Compte getOne(int idCompte) throws SQLException{
        String command = "SELECT * FROM compte WHERE compte.idCompte = ?;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        stmt.setObject(1, idCompte);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Compte(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
        }
        
        return null;
        
    }
    
    public Compte getCompteByIdUser(int idUser) throws SQLException{
        String command = "SELECT * FROM compte WHERE compte.idUser = ?; ";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        stmt.setObject(1,idUser);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
            return new Compte(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4));
        }
        
        return null;
    }
    
    //Methode pour recuperer tous les comptes de la BD
    public List<Compte> getAllCompte() throws SQLException{
        String command = "SELECt * FROM compte ORDER BY idCompte DESC;";
        
        PreparedStatement stmt = JDBC.getConnexion().prepareStatement(command);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Compte> listCompte = new ArrayList<>();
        while(rs.next()){
            listCompte.add(new Compte(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getInt(4)));
        }
        
        return listCompte;
    }
    
    //Afficher les attributs de l'adminstrateur
    @Override
    public String toString(){
        return "Compte{ idCompte = " + idCompte + ", solde = " + solde + ", idUser = " + idUser + ", idAdmin = " + idAdmin; 
    }
    
    
    /*
    public static void main(String arg[]){
        Compte compte = new Compte();
        try{
            //compte.save(7000000, 1, 1);
            String result = compte.getOne(1).toString();
            System.out.println(result);
            
            compte.update(1, 6500000.55, 1, 1);
            
            result = compte.getOne(1).toString();
            System.out.println(result);
        } catch(SQLException ex){
            Logger.getLogger(Compte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
}
