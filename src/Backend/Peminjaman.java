/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Backend;

import java.sql.ResultSet;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Peminjaman {
    private String transaksi; 
    private String buku;
    private String username;  
    private String tglpinjam;
    private String tglkembali;
    private String status;
    
    public Koneksi kon = new Koneksi();
    public ResultSet r = null;
    
    public Peminjaman(){}
    
    public String getTransaksi(){ return transaksi; }
    public String getBuku(){ return buku; }
    public String getUsername(){ return username; }
    public String getTglpinjam(){ return tglpinjam; }
    public String getTglkembali(){ return tglkembali; }
    public String getStatus(){ return status; }
    
    public void setTransaksi(String transaksi){this.transaksi = transaksi; }
    public void setBuku(String buku){ this.buku = buku; }
    public void setUsername(String username){ this.username = username; } 
    public void setTglpinjam(String tglpinjam){ this.tglpinjam = tglpinjam; } 
    public void setTglkembali(String tglkembali){ this.tglkembali = tglkembali; } 
    public void setStatus(String status){ this.status = status; }
    
    public void insertPeminjaman(){ 
        String s = "insert into transaksi values ('" + this.transaksi+"', '"+this.tglpinjam+"', '" + this.tglkembali+"', '"+this.status+"', '"+this.buku+"', '"+this.username+"')"; 
        kon.query(s);
    }
    
    public void updatePeminjaman(){
        String s = "update transaksi set status_peminjaman = '"+this.status+"' where id_transaksi = '"+this.transaksi+"'";
        kon.query(s);
    }
    
    public ResultSet getPeminjaman(){
        r = kon.getData("select * from transaksi;");
        return r;
    }
    
    public ResultSet getPeminjamanId(){
        r = kon.getData("select * from transaksi where id_transaksi = '"+this.transaksi+"'");
        return r;
    }
    
    public ResultSet getPeminjamanUsername(){
        r = kon.getData("select * from transaksi where username = '"+this.username+"'");
        return r;
    }
    
    public ResultSet getPeminjamanBuku(){
        r = kon.getData("select * from transaksi where id_buku = '"+this.buku+"'");
        return r;
    }
}