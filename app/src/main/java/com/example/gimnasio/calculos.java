package com.example.gimnasio;

public class calculos {
    private int peso;
    private int estatura;
    private float imc;
    private int edad;
    private boolean sexo;
    private float grasa;
    public calculos(int peso,int estatura,int edad,boolean sexo){
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.sexo = sexo;
        setImc();
        setGrasa();






    }


    public float getImc() {
        return imc;
    }

    private void setImc() {
        int estatura2 = estatura * estatura;
        imc = estatura2/peso;
    }

    public float getGrasa() {
        return grasa;
    }

    private void setGrasa() {
        //Masculino
       if(sexo){
           grasa = (float) (1.2 * getImc() + 0.23 * edad - 10.8 - 5.4);
       }
       //Femenino
        else{
           grasa = (float) (1.2 * getImc() + 0.23 * edad - 5.4);
       }
    }
}
