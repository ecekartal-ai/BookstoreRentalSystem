enum Genre {
	ACT("Action movie - includes fight scenes, stunts and general danger."),
	DRA("Drama movie - focusses emotions and intense situations."),
	SCI("Science fiction movie - incorporates space, biology and any other observable science."),
	THR("Thriller movie - deals with generating suspense and anxiety."),
	COM("Comedy movie - intends to make someone laugh."),
	OTH("Other movie - if the genre is not specified, its default value will be Other.");
	
	String genre1;
	Genre(String s){
		genre1 = s;
	}
	String showGenre() {
		return genre1;
	}
}

 
