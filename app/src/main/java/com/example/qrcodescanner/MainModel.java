package com.example.qrcodescanner;

public class MainModel {
    String cantitate,cod,nume,photo;


    MainModel(){

    }
    public MainModel(String cantitate, String cod, String photo,String nume) {
        this.cantitate = cantitate;
        this.cod = cod;
        this.photo = photo;
        this.nume = nume;
    }

    public String getCantitate() {
        return cantitate;
    }

    public void setCantitate(String cantitate) {
        this.cantitate = cantitate;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
