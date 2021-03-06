package src.app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import src.dataStructures.SinglyLinkedList;
import src.entity.User;

/*
* Step 3:
* - identify suspicious reviewers
* - Return: SLL, BT
* - Arge: accept Object + List<User>
* 
* filename to user.json declared in step2 
*/

public class Step3 {

    public SinglyLinkedList<User> arrayListToSinglyLinkedList(List<User> userList, ArrayList<String> fakeReviews) {
        SinglyLinkedList<User> toReturn = new SinglyLinkedList<>();

        for (int i = 0; i < fakeReviews.size(); i += 2) {
            // [i] = userid, [i+1] = fakeReviewCount
            for (User user : userList) {
                if (user.getUserId().equals(fakeReviews.get(i))
                        && (Double.parseDouble(fakeReviews.get(i + 1)) / (double) user.getReviewCount()) >= 0.9
                        ) {
                    toReturn.addLast(user); 
                    break;
                }
            }
        }
        return toReturn;
    }

    public SinglyLinkedList<User> hashMapToSinglyLinkedList(List<User> userList, Map<String, Integer> fakeReviews) {
        // Singly Linked list to add all sus users
        SinglyLinkedList<User> toReturn = new SinglyLinkedList<>();
        for (User user : userList) {

            // skip over user if he does not have any fake reviews
            if (fakeReviews.get(user.getUserId()) == null) {
                continue;
            }

            // reviewer is sus, cause 90%+ reviews were sus and <= 10 friends
            if (((double) fakeReviews.get(user.getUserId()) / (double) user.getReviewCount()) >= 0.9
                   ) {
                // add user to singlylinkedlist (if empty it adds the user as a head)
                toReturn.addLast(user);
            }
        }
        return toReturn;
    }

    public TreeSet<User> arrayListToBinaryTree(List<User> userList, ArrayList<String> fakeReviews) {
        TreeSet<User> toReturn = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getUserId().compareTo(u2.getUserId());
            }
        });

        for (int i = 0; i < fakeReviews.size(); i += 2) {
            // [i] = userid, [i+1] = fakeReviewCount
            for (User user : userList) {
                if (user.getUserId().equals(fakeReviews.get(i))
                        && (Double.parseDouble(fakeReviews.get(i + 1)) / (double) user.getReviewCount()) >= 0.9
                       ) {
                    toReturn.add(user);
                    break;
                }
            }
        }

        return toReturn;
    }

    public TreeSet<User> hashMapToBinaryTree(List<User> userList, Map<String, Integer> fakeReviews) {
        TreeSet<User> toReturn = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getUserId().compareTo(u2.getUserId());
            }
        });

        for (User user : userList) {
            // skip over user if he does not have any fake reviews
            if (fakeReviews.get(user.getUserId()) == null) {
                continue;
            }

            // reviewer is sus, cause 90%+ reviews were sus and <= 10 friends
            if (((double) fakeReviews.get(user.getUserId()) / (double) user.getReviewCount()) >= 0.9) {
                // add user to BinaryTree (if empty it adds the user as root)
                toReturn.add(user);
            }
        }
        return toReturn;
    }

}
