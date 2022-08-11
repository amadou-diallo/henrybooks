
package business;

import java.text.NumberFormat;

/**
 *
 * @author 
 */
public class Inventory {
    private int StoreID, OnHand;
    private String BookID, Author, Title;
    private double Price;
    
    NumberFormat c = NumberFormat.getCurrencyInstance();
    
    public Inventory() {
        StoreID = 0;
        OnHand = 0;
        BookID = "";
        Title = "";
        Author = "";
        Price = 0.0;
    }

    public int getStoreID() {
        return StoreID;
    }

    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }

    public int getOnHand() {
        return OnHand;
    }

    public void setOnHand(int OnHand) {
        this.OnHand = OnHand;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String BookID) {
        this.BookID = BookID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    
    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }
    
    public double getPrice() {
        return Price;
    }

    public String getPriceF() {
        return c.format(Price);
    }
    
    public void setPrice(double Price) {
        this.Price = Price;
    }
        
}
