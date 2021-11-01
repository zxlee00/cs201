import entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class step2test {
    public static void main(String[] args){
        step2 step2 = new step2();
        ArrayList<Business> bList = new ArrayList<Business>();
        List<Review> reviewsList = new ArrayList<>();
        SinglyLinkedList<Business> linkedBList = new SinglyLinkedList<>();


        System.out.println("a2a result: " + a2aTest(step2, bList, reviewsList));
        bList.clear(); reviewsList.clear();

        System.out.println("a2h result: " + a2hTest(step2, bList, reviewsList));
        bList.clear(); reviewsList.clear();

        System.out.println("l2h result: " + l2hTest(step2, linkedBList, reviewsList));
        bList.clear(); reviewsList.clear();
    }

    public static String a2aTest(step2 step2, ArrayList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        bList.add(b1);

        ArrayList<String> result = step2.ArrayListToArrayList(reviewsList, bList);
        return result.toString();
    }

    public static String a2hTest(step2 step2, ArrayList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        bList.add(b1);

        Map<String, Integer> result = step2.ArrayListToHashMap(reviewsList, bList);
        return result.toString();
    }

    public static String l2hTest(step2 step2, SinglyLinkedList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        bList.addFirst(b1);

        Map<String, Integer> result = step2.LinkedListToHashMap(reviewsList, bList);
        return result.toString();
    }
}
