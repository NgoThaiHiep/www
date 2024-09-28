package Shopping.daoImp;


import java.util.List;

import Shopping.enity.Book;

public interface BookDao {
	public List<Book> findAll();
	public Book getByID(int id);
	public void addBook(Book b);

}
