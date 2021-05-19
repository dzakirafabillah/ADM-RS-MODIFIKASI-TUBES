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
import synchronizedTest.Antrian;
import synchronizedTest.TambahThread;
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
				//con.close();
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
    
    public static String[] getPoliklinikName(){
           
      PreparedStatement pst = null;
      String[] arrPoliklinik = new String[100];
      String sql = "select * from POLIKLINIK";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrPoliklinik[i] = st.getString(2);
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
    
    
    
    public static String getJmlPendaftaran(String aNama, String aBulan, String aTahun){
           
      PreparedStatement pst = null;
      String hasil = "0";
      String sql = "SELECT GET_JML_RIWAYAT_PENDAFTARAN('"+aNama+"', "+aBulan+", "+aTahun+")FROM DUAL";
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
    
    
    /****************************** DOKTER ******************************/
    /************************************************************************/
    
    public static String[] getDokter(String idPoli){
           
      PreparedStatement pst = null;
      String[] arrPoliklinik = new String[100];
      String sql = "select * from DOKTER WHERE POLIKLINIK_ID_POLIKLINIK = '"+idPoli+"'";
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
    
    public  static String addDokter(String Nama, String NoIzinPraktek, 
            String PhoneNumber, String Spesialisasi, String Gaji, String Alamat, 
            String IdPoliklinik){
         
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DOKTER_INSERT(?,?,?,?,?,?,?)}");
			stmt.setString(1, Nama);
                        stmt.setString(2, NoIzinPraktek);
                        stmt.setString(3, PhoneNumber);
                        stmt.setString(4, Spesialisasi);
                        stmt.setString(5, Gaji);
                        stmt.setString(6, Alamat);
                        stmt.setString(7, IdPoliklinik);
                        
                        stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Dokter berhasil ditambahkan !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Dokter gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
			//	con.close();
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
			//	con.close();
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
      Object[][] result =  new Object[0][9];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][9];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
            String noHP, String spesialis, String tGajiDok, String alamat, String idPoli){
         int gajiDok = Integer.parseInt(tGajiDok);
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DOKTER_UPDATE(?,?,?,?,?," + gajiDok+ ",?,?)}");
			stmt.setString(1, idDok);
			stmt.setString(2, namaDok);
                        stmt.setString(3, noPrak);
                        stmt.setString(4, noHP);
                        stmt.setString(5, spesialis);
                        stmt.setString(6, alamat);
                        stmt.setString(7, idPoli);
			
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
      Object[][] result =  new Object[1][9];
        
        try {
            pst = con.prepareStatement(sql);
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
    
    
    public static Object[][] getListDokter(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DOKTER";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][9];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][9];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
    
    public static Object[][] getListSearchDokter(String noRM){
      
      PreparedStatement pst = null;
      
      String sql = "select * from DOKTER WHERE id_dokter = '" + noRM + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][9];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][9];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
	//			con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
     
     
     
    /************************ RIWAYAT PENDAFTARAN ***********************/
    /************************************************************************/
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
      Object[][] result =  new Object[30][9];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][9];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
      
      String sql = "select * from RIWAYAT_PENDAFTARAN WHERE pasien_no_rekam_medis = '" 
                    + noRM + "' OR diagnosa = '" + noRM + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][9];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][9];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<10 ;k++){
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
		//		con.close();
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

    
     public  static Object[][] getDaftarAntrian(String idDok, String tgl){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RIWAYAT_PENDAFTARAN WHERE dokter_id_dokter = '" 
                    + idDok + "' AND tgl_registrasi = '" + tgl +"'";
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
                    if(k-1 == 2) {
                        result[i][k-1] = st.getString(8);
                    }else if (k-1 == 3){
                        result[i][k-1] = st.getString(3);
                    }else{
                        result[i][k-1] = st.getString(k);
                    }
                }
                i++;
            }
            
            pst.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return result;
        
    }
     
     
     public static void updDiagnosa(String noReg, String diagnosa){
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call DIAGNOSA_UPDATE(?,?)}");
			stmt.setString(1, noReg);
			stmt.setString(2, diagnosa);
			
			stmt.executeUpdate();
			
                        JOptionPane.showMessageDialog(null, "Update Diagnosa Berhasil Dilakukan");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update Diagnosa Gagal Dilakukan");
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
		//		con.close();
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
            
            String sql = "select id_tindakan,jumlah,total_tarif from TINDAKAN_HISTORY WHERE no_registrasi = '" + result2[0][0] +"'" ;
            pst = con.prepareStatement(sql);
            
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][3];
            
            st=pst.executeQuery();
            i=0;
            while(st.next()){
                for (int k =1; k<4 ;k++){
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
     
     public  static String addTindakanToPasien(String idT, String noR, String jml){
         String idTindakan = idT;
         String noRegis = noR;
         String jumlah = jml;
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TINDAKAN_HISTORY_INSERT(?,?,"+jml+")}");
                        stmt.setString(1, noR);
                        stmt.setString(2, idT);
                        
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
    
    public static String getTarif(String idP){
           
      PreparedStatement pst = null;
      String hasil = "0";
      String sql = "SELECT total_pembayaran FROM PEMBAYARAN WHERE id_pembayaran = '" + idP + "'";
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

    /************************* RESEP DAN OBAT *************************/
    /************************************************************************/

    public static void addObat(String tNamaObat, String tKodeObat, 
            String tIdJenis, String tHarga, String tStock){
             int harga = Integer.parseInt(tHarga);
             int stock = Integer.parseInt(tStock);

             CallableStatement stmt = null;
             Scanner input = new Scanner(System.in);

             try{
                            con = DBConnection.getConnection();
                            stmt = con.prepareCall("{call OBAT_INSERT(?,?,"+stock+","+harga+",?)}");

                            stmt.setString(1, tKodeObat);
                            stmt.setString(2, tNamaObat);
                            stmt.setString(3, tIdJenis);


                            //register the OUT parameter before calling the stored procedure
                            //stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
                            //stmt.registerOutParameter(1, java.sql.Types.DATE);

                            stmt.executeUpdate();

                            //read the OUT parameter now
                            //String result = stmt.getString(3);
                            JOptionPane.showMessageDialog(null, "Insert Obat Berhasil Dilakukan");

                    }catch(Exception e){
    			e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Insert Obat Gagal Dilakukan");
                    }finally{
                            try {
                                    stmt.close();
                                   // con.close();
                                    input.close();
                            } catch (SQLException e) {
    //				e.printStackTrace();
                            }
                    }

         }
    
    
    public static Object[][] getListObat(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from OBAT";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][7];
        
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
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    public static Object[][] getListBahan(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from INGREDIENT";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[100][2];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][2];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<3 ;k++){
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
    
    public static Object[][] getListSearchBahan(String namaBahan){
      
      PreparedStatement pst = null;
      
      String sql = "select * from INGREDIENT WHERE NAMA_BAHAN = '" + namaBahan + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][2];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][2];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<3 ;k++){
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
    
    
    public static Object[][] getListSearchObat(String idJenis){
      
      PreparedStatement pst = null;
      
      String sql = "select * from OBAT WHERE ID_JENIS_OBAT = '" + idJenis + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[30][7];
        
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
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
         
        }  
        return result;
        
    }
    
    
    public static String[] getIngredients(String idObat){
           
      PreparedStatement pst = null;
      String[] arrIngredients = new String[100];
      String sql = "select * from KANDUNGAN_OBAT WHERE ID_OBAT = '" + idObat + "'";
      ResultSet st;
         
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            int i = 0; 
            while(st.next()){
                arrIngredients[i] = st.getString(4);
                i++;
            }
            pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrIngredients;
    }
    
    public static boolean searchIdObat(String idObat){
      
      PreparedStatement pst = null;
      
      String sql = "select * from OBAT WHERE id_obat = '" + idObat + "'";
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

    public static boolean searchIdBahan(String idBahan){
      
      PreparedStatement pst = null;
      
      String sql = "select * from INGREDIENT WHERE id_bahan = '" + idBahan + "'";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][2];
        
        try {
            pst = con.prepareStatement(sql);
            st=pst.executeQuery();
            while(st.next()){
                size++;
            }
            result =  new Object[size][2];
            
            st=pst.executeQuery();
            int i=0;
            while(st.next()){
                for (int k =1; k<3 ;k++){
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
    
    public static Object[][] getListResep(){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RESEP";
      ResultSet st;
      int size = 0;
      Object[][] result =  new Object[0][6];
        
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
    
    
    public static boolean searchResep(String idResep){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RESEP WHERE id_resep = '" + idResep + "'";
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
    
    public static void updStatusResep(String idResep){
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call TEBUS_RESEP(?)}");
			stmt.setString(1, idResep);
			
			stmt.executeUpdate();
			
                        JOptionPane.showMessageDialog(null, "Status Tebus Berubah Menjadi Sudah Ditebus");
                        
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Update Status Tebus Resep Gagal Dilakukan");
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
    
    
    public static String getTarifResep(String idR){
           
      PreparedStatement pst = null;
      String hasil = "0";
      String sql = "SELECT GET_TOTAL_TARIF_RESEP('"+idR+"')FROM DUAL";
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

    
    public static Object[][] getListObatResep(String idResep){
      
      PreparedStatement pst = null;
      PreparedStatement pst2 = null;
      PreparedStatement pst3 = null;
      
      ResultSet st, st2, st3;
      int size = 0;
      Object[][] result =  new Object[0][0];
      Object[][] result2 =  new Object[1][1];
        
        try {
            
            String sql = "select id_obat,jumlah,unit,total_harga from RESEP_OBAT WHERE id_resep = '" + idResep +"'" ;
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
                String sqlNamaTindakan = "select * from OBAT WHERE id_obat = '" + st.getString(2) +"'" ;
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
    
    
    public static Object[][] getListSearchResep(String noRegis){
      
      PreparedStatement pst = null;
      
      String sql = "select * from RESEP WHERE NO_REGISTRASI = '" + noRegis + "'";
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

    public static String addResep(String noReg, String ket){
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Resep Record Save Success::";
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call RESEP_INSERT(?,?)}");
			stmt.setString(1, noReg);
			stmt.setString(2, ket);
                        stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Resep berhasil dibuat !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Resep gagal dibuat !");
		}finally{
			try {
				stmt.close();
	//			con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
    
    
    public static void insertObatKeResep(String tIdResep, String tIdObat, 
            String tJml, String tUnit){
             int jml = Integer.parseInt(tJml);

             CallableStatement stmt = null;
             Scanner input = new Scanner(System.in);

             try{
                            con = DBConnection.getConnection();
                            stmt = con.prepareCall("{call RESEP_OBAT_INSERT(?,?,"+jml+",?)}");

                            stmt.setString(1, tIdResep);
                            stmt.setString(2, tIdObat);
                            stmt.setString(3, tUnit);

                            stmt.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Insert Obat Berhasil Dilakukan");

                    }catch(Exception e){
    			e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Insert Obat Gagal Dilakukan");
                    }finally{
                            try {
                                    stmt.close();
                                   // con.close();
                                    input.close();
                            } catch (SQLException e) {
    //				e.printStackTrace();
                            }
                    }

         }
    
    public static void updStockObat(String idObat, String tStockFisik, String tStockAvail){
             int stockFisik = Integer.parseInt(tStockFisik);
             int stockAvail = Integer.parseInt(tStockAvail);

             CallableStatement stmt = null;
             Scanner input = new Scanner(System.in);

             try{
                            con = DBConnection.getConnection();
                            stmt = con.prepareCall("{call STOCK_OBAT_UPDATE(?,"+stockFisik+","+stockAvail+")}");

                            stmt.setString(1, idObat);

                            //register the OUT parameter before calling the stored procedure
                            //stmt.registerOutParameter(2, java.sql.Types.VARCHAR);
                            //stmt.registerOutParameter(1, java.sql.Types.DATE);

                            stmt.executeUpdate();

                            //read the OUT parameter now
                            //String result = stmt.getString(3);
                            JOptionPane.showMessageDialog(null, "Upadate Stock Obat Berhasil Dilakukan");

                    }catch(Exception e){
    			e.printStackTrace();
                            JOptionPane.showMessageDialog(null, "Upadate Stock Gagal Dilakukan");
                    }finally{
                            try {
                                    stmt.close();
                                   // con.close();
                                    input.close();
                            } catch (SQLException e) {
    //				e.printStackTrace();
                            }
                    }

         }
    
    
     public static String addDataKandunganObat(String idObat, String idBahan){
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Resep Record Save Success::";
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call KANDUNGAN_OBAT_INSERT(?,?)}");
			stmt.setString(1, idObat);
			stmt.setString(2, idBahan);
                        stmt.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Data Komposisi berhasil ditambahkan !");
		}catch(Exception e){
//			e.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Data Komposisi gagal ditambahkan !");
		}finally{
			try {
				stmt.close();
	//			con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
    
    
    /*ANTRIAN*/
    
    public static int getLastQueueNumber(String idDok,String tgl){
        PreparedStatement pst = null;
        String hasil = "0";
        String sql = "SELECT GET_LAST_QUEUE_NUMBER('"+idDok+"', '"+tgl+"')FROM DUAL";
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
          
          return Integer.parseInt(hasil.replace("\n",""));
      }

    public static String addDaftar(String symptom, String diagnosa, 
                  String tipeRawat, String norek, String IdPoliklinik, String IdDok){
         String sym = symptom;
         String diag = diagnosa;
         String tipe = tipeRawat;
         String no = norek;
         String Id = IdPoliklinik;
         
         /*Mengatur Nomor Antrian*/
         Antrian antrian = new Antrian(IdDok, "17-05-2021");
        
         new Thread(new TambahThread(antrian)).start();
         int noAntri = antrian.get_no_antri(); 
         
         CallableStatement stmt = null;
         Scanner input = new Scanner(System.in);
         String hasil = "Record Save Success::";
         
         try{
			con = DBConnection.getConnection();
			stmt = con.prepareCall("{call RIWAYAT_PENDAFTARAN_INSERT("+noAntri+",?,?,?,?,?)}");
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
	//			con.close();
				input.close();
			} catch (SQLException e) {
//				e.printStackTrace();
			}
		}
         
         return hasil;
     }
}


    