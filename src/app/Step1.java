package src.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

import src.dataStructures.SinglyLinkedList;
import src.entity.Business;

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

    public TreeSet<Business> filterRestaurantsBinaryTree(List<Business> businessList) {
        TreeSet<Business> restaurantTreeSet = new TreeSet<Business>(new Comparator<Business>() {
            @Override
            public int compare(Business b1, Business b2) {
                return b1.getBusinessId().compareTo(b2.getBusinessId());
            }
        });

        for (Business b : businessList) {
            if (Objects.nonNull(b.getCategories()) && b.getCategories().contains("Restaurant")) {
                restaurantTreeSet.add(b);
            }
        }

        return restaurantTreeSet;
    }
}
