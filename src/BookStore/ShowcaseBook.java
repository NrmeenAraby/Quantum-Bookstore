package BookStore;

public class ShowcaseBook extends Book{
    public ShowcaseBook(String ISBN,String title,int publishedYear,double price){
        super(ISBN,title,publishedYear, price);
    }

    public double buy(long quantity,String email,String address){
        throw new UnsupportedOperationException("Showcase books are not for sale");
    }
}
