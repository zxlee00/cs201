package src.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

import src.dataStructures.SinglyLinkedList;

import java.util.List;

import src.entity.Business;
import src.entity.Review;

/*
* - identify suspicious reviews
* - Return: HashMap / ArrayList
* - Args: List<Reviews> + (List, LL or BT)
* 
*/
// return userID linked to numOfSusReviews
public class Step2 {

    // Returns Map<String userID, Integer numOfSusReviews>
    public Map<String, Integer> ArrayListToHashMap(List<Review> reviewsList, ArrayList<Business> businessList) {

        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }
                String userID = review.getUserId();
                if (toReturn.containsKey(userID)) {
                    Integer x = toReturn.get(userID);
                    toReturn.put(userID, x + 1);
                } else {
                    toReturn.put(userID, 1);
                }
            }
        }
        return toReturn;
    }

    // Returns ArrayList<String>
    public ArrayList<String> ArrayListToArrayList(List<Review> reviewsList, ArrayList<Business> businessList) {

        ArrayList<String> toReturn = new ArrayList<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }
                    
                // check if already contains
                boolean contains = false;
                for (int i = 0; i < toReturn.size(); i+=2) {
                    if (toReturn.get(i).equals(review.getUserId())) {
                        int oldValue = Integer.parseInt(toReturn.get(i+1));
                        toReturn.set(i+1, Integer.toString(oldValue+1));
                        contains = true;
                    }
                }
                if(!contains) {
                    toReturn.add(review.getUserId());
                    toReturn.add("1");
                }
                
            }
        }
        return toReturn;
    }
    
    public Map<String, Integer> LinkedListToHashMap(List<Review> reviewsList, SinglyLinkedList<Business> businessList) {
        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            SinglyLinkedList.Node<Business> current = businessList.getHead();
            while(current != null) {
                // if review not in businessList, skip
                if (!(current.getElement().getBusinessId().equals(review.getBusinessId()))) {
                    current = current.getNext();
                    continue;
                }
                // if review is sus, add it to the map

                String userID = review.getUserId();
                if (toReturn.containsKey(userID)) {
                    Integer x = toReturn.get(userID);
                    toReturn.put(userID, x + 1);
                } else {
                    toReturn.put(userID, 1);
                }
                current = current.getNext();
            }
        }
        return toReturn;
    }
    
    public ArrayList<String> LinkedListToArrayList(List<Review> reviewsList, SinglyLinkedList<Business> businessList) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (Review review : reviewsList) {
            SinglyLinkedList.Node<Business> current = businessList.getHead();
            while(current != null) {
                // if review not in businessList, skip
                if (!(current.getElement().getBusinessId().equals(review.getBusinessId()))) {
                    current = current.getNext();
                    continue;
                }
                    
                // check if already contains
                boolean contains = false;
                for (int i = 0; i < toReturn.size(); i+=2) {
                    if (toReturn.get(i).equals(review.getUserId())) {
                        int oldValue = Integer.parseInt(toReturn.get(i+1));
                        toReturn.set(i+1, Integer.toString(oldValue+1));
                        contains = true;
                    }
                }
                if(!contains) {
                    toReturn.add(review.getUserId());
                    toReturn.add("1");
                }
                current = current.getNext();
            }
        }
        return toReturn;
    }
    
    public ArrayList<String> binaryTreeToArrayList(List<Review> reviewsList, TreeSet<Business> businessList) {
        ArrayList<String> toReturn = new ArrayList<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }
                    
                // check if already contains
                boolean contains = false;
                for (int i = 0; i < toReturn.size(); i+=2) {
                    if (toReturn.get(i).equals(review.getUserId())) {
                        int oldValue = Integer.parseInt(toReturn.get(i+1));
                        toReturn.set(i+1, Integer.toString(oldValue+1));
                        contains = true;
                    }
                }
                if(!contains) {
                    toReturn.add(review.getUserId());
                    toReturn.add("1");
                }
               
            }
        }
        return toReturn;
    }

    public Map<String, Integer> BinaryTreeToHashMap(List<Review> reviewsList, TreeSet<Business> businessList) {
        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }
                String userID = review.getUserId();
                if (toReturn.containsKey(userID)) {
                    Integer x = toReturn.get(userID);
                    toReturn.put(userID, x + 1);
                } else {
                    toReturn.put(userID, 1);
                }
            }
        }
        return toReturn;
    }

    public static boolean isSus(Review review) {
        int reviewLength = review.getText().length();
        double reviewStars = review.getStars();
        if (reviewLength <= 4 && reviewStars == 1) {
            return true;
        }
        return false;
    }
}
