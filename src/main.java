import java.io.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class main {

    public static void main(String[] args) {

        try {
            BufferedWriter writer1 = new BufferedWriter(new FileWriter("input1.txt"));
            writer1.write("1\n2\n3\n4\n5\n");
            writer1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            BufferedWriter writer2 = new BufferedWriter(new FileWriter("input2.txt"));
            writer2.write("5\n6\n7\n8\n9\n");
            writer2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("input1.txt"));
            String line;
            while ((line = reader1.readLine()) != null) {
                list1.add(Integer.parseInt(line));
            }
            reader1.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader reader2 = new BufferedReader(new FileReader("input2.txt"));
            String line;
            while ((line = reader2.readLine()) != null) {
                list2.add(Integer.parseInt(line));
            }
            reader2.close();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> mergedList = new ArrayList<>();
        mergedList.addAll(list1);
        mergedList.addAll(list2);

        try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("merged.txt"))) {
            for (int i = 0; i < mergedList.size(); i++) {
                writer3.write(mergedList.get(i).toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<Integer> commonSet = new HashSet<>(list1);
        commonSet.retainAll(list2);

        try (BufferedWriter writer4 = new BufferedWriter(new FileWriter("common.txt"))) {
            for (Integer num : commonSet) {
                writer4.write(num.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
