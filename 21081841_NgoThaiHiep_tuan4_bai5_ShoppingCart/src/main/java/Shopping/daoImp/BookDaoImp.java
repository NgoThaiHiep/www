package Shopping.daoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import Shopping.enity.Book;

public class BookDaoImp implements BookDao{

private DataSource dataSource;
	
	public BookDaoImp(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from book";
		List<Book> list = new ArrayList<Book>();
		
		try(
				 Connection con = this.dataSource.getConnection();
				    PreparedStatement ps = con.prepareStatement(sql);
				    ResultSet rs = ps.executeQuery();
		){
           while (rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String translator = rs.getString("translator");
			int price = rs.getInt("price");
			int quantity = rs.getInt("quantity");
			String image = rs.getString("image");
			list.add(new Book(id,title, author,translator, price, quantity, image));
			
		}
              
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		return list;
	}

	@Override
	public Book getByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from book where id = ?";
		Book b = null;
		
		try (
		        Connection con = this.dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					
					String title = rs.getString("title");
					String author = rs.getString("author");
					String translator = rs.getString("translator");
					int price = rs.getInt("price");
					int quantity = rs.getInt("quantity");
					String image = rs.getString("image");
					b = new Book(id,title, author,translator, price, quantity, image);
				}
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public void addBook(Book b) {
		// TODO Auto-generated method stub
		String sql = "insert into book(title, author,translator, price, quantity, image) values(?,?,?,?,?,?)";
		try (
                Connection con = this.dataSource.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
        ){
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());
            ps.setString(3, b.getTranslator());
            ps.setInt(4, b.getPrice());
            ps.setInt(5, b.getQuantity());
            ps.setString(6, b.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
        	  e.printStackTrace();
        }
		
	}

}
