package daoImp;

import java.util.List;

import entity.DienThoai;

public interface DienThoaiDAO {
	public List<DienThoai> FindAll();
	public DienThoai FindByID(int id);
	public DienThoai Add(DienThoai dt);
	public DienThoai Update(DienThoai dt);
	public boolean Delete(int id);
 }
