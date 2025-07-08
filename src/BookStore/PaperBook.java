package BookStore;

import Services.ShippingService;

public class PaperBook extends Book {
    private long stock;
    private boolean isShippable;
    private double shippingPrice;

    public PaperBook(String ISBN,String title,int publishedYear,double price,long stock,boolean isShippable,double shippingPrice){
        super(ISBN,title,publishedYear,price);
        this.stock=stock;
        this.isShippable=isShippable;
        this.shippingPrice=shippingPrice;
    }

    public double buy(long quantity,String email,String address){
        if(quantity>this.stock){
            throw new IllegalArgumentException("Not enough stock, We only have "+stock);
        }
        stock-=quantity;
        double totalPrice=quantity*getPrice();
        if(isShippable){
            ShippingService.send(address);
            totalPrice+=shippingPrice*quantity;
        }
      return totalPrice;
    }

}
