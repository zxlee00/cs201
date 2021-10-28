public class Review implements Comparable<Review> {
    
    private String reviewId;
    private String userId;
    private String businessId;
    private int stars;
    private String text;
    
    


    public Review() {
		super();
	}

	public Review(String reviewId, String userId, String businessId, int stars, String text) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.businessId = businessId;
        this.stars = stars;
        this.text = text;
    }

    public String getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public int getStars() {
        return this.stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Review ID: " + getReviewId() +
            ", User ID: " + getUserId() +
            ", Business ID: " + getBusinessId() +
            ", Stars: " + getStars() +
            ", Text: " + getText();
    }

    @Override
    public int compareTo(Review r) {
        return getReviewId().compareTo(r.getReviewId());
    }  
}
