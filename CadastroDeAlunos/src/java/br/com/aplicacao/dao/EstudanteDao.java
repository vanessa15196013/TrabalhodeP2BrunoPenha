package br.com.aplicacao.dao;

import br.com.aplicacao.model.Estudante;
import java.util.List;

/**
 *
 * @author fabiano
 */
public interface EstudanteDao {
    public void addEstudante(Estudante estudante);

    public void deleteEstudante(int idEstudante);

    public void updateEstudante(Estudante estudante);

    public List<Estudante> getAllEstudantes();

    public Estudante getEstudanteById(int idEstudante);
}
