import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import entity.User;

public class step3test {
    public static void main(String[] args) {
        Step3 step3 = new Step3();
        // Creating test data to use
        String[] u1Friends = new String[] { "wqoXYLWmpkEH0YvTmHBsJQ", "KUXLLiJGrjtSsapmxmpvTA",
                "6e9rJKQC3n0RSKyHLViL-Q" };
        String[] u3Friends = new String[] { "wqoXYLWmpkEH0YvTmHBsJQ", "KUXLLiJGrjtSsapmxmpvTA",
                "6e9rJKQC3n0RSKyHLViL-Q", "123", "123", "123", "123", "123", "123", "123", "123" };

        List<User> userList = new LinkedList<>();
        User u1 = new User("Ha3iJu77CxlrFm-vQRs_8g", "Sebastien", 56, u1Friends, 4.31);
        User u2 = new User("gfdsgdgdfgfg", "Jeen", 45, u1Friends, 3.5);
        User u3 = new User("asdasdasd", "ethan", 25, u3Friends, 2.0);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);

        // ARRAYLIST: Assume fake number of reviews from step 2
        ArrayList<String> fakeReviewsArrayList = new ArrayList<>();
        fakeReviewsArrayList.add(u1.getUserId()); // fake reviewer >= 0.9 (0.98)
        fakeReviewsArrayList.add("55");
        fakeReviewsArrayList.add(u3.getUserId()); // good reviewser <= 0.9 (0.8)
        fakeReviewsArrayList.add("20");

        // TEST:
        // ArrayListToSinglyLinkedList
        SinglyLinkedList<User> al2sll = step3.arrayListToSinglyLinkedList(userList, fakeReviewsArrayList);
        System.out.println("ArrayList to Singly Linked List");
        System.out.println(al2sll.toString());

        // HASHMAP: Assume fake number of reviews from step 2
        Map<String, Integer> fakeReviewsHashMap = new HashMap<>();
        fakeReviewsHashMap.put(u1.getUserId(), 55); // fake reviewer >= 0.9 (0.98)
        fakeReviewsHashMap.put(u3.getUserId(), 20); // good reviewser <= 0.9 (0.8)

        // HashMapToSinglyLinkedList
        SinglyLinkedList<User> hm2sll = step3.hashMapToSinglyLinkedList(userList, fakeReviewsHashMap);
        System.out.println("HashMap to Singly Linked List: ");
        System.out.println(hm2sll.toString());

        // ArrayListToBinaryTree - Data taken from fakeReviewsArrayList
        TreeSet<User> al2bt = step3.arrayListToBinaryTree(userList, fakeReviewsArrayList);
        System.out.println("Array List to Binary Tree: ");
        System.out.println(al2bt.toString());

        // HashMapToBinaryTree - Data taken from fakeReviewsHashMap
        TreeSet<User> hm2bt = step3.hashMapToBinaryTree(userList, fakeReviewsHashMap);
        System.out.println("Hash Map to Binary Tree: ");
        System.out.println(hm2bt.toString());
    }
}
