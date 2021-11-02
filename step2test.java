import entity.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Comparator;

public class step2test {
    public static void main(String[] args){
        // set up
        Step2 step2 = new Step2();
        ArrayList<Business> bList = new ArrayList<Business>();
        List<Review> reviewsList = new ArrayList<>();
        SinglyLinkedList<Business> linkedBList = new SinglyLinkedList<>();
        TreeSet<Business> bTreeBList = new TreeSet<Business>(new Comparator<Business>() {
            @Override
            public int compare(Business b1, Business b2) {
                return b1.getBusinessId().compareTo(b2.getBusinessId());
            }
        });

        // test
        System.out.println("a2a result: " + a2aTest(step2, bList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);

        System.out.println("a2h result: " + a2hTest(step2, bList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);

        System.out.println("l2a result: " + l2aTest(step2, linkedBList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);

        System.out.println("l2h result: " + l2hTest(step2, linkedBList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);

        System.out.println("bt2a result: " + bt2aTest(step2, bTreeBList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);

        System.out.println("bt2h result: " + bt2hTest(step2, bTreeBList, reviewsList));
        clear(bList, reviewsList, linkedBList, bTreeBList);
    }

    public static String a2aTest(Step2 step2, ArrayList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.add(b1);
        bList.add(b2);

        ArrayList<String> result = step2.ArrayListToArrayList(reviewsList, bList);
        return result.toString();
    }

    public static String a2hTest(Step2 step2, ArrayList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.add(b1);
        bList.add(b2);

        Map<String, Integer> result = step2.ArrayListToHashMap(reviewsList, bList);
        return result.toString();
    }

    public static String l2hTest(Step2 step2, SinglyLinkedList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.addFirst(b1);
        bList.addFirst(b2);

        Map<String, Integer> result = step2.LinkedListToHashMap(reviewsList, bList);
        return result.toString();
    }

    public static String l2aTest(Step2 step2, SinglyLinkedList<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.addFirst(b1);
        bList.addFirst(b2);

        ArrayList<String> result = step2.LinkedListToArrayList(reviewsList, bList);
        return result.toString();
    }

    public static String bt2aTest(Step2 step2, TreeSet<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.add(b1);
        bList.add(b2);

        ArrayList<String> result = step2.binaryTreeToArrayList(reviewsList, bList);
        return result.toString();
    }

    public static String bt2hTest(Step2 step2, TreeSet<Business> bList, List<Review> reviewsList) {
        Review r1 = new Review("rID", "uID", "bID", 1, "h");
        Review r2 = new Review("rID2", "uID", "bID", 1, "i");
        Review r3 = new Review("rID3", "uID", "bID", 1, "j");
        Review r4 = new Review("rID4", "uID2", "bID", 1, "k");
        Review r5 = new Review("rID5", "uID2", "bID2", 1, "l");
        reviewsList.add(r1);
        reviewsList.add(r2);
        reviewsList.add(r3);
        reviewsList.add(r4);
        reviewsList.add(r5);
        Business b1 = new Business("bID", "pizzhut", 1, 1, "Restaurant");
        Business b2 = new Business("bID2", "macs", 1, 1, "Restaurant");
        bList.add(b1);
        bList.add(b2);

        Map<String, Integer> result = step2.BinaryTreeToHashMap(reviewsList, bList);
        return result.toString();
    }

    // empties lists
    public static void clear(ArrayList<Business> bList, List<Review> reviewsList, SinglyLinkedList<Business> LinkedBList, 
                                TreeSet<Business> bTreeList) {
        bList.clear();
        reviewsList.clear();
        while(LinkedBList.getHead() != null) {
            LinkedBList.removeFirst();
        }
        bTreeList.clear();
    }
}
