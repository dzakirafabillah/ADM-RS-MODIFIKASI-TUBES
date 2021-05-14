/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrasiRS;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class daftar { 
    static Connection con = DBConnection.getConnection();

    public static Object[][] DaftarPasien(){
           
      PreparedStatement pst = null;
     Object[][] hasil = null;
      String sql = "select * from PASIEN";
      ResultSet st;
       int size = 0;
      Object[][] result =  new Object[30][4];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][4];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<5 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     public static Object[][] searchPasien(String noRM){
      
      PreparedStatement pst = null;
      
      String sql = "select * from PASIEN WHERE no_rekam_medis = '" + noRM + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][4];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][4];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<5 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
     
     public static Object[][] DaftarPoli(){
           
      PreparedStatement pst = null;
     Object[][] hasil = null;
      String sql = "select * from POLIKLINIK";
      ResultSet st;
       int size = 0;
      Object[][] result =  new Object[30][3];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][3];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<4 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
     public static Object[][] searchPoli(String nama){
      
      PreparedStatement pst = null;
      
      String sql = "select * from POLIKLINIK WHERE NAMA_POLIKLINIK = '" + nama + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][3];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][3];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<4 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(daftar.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
}
