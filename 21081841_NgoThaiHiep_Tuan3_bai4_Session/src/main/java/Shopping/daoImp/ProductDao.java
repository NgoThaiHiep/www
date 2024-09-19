package Shopping.daoImp;

import java.util.List;

import Shopping.entity.Product;

public interface ProductDao {
	public List<Product> findAll();
	public Product getByID(int id);
	public void addProduct(Product p);
}
