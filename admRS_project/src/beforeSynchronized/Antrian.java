/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeSynchronized;

import AdministrasiRS.Query;
import synchronizedTest.*;

/**
 *
 * @author DZAKIRA
 */
public class Antrian {
    private String idDokter;
    private String date;
    private int no_antrian;
    
    //creator
    public Antrian(String idDok,String tgl){
        idDokter = idDok;
        date = tgl;
         no_antrian = Query.getLastQueueNumber(idDokter, date); /*Select dari database*/
    }
    //reader
    int get_no_antri(){
        return no_antrian;
    }
    
    //manipulator
    public void tambah_no_antrian(){
        no_antrian = no_antrian + 1;
        System.out.println("No Antrian : " + no_antrian);
    }        
}