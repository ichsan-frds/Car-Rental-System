/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Backend;

import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class Buku {
    private String id; 
    private String judul; 
    private String jenis; 
    private int tahun; 
    
    public Koneksi kon = new Koneksi();
    public ResultSet r = null;
    
    public Buku(){ }
    
    public String getId(){ return id; } 
    public String getJudul(){ return judul; }
    public String getJenis(){ return jenis; }
    public int getTahun(){ return tahun; }

    public void setId(String id){ this.id = id; }
    public void setJudul(String judul){ this.judul = judul; } 
    public void setJenis(String jenis){ this.jenis = jenis; }  
    public void setTahun(int tahun){ this.tahun = tahun; } 
    
    public void insertBuku(){ 
        String s = "insert into buku values ('"+this.id+"', '"+this.judul+"', '"+this.jenis+"', '"+this.tahun+"')"; 
        kon.query(s);
    }
    
    public void updateBuku(){  
        String s = "update buku set judul = '"+this.judul+"', jenis = '"+this.jenis+"', tahun_terbit = '"+this.tahun+"' where id_buku = '"+this.id+"'";
        kon.query(s); 
    }
    
    public void deleteBuku(){ 
        String s = "delete from buku where id_buku = '" + this.id+"'";
        kon.query(s);
    }
    
    public ResultSet getBuku(){
        r = kon.getData("select * from buku");
        return r;
    }
    
    public ResultSet getBukuId(){
        r = kon.getData("select * from buku where id_buku = '"+this.id+"'");
        return r;
    }
}