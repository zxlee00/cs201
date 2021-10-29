import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.Business;
import entity.Review;
import entity.User;


public class SusFinder {
	
	private static final String PROPERTIES_FILE = "application.properties";
	
	private static Properties properties;
	
	private static JSONParser parser;
	
	public static void main(String[] args) {
		
		// each step = 1 class
		// util tool? + algorithm (main method) => keep calling it to measure the parameters
		
		/*
		 * 
		 * Step 1: + POJO
		 * - filter restaurants from businesses
		 * - Return: ArrayList  / LinkedList / Binary Tree
		 * - Args: List<Business>
		 * 
		 * filename to businesses.json declared in step1 
		 * 
		 * 
		 * 
		 * Step 2:
		 * - identify suspicious reviews
		 * - Return: HashMap / ArrayList
		 * - Args: accept Object (use "instance of" to check for List, LL or BT) + List<Reviews>
		 * 
		 * filename to reviews.json declared in step2 
		 * 
		 * 
		 * Step 3:
		 * - identify suspicious reviewers
		 * - Return: SLL, BT
		 * - Arge: accept Object + List<User>
		 * 
		 * filename to user.json declared in step2 
		*/
		
		try {
			loadProperties();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		parser = new JSONParser();
		
		
		try {
			// List<Business> businessList = loadBusinessFromJson();
			// for(Business b: businessList) {
			// 	System.out.println(b.toString());
			// }
			Step1 step1 = new Step1();
			
			List<Business> businessList = loadBusinessFromJson();

			ArrayList<Business> restaurantsAl = step1.filterRestaurantsArrayList(businessList);
			SinglyLinkedList<Business> restaurantsSll = step1.filterRestaurantsSinglyLinkedList(businessList);
			Set<Business> restaurantTreeSet = step1.filterRestaurantsBinaryTree(businessList);

			System.out.println(restaurantsAl.size());
			System.out.println(restaurantsSll.size());
			System.out.println(restaurantTreeSet.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private static void loadProperties() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(PROPERTIES_FILE));
	}


	private static List<Business> loadBusinessFromJson() throws IOException, ParseException{
		String filePath = properties.getProperty("rootDir") + "/" + properties.getProperty("businessDataset");
		File file = new File(filePath);
		
		String rawContent = FileUtils.readFileToString(file, "UTF-8");
		JSONArray jsonArray = (JSONArray)parser.parse("[" + rawContent + "]");
		
		List<Business> businessList = new LinkedList<>();
		
		for(Object o: jsonArray) {
			if(o instanceof JSONObject) {
				JSONObject jsonObject = (JSONObject) o;
				businessList.add(jsonToBusiness(jsonObject));
			}
		}
		
		return businessList;
		
 	}
	
	private static Business jsonToBusiness(JSONObject o) {
		Business b = new Business();
		b.setBusinessId((String) o.get("business_id"));
		b.setCategories((String) o.get("categories"));
		b.setName((String) o.get("name"));
		b.setReviewCount((long) o.get("review_count"));
		b.setStars((double) o.get("stars"));
		
		return b;
	}


	private static List<Review> loadReviewFromJson() throws IOException, ParseException{
		
		String filePath = properties.getProperty("rootDir") + "/" + properties.getProperty("reviewDataset");
		File file = new File(filePath);
		
		String rawContent = FileUtils.readFileToString(file, "UTF-8");
		JSONArray jsonArray = (JSONArray)parser.parse("[" + rawContent + "]");
		
		List<Review> reviewList = new LinkedList<>();
		
		for(Object o: jsonArray) {
			if(o instanceof JSONObject) {
				JSONObject jsonObject = (JSONObject) o;
				reviewList.add(jsonToReview(jsonObject));
			}
		}
		
		return reviewList;
		
	}
	
	private static Review jsonToReview(JSONObject o) {
		Review r = new Review();
		r.setBusinessId((String) o.get("business_id"));
		r.setReviewId((String) o.get("review_id"));
		r.setStars((int) o.get("stars"));
		r.setText((String) o.get("text"));
		r.setUserId((String) o.get("user_id"));
		
		return r;
	}


	private static List<User> loadUserFromJson() throws ParseException, IOException{
		String filePath = properties.getProperty("rootDir") + "/" + properties.getProperty("userDataset");
		File file = new File(filePath);
		
		String rawContent = FileUtils.readFileToString(file, "UTF-8");
		JSONArray jsonArray = (JSONArray)parser.parse("[" + rawContent + "]");
		
		List<User> userList = new LinkedList<>();
		
		for(Object o: jsonArray) {
			if(o instanceof JSONObject) {
				JSONObject jsonObject = (JSONObject) o;
				userList.add(jsonToUser(jsonObject));
			}
		}
		
		return userList;
	}


	private static User jsonToUser(JSONObject o) {
		User u = new User();
		u.setAverageStars((double) o.get("average_stars"));
		u.setFriends((String) o.get("friends"));
		u.setName((String) o.get("name"));
		u.setReviewCount((int) o.get("review_count"));
		u.setUserId((String) o.get("user_id"));
		
		return u;
	}

}
