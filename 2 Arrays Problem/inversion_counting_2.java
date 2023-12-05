import java.util.*;

public class inversion_counting_2 {
    public static long count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numInstances = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numInstances; i++) {
            ArrayList<Integer> qLine = new ArrayList<>();
            ArrayList<Integer> pLine = new ArrayList<>();
            int arraySize = scanner.nextInt();

            for (int j = 0; j < arraySize * 2; j++) {
                if (j < arraySize) {
                    qLine.add(scanner.nextInt());
                } else {
                    pLine.add(scanner.nextInt());
                }
            }

            if (i < numInstances - 1) {
                scanner.nextLine();
            }

            HashMap<Integer, Integer> qMap = new HashMap<>();
            for (int x = 0; x < qLine.size(); x++) {
                qMap.put(qLine.get(x), x);
            }
            qLine = (ArrayList<Integer>) mergesort(qLine.size(), qLine);

            ArrayList<Integer> newPLine = new ArrayList<>();
            for (int x = 0; x < qMap.size(); x++) {
                newPLine.add(pLine.get(qMap.get(qLine.get(x))));
            }

            pLine = newPLine;

            count = 0;
            mergesort(pLine.size(), pLine);
            System.out.println(count);
            count = 0;
        }
        scanner.close();
    }

    public static List<Integer> mergesort(int lengthArr, List<Integer> pLine) {
        if (lengthArr == 1) {
            return pLine;
        }

        int midPos = lengthArr / 2;

        List<Integer> firstHalf = pLine.subList(0, midPos);
        List<Integer> secondHalf = pLine.subList(midPos, lengthArr);

        List<Integer> partOne = mergesort(midPos, firstHalf);
        List<Integer> partTwo = mergesort(lengthArr - midPos, secondHalf);

        List<Integer> combined = countInversions(partOne, partTwo);

        return combined;
    }

    public static List<Integer> countInversions(List<Integer> qLine, List<Integer> pLine) {
        int x = 0;
        int y = 0;
        List<Integer> totalList = new ArrayList<>();

        while ((x < qLine.size()) && (y < pLine.size())) {
            if (pLine.get(y) < qLine.get(x)) {
                totalList.add(pLine.get(y));
                count += qLine.size() - x;
                y += 1;
            } else {
                totalList.add(qLine.get(x));
                x += 1;
            }
        }

        if (x == qLine.size()) {
            totalList.addAll(pLine.subList(y, pLine.size()));
        } else if (y == pLine.size()) {
            totalList.addAll(qLine.subList(x, qLine.size()));
        }

        return totalList;
    }
}