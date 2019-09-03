package model;

public class Crawling_product {
	private int num;
	private String title;
	private String price;
	private String brand;
	private String boardid;
	
	public Crawling_product() {
		
	}
	
	public Crawling_product(String title, String price, String brand) {
		super();
		this.title = title;
		this.price = price;
		this.brand = brand;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getBoardid() {
		return boardid;
	}
	public void setBoardid(String boardid) {
		this.boardid = boardid;
	}

	@Override
	public String toString() {
		return "Crawling_product [num=" + num + ", title=" + title + ", price=" + price + ", brand=" + brand
				+ ", boardid=" + boardid + "]";
	}
	
	
	
	
}
