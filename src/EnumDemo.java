class EnumDemo {
	
	public static void main(String args[]) {
		
		System.out.println(" ");
		for(Genre g : Genre.values()) {
			System.out.println(g + " " + g.showGenre());
		}
		
	}
}
