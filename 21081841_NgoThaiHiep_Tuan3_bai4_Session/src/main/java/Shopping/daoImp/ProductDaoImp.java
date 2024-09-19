package Shopping.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import Shopping.entity.Product;

public class ProductDaoImp implements ProductDao{
	private DataSource datasource;
	
	
	public ProductDaoImp(DataSource dataSource) {
		this.datasource = dataSource;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		List<Product> list = new ArrayList<Product>();
		try (
			Connection con = this.datasource.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		){
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				Double price = rs.getDouble("price");
				String image = rs.getString("image");
				list.add(new Product(id, name, price, image));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Product getByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select  * from product where id = ?";
		Product p = null;
		try
		(
			Connection con = this.datasource.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
		){
			ps.setInt(1, id);
			try(ResultSet rs = ps.executeQuery();){
				while(rs.next()) {
					String name = rs.getString("name");
					Double price = rs.getDouble("price");
					String image = rs.getString("image");
					p = new Product(id, name, price, image);
				}
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		String sql = "insert into product (name, price, image) values (?,?,?)";
		try (
			Connection con = this.datasource.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			){
			
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setString(3, p.getImage());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
