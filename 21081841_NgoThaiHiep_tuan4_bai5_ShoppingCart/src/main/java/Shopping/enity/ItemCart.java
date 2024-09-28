package Shopping.enity;

public class ItemCart {
	private Book book;
	private int quantity;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ItemCart() {
		super();
	}
	public ItemCart(Book book) {
		super();
		this.book = book;
	}

	public ItemCart(Book book, int quantity) {
		super();
		this.book = book;
		this.quantity = quantity;
	}
	
}
