import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		
		ArrayList <Employe> arrayEmploye= new ArrayList<Employe> ();
		ArrayList <User> arrayUser = new ArrayList <User> ();
		ArrayList <Wine> arrayWine = new ArrayList <Wine> ();
		
		
		
		arrayEmploye.add(new Employe("kafack","jacques","jacq@gmail.com","jack23","logo25"));
		
		arrayWine.add(new Wine("bordeaux","2011","champagnede de table","valle nantes",5));
		arrayWine.add(new Wine("lambusco", "2015","vino Frizzante","langhiranno", 3));

		arrayUser.add(new User("tati","menang","menatati@gmail.com","tatiana02","sem56"));
		arrayUser.add(new User("luca","bonelli","luca@gamil.com","luca06","large13"));
		
		System.out.println("MENU\n "+"1 : EMPLOYE\n" + " 2 : USER");
		String ss = keyboard.nextLine();
		int qq = Integer.valueOf(ss);
		if(qq ==1) {
			@SuppressWarnings("resource")
			Scanner pt = new Scanner(System.in);
			boolean  start = true;
			while(start) {
				MenuEmploye();
				int pt1 = keyboard.nextInt();
				switch(pt1) {
				case 1:registration_(arrayEmploye);break;
				case 2:Login_(arrayEmploye,arrayWine);
				}
			}
		}
		else {
			boolean W_runninng = true;
			while(W_runninng) {
				MenuUser();
				int cki = keyboard.nextInt();
			    //System.out.flush();
				switch(cki) {
					case 1: registration(arrayUser); break;
					case 2:  Login(arrayUser,arrayWine); break;
					case 3: Search(arrayWine); break;				
				}				
			}
		}		
	}
	// provide the new wine
	public static void provide_Wine(Employe employe, ArrayList <Wine> arrayWine) { 
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("wine name");
		String name_Wine = keyboard.nextLine();
		System.out.println("wine year");
		String year_wine = keyboard.nextLine();
		System.out.println("Quatity");
		String q = keyboard.nextLine();
		int quantity = Integer.valueOf(q); // convert to integer
		for(int i = 0; i<arrayWine.size(); i++) {
			if(name_Wine.equals(arrayWine.get(i).getName()) &&  year_wine.equals(arrayWine.get(i).getYear()))
				arrayWine.get(i).increaseQuantity(quantity);
		}
	}
	// creare notifica
	public static void send_Wine() {
		// sent Wine to user
	}
	public static void by_Wine(User user ,ArrayList <Wine> arrayWine) {
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("wine name");
		String name_Wine = keyboard.nextLine();
		System.out.println("wine year");
		String year_wine = keyboard.nextLine();
		System.out.println("Quatity");
		String q = keyboard.nextLine();
		int quantity = Integer.valueOf(q); // convert to integer
		for(int i= 0; i< arrayWine.size(); i++)
			if(name_Wine.equals(arrayWine.get(i).getName()) && year_wine.equals(arrayWine.get(i).getName())
					&& quantity <= arrayWine.get(i).getQuantity()) {// look up the name,year , the quantity
				//write to file name user  name Wine and quantity
				OutputStream os = null;
				String data = user.getFirstName()+ " " + arrayWine.get(i).getName() + q;
				try {
					os =new FileOutputStream(new File("/"
							+ "Users/Administrator/My_First_Maven_Project/saveData.txt"));
					 os.write(data.getBytes(), 1, data.length());
					
				}catch(IOException e) {e.printStackTrace();}
				finally {try {os.close();}catch(IOException e) {
					e.printStackTrace();
				}
				arrayWine.get(i).decreaseQuantity(quantity);
				}
			}
			else {
				System.out.println("non of stock");
			}
	}
	
	// user Search the Wine
	@SuppressWarnings("resource")
	public static void  Search(ArrayList <Wine> arrayWine) {
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("wine name");
		String name_Wine = keyboard.nextLine();
		System.out.println("wine year");
		String year_wine = keyboard.nextLine();
		for(int i = 0; i<arrayWine.size(); i++) {
			if(name_Wine.equals(arrayWine.get(i).getName()) &&  year_wine.equals(arrayWine.get(i).getYear()))
				System.out.println("remaining quantity " + arrayWine.get(i).getQuantity());
		}
	}
	
	// Menu employe	
	public static void MenuEmploye() {
		@SuppressWarnings({ "unused", "resource" })
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("MENU EMPLOYE\n");
		System.out.println("1 Registration\n"+ "2 Login\n");
		
	}
	// registration Employe
	public static void registration_(ArrayList <Employe> arryEmploye) {
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("Firstname");
		String firstname = keyboard.nextLine();
		System.out.println("lastnane");
		String lastname= keyboard.nextLine();
		System.out.println("email");
		String email = keyboard.nextLine();
		System.out.println("username");
		String username = keyboard.nextLine();
		System.out.println("password");
		String password = keyboard.nextLine();
		Employe newEmploye = new Employe(firstname,lastname,email,username,password);
		System.out.println("registration");	
		arryEmploye.add(newEmploye);		
	}
	// login employes
	public static void Login_(ArrayList <Employe> arryEmploye,ArrayList <Wine> arrayWine)
	{
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("userame");
		String username = keyboard.nextLine();
		System.out.println("password");
		String pass = keyboard .nextLine();
		if(username.length()==0 || pass.length()==0) {
			System.out.println("error try again\n");
		}
		else{
			for(int i=0; i< arryEmploye.size(); i++ ) {
				if(username.equals(arryEmploye.get(i).getUsername()) && pass.equals(arryEmploye.get(i).getPassword())) {
					System.out.println("glad to see you again \n");				
					provide_Wine( arryEmploye.get(i),arrayWine);
				}		
			}
			System.out.println("login error\n");	
		}
	}
	// menu user
	@SuppressWarnings({ "resource", "unused" })
	public static void MenuUser() {
		Scanner keyboard  = new Scanner(System.in);
		//String print = keyboard.nextLine();
		System.out.println("MENU USER\n");
		System.out.println("1 Registration\n"+ "2 Login\n"+ "3 Search\n");		
	}
	
	// registration User
	public static void registration(ArrayList <User> arrUser) {
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("Firstname");
		String firstname = keyboard.nextLine();
		System.out.println("lastnane");
		String lastname= keyboard.nextLine();
		System.out.println("email");
		String email = keyboard.nextLine();
		System.out.println("username");
		String username = keyboard.nextLine();
		System.out.println("password");
		String password = keyboard.nextLine();
		User newUser = new User(firstname,lastname,email,username,password);
		System.out.println("registration");	
		arrUser.add(newUser);		
	}	

		// connect user, after the control buy a produit
	public static void Login(ArrayList <User> arrUser,ArrayList <Wine> arrayWine)
	{
		@SuppressWarnings("resource")
		Scanner keyboard  = new Scanner(System.in);
		System.out.println("userame");
		String username = keyboard.nextLine();
		System.out.println("password");
		String pass = keyboard.nextLine();
		if(username.length()==0 || pass.length()==0) {
			System.out.println("error try again");
		}
		else{
			for(int i=0; i< arrUser.size(); i++ ) {
				if(username.equals(arrUser.get(i).getUsername()) && pass.equals(arrUser.get(i).getPassword())) {
					System.out.println("glad to see you again \n");
					by_Wine( arrUser.get(i),arrayWine);
				}		
			}
			System.out.println("non to stock");	
		}
	}
}
