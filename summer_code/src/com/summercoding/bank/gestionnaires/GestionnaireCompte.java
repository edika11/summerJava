/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Compte;
import java.sql.SQLException;

/**
 *
 * @author Edika Edmond Junior
 */
public class GestionnaireCompte {
    private Compte compte = new Compte();
    
    public void saveCompte(double solde, int idUser, int idAdmin) throws SQLException{
        compte.save(solde, idUser, idAdmin);
    }
}
