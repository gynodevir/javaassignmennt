package javaassignment;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.*;
 class ListManager {
    private List<String> list;

    public ListManager() {
        this.list = new ArrayList<>();
    }

    public void addElement(String element) {
        list.add(element);
    }

    public void removeElement(String element) {
        if (list.contains(element)) {
            list.remove(element);
        } else {
            System.out.println("Element not found in the list.");
        }
    }

    public void displayElements() {
        System.out.println("Elements in the list:");
        for (String element : list) {
            System.out.println(element);
        }
    }
}
 class SetManager {
    private Set<String> set;

    public SetManager() {
        this.set = new HashSet<>();
    }

    public void addElement(String element) {
        set.add(element);
    }

    public void removeElement(String element) {
        if (set.contains(element)) {
            set.remove(element);
        } else {
            System.out.println("Element not found in the set.");
        }
    }

    public void displayElements() {
        System.out.println("Elements in the set:");
        for (String element : set) {
            System.out.println(element);
        }
    }
}

 class MapManager {
    private Map<Integer, String> map;

    public MapManager() {
        this.map = new HashMap<>();
    }

    public void addKeyValuePair(int key, String value) {
        if (map.containsKey(key)) {
            System.out.println("Duplicate key found. Key-value pair not added.");
        } else {
            map.put(key, value);
        }
    }

    public void removeKeyValuePair(int key) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            System.out.println("Key not found in the map.");
        }
    }

    public void displayKeyValuePairs() {
        System.out.println("Key-Value pairs in the map:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
class fifthanswer {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ListManager listManager = new ListManager();
        SetManager setManager = new SetManager();
        MapManager mapManager = new MapManager();

        int choice;
        do {
            System.out.println("\nChoose a collection to manage:");
            System.out.println("1. List");
            System.out.println("2. Set");
            System.out.println("3. Map");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageList(scanner, listManager);
                    break;
                case 2:
                    manageSet(scanner, setManager);
                    break;
                case 3:
                    manageMap(scanner, mapManager);
                    break;
                case 0:
                    System.out.println("Exiting the Collection Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void manageList(Scanner scanner, ListManager listManager) {
        int listChoice;
        do {
            System.out.println("\nList Management:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            listChoice = scanner.nextInt();

            switch (listChoice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    String addElement = scanner.next();
                    listManager.addElement(addElement);
                    break;
                case 2:
                    System.out.print("Enter the element to remove: ");
                    String removeElement = scanner.next();
                    listManager.removeElement(removeElement);
                    break;
                case 3:
                    listManager.displayElements();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (listChoice != 0);
    }

    private static void manageSet(Scanner scanner, SetManager setManager) {
        int setChoice;
        do {
            System.out.println("\nSet Management:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            setChoice = scanner.nextInt();

            switch (setChoice) {
                case 1:
                    System.out.print("Enter the element to add: ");
                    String addElement = scanner.next();
                    setManager.addElement(addElement);
                    break;
                case 2:
                    System.out.print("Enter the element to remove: ");
                    String removeElement = scanner.next();
                    setManager.removeElement(removeElement);
                    break;
                case 3:
                    setManager.displayElements();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (setChoice != 0);
    }

    private static void manageMap(Scanner scanner, MapManager mapManager) {
        int mapChoice;
        do {
            System.out.println("\nMap Management:");
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Remove a key-value pair");
            System.out.println("3. Display all key-value pairs");
            System.out.println("0. Back to main menu");
            System.out.print("Enter your choice: ");
            mapChoice = scanner.nextInt();

            switch (mapChoice) {
                case 1:
                    System.out.print("Enter the key: ");
                    int key = scanner.nextInt();
                    System.out.print("Enter the value: ");
                    String value = scanner.next();
                    mapManager.addKeyValuePair(key, value);
                    break;
                case 2:
                    System.out.print("Enter the key to remove: ");
                    int removeKey = scanner.nextInt();
                    mapManager.removeKeyValuePair(removeKey);
                    break;
                case 3:
                    mapManager.displayKeyValuePairs();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (mapChoice != 0);
    }
}
