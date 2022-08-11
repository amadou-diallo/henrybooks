
package business;
/**
 * @author
 */
public class Store {
    private int StoreID, StoreEmp;
    private String StoreName, StoreAddr;
    
    public Store() {
        StoreID = 0;
        StoreEmp = 0;
        StoreName = "";
        StoreAddr = "";
    }

    public int getStoreID() {
        return StoreID;
    }
    public void setStoreID(int StoreID) {
        this.StoreID = StoreID;
    }
    public int getStoreEmp() {
        return StoreEmp;
    }
    public void setStoreEmp(int StoreEmp) {
        this.StoreEmp = StoreEmp;
    }
    public String getStoreName() {
        return StoreName;
    }
    public void setStoreName(String StoreName) {
        this.StoreName = StoreName;
    }
    public String getStoreAddr() {
        return StoreAddr;
    }
    public void setStoreAddr(String StoreAddr) {
        this.StoreAddr = StoreAddr;
    }
}
