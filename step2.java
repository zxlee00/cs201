import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import LinkedBinaryTree.Node;
import entity.Business;
import entity.Review;

/*
* - identify suspicious reviews
* - Return: HashMap / ArrayList
* - Args: List<Reviews> + (List, LL or BT)
* 
*/
public class step2 {
    // Returns Map<userID, numOfSusReviews>
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
                    if (toReturn.contains(review)) {
                        Integer x = toReturn.get(review);
                        toReturn.put(review.getUserId(), x + 1);
                    } else {
                        toReturn.put(review.getUserId(), 1);
                    }
                }
            }
        }
    }

    public ArrayList<Business> ArrayListToArrayList(List<Review> reviewsList, ArrayList<Business> businessList) {

        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            for (Business business : businessList) {
                // if review not in businessList, skip
                if (!(business.getBusinessId().equals(review.getBusinessId()))) {
                    continue;
                }

                // if review is sus, add it to the map
                if (isSus(review)) {
                    if (toReturn.contains(review)) {
                        Integer x = toReturn.get(review);
                        toReturn.put(review.getUserId(), x + 1);
                    } else {
                        toReturn.put(review.getUserId(), 1);
                    }
                }
            }
        }
    }

    // Returns Map<userID, numOfSusReviews>
    public Map<String, Integer> LinkedListToHashMap(List<Review> reviewsList, LinkedList<Business> businessList) {

        Map<String, Integer> toReturn = new HashMap<>();
        for (Review review : reviewsList) {
            Node<E> current = businessList;
            while (current != null) {
                // if review not in businessList, skip
                if (!(current.getElement().getBusinessId.equals(review.getBusinessId()))) {
                    current = current.getNext();
                    continue;
                }

                // if review is sus, add it to the map
                if (isSus(review)) {
                    if (toReturn.contains(review)) {
                        Integer x = toReturn.get(review);
                        toReturn.put(review.getUserId(), x + 1);
                    } else {
                        toReturn.put(review.getUserId(), 1);
                    }
                }

                current = current.getNext();
            }
        }
    }

    

    public static boolean isSus(Review review) {
        int reviewLength = review.getText().length();
        int reviewStars = review.getStars();
        if (reviewLength <= 4 && reviewStars == 1) {
            return true;
        }
        return false;
    }
}
