import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class CustomerTest {
	
	public static void main(String args[]) {
		
		int choice;
		ArrayList<Displayable> displayableArray = new ArrayList<Displayable>();
		
		while(true) {
			
			String ch = JOptionPane.showInputDialog("1. Create a new Customer\n" + 
					"2. Create a new DVD\n" + 
					"3. Create a new DVD with genre\n" +
					"4. Create a new Digital Movie\n" +
					"5. Rent a DVD\n" +
					"6. Display Customer Information\n" +
					"7. Display Content Information\n" +
					"8. Display number of customers\n" +
					"9. Display All Contents in order\n" +
					"10. Display All Customers in order\n" +
					"11. Write a review for a Digital Movie\n" +
					"12. Display reviews for a Digital Movie\n" +
					"0. Exit \n");
			choice = Integer.parseInt(ch);

			if(choice == 0) {
				break;
			}

			else if(choice == 1) {
				displayableArray.add(new Customer());
			}

			else if(choice == 2) {
				displayableArray.add(new DVD());
			}

			else if(choice == 3) {
				String genre = JOptionPane.showInputDialog("Enter genre");
				Genre ret;
				ret = Genre.valueOf(genre);
				displayableArray.add(new DVD(ret));
			}
			
			else if(choice ==  4) {
				displayableArray.add(new DigitalMovie());
			}
			
			else if(choice ==  5) {
				String idtem = JOptionPane.showInputDialog("Enter customer id");
				int idtemp = Integer.parseInt(idtem);
				boolean valid1=false;
				boolean valid2=false;
				for(int i=0;i<displayableArray.size();i++) {
					if(displayableArray.get(i) instanceof Customer) {
						if(((Customer) displayableArray.get(i)).getId() == idtemp) {
							valid1=true;
							String dvdtem = JOptionPane.showInputDialog("Enter dvd id");
							int dvdid = Integer.parseInt(dvdtem);
							for(int j=0;j<displayableArray.size();j++) {
								if(displayableArray.get(j) instanceof DVD) {
									if(((DVD) displayableArray.get(j)).id == dvdid) {
										valid2=true;
										((DVD) displayableArray.get(j)).rentDate = new Date();
										((Customer) displayableArray.get(i)).rentalDVD[i] = dvdid;
									}
								}
							}
							if(!valid2)
								JOptionPane.showMessageDialog(null,"No dvd has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(!valid1)
					JOptionPane.showMessageDialog(null,"No customer has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
			}

			else if(choice == 6) {
				String idtem = JOptionPane.showInputDialog("Enter customer id");
				int id = Integer.parseInt(idtem);
				boolean found = false;
				for (int i=0; i<displayableArray.size(); i++) {
					if(displayableArray.get(i) instanceof Customer)
					{
						if (((Customer) displayableArray.get(i)) != null && ((Customer) displayableArray.get(i)).getId() == id) {
							found = true;
							((Customer) displayableArray.get(i)).displayInfo();
							break;
						}
					}
				}
				if(!found)
					JOptionPane.showMessageDialog(null,"No customer has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
			}

			else if(choice == 7) {
				int i;
				int duration1,duration;
				String temp = JOptionPane.showInputDialog("Enter content id");
				int ContentId = Integer.parseInt(temp);
				boolean found = false;
				for (i = 0; i<displayableArray.size(); i++) {
					if(displayableArray.get(i) instanceof DigitalMovie)
					{
						if (displayableArray.get(i) != null && ((DigitalMovie) displayableArray.get(i)).id == ContentId) {
							found = true;
							((DigitalMovie) displayableArray.get(i)).displayInfo();
							
							String temp1 = JOptionPane.showInputDialog("How long would you like to rent that Digital Movie?");
							duration = Integer.parseInt(temp1);
							JOptionPane.showMessageDialog(null, "The rental cost for "+duration+" days is $"+((DVD) displayableArray.get(i)).calculateCost(duration), "", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				for (i = 0; i<displayableArray.size(); i++) {
					if(displayableArray.get(i) instanceof DVD)
					{
						if (displayableArray.get(i) != null && ((DVD) displayableArray.get(i)).id == ContentId) {
							found = true;
							((DVD) displayableArray.get(i)).displayInfo();
							
							String temp1 = JOptionPane.showInputDialog("How long would you like to rent that DVD?");
							duration1 = Integer.parseInt(temp1);
							JOptionPane.showMessageDialog(null, "The rental cost for "+duration1+" days is $"+((DVD) displayableArray.get(i)).calculateCost(duration1), "", JOptionPane.INFORMATION_MESSAGE);
							break;
						}
					}
				}
				if(!found)
					JOptionPane.showMessageDialog(null,"No content has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
			}

			else if(choice == 8) {
				JOptionPane.showMessageDialog(null, "Number of Customers:"+Customer.customerCount, "", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if(choice == 9) {
				ArrayList<Content> testArray = new ArrayList<Content>();
				for(int a=0; a<displayableArray.size();a++)
				{
					if(displayableArray.get(a) instanceof Content)
					{
						testArray.add((Content)displayableArray.get(a));
						
					}
				}
				Collections.sort(testArray,new LengthComparator());
				for(int b=0; b<testArray.size(); b++)
				{
					testArray.get(b).displayInfo();
				}
			}
			
			else if(choice == 10) {
				ArrayList<Customer> testArray = new ArrayList<Customer>();
				for(int a=0; a<displayableArray.size();a++)
				{
					if(displayableArray.get(a) instanceof Customer)
					{
						testArray.add((Customer)displayableArray.get(a));
						
					}
				}
				Collections.sort(testArray, Customer.ageComparator);
				for(int b=0; b<testArray.size(); b++)
				{
					testArray.get(b).displayInfo();
				}
			}
			
			else if(choice == 11) {
				String temp = JOptionPane.showInputDialog("Enter Customer id");
				int CustomerId = Integer.parseInt(temp);
				
				boolean found = false;
				for (int i = 0; i<displayableArray.size(); i++) {
					if(displayableArray.get(i) instanceof Customer)
					{
						if (displayableArray.get(i) != null && ((Customer) displayableArray.get(i)).getId() == CustomerId) {
							found = true;
							
							String temp1 = JOptionPane.showInputDialog("Enter Digital Movie id");
							int DigitalMovieId = Integer.parseInt(temp1);
							
							boolean found1 = false;
							for (int j = 0; j<displayableArray.size(); j++)
							{
								if(displayableArray.get(j) instanceof DigitalMovie)
								{
									if (displayableArray.get(j) != null && ((DigitalMovie) displayableArray.get(j)).id == DigitalMovieId) {
										found1 = true;
										Review review=new Review();
										((DigitalMovie)displayableArray.get(j)).customerReviews.put(CustomerId,review);
										break;
									}
								}
							}
							if(!found1)
								JOptionPane.showMessageDialog(null,"No digital movie has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				if(!found)
					JOptionPane.showMessageDialog(null,"No customer has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
			}
			
			else if(choice == 12) {
				String temp = JOptionPane.showInputDialog("Enter Digital Movie id");
				int DigitalMovieId = Integer.parseInt(temp);
				
				boolean found = false;
				for (int i = 0; i<displayableArray.size(); i++) {
					if(displayableArray.get(i) instanceof DigitalMovie)
					{
						if (displayableArray.get(i) != null && ((DigitalMovie) displayableArray.get(i)).id == DigitalMovieId) {
							found=true;
							((DigitalMovie)displayableArray.get(i)).displaycustomerReviewsInfo();
							((DigitalMovie)displayableArray.get(i)).displayaverageRating();
						}
					}
				}
				if(!found)
					JOptionPane.showMessageDialog(null,"No digital movie has found with the given id!","Error",JOptionPane.ERROR_MESSAGE);
			}
		}

	}

}
