package com.example.gimnasio;

public class calculos {
    private int peso;
    private int estatura;
<<<<<<< HEAD
    private float imc;
    private int edad;
    private boolean sexo;
    private float grasa;
=======
    private double imc;
    private int edad;
    private boolean sexo;
    private double grasa;
>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
    public calculos(int peso,int estatura,int edad,boolean sexo){
        this.peso = peso;
        this.estatura = estatura;
        this.edad = edad;
        this.sexo = sexo;
<<<<<<< HEAD
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
=======
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

>>>>>>> e2b576f4704cd2923fcd01cb554e4793f5be1b54
}
