package ec.edu.ups.appdis.g1.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Persona;
@Stateless
public class CuentaDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;

	public boolean insertJPA(Cuenta entity) throws SQLException {
		em.persist(entity);
		return true;
	}

	public void updateJPA(Cuenta entity) throws Exception {
		try {
			em.merge(entity);
		} catch (Exception e) {
			throw new Exception("Erro actualizar Cuenta " + e.getMessage());
		}
	}

	public List<Cuenta> buscarCuenta(int idcuenta) {
		String jpql = "Select c from Cuenta c where c.idCuenta =?1";
		Query q = em.createQuery(jpql, Cuenta.class);
		q.setParameter(1, idcuenta);
		return (List<Cuenta>) q.getResultList();
	}
}
