package com.example.jeanfernandes.meutreino.models;

import android.graphics.Bitmap;

import com.example.jeanfernandes.meutreino.R;

import java.util.ArrayList;

public class Musculos extends BaseModel {

    private Bitmap avatar;
    private String nome;

    public Musculos() {
    }

    public Musculos(Bitmap avatar, String nome) {
        this.avatar = avatar;
        this.nome = nome;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
