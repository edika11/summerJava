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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Edika Edmond Junior
 */
public class Controller {
    //Cas d'un admin
    GestionnaireAdmin gestionnaireAdmin = new GestionnaireAdmin();
    
    //login de l'admin
    public Admin routeVersLoginAdmin(String login, String password) throws SQLException{
        return gestionnaireAdmin.login(login, password);
    }
    
    //retourner un admin selon son ID
    public Admin routeVersGetAdminByIdAdmin(int Admin) throws SQLException{
        return gestionnaireAdmin.getAdminByIdAdmin(Admin);
    }
    
    //Enregistrer un admin
    public void routeVersSaveAdmin(String login, String password, String nom)throws SQLException{
        gestionnaireAdmin.saveAdmin(login, password, nom);
    }
    
    //Update un admin
    public void routeVersUpdateAdmin(int idAdmin, String login, String password, String nom) throws SQLException{
        gestionnaireAdmin.upadteAdmin(idAdmin, login, password, nom);
    }
    
    //Supprimer un admin
    public void routeVersDeleteAdmin(int idAdmin) throws SQLException{
        gestionnaireAdmin.deleteAdmin(idAdmin);
    }
    
    //Retourner la liste de tous les admin
    public List<Admin> routeVerslistAllAdmin() throws SQLException{
        return gestionnaireAdmin.listAllAdmin();
    }
    
    
    //Cas d'un utilisateur
    GestionnaireUtilisateur gestionnaireUtilisateur = new GestionnaireUtilisateur();
    
    //login de l'admin
    public Utilisateur routeVersLoginUtilisateur(String login, String password) throws SQLException{
        return gestionnaireUtilisateur.login(login, password);
    }
    
    //Retourner un utilisateur selon son ID
    public Utilisateur routeVersGetUtilisateurByIdUser(int idUser) throws SQLException{
        return gestionnaireUtilisateur.getUtilisateurByIdUser(idUser);
    }
    
    //Enregistrer un utilisateur
    public void routeVersSaveUtilisateur(String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        gestionnaireUtilisateur.saveUtilisateur(login, password, nom, prenom, dateNaissance, genre, idAdmin);
    }
    
    //Update un utilisateur
    public void routeVersUpdateUtilisateur(int idUser, String login, String password, String nom, String prenom, LocalDate dateNaissance, String genre, int idAdmin) throws SQLException{
        gestionnaireUtilisateur.updateUtilisateur(idUser, login, password, nom, prenom, dateNaissance, genre, idAdmin);
    }
    
    //Supprimer un utilisateur
    public void routeVersDeleteUtilisateur(int idUser) throws SQLException{
        gestionnaireUtilisateur.deleteUtilisateur(idUser);
    }
    
    //Retourner la liste de tous les utilisateurs
    public List<Utilisateur> routeVersAllUtilisateur() throws SQLException{
        return gestionnaireUtilisateur.listAllUtilisateur();
    }
    
    
    //Cas d'un compte
    GestionnaireCompte gestionnaireCompte = new GestionnaireCompte();
    
    //Enregistrer un compte
    public void routeVersSaveCompte(double solde, int idUser, int idAdmin) throws SQLException{
        gestionnaireCompte.saveCompte(solde, idUser, idAdmin);
    }
    
    //Update un compte
    public void routeVersUpdateCompte(int idCompte, double solde, int idUser, int idAdmin) throws SQLException{
        gestionnaireCompte.updateCompte(idCompte, solde, idUser, idAdmin);
    }
    
    //Supprimer un compte
    public void routeVersDeleteCompte(int idCompte) throws SQLException{
        gestionnaireCompte.deleteCompte(idCompte);
    }
    
    //Retouner la liste de tous les comptes
    public List<Compte> routeVersAllCompte() throws SQLException{
        return gestionnaireCompte.listAllCompte();
    }
    
    //Retourner un compte selon son ID
    public Compte routeVersGetCompteByIdCompte(int idCompte) throws SQLException{
        return gestionnaireCompte.getCompteByIdCompte(idCompte);
    }
    
    //Retourner un compte selon l'idUser
    public Compte routeVersGetCompteByIdUser(int idUser) throws SQLException{
        return gestionnaireCompte.getCompteByIdUSer(idUser);
    }
    
    
    //Fonction pour checker si le ;login est conforme à un email
    public boolean isEmailValid(String email){
        //Expression reguliere pour verifier si l'email est valide
        String expressionDeVerification = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Za-z]{2,10}$";
        
        //Compilation de la regex
        Pattern pattern  =Pattern.compile(expressionDeVerification, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    /*Fonction pour checker si le mot de passe est conforme
    Les conditions: - doit avoir une longueur minimale de 8 caracteres
                    - doit contenir au moins une minuscule
                    - doit contenir au moins une majuscule
                    - doit contenir au moins un chiffre
                    - doit contenir au moins un caractere special parmi !@#$%^&*
    */
    public boolean isPasswordValid(String password){
        //Expression reguliere pour verifier si le password est valide
        String expressionDeVerification = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$";
        
        //Compilation de la regex
        Pattern pattern = Pattern.compile(expressionDeVerification);
        Matcher matcher = pattern.matcher(password);
        
        return matcher.matches();
    }
}
