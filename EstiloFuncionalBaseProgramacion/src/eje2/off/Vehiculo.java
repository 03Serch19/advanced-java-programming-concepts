package eje2.off;
public class Vehiculo {
private String matriculla;
private String modelo;
private double kilometros;
 public Vehiculo(String matriculla, String modelo, double kilometros) {
    this.matriculla = matriculla;
    this.modelo = modelo;
    this.kilometros = kilometros;
  }
public String getMatriculla() {
    return matriculla;
  }

public void setMatriculla(String matriculla) {
    this.matriculla = matriculla;
  }

public String getModelo() {
    return modelo;
  }

public void setModelo(String modelo) {
    this.modelo = modelo;
  }

public double getKilometros() {
    return kilometros;
  }

public void setKilometros(double kilometros) {
    this.kilometros = kilometros;
  }
@Override
public String toString() { return "Vehiculo{" + "matriculla='" + matriculla + '\'' + ", modelo='" + modelo + '\'' + ", kilometros=" + kilometros + '}'; }



}
