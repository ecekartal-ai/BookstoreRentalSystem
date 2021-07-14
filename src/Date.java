import javax.swing.JOptionPane;

public class Date {
	int day;
	int month;
	int year;
	String s1,s2,s3;
	
	public Date(){
		String s1 = JOptionPane.showInputDialog("Enter day\n");
		this.s1 = s1;
		
		String s2 = JOptionPane.showInputDialog("Enter month\n");
		this.s2 = s2;
		
		String s3 = JOptionPane.showInputDialog("Enter year\n");
		this.s3 = s3;
	}
	
	public class IntegerParseTest {
		
		public void main(String[] args) {
			
			day=Integer.parseInt(s1);
			month=Integer.parseInt(s2);
			year=Integer.parseInt(s3);
		}
	}
	
}
