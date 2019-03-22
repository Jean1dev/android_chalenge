package com.example.jeanfernandes.meutreino.models;

public class FolhaModel extends BaseModel {

    private String nome;
    private Double salario;
    private Double aumento;
    private Double novoSaldo;

    public FolhaModel() {
    }

    public FolhaModel(String nome, Double salario, Double aumento, Double novoSaldo) {
        this.nome = nome;
        this.salario = salario;
        this.aumento = aumento;
        this.novoSaldo = novoSaldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getAumento() {
        return aumento;
    }

    public void setAumento(Double aumento) {
        this.aumento = aumento;
    }

    public Double getNovoSaldo() {
        return novoSaldo;
    }

    public void setNovoSaldo(Double novoSaldo) {
        this.novoSaldo = novoSaldo;
    }

    public void calcularNovoSaldo(){
        this.aumento = this.salario > 1000
            ? (this.salario * .3)
            : (this.salario * .4);
        this.novoSaldo = this.salario + this.aumento;

    }
}
