import java.util.Comparator;

import javax.naming.spi.DirStateFactory.Result;

public class Business implements Comparable<Business> {
    private String businessId;
    private String name;
    private String categories;
    
    public Business(String businessId, String name, String categories) {
        this.businessId = businessId;
        this.name = name;
        this.categories = categories;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Business ID: " + businessId + ", Name:" + name;
    }

    @Override
    public int compareTo(Business b) {
        return getName().compareTo(b.getName());
    }  
}
