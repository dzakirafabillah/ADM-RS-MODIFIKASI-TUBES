/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrasiRS;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */

public class tambah {
     static Connection con = DBConnection.getConnection();
     
     public static String addPasien(String Nama, String Gender, String TglLahir){
         String Name = Nama;
         String JenisKelamin = Gender ;
         String  TLahir = TglLahir;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Pasien Record Save Success::";
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call PASIEN_INSERT(?,?,?)}");
			stmt.setString(1, Name);
			stmt.setString(2, JenisKelamin);
			stmt.setString(3, TLahir);
                        stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data Pasien berhasil ditambahkan !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Pasien gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
   
    public  static String addPoliklinik(String Nama){
         String Name = Nama;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = " Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call POLIKLINIK_INSERT(?)}");
			stmt.setString(1, Name);
                             stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Poliklinik berhasil ditambahkan !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Pasien gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
      
    public  static String addDokter(String Nama, String NoIzinPraktek, String PhoneNumber, String Spesialisasi, String Gaji, String IdPoliklinik){
         String Name = Nama;
         String NoIzin = NoIzinPraktek;
         String Phone = PhoneNumber;
         String Spesial = Spesialisasi;
         String gaji = Gaji;
         String Id = IdPoliklinik;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DOKTER_INSERT(?,?,?,?,?,?)}");
			stmt.setString(1, Name);
                        stmt.setString(2, NoIzin);
                        stmt.setString(3, Phone);
                        stmt.setString(4, Spesial);
                        stmt.setString(5, gaji);
                        stmt.setString(6, Id);
                        
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Dokter berhasil ditambahkan !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Dokter gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
     public static String addDaftar(String symptom, String diagnosa, String tipeRawat, String norek, String IdPoliklinik){
         String sym = symptom;
         String diag = diagnosa;
         String tipe = tipeRawat;
//         String tgl = tglRegis;
         String no = norek;
         String Id = IdPoliklinik;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call RIWAYAT_PENDAFTARAN_INSERT(?,?,?,?,?)}");
			stmt.setString(1, sym);
                        stmt.setString(2, diag);
                        stmt.setString(3, tipe);
                        stmt.setString(4, no);
                        stmt.setString(5, Id);
                        
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Pendaftaran berhasil !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Pendaftaran gagal dilakukan!");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
}
     


