package src.entity;

public class Business {

    private String businessId;
    private String name;
    private double stars;
    private long reviewCount;
    private String categories;
    
    
    
    public Business() {
		super();
	}

	public Business(String businessId, String name, double stars, int reviewCount, String categories) {
        this.businessId = businessId;
        this.name = name;
        this.stars = stars;
        this.reviewCount = reviewCount;
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

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(long reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "Business ID: " + businessId + ", Name:" + name;
    }
}
