
public class User extends Person {

	public User(String f, String l, String e, String u,String p) {
		super(f, l, e, u,p);
	}
	private Wine vino[] = new Wine[0];
	
	
	public Wine[] getVino() {return this.vino;}
	


}
