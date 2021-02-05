package ec.edu.ups.appdis.g1.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.modelo.Cuenta;
import ec.edu.ups.appdis.g1.modelo.Transaccion;
@Stateless
public class TransaccionDAO {
	@Inject
	private Connection con;
	@Inject
	private EntityManager em;
	public boolean insertJPA(Transaccion entity) throws SQLException {
		em.persist(entity);
		return true;
	}
}
