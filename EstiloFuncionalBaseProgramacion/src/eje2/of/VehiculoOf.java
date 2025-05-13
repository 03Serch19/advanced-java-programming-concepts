package eje2.of;
/*el tipo de kilometros debio ser int o long. */
public class VehiculoOf {
  private String matricula;
  private Modelo modelo;
  private double kilometros;
  public VehiculoOf() {
  }
  public VehiculoOf(String matricula, Modelo modelo, double kilometros) {
    this.matricula = matricula;
    this.modelo = modelo;
    this.kilometros = kilometros;
  }
  public String getMatriculla() {
    return matricula;
  }
  public void setMatriculla(String matricula) {
    this.matricula = matricula;
  }
  public Modelo getModelo() {
    return modelo;
  }
  public void setModelo(Modelo modelo) {
    this.modelo = modelo;
  }
  public double getKilometros() {
    return kilometros;
  }
  public void setKilometros(double kilometros) {
    this.kilometros = kilometros;
  }
  @Override
  public String toString() {
    return "VehiculoOf{" +
            "matricula='" + matricula + '\'' +
            ", modelo=" + modelo +
            ", kilometros=" + kilometros +
            '}';
  }
}
