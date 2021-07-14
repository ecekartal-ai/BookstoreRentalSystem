import javax.swing.JOptionPane;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Customer implements Displayable, Comparable<Customer>{
	private int id;
	String name;
	String surname;
	String email;
	private int age;
	private int postCode;
	Integer[] rentalDVD = new Integer[10]; 
	static int customerCount = 0;

	public Customer(){
		String id = JOptionPane.showInputDialog("Enter id\n");
		this.id = Integer.parseInt(id);

		while(true)
		{
			try {
				String name = JOptionPane.showInputDialog("Enter name\n");
				this.name = name;
				if(containDigit(name))
					throw new InputMismatchException();
				else
					break;
			}catch(InputMismatchException e) {
				JOptionPane.showMessageDialog(null,"Name cannot contain any numbers!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		while(true)
		{
			try {
				String surname = JOptionPane.showInputDialog("Enter surname\n");
				this.surname = surname;
				if(containDigit(surname))
					throw new InputMismatchException();
				else
					break;
			}catch(InputMismatchException e) {
				JOptionPane.showMessageDialog(null,"Surname cannot contain any numbers!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		String age = JOptionPane.showInputDialog("Enter age\n");
		this.age = Integer.parseInt(age);

		String postCode = JOptionPane.showInputDialog("Enter postal code\n");
		this.postCode = Integer.parseInt(postCode);

		String email = JOptionPane.showInputDialog("Enter email\n");
		this.email = email;

		customerCount++;
	}

	public int getId(){
		return id;
	}

	public int getAge(){
		return age;
	}

	public int getPostCode(){
		return postCode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public void displayInfo() {
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+
				"name:"+name+"\n"+
				"surname:"+surname+"\n"+
				"age:"+age+"\n"+
				"postal code:"+postCode+"\n"+
				"email:"+email+"\n",
				"Customer Info",JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public int compareTo(Customer o) {

		return (this.age - o.age);
	}

	public static Comparator<Customer> ageComparator = new Comparator<Customer>(){
		@Override
		public int compare(Customer o1, Customer o2) {
			return o1.age - o2.age;
		}
	};

	public final boolean containDigit(String s) {

	    boolean digit = false;

	    if (s != null && !s.isEmpty()) {
	        for (char c : s.toCharArray()) {
	            if (digit = Character.isDigit(c)) {
	                break;
	            }
	        }
	    }

	    return digit;
	}
}
