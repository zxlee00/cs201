import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import java.util.List;

import entity.Business;
import entity.Review;

/*
* - identify suspicious reviews
* - Return: HashMap / ArrayList
* - Args: List<Reviews> + (List, LL or BT)
* 
*/
// return userID linked to numOfSusReviews
public class step2 {

    // Returns Map<String userID, Integer numOfSusReviews>
    public Map<String, Integer> ArrayListToHashMap(List<Review> reviewsList, ArrayList<Business> businessList) {

        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }
                // if review is sus, add it to the map
                if (isSus(review)) {
                    String userID = review.getUserId();
                    if (toReturn.containsKey(userID)) {
                        Integer x = toReturn.get(userID);
                        toReturn.put(userID, x + 1);
                    } else {
                        toReturn.put(userID, 1);
                    }
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

                // if review is sus, add it to the new arraylist
                if (isSus(review)) {
                    
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
        }
        return toReturn;
    }
    
    public Map<String, Integer> LinkedListToHashMap(List<Review> reviewsList, SinglyLinkedList<Business> businessList) {

        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            Business current = businessList.first();
        }
        return toReturn;
    }

    // Returns Map<userID, numOfSusReviews>
    // public Map<String, Integer> LinkedListToHashMap(List<Review> reviewsList, LinkedList<Business> businessList) {

    //     Map<String, Integer> toReturn = new HashMap<>();
    //     for (Review review : reviewsList) {
    //         Node current = businessList;
    //         while (current != null) {
    //             // if review not in businessList, skip
    //             if (!(current.getElement().getBusinessId.equals(review.getBusinessId()))) {
    //                 current = current.getNext();
    //                 continue;
    //             }

    //             // if review is sus, add it to the map
    //             if (isSus(review)) {
    //                 String userID = review.getUserId();
    //                 if (toReturn.containsKey(userID)) {
    //                     Integer x = toReturn.get(userID);
    //                     toReturn.put(userID, x + 1);
    //                 } else {
    //                     toReturn.put(userID, 1);
    //                 }
    //             }

    //             current = current.getNext();
    //         }
    //     }
    //     return toReturn;
    // }
    
    // public ArrayList<String> LinkedListToArrayList(List<Review> reviewsList, LinkedList<Business> businessList) {

    //     ArrayList<String> toReturn = new ArrayList<>();
    //     for (Review review : reviewsList) {
    //         Node current = businessList;
    //         while (current != null) {

    //             current = current.getNext();
    //         }
    //     }
    //     return toReturn;
    // }
    public static boolean isSus(Review review) {
        int reviewLength = review.getText().length();
        int reviewStars = review.getStars();
        if (reviewLength <= 4 && reviewStars == 1) {
            return true;
        }
        return false;
    }
}
