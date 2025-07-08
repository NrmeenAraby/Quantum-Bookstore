package BookStore;

import Services.MailService;

public class EBook extends Book{
    private String fileType;
    private boolean byEmail;

    public EBook(String ISBN,String title,int publishedYear,double price,String fileType,boolean byEmail){
        super(ISBN,title,publishedYear,price);
        this.fileType=fileType;
        this.byEmail=byEmail;
    }

    public double buy(long quantity, String email, String address){
        if (quantity != 1) {
            throw new IllegalArgumentException("You can only buy one copy of an EBook at a time");
        }
        if(byEmail){
            MailService.send(email);
        }
         return getPrice();
    }
}
