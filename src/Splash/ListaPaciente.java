/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Splash;

/**
 *
 * @author Alex
 */
public class ListaPaciente {
    private String sintomas;
    private String diagnostico;
    private String receta;

    public ListaPaciente(String sintomas, String diagnostico, String receta) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.receta = receta;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
}
