import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.TreeSet;

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
			
			System.out.println((double)Runtime.getRuntime().freeMemory()/1000/1000 + "MB");
			
			/*
			 * Step 1
			 */			
			Step1 step1 = new Step1();
			List<Business> businessList = loadBusinessFromJson();

			
//			long startMem = calculateMemoryUsage();
//			long startTime = System.currentTimeMillis();
//			ArrayList<Business> restaurantsAl = step1.filterRestaurantsArrayList(businessList);
//			long endMem = calculateMemoryUsage();
//			long endTime = System.currentTimeMillis();
//			System.out.println("Step 1 - ArrayList:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
//			long startMem = calculateMemoryUsage();
//			long startTime = System.currentTimeMillis();
//			SinglyLinkedList<Business> restaurantsSll = step1.filterRestaurantsSinglyLinkedList(businessList);
//			long endMem = calculateMemoryUsage();
//			long endTime = System.currentTimeMillis();
//			System.out.println("Step 1 - Singly Linked List:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
			long startMem = calculateMemoryUsage();
			long startTime = System.currentTimeMillis();
			TreeSet<Business> restaurantTreeSet = step1.filterRestaurantsBinaryTree(businessList);
			long endMem = calculateMemoryUsage();
			long endTime = System.currentTimeMillis();
			System.out.println("Step 1 - Binary Tree:");
			printInfo(startMem, endMem, startTime, endTime);
			
			System.out.println();
//			
			businessList = null;
			System.gc();
			
			
			/*
			 * Step 2
			 */	
			Step2 step2 = new Step2();
			List<Review> reviewList = loadReviewFromJson();
			
			Map<String, Integer> userIdToNumSusReviews;
			ArrayList<String> userIdNumSusReviewsArrayList;
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			userIdToNumSusReviews = step2.ArrayListToHashMap(reviewList, restaurantsAl);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 2 - ArrayList to HashMap:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			userIdToNumSusReviews = step2.BinaryTreeToHashMap(reviewList, restaurantTreeSet);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 2 - Binary Tree to Hashmap:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			userIdToNumSusReviews = step2.LinkedListToHashMap(reviewList, restaurantsSll);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 2 - LinkedList to Hashmap:");
//			printInfo(startMem, endMem, startTime, endTime);	
//			
//			System.out.println();
//			
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			userIdNumSusReviewsArrayList = 
//					step2.ArrayListToArrayList(reviewList, restaurantsAl);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 2 - ArrayList to ArrayList:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			userIdNumSusReviewsArrayList = 
//					step2.LinkedListToArrayList(reviewList, restaurantsSll);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 2 - LinkedList to ArrayList:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println();
//			
			startMem = calculateMemoryUsage();
			startTime = System.currentTimeMillis();
			userIdNumSusReviewsArrayList = 
					step2.binaryTreeToArrayList(reviewList, restaurantTreeSet);
			endMem = calculateMemoryUsage();
			endTime = System.currentTimeMillis();
			System.out.println("Step 2 - BinaryTree to ArrayList:");
			printInfo(startMem, endMem, startTime, endTime);
			
			System.out.println();
//			
//			reviewList = null;
//			System.gc();
			
			
			/*
			 * Step 3
			 */	
			Step3 step3 = new Step3();
			List<User> userList = loadUserFromJson();
			SinglyLinkedList<User> susUsersSll;
			TreeSet<User> susUsersTree;

//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			susUsersSll = step3.arrayListToSinglyLinkedList(userList, userIdNumSusReviewsArrayList);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 3 - ArrayList to SinglyLinkedList:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			susUsersSll = step3.hashMapToSinglyLinkedList(userList, userIdToNumSusReviews);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 3 - HashMap to SinglyLinkedList:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			
			startMem = calculateMemoryUsage();
			startTime = System.currentTimeMillis();
			susUsersTree = step3.arrayListToBinaryTree(userList, userIdNumSusReviewsArrayList);
			endMem = calculateMemoryUsage();
			endTime = System.currentTimeMillis();
			System.out.println("Step 3 - ArrayList to BinaryTree:");
			printInfo(startMem, endMem, startTime, endTime);
