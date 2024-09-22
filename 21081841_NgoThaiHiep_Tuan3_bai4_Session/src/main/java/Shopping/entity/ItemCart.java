package Shopping.entity;

public class ItemCart {
	private Product product;
	private int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuanlity(int quantity) {
		this.quantity = quantity;
	}
	public ItemCart(Product product, int quanlity) {
		super();
		this.product = product;
		this.quantity = quanlity;
	}
	public ItemCart() {
		super();
	}
	
}
