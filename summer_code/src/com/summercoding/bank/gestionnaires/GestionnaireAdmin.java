/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.summercoding.bank.gestionnaires;

import com.summercoding.bank.entities.Admin;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Edika Edmond Junior
 */
public class GestionnaireAdmin {
    private Admin admin = new Admin();
    
    //Login de l'admin
    public Admin login(String login, String password)throws SQLException{
        return admin.getByLoginAndPassword(login, password);
    }
    
    //Enregistrement d'un admin
    public void saveAdmin(String login, String password, String nom) throws SQLException{
        admin.save(login, password, nom);
    }
    
    //Retourner la liste de tous les admin
    public List<Admin> listAllAdmin() throws SQLException{
        return admin.getAllAdmin();
    }
    
    //Retourner un admin selon l'ID
    public Admin getAdminByIdAdmin(int idAdmin) throws SQLException{
        return admin.getOne(idAdmin);
    }
}
