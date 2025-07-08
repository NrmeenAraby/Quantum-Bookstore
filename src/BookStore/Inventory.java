package BookStore;

import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Book>books;
    public Inventory(){
        books=new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
        System.out.println( book.getTitle()+" Added" );
    }

    public List<Book> removeOutdatedBooks(int threshold){
        List<Book> outDated=new ArrayList<>();
        Iterator<Book> iter = books.iterator();
        int currentYear = Year.now().getValue();
        while (iter.hasNext()){
            Book book = iter.next();
            int age = currentYear - book.getPublishedYear();
            if(age>threshold){
                outDated.add(book);
                iter.remove();
            }

        }
        return outDated;
    }

    public double buyBook(String ISBN, long quantity, String email,String address){
        for(Book book:books){
            if(book.getISBN().equals(ISBN)){
                return book.buy(quantity,email,address);
            }
        }
        throw new IllegalArgumentException("Book with ISBN " + ISBN + " not found");
    }

}
