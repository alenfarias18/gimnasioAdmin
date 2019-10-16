package com.example.gimnasio;

public class calculos {
    private int peso;
    private int estatura;
    private double imc;
    private int edad;
    private boolean sexo;
    private double grasa;
    public calculos(int peso,int estatura,int edad,boolean sexo){
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.sexo = sexo;
    }

    public double imc(){
        imc = 0;
        imc = (double)(peso/(estatura*estatura));
        return imc;
    }

    public double grasa(){
        if(sexo){
        grasa = 1.2 *  imc  +  0.23 * edad - 10.8 - 5.4;
        }
        else{
            grasa = 1.2 *  imc  +  0.23 * edad - 5.4;
        }
        return grasa;
    }

}
