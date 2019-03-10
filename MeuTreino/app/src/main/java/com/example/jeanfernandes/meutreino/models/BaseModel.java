package com.example.jeanfernandes.meutreino.models;

import com.example.jeanfernandes.meutreino.utils.Ferramentas;

public abstract class BaseModel {

    protected int __id;
    protected Ferramentas ferramentas;

    public int get__id() {
        return __id;
    }

    public void set__id(int __id) {
        this.__id = __id;
    }
}
