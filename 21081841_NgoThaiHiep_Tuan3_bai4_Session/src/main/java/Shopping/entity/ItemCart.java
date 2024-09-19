package Shopping.entity;

public class ItemCart {
	private Product product;
	private int quanlity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuanlity() {
		return quanlity;
	}
	public void setQuanlity(int quanlity) {
		this.quanlity = quanlity;
	}
	public ItemCart(Product product, int quanlity) {
		super();
		this.product = product;
		this.quanlity = quanlity;
	}
	public ItemCart() {
		super();
	}
	
}
