package com.example.gimnasio;

public class ingresaEvaluacion {
    private String fechaEvaluacion,path;
    private double peso,estatura,imc,porcentajeGrasa,medidaCintura,grasaInstrumento;
    public ingresaEvaluacion(String fechaEvaluacion, double peso, double estatura, double imc, double porcentajeGrasa, double medidaCintura, double grasaInstrumento, String path){
        this.fechaEvaluacion = fechaEvaluacion;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
        this.porcentajeGrasa = porcentajeGrasa;
        this.medidaCintura = medidaCintura;
        this.grasaInstrumento = grasaInstrumento;
        this.path = path;
    }
}
