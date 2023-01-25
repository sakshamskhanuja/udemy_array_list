import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scans the user input.
        Scanner scanner = new Scanner(System.in);

        // Stores the user input.
        ArrayList<String> groceryList = new ArrayList<>();

        do {
            try {
                System.out.print("""
                        Available actions:
                        0 - to shutdown
                        1 - to add item(s) to list (comma delimited list)
                        2 - to remove any items (comma delimited list)
                        \nEnter a number for which action you want to do:\s""");

                int input = Integer.parseInt(scanner.nextLine());

                if (input == 0) {
                    // shutdown
                    break;
                } else if (input == 1) {
                    System.out.print("Enter items to add: ");

                    // Checks whether entered item is already on the list.
                    String item = scanner.nextLine();

                    // Stores the input item into an array.
                    String[] inputItems = item.split(",");

                    // Trimming all elements of inputItems.
                    for (int i = 0; i < inputItems.length; i++) {
                        inputItems[i] = inputItems[i].trim();
                    }

                    // Adding elements of inputItem in groceryList.
                    for (String element : inputItems) {
                        if (!groceryList.contains(element)) {
                            groceryList.add(element);
                        } else {
                            System.out.println(element + " already present in the list.");
                        }
                    }
                } else if (input == 2) {
                    System.out.print("Enter item to remove: ");

                    // Removes entered text from the list, if available.
                    groceryList.remove(scanner.nextLine());
                } else {
                    System.out.println("Wrong Choice. Try again.");
                }

                // Sorting list alphabetically.
                groceryList.sort(Comparator.naturalOrder());

                // Prints the grocery list.
                System.out.println("\nGrocery List : " + groceryList + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Enter only 0, 1 or 2.");
            }
        } while (true);
    }
}