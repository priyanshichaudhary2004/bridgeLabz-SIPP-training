class Book {
    String title;
    String genre;
    int pages;

    public Book(String title, String genre, int pages) {
        this.title = title;
        this.genre = genre;
        this.pages = pages;
    }

    public String getGenre() { 
    	return genre; 
    }
    
    public int getPages() { 
    	return pages; 
    }
    
    public String getTitle() {
    	return title; 
    }
}