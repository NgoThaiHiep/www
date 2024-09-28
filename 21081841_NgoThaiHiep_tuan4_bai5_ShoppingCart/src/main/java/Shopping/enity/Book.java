package Shopping.enity;

public class Book {

	private int id;
    private String title;
    private String author;
    private String translator;
    private int price;
    private int quantity;
    private String image;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public Book() {
		super();
	}
	public Book(String title, String author, String translator, int price, int quantity, String image) {
		super();
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	public Book(int id, String title, String author, String translator, int price, int quantity, String image) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.translator = translator;
		this.price = price;
		this.quantity = quantity;
		this.image = image;
	}
	
	

    
    // Getters and setters
}
