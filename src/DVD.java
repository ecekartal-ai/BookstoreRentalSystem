import javax.swing.JOptionPane;

class DVD extends Content{

	Date rentDate;
	
	public DVD()
	{
		genre = Genre.OTH;
	}
	
	public DVD(Genre genre)
	{
		this.genre = genre;
	}
	
	double calculateCost(int duration) {
		double duration1;
		if(duration>0 && duration<=7)
		{
			costPerDay=1.0;
			duration1=costPerDay*duration;
			return duration1;
		}
		if(duration>7 && duration<=14.0)
		{
			costPerDay=1.2;
			duration1=costPerDay*duration;
			return duration1;
		}
		else
		{
			costPerDay=2.0;
			duration1=costPerDay*duration;
			return duration1;
		}
	}

	public void displayInfo() {
		JOptionPane.showMessageDialog(null,"id:"+id+"\n"+ 
				"title:"+title+"\n"+
				"artist:"+artist+"\n"+
				"genre:"+genre.showGenre()+"\n"+
				"length:"+length+"\n",
				"Content Info",JOptionPane.INFORMATION_MESSAGE);
	}
}

