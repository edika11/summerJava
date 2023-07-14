/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Utilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Edika Edmond Junior
 */
public class GestionnaireUtilisateur {
    private Utilisateur utilisateur = new Utilisateur();
    
    //login de l'utilisateur
    public Utilisateur login(String login, String passsword) throws SQLException{
        return utilisateur.getByLoginAndPassword(login, passsword);
    }
    
    //Recuperer un utilisateur selon son ID
    public Utilisateur getUtilisateurByIdUser(int idUser) throws SQLException{
        return utilisateur.getOne(idUser);
    }
    
    //Enregister un utilisateur
    public void saveUtilisateur(String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        utilisateur.save(login, password, nom, prenom, dateNaissance, genre, idAdmin);
    }
    
    //Update un utilisateur
    public void updateUtilisateur(int idUser, String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        utilisateur.update(idUser, login, password, nom, prenom, dateNaissance, genre, idAdmin);
    }
    
    //Supprimer un utilisateur
    public void deleteUtilisateur(int idUser) throws SQLException{
        utilisateur.delete(idUser);
    }
    
    //Retourner la liste de tous les utlisateurs de la BD
    public List<Utilisateur> listAllUtilisateur() throws SQLException{
        return utilisateur.getAllUser();
    }
}
