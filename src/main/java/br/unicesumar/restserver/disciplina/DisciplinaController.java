/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicesumar.restserver.disciplina;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alunos
 */
@RestController
@RequestMapping(value="/disciplinas")
@Transactional
public class DisciplinaController {
    
    @Autowired
    private EntityManager em;
    
    @RequestMapping(method= RequestMethod.GET)
    public List<Disciplina> getDisciplinas(){
        return em.createQuery("from Disciplina").getResultList();
    }
    
    @RequestMapping(method= RequestMethod.POST)
    public void criaDisciplina(@RequestBody Disciplina disciplina){
        em.persist(disciplina);
    }
    
    @RequestMapping(value="/{id}",method= RequestMethod.PUT)
    public void alteraDisciplina(@PathVariable Long id,@RequestBody Disciplina nova){
        Disciplina antiga = em.find(Disciplina.class, id);
        antiga.setNome(nova.getNome());
        antiga.setCargaHoraria(nova.getCargaHoraria());
        antiga.setPeso(nova.getPeso());
        em.persist(antiga);
    }
    
    @RequestMapping(value="/{id}",method= RequestMethod.DELETE)
    public void excluiDisciplina(@PathVariable Long id){
        em.createQuery("Delete from Disciplina d Where d.id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
    
}
