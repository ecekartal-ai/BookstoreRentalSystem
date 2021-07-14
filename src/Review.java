import javax.swing.JOptionPane;

public class Review {
	double starRating;
	String comment;
	
	public Review()
	{
		String starRating = JOptionPane.showInputDialog("Rate the digital movie on a 1-10 rating scale\n");
		this.starRating = Double.parseDouble(starRating);
		
		String comment = JOptionPane.showInputDialog("Write a short review about the movie\n");
		this.comment = comment;
	}
}
