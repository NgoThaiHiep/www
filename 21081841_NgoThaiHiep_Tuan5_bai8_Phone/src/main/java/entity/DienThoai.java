package entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DienThoai")
public class DienThoai {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MADT")
	private int madt;
	@Column(name = "TENDT")
	private String  tendt;
	@Column(name = "NAMSANXUAT")
	private int namsx;
	
	@Column(name = "CAUHINH")
	private String cauhinh;
	
	@Column(name = "MANCC")
	private int mancc;

	public int getMadt() {
		return madt;
	}

	public void setMadt(int madt) {
		this.madt = madt;
	}

	public String getTendt() {
		return tendt;
	}

	public void setTendt(String tendt) {
		this.tendt = tendt;
	}

	public int getNamsx() {
		return namsx;
	}

	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}

	public String getCauhinh() {
		return cauhinh;
	}

	public void setCauhinh(String cauhinh) {
		this.cauhinh = cauhinh;
	}

	public int getMancc() {
		return mancc;
	}

	public void setMancc(int mancc) {
		this.mancc = mancc;
	}

	public DienThoai(int madt, String tendt, int namsx, String cauhinh, int mancc) {
		super();
		this.madt = madt;
		this.tendt = tendt;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.mancc = mancc;
	}

	public DienThoai(String tendt, int namsx, String cauhinh, int mancc) {
		super();
		this.tendt = tendt;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.mancc = mancc;
	}
	

	public DienThoai() {
		super();
	}
	
	
}
