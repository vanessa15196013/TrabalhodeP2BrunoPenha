package br.com.aplicacao.model;

/**
 *
 * @author fabiano
 */
public class Estudante {
    private int idEstudante;
    private String primeiroNome;
    private String ultimoNome;
    private String curso;

    public String getCurso() {
        return curso;
    }

    public int getIdEstudante() {
        return idEstudante;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setIdEstudante(int idEstudante) {
        this.idEstudante = idEstudante;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    @Override
    public String toString() {
        return "Student [idestudante=" + idEstudante + ", firstName=" + primeiroNome
                + ", lastName=" + ultimoNome + ", course=" + curso +"]";
    }
 
    
}