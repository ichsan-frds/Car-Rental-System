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
public class pelanggan {
    private String id; 
    private String nama; 
    private String alamat; 
    private String cp; 
    private String status;
    
    public koneksi kon = new koneksi();
    public ResultSet r = null;
    
    public pelanggan(){ }
    
    public String getId(){ return id; } 
    public String getNama(){ return nama; }
    public String getAlamat(){ return alamat; }
    public String getCp(){ return cp; }
    public String getStatus(){ return status; } 
    public void setId(String id){ this.id = id; } 
    public void setNama(String nama){ this.nama = nama; } 
    public void setAlamat(String alamat){ this.alamat = alamat; } 
    public void setCp(String cp){ this.cp = cp; } 
    public void setStatus(String status){ this.status = status; }
    
    public void insertPelanggan(){ 
        String s = "insert into pelanggan values ('"+this.id+"', '"+this.nama+"', '"+this.cp+"', '"+this.alamat+"')"; 
        kon.query(s);
    }
    
    public void updatePelanggan(){  
        String s = "update pelanggan set id_pelanggan = '"+this.id+"', nama = '"+this.nama+"', cp = '"+this.cp+"', alamat = '"+this.alamat+"' where id_pelanggan = '"+this.id+"'";
        kon.query(s); 
    }
    
    public void deletePelanggan(){ 
        String s = "delete from pelanggan where id_pelanggan = '" + this.id+"'";
        kon.query(s);
    }
    
    public ResultSet getPelanggan(){
        r = kon.getData("select * from pelanggan where id_pelanggan = '"+this.id+"'");
        return r;
    }
}
