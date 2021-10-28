package entity;

public class User {

    private String userId;
    private String name;
    private int reviewCount;
    private String friends;
    private double averageStars;

    public User(String userId, String name, int reviewCount, String friends, double averageStars) {
        this.userId = userId;
        this.name = name;
        this.reviewCount = reviewCount;
        this.friends = friends;
        this.averageStars = averageStars;
    }

    public User() {
		super();
	}

	public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReviewCount() {
        return this.reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    public String getFriends() {
        return this.friends;
    }

    public void setFriends(String friends) {
        this.friends = friends;
    }

    public double getAverageStars() {
        return this.averageStars;
    }

    public void setAverageStars(double averageStars) {
        this.averageStars = averageStars;
    }


    @Override
    public String toString() {
        return "User ID: " + getUserId() +
            ", Name: " + getName() +
            ", Review Count: " + getReviewCount() +
            ", Friends: " + getFriends() +
            ", Average Stars: " + getAverageStars();
    }
}
