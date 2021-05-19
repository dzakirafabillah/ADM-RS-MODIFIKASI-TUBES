/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beforeSynchronized;

import synchronizedTest.*;

/**
 *
 * @author DZAKIRA
 */
public class TambahThread implements Runnable{
    private Antrian antrian;
    public TambahThread(Antrian antrian) {
        this.antrian = antrian;
    }
    public void run() {	
        antrian.tambah_no_antrian();   
    }
    
}