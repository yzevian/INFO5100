package reservationDao;

public class newRe {
	private String id;
	public newRe() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String brand;
	private String type;
	private String price;
	private String color;

	public newRe(String id,String brand, String color, String price, String type){
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	
}
