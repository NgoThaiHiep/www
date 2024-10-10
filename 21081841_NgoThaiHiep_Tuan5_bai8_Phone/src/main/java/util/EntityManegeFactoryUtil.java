package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManegeFactoryUtil {
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	public EntityManegeFactoryUtil() {
		emf = Persistence.createEntityManagerFactory("QLDienThoaiMSSQL");
		em = emf.createEntityManager();
	}

	public EntityManager getEntityManager() {
		return em;
	}

	public void close() {
		em.close();
		emf.close();
	}
	
}
