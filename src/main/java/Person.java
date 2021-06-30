public class Person  {
	private String firstName=" ";
	private String lastName = " ";
	private String email=" ";
	private String username =" ";
	private String password=" ";
	
	public Person(String f,String l,String e, String u, String p) {
		this.firstName=f;
		this.lastName=l;
		this.email =e;
		this.username = u;
		this.password = p;
		
	}
	
	
	public String getFirstName() {return this.firstName;}
	public void setFirstName(String newFirstName) {this.firstName=newFirstName;}
	
	public String getLastName() {return this.lastName;}
	public void setLastName(String newLastName) {this.lastName=newLastName;}
	
	public String getEmail() {return this.email;}
	public void setEmail(String newEmail) {this.email=newEmail;}
	
	public String getUsername() {return this.username;}
	
	public String getPassword() {return this.password;}
	
	
	
	public void print() {
		System.out.println( getFirstName()+" "+getLastName() + " ,"+getEmail());
    }
	
	
}

