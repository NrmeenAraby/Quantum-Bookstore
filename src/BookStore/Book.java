package BookStore;

public abstract class Book {
    private String ISBN;
    private String title;
    private int publishedYear;
    private double price;

    public Book( String ISBN,String title,int publishedYear,double price){
        this.ISBN=ISBN;
        this.title=title;
        this.publishedYear=publishedYear;
        this.price=price;
    }

    public String getISBN(){
        return ISBN;
    }
    public String getTitle() {
        return title;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public double getPrice() {
        return price;
    }

    public  abstract double buy(long quantity,String email,String address);

}
