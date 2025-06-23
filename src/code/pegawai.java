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
public class pegawai {
    private String idbaru;
    private String idlama; 
    private String nama; 
    private String alamat; 
    private String cp;
    private String username; 
    private String password;
    private String kode;
    
    public koneksi kon = new koneksi();
    public ResultSet r = null;
    
    public pegawai(){ }
    
    public String getIdbaru(){ return idbaru; } 
    public String getIdlama(){ return idlama; } 
    public String getNama(){ return nama; }
    public String getAlamat(){ return alamat; }
    public String getCp(){ return cp; }
    public String getUsername(){ return username; }
    public String getPassword(){ return password; }
    public String getKode(){ return kode; }
    
    public void setIdbaru(String idbaru){ this.idbaru = idbaru; } 
    public void setIdlama(String idlama){ this.idlama = idlama; } 
    public void setNama(String nama){ this.nama = nama; } 
    public void setAlamat(String alamat){ this.alamat = alamat; } 
    public void setCp(String cp){ this.cp = cp; } 
    public void setUsername(String username){ this.username = username; } 
    public void setPassword(String password){ this.password = password; } 
    public void setKode(String kode){ this.kode = kode; } 
    
    public void insertPegawai(){ 
        String s = "insert into pegawai values ('"+this.idbaru+"', '"+this.nama+"', '"+this.alamat+"', '"+this.cp+"', '"+this.username+"', '"+this.password+"', '0')"; 
        kon.query(s);
    }
    
    public void updatePegawai(){  
        String s = "update pegawai set id_pegawai = '"+this.idbaru+"', nama = '"+this.nama+"', cp = '"+this.cp+"', alamat = '"+this.alamat+"', username = '"+this.username+"', password = '"+this.password+"', kode = '"+this.kode+"' where id_pegawai = '"+this.idlama+"'";
        kon.query(s); 
    }
    
    public void deletePegawai(){ 
        String s = "delete from pegawai where id_pegawai = '" + this.idbaru+"'";
        kon.query(s);
    }
    
    public ResultSet getPegawai(){
        r = kon.getData("select * from pegawai where id_pegawai = '"+this.idbaru+"'");
        return r;
    }
}
