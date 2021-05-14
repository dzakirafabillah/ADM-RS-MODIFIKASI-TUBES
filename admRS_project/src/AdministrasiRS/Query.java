/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdministrasiRS;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author HP
 */
public class Query { 
    static Connection con = DBConnection.getConnection();

    /****************************** POLIKLINIK ******************************/
    /************************************************************************/
    
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
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
    
    public static String[] getPoliklinik(){
           
      PreparedStatement pst = null;
      String[] arrPoliklinik = new String[100];
      String sql = "select * from POLIKLINIK";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrPoliklinik[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrPoliklinik;
    }
    
    public static String getIdPoliklinik(String namaPol){
           
      PreparedStatement pst = null;
      String[] arrPoliklinik = new String[100];
      String sql = "select * from POLIKLINIK WHERE nama_poliklinik = '" + namaPol + "'" ;
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrPoliklinik[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrPoliklinik[0];
    }
    
    
    public static String textProcedure(String aNama, String aBulan, String aTahun){
        String text;
        Scanner input = new Scanner(System.in);
        CallableStatement stmt = null;
        String result = "";
        try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call JML_RIWAYAT_PENDAFTARAN(?,?,?,?)}");
			stmt.setString(1, aNama);
			stmt.setString(2, aBulan);
			stmt.setString(3, aTahun);
	
         
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(4, java.sql.Types.VARCHAR);
			
			stmt.executeUpdate();
			result = stmt.getString(4);
			//read the OUT parameter now
//			System.out.println(result);
		}catch(Exception e){
//			e.printStackTrace();
                        
		}finally{
			try {
				stmt.close();
//				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
                        return result;
                        
		}
        
    }
    
    
    /****************************** DOKTER ******************************/
    /************************************************************************/
    
    public  static String addDokter(String Nama, String NoIzinPraktek, 
            String PhoneNumber, String Spesialisasi, String Gaji, 
            String IdPoliklinik){
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
    
    public static void delDokter(String tIdDok){
        String idDok = tIdDok;
        
        CallableStatement stmt = null;
        Scanner input = new Scanner(System.in);
         
        try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DOKTER_DELETE(?)}");
			
			stmt.setString(1, idDok);
			
			System.out.println(idDok);
                        
			
			stmt.executeUpdate();
			
			
                        JOptionPane.showMessageDialog(null, "Delete Dokter Berhasil Dilakukan");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Delete Dokter Gagal Dilakukan\nPoliklinik harus memiliki minimal 1 dokter");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
     }
    
    
    public static boolean searchIdDok(String idDok){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DOKTER WHERE id_dokter = '" + idDok + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][7];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][7];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<8 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            System.out.println(result.length == 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return (result.length == 0);
        
    }
    
     public static void updDokter(String idDok, String namaDok, String noPrak, 
            String noHP, String spesialis, String tGajiDok, String idPoli){
         int gajiDok = Integer.parseInt(tGajiDok);
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DOKTER_UPDATE(?,?,?,?,?," + gajiDok+ ",?)}");
			stmt.setString(1, idDok);
			stmt.setString(2, namaDok);
                        stmt.setString(3, noPrak);
                        stmt.setString(4, noHP);
                        stmt.setString(5, spesialis);
                        stmt.setString(6, idPoli);
			
			stmt.executeUpdate();
			
                        JOptionPane.showMessageDialog(null, "Update Dokter Berhasil Dilakukan");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update Dokter Gagal Dilakukan");
		}finally{
			try {
				stmt.close();
				//con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
     }
   

    public static Object[][] getSearchDokter(String noRM){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DOKTER WHERE id_dokter = '" + noRM + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[1][7];
        
        try {
            pst = con.prepareStatement(sql);
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<8 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    /****************************** PASIEN ******************************/
    /************************************************************************/
    
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
     
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
     
     
     
    /************************ RIWAYAT PENDAFTARAN ***********************/
    /************************************************************************/
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
    
    public static boolean searchNoRegis(String noReg){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RIWAYAT_PENDAFTARAN WHERE no_registrasi = '" + noReg + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][8];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][8];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<8 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            System.out.println(result.length == 0);
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return (result.length == 0);
        
    }
    
    public static Object[][] getListInapSaatIni(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DAFTAR_INAP_SAAT_INI";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][4];
        
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    
    public static Object[][] getListPendaftaran(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RIWAYAT_PENDAFTARAN";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][8];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][8];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<9 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
   public  static Object[][] getListSearchPendaftaran(String noRM){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RIWAYAT_PENDAFTARAN WHERE pasien_no_rekam_medis = '" + noRM + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][8];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][8];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<9 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return result;
        
    }
   
   public static Object[][] getListRawatInap(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from KUNJUNGAN_PS_INAP";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][5];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][5];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<6 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    public static Object[][] getListRawatJalan(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from KUNJUNGAN_PS_JALAN";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][5];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][5];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<6 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    
    public static void updRP(String noRegis, String diagnosa){
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call RIWAYAT_PENDAFTARAN_UPDATE(?,?)}");
			stmt.setString(1, noRegis);
			stmt.setString(2, diagnosa);
			
			stmt.executeUpdate();
			
                        JOptionPane.showMessageDialog(null, "Update Riwayat Pendaftaran Berhasil Dilakukan");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update Riwayat Pendaftaran Gagal Dilakukan");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
     }

    public static Object[][] getSearchRP(String noRegis){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RIWAYAT_PENDAFTARAN WHERE no_registrasi = '" + noRegis + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[1][8];
        
        try {
            pst = con.prepareStatement(sql);
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<9 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }

    /*************************** TINDAKAN ****************************/
    /************************************************************************/
    
     public static void addTindakan(String tNamaTindakan, String tTarif, String tDeskripsi){
         String namaTindakan = tNamaTindakan;
         int tarif = Integer.parseInt(tTarif);
         String deskripsi = tDeskripsi;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TINDAKAN_INSERT(?,?,"+tarif+")}");
			
			stmt.setString(1, namaTindakan);
                        stmt.setString(2, deskripsi);
			
			
			//register the OUT parameter before calling the stored procedure
			//stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
                        //stmt.registerOutParameter(1, java.sql.Types.DATE);
			
			stmt.executeUpdate();
			
			//read the OUT parameter now
                        //String result = stmt.getString(3);
                        JOptionPane.showMessageDialog(null, "Insert Tindakan Berhasil Dilakukan");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Insert Tindakan Gagal Dilakukan");
		}finally{
			try {
				stmt.close();
				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
     }
     
     
     public static Object[][] getListTindakan(String idP){
      
      PreparedStatement pst = null;
      PreparedStatement pst2 = null;
      PreparedStatement pst3 = null;
      
      
      String sql2 = "select rp_no_registrasi FROM PEMBAYARAN WHERE id_pembayaran = '" + idP +"'" ;
      System.out.println(sql2);
      ResultSet st, st2, st3;
      int size = 0;
      Object[][] result =  new Object[0][0];
      Object[][] result2 =  new Object[1][1];
        
        try {
            
            pst2 = con.prepareStatement(sql2);
            
            st2=pst2.executeQuery();
            int i=0;
            while(st2.next()){
                    result2[i][0] = st2.getString(1);  
            }
            
            String sql = "select id_tindakan,tarif,jumlah,total from TINDAKAN_HISTORY WHERE no_registrasi = '" + result2[0][0] +"'" ;
            pst = con.prepareStatement(sql);
            
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][4];
            
            st=pst.executeQuery();
            i=0;
            while(st.next()){
                for (int k =1; k<5 ;k++){
                    result[i][k-1] = st.getString(k);
                }
                String sqlNamaTindakan = "select * from TINDAKAN WHERE id_tindakan = '" + st.getString(1) +"'" ;
                pst3 = con.prepareStatement(sqlNamaTindakan);

                st3=pst3.executeQuery();
                
                int j = 0;
                while(st3.next()){
                    result[i][0] = st3.getString(2);
                }
                
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    
    public static Object[][] getListTindakanRS(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from TINDAKAN";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][4];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][8];
            
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    public static String[] getTindakanID(){
           
      PreparedStatement pst = null;
      String[] arrTindakan = new String[100];
      String sql = "select * from TINDAKAN";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrTindakan[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(dokter.poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrTindakan;
    }
     
     public static String getTarifTindakan(String idTindakan){
           
      PreparedStatement pst = null;
      String[] arrTindakan = new String[100];
      String sql = "select tarif from TINDAKAN WHERE ID_TINDAKAN = '" + idTindakan + "'";
      ResultSet st;
      //System.out.println(sql);
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
        //        System.out.println(st.getString(1) + "ss");
                arrTindakan[i] = st.getString(1);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            //Logger.getLogger(dokter.poliklinik.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrTindakan[0];
    }
     
     public  static String addTindakanToPasien(String idT, String noR, String jml, String aTarif){
         String idTindakan = idT;
         String noRegis = noR;
         String jumlah = jml;
         String tarif = aTarif;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TINDAKAN_HISTORY_INSERT(?,?,?,?)}");
                        stmt.setString(2, noR);
                        stmt.setString(3, idT);
                        stmt.setString(4, jml);
                        stmt.setString(5, getTarifTindakan(idT));
                        
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Tindakan berhasil ditambahkan !");
		}catch(Exception e){
			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Tindakan gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
				//con.close();
				input.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
         
         return hasil;
     }
    /****************************** KEUANGAN ******************************/
    /************************************************************************/
    
    public static String getTarif(String noRegis){
        Scanner input = new Scanner(System.in);
        CallableStatement stmt = null;
        String result = "";
        try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TOTAL_TARIF(?,?)}");
			stmt.setString(1, noRegis);
      
			//register the OUT parameter before calling the stored procedure
			stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			
			stmt.executeUpdate();
			result = stmt.getString(2);
			//read the OUT parameter now
                        
		}catch(Exception e){
//			e.printStackTrace();
		}finally{
			try {
                                stmt.close();
//				con.close();
				input.close();
			} catch (SQLException e){
//				e.printStackTrace();
			}
                        return result;                        
		}        
    }
    
    public static boolean searchPembayaran(String idP){
      
      PreparedStatement pst = null;
      
      String sql = "select * from PEMBAYARAN WHERE id_pembayaran = '" + idP + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[1][4];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][4];
            
            pst.close();
            System.out.println(size == 0);
            
        } catch (SQLException ex){
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return (result.length == 0);
    }
    
    public static void updStatusPembayaran(String idP){
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call PEMBAYARAN_UPDATE_SUDAH_BAYAR(?)}");
			stmt.setString(1, idP);
			
			stmt.executeUpdate();
			
                        JOptionPane.showMessageDialog(null, "Status Pembayaran Berubah Menjadi Sudah Dibayar");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update Status Pembayaran Gagal Dilakukan");
		}finally{
			try {
				stmt.close();
//				con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
     }
    
    public static String getPemasukan(String year){
           
      PreparedStatement pst = null;
      String hasil = "0";
      String sql = "SELECT GET_INCOME("+year+")FROM DUAL";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            
            while(st.next()){
               hasil = "\n"+st.getString(1);
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return String.valueOf(hasil);
    }
    
    
    
    public static Object[][] getListPembayaran(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from PEMBAYARAN";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][4];
        
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
}


    /************************* RESEP DAN OBAT *************************/
    /************************************************************************/