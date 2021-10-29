import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import entity.Business;


public class Step1 {
    public ArrayList<Business> filterRestaurantsArrayList(List<Business> businessList) {
        ArrayList<Business> restaurantList = new ArrayList<Business>();

        for (Business b : businessList) {
            if (Objects.nonNull(b.getCategories()) && b.getCategories().contains("Restaurant")) {
                restaurantList.add(b);
            }    
        }

        return restaurantList;
    }

    public SinglyLinkedList<Business> filterRestaurantsSinglyLinkedList(List<Business> businessList) {
        SinglyLinkedList<Business> restaurantSll = new SinglyLinkedList<Business>();

        for (Business b : businessList) {
            if (Objects.nonNull(b.getCategories()) && b.getCategories().contains("Restaurant")) {
                restaurantSll.addLast(b);
            }    
        }

        return restaurantSll;
    }

    public LinkedBinaryTree<Business> filterRestaurantsLinkedBinaryTree(List<Business> businessList) {
        LinkedBinaryTree<Business> restaurantLbt = new LinkedBinaryTree<Business>();

        // Node<Integer> root = (Node<Integer>) restaurantLbt.addRoot(0);
        // btree.addLeft(root, -4);
        // btree.addRight(root, 4);
        // btree.addLeft(root.getLeft(), -6);
        // btree.addRight(root.getLeft(), -2);
        // btree.addLeft(root.getRight(), 2);
        // btree.addRight(root.getRight(), 6);

        return restaurantLbt;
    }
}
