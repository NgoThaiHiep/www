package dao;

import java.util.List;

import daoImp.DienThoaiDAO;
import entity.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;


public class DienThoaiDAOImp implements DienThoaiDAO{

	private EntityManager em;
	
	
	public DienThoaiDAOImp(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public List<DienThoai> FindAll() {
		// TODO Auto-generated method stub
		try {
			return em.createQuery("FROM DienThoai", DienThoai.class).getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai FindByID(int id) {
		// TODO Auto-generated method stub
		try {
			DienThoai dienthoai = em.find(DienThoai.class, id);
			return dienthoai;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DienThoai Add(DienThoai dt) {
		// TODO Auto-generated method stub
		EntityTransaction tr = null;
		try {
			tr = em.getTransaction();
			tr.begin();
			em.persist(dt);
			tr.commit();
			return dt;
			
		} catch (Exception e) {
			if (tr.isActive() && tr != null) {
				tr.rollback();
			}
		}
		return null;
	}

	@Override
	public DienThoai Update(DienThoai dt) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(dt);
			tx.commit();
			return dt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			DienThoai dt = em.find(DienThoai.class, id);
			em.remove(dt);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		
	}

}
