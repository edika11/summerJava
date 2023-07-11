/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.controlleur;

import com.summercoding.bank.entities.Admin;
import com.summercoding.bank.entities.Compte;
import com.summercoding.bank.entities.Utilisateur;
import com.summercoding.bank.gestionnaires.GestionnaireAdmin;
import com.summercoding.bank.gestionnaires.GestionnaireCompte;
import com.summercoding.bank.gestionnaires.GestionnaireUtilisateur;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Edika Edmond Junior
 */
public class Controller {
    //Cas d'un admin
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    
    public Admin routeVersLoginAdmin(String login, String password) throws SQLException{
        return gestionnaireAdmin.login(login, password);
    }
    
    public Admin routeVersGetAdminByIdAdmin(int Admin) throws SQLException{
        return gestionnaireAdmin.getAdminByIdAdmin(Admin);
    }
    
    public void routeVersSaveAdmin(String login, String password, String nom)throws SQLException{
        gestionnaireAdmin.saveAdmin(login, password, nom);
    }
    
    public List<Admin> routeVerslistAllAdmin() throws SQLException{
        return gestionnaireAdmin.listAllAdmin();
    }
    
    
    //Cas d'un utilisateur
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    public Utilisateur routeVersLoginUtilisateur(String login, String password) throws SQLException{
        return gestionnaireUtilisateur.login(login, password);
    }
    
    public Utilisateur routeVersGetUtilisateurByIdUser(int idUser) throws SQLException{
        return gestionnaireUtilisateur.getUtilisateurByIdUser(idUser);
    }
    
    public void routeVersSaveUtilisateur(String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        gestionnaireUtilisateur.saveUtilisateur(login, password, nom, prenom, dateNaissance, genre, idAdmin);
    }
    
    public List<Utilisateur> routeVersAllUtilisateur() throws SQLException{
        return gestionnaireUtilisateur.listAllUtilisateur();
    }
    
    
    //Cas d'un compte
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
    
    public void routeVersSaveCompte(double solde, int idUser, int idAdmin) throws SQLException{
        gestionnaireCompte.saveCompte(solde, idUser, idAdmin);
    }
    
    public List<Compte> routeVersAllCompte() throws SQLException{
        return gestionnaireCompte.listAllCompte();
    }
}
