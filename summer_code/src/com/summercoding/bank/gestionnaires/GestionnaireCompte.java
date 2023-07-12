/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Compte;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edika Edmond Junior
 */
public class GestionnaireCompte {
    private Compte compte = new Compte();
    
    public void saveCompte(double solde, int idUser, int idAdmin) throws SQLException{
        compte.save(solde, idUser, idAdmin);
    }
    
    public void updateCompte(int idCompte, double solde, int idUser, int idAdmin) throws SQLException{
        compte.update(idCompte, solde, idUser, idAdmin);
    }
    
    public void deleteCompte(int idCompte) throws SQLException{
        compte.delete(idCompte);
    }
    
    //Retourner la liste de tous les comptes
    public List<Compte> listAllCompte() throws SQLException{
        return compte.getAllCompte();
    }
    
    public Compte getCompteByIdCompte(int idCompte) throws SQLException{
        return compte.getOne(idCompte);
    }
}
