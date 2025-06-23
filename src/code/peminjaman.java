/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author Muhammad Ichsan
 */
public class peminjaman {
    private String peminjaman; 
    private String pegawai;
    private String mobil; 
    private String pelanggan;  
    private String tglpinjam;
    private String tglkembali;
    private String lama;
    private String biaya; 
    private String telat; 
    private String denda;
    private String status;
    
    public koneksi kon = new koneksi();
    public ResultSet r = null;
    
    public peminjaman(){}
    
    public String getPem(){ return peminjaman; }
    public String getPeg(){ return pegawai; }
    public String getMobil(){ return mobil; }
    public String getPel(){ return pelanggan; }
    public String getTglpinjam(){ return tglpinjam; }
    public String getTglkembali(){ return tglkembali; }
    public String getLama(){ return lama; }
    public String getBiaya(){ return biaya; }
    public String getTelat(){ return telat; }
    public String getDenda(){ return denda; }
    public String getStatus(){ return status; }
    
    public void setPem(String peminjaman){this.peminjaman = peminjaman; }
    public void setPeg(String pegawai){ this.pegawai = pegawai; }
    public void setMobil(String mobil){ this.mobil = mobil; } 
    public void setPel(String pelanggan){ this.pelanggan = pelanggan; } 
    public void setTglpinjam(String tglpinjam){ this.tglpinjam = tglpinjam; } 
    public void setTglkembali(String tglkembali){ this.tglkembali = tglkembali; } 
    public void setLama(String lama){ this.lama = lama; }
    public void setPegawai(String pegawai){ this.pegawai = pegawai; } 
    public void setBiaya(String biaya){ this.biaya = biaya; } 
    public void setTelat(String telat){ this.telat = telat; } 
    public void setDenda(String denda){ this.denda = denda; }
    public void setStatus(String status){ this.status = status; }
    
    public void insertPeminjaman(){ 
        String s = "insert into peminjaman values ('" + this.peminjaman+"', '"+this.pegawai+"', '" + this.mobil+"', '"+this.pelanggan+"', '"+this.tglpinjam+"', '"+this.tglkembali+"', '"+this.lama+"', '0', '"+this.biaya+"', '0', '"+this.status+"')"; 
        kon.query(s);
    }
    
    public void updatePeminjaman(){
        String s = "update peminjaman set telat = '"+this.telat+"', denda = '"+this.denda+"', status = '"+this.status+"' where id_peminjaman = '"+this.peminjaman+"'";
        kon.query(s);
    }
    
    public void deletePeminjaman(){
        String s = "delete from peminjaman where id_peminjaman = '"+this.peminjaman+"'";
        kon.query(s);
    }
    
    public ResultSet getPeminjaman(){
        r = kon.getData("select * from peminjaman;");
        return r;
    }
    
    public ResultSet getPeminjamanId(){
        r = kon.getData("select * from peminjaman where id_peminjaman = '"+this.peminjaman+"'");
        return r;
    }
    
    public ResultSet getPeminjamanPel(){
        r = kon.getData("select * from peminjaman where id_pelanggan = '"+this.pelanggan+"'");
        return r;
    }
    
    public ResultSet getPeminjamanPeg(){
        r = kon.getData("select * from peminjaman where id_pegawai = '"+this.pegawai+"'");
        return r;
    }
    
    public ResultSet getPeminjamanMobil(){
        r = kon.getData("select * from peminjaman where id_mobil = '"+this.mobil+"'");
        return r;
    }
}
