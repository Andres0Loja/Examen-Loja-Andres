package ec.edu.ups.appdis.g1.dao;

import java.sql.Connection;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.modelo.Persona;
import javax.persistence.Query;
@Stateless
public class PersonaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	public List<Persona> buscarPersona(String cedula) {
		String jpql= "Select c from Persona c where c.cedula =?1";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter(1, cedula);
		return (List<Persona>) q.getResultList();
	}
	
}
