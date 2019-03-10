package com.example.jeanfernandes.meutreino.models;

public class IMC extends BaseModel {

    private Double altura;
    private Double peso;
    private Double pesoIdeal;
    private Double imc;

    //TABELA
    public static final String TABELA_NOME = "imc_info",
                                COLUNA_ID = "_id",
                                COLUNA_IMC = "imc";

    public static final String CREATE_TABLE = " create table " + TABELA_NOME
            + "("
            + COLUNA_ID + " integer primary key autoincrement,"
            + COLUNA_IMC + " text not null)"
            ;

    public static final String DROP_TABLE = "drop table if exists" + TABELA_NOME;

    public IMC() {
    }

    public IMC(Double altura, Double peso) {
        this.altura = altura;
        this.peso = peso;
    }

    public String resolver() {
        int op = this.imc.intValue();
        this.calcular();

        if(op > 30){
            return "Obeso";
        }else if(op <= 30 && op > 25){
            return "Acima do peso";
        }else if(op < 25 && op > 20){
            return "normal";
        }
        return "Baixo peso";
    }

    private void calcular(){
        Double alturaCm = this.altura * 100;
        this.pesoIdeal = (alturaCm - 100) - ((alturaCm - this.peso) / 4) * (5 / 100);
        this.imc = this.peso / Math.pow(this.altura, 2);
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(Double pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }
}
