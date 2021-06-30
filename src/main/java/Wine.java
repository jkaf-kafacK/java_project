
public class Wine {
	private String name = "";
	private String year ="";
	private String technical_note= "";
	private String dizziness ="";
	private int quantity =0;
	
	public Wine(String n,String a,String nt,String d,int qt) {
		this.name = n;
		this.year = a;
		this.technical_note=nt;
		this.dizziness=d;
		this.quantity=qt;
		
	}
	public String getName() {return this.name;}
	public void setName(String _n) {this.name =_n;}
	
	public String getYear() {return this.year;}
	public void setYear(String _y) {this.year=_y;}
	
	public String getTechnical_note() {return this.technical_note;}
	public void setTechnical(String _nt) {this.technical_note=_nt;}
	
	public String getDizziness() {return this.dizziness;}
	public void setDizziness(String _d) {this.dizziness=_d;}
	
	public int getQuantity() {return this.quantity;}
	
	public void decreaseQuantity(int q) {
		this.quantity-=q;
	}

	public void increaseQuantity(int q) {
		this.quantity+=q;
	}

}
