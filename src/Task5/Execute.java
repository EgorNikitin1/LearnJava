package Task5;

import java.io.*;
import java.util.*;

public class Execute {
    public static void main(String[] args) throws IOException {

        String readFile = "src/Task5/5-9.txt.txt";
        String writeFile = "src/Task5/result.txt";

        ArrayList<Patent> listPatent = readFile(readFile);

        writeToFile(writeFile, listPatent);

    }

    public static ArrayList<Patent> readFile(String filename) {
        ArrayList<Patent> list = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line = null;
            while((line = in.readLine()) != null) {
                String[] values = line.split(", ");
                list.add(new Patent(
                        values[0],
                        Integer.parseInt(values[1]),
                        new ArrayList<>(List.of(Arrays.copyOfRange(values, 2, values.length)))));
            }
            for (Patent item: list) {
                System.out.println(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Patent getLastPatent(ArrayList<Patent> list) {
        int maxYear = 0;
        Patent maxYearPatent = null;
        for (Patent item: list) {
            if (item.getRegYear() > maxYear) {
                maxYear = item.getRegYear();
                maxYearPatent = item;
            }
        }
        return maxYearPatent;
    }

    public static ArrayList<Patent> getPatents(ArrayList<Patent> list) {
        Iterator<Patent> iterator = list.iterator();
        ArrayList<Patent> result = new ArrayList<>();
        while (iterator.hasNext()) {
            Patent item = iterator.next();
            if (item.getInventors().size() >= 2) {
                result.add(item);
            }
        }
        return result;
    }

    public static String getInventor(ArrayList<Patent> list) {
        Map<String, Integer> inventor1 = new HashMap<>();
        int value;
        for (Patent patent : list) {
            ArrayList<String> inventor2 = patent.getInventors();
            for (String s : inventor2) {
                if (!inventor1.containsKey(s)) {
                    inventor1.put(s, 1);
                } else {
                    value = inventor1.get(s) + 1;
                    inventor1.put(s, value);
                }
            }
        }
        return Collections.max(inventor1.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static Set<String> getCoInventor(ArrayList<Patent> list, String inventor) {
        Set<String> set = new HashSet<>();
        for (Patent item: list) {
            for (String coinventor: item.getInventors()) {
                if (inventor.equalsIgnoreCase(coinventor)) {
                    set.addAll(item.getInventors());
                }
            }
        }
        set.remove(inventor);
        return set;
    }

    public static void writeToFile(String filename, ArrayList<Patent> listPatent) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        printWriter.printf("Самый новый патент:\n");
        printWriter.printf(getLastPatent(listPatent).toString());

        printWriter.printf("\n\nПатенты с двумя и более изобретателями:\n");
        ArrayList<Patent> list = getPatents(listPatent);
        for (Patent item: list) {
            printWriter.printf(item.toString());
            printWriter.printf("\n");
        }

        printWriter.printf("\n\nИзобретатель с наибольшим количестом патентов:\n");
        String inventor = getInventor(listPatent);
        printWriter.printf(inventor);

        printWriter.printf("\n\nСоавторы изобретателя:\n");
        printWriter.printf(getCoInventor(listPatent, inventor).toString());
        printWriter.close();
    }
}
