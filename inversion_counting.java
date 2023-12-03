
import java.util.*;

public class inversion_counting {
    public static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInstances = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numInstances; i++) {
            count = 0;
            ArrayList<Integer> pages = new ArrayList<>();
            int arraySize = scanner.nextInt();

            for (int j = 0; j < arraySize; j++) {
                pages.add(scanner.nextInt());
            }

            mergesort(pages);
            System.out.println(count);
            count = 0;

            if (i < numInstances - 1) {
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public static ArrayList<Integer> mergesort(ArrayList<Integer> inputArray) {
        if (inputArray.size() == 1) {
            return inputArray;
        }
        ArrayList<Integer> partOne = new ArrayList<>();
        ArrayList<Integer> partTwo = new ArrayList<>();

        for (int i = 0; i < inputArray.size(); i++) {
            if (i < inputArray.size() / 2) {
                partOne.add(inputArray.get(i));
            } else {
                partTwo.add(inputArray.get(i));
            }
        }

        partOne = mergesort(partOne);
        partTwo = mergesort(partTwo);

        return merge(partOne, partTwo);

    }

    public static ArrayList<Integer> merge(ArrayList<Integer> partOne, ArrayList<Integer> partTwo) {
        ArrayList<Integer> sorted = new ArrayList<>();
        while (!(partOne.isEmpty()) || !(partTwo.isEmpty())) {
            if (partOne.size() == 0) {
                sorted.add(partTwo.get(0));
                partTwo.remove(0);
            } else if (partTwo.size() == 0) {
                sorted.add(partOne.get(0));
                partOne.remove(0);
            } else if (partOne.get(0) <= partTwo.get(0)) {
                sorted.add(partOne.get(0));
                partOne.remove(0);
            } else {
                count += partOne.size();
                sorted.add(partTwo.get(0));
                partTwo.remove(0);
            }
        }
        return sorted;
    }
}