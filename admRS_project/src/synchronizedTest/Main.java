/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchronizedTest;

/**
 *
 * @author DZAKIRA
 */
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        Antrian antrian = new Antrian("DKTR0013", "17-05-2021");
        
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        new Thread(new TambahThread(antrian)).start();
        
        try{
            Thread.sleep(1500);
        }catch(Exception e){System.out.println(e);}
      

    }
}