//			
//			
//			startMem = calculateMemoryUsage();
//			startTime = System.currentTimeMillis();
//			susUsersTree = step3.hashMapToBinaryTree(userList, userIdToNumSusReviews);
//			endMem = calculateMemoryUsage();
//			endTime = System.currentTimeMillis();
//			System.out.println("Step 3 - HashMap to BinaryTree:");
//			printInfo(startMem, endMem, startTime, endTime);
//			
//			System.out.println(susUsersTree.size());
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void printInfo(long startMem, long endMem, long startTime, long endTime) {
		System.out.println("Memory Usage: " + (double)(endMem - startMem)/1000 + " KB");
		System.out.println("Time Taken: " + (endTime - startTime) + "ms");
	}
	
	private static long calculateMemoryUsage() {
		Runtime rt = Runtime.getRuntime();
		// run garbage collection
		rt.gc();
		return rt.totalMemory() - rt.freeMemory();
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


	@SuppressWarnings("unchecked")
	private static List<Review> loadReviewFromJson() throws IOException, ParseException{
		
		String filePath = properties.getProperty("rootDir") + "/" + properties.getProperty("reviewDataset");
		File file = new File(filePath);
		
//		String rawContent = FileUtils.readFileToString(file, "UTF-8");
//		JSONArray jsonArray = (JSONArray)parser.parse("[" + rawContent + "]");
		
		Iterator<Object> iter = FileUtils.lineIterator(file);
		
		List<Review> reviewList = new LinkedList<>();
		
		int i = 0;
		
		
		while(iter.hasNext()) {
			
			Object o = iter.next();
			String s = (String) o;
			
			JSONObject jso = (JSONObject)parser.parse(s);
			Review r = jsonToReview(jso);
			
			if(r != null) {
				reviewList.add(r);
				i++;
				if(i == 10000) break;
			}
			
		}
		
		return reviewList;
		
	}
	
	private static Review jsonToReview(JSONObject o) {
		Review r = new Review();
		r.setBusinessId((String) o.get("business_id"));
		r.setReviewId((String) o.get("review_id"));
		Object obj = o.get("stars");
		if(Objects.isNull(obj)) return null;
		r.setStars((double) obj);
		r.setText((String) o.get("text"));
		r.setUserId((String) o.get("user_id"));
		
		if(isSus(r)) return null;
		
		return r;
	}


	private static List<User> loadUserFromJson() throws ParseException, IOException{
		String filePath = properties.getProperty("rootDir") + "/" + properties.getProperty("userDataset");
		File file = new File(filePath);

		Iterator<Object> iter = FileUtils.lineIterator(file);
		
		List<User> userList = new LinkedList<>();
		
		int i = 0;
		
		// String rawContent = FileUtils.readFileToString(file, "UTF-8");
		// JSONArray jsonArray = (JSONArray)parser.parse("[" + rawContent + "]");


		while(iter.hasNext()) {
			
			Object o = iter.next();
			String s = (String) o;
			
			JSONObject jso = (JSONObject)parser.parse(s);
			User u = jsonToUser(jso);
			
			if(u != null) {
				userList.add(u);
				i++;
				if(i == 50000) break;
			}
			
		}
		
		return userList;
	}


	private static User jsonToUser(JSONObject o) {
		User u = new User();
		u.setAverageStars((double) o.get("average_stars"));
		u.setFriends(((String) o.get("friends")).split(","));
		u.setName((String) o.get("name"));
		u.setReviewCount((long) o.get("review_count"));
		u.setUserId((String) o.get("user_id"));
		if (isFriendless(u)) return null;
		return u;
	}
	
	public static boolean isSus(Review review) {
        int reviewLength = review.getText().length();
        double reviewStars = review.getStars();
        if (reviewLength <= 4 && reviewStars == 1) {
            return true;
        }
        return false;
    }
	// <=10 friends
	public static boolean isFriendless(User user){
		return user.getFriends().length<=10;
	}

	
}
