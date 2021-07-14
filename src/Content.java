import java.lang.Integer;
import javax.swing.JOptionPane;

abstract class Content implements Displayable{
	int id;
	String title;
	String artist;
	Genre genre;
	int length;
	double costPerDay=1.0;
	
	public Content()
	{
		String id = JOptionPane.showInputDialog("Enter id\n");
		this.id = Integer.parseInt(id);
		
		String title = JOptionPane.showInputDialog("Enter title\n");
		this.title = title;
		
		String artist = JOptionPane.showInputDialog("Enter artist\n");
		this.artist = artist;
		
		genre = Genre.OTH;
		while(true)
		{
			try {
				String length;
				length = JOptionPane.showInputDialog("Enter length\n");
				int len = Integer.parseInt(length);
				this.length=len;
				break;
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Length cannot be a string!","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
	public void displayInfo() {
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"title:"+title+"\n"+
				"artist:"+artist+"\n"+
				"genre:"+genre+"\n"+
				"length:"+length+"\n",
				"Content Info",JOptionPane.INFORMATION_MESSAGE);
	}
	
	abstract double calculateCost(int duration); 
	
}
