/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.ResultSet;

/**
 *
 * @author Muhammad Ichsan
 */
public class mobil {
    private String idbaru; 
    private String idlama; 
    private String jenis; 
    private int sewa; 
    private int stok; 
    
    public koneksi kon = new koneksi();
    public ResultSet r = null;
    
    public mobil(){ }
    
    public String getIdbaru(){ return idbaru; } 
    public String getIdlama(){ return idlama; } 
    public String getJenis(){ return jenis; }
    public int getSewa(){ return sewa; }
    public int getStok(){ return stok; }
    public void setIdbaru(String idbaru){ this.idbaru = idbaru; } 
    public void setIdlama(String idlama){ this.idlama = idlama; }
    public void setJenis(String jenis){ this.jenis = jenis; } 
    public void setSewa(int sewa){ this.sewa = sewa; } 
    public void setStok(int stok){ this.stok = stok; } 
    
    public void insertMobil(){ 
        String s = "insert into mobil values ('"+this.idbaru+"', '"+this.jenis+"', '"+this.sewa+"', '"+this.stok+"')"; 
        kon.query(s);
    }
    
    public void updateMobil(){  
        String s = "update mobil set id_mobil = '"+this.idbaru+"', jenis = '"+this.jenis+"', sewa = '"+this.sewa+"', stok = '"+this.stok+"' where id_mobil = '"+this.idlama+"'";
        kon.query(s); 
    }
    
    public void updateStokMobil(){  
        String s = "update mobil set stok = '"+this.stok+"' where id_mobil = '"+this.idbaru+"'";
        kon.query(s); 
    }
    
    public void deleteMobil(){ 
        String s = "delete from mobil where id_mobil = '" + this.idbaru+"'";
        kon.query(s);
    }
    
    public ResultSet getMobil(){
        r = kon.getData("select * from mobil");
        return r;
    }
    
    public ResultSet getMobilId(){
        r = kon.getData("select * from mobil where id_mobil = '"+this.idbaru+"'");
        return r;
    }
}
