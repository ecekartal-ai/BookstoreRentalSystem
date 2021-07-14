import java.util.HashMap;
import javax.swing.JOptionPane;

class DigitalMovie extends Content{
	String streamingService;
	HashMap<Integer, Review> customerReviews = new HashMap<Integer, Review>();
	
	public DigitalMovie()
	{
		String streamingService = JOptionPane.showInputDialog("Enter streaming service\n");
		this.streamingService = streamingService;
	}
	
	double calculateCost(int duration) {
		double duration1;
		
		if(duration>0 && duration<=7)
		{
			costPerDay=1.0;
			duration1=costPerDay*duration;
			return duration1;
		}
		if(duration>7 && duration<=14)
		{
			costPerDay=0.8;
			duration1=costPerDay*duration;
			return duration1;
		}
		else
		{
			costPerDay=0.5;
			duration1=costPerDay*duration;
			return duration1;
		}
	}

	public void displayInfo() {
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"title:"+title+"\n"+
				"artist:"+artist+"\n"+
				"genre:"+genre.showGenre()+"\n"+
				"length:"+length+"\n"+
				"streaming service:"+streamingService+"\n",
				"Content Info",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void displaycustomerReviewsInfo() {
		customerReviews.entrySet().forEach(entry->{
			JOptionPane.showMessageDialog(null,
					"Customer Id:"+entry.getKey()+"\n"+
					"Rating:"+entry.getValue().starRating+"\n"+
					"Comment:"+entry.getValue().comment+"\n",
					"Customer Reviews",JOptionPane.INFORMATION_MESSAGE);
		});
	}
	
	public void displayaverageRating() {
		double sum=0.0;
		double average=0.0;
		for(Review c: customerReviews.values())
		{
			sum+=c.starRating;
		}
		
		average = sum / (customerReviews.size());
		JOptionPane.showMessageDialog(null, "The average star-rating of the movie is:"+average+"\n","",JOptionPane.INFORMATION_MESSAGE);
	}
}
