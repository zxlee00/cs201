package src.stepTests;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//
//import org.apache.commons.io.FileUtils;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
//
//import src.entity.Business;
//import src.app.*;
//
//public class Test {
//    public static void main(String[] args) {
//
//        // reading json file and storing all businesses
//        JSONParser parser = new JSONParser();
//
//        ArrayList<Business> businessList = new ArrayList<Business>();
//
//        try {
//            String fileContent = FileUtils.readFileToString(new File("yelp_academic_dataset_business.json"), "UTF-8");
//            String data = "[" + fileContent + "]";
//            JSONArray a = (JSONArray)parser.parse(data);
//
//            for (Object o : a) {
//                JSONObject business = (JSONObject) o;
//    
//                String businessId = (String) business.get("business_id");
//    
//                String name = (String) business.get("name");
//    
//                String categories = (String) business.get("categories");
//                // String[] categoriesList = categories.split(", ");
//    
//                // System.out.println("Categories:");
//                // for (String cat : categoriesList) {
//                //     System.out.println(cat);
//                // }
//
//                businessList.add(new Business(businessId, name, categories));
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        // filtering list of businesses to include only restaurants
//        ArrayList<Business> restaurantList = new ArrayList<Business>();
//
//        for (Business b : businessList) {
//            if (b.getCategories() != null && b.getCategories().contains("Restaurant")) {
//                restaurantList.add(b);
//            }    
//        }
//
//        // print list of restaurants
//        for (int i = 0; i < restaurantList.size(); i++) {
//            System.out.println(restaurantList.get(i).toString());
//        }
//
//        // singly linkedlist
//        SinglyLinkedList<Business> restaurantSll = new SinglyLinkedList<Business>();
//        for (Business b : businessList) {
//            if (b.getCategories() != null && b.getCategories().contains("Restaurant")) {
//                restaurantSll.addLast(b);
//            }    
//        }
//
//        // print business and restuarant count
//        System.out.println("Business Count: " + businessList.size());
//        System.out.println("Restaurant Count: " + restaurantList.size());
//        System.out.println("Restaurant Count: " + restaurantSll.size());
//    }
//}
