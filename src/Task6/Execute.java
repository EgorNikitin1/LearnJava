package Task6;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Execute {

    public static void main(String[] args) throws IOException {

        String filename = "src/Task6/Var9.txt";

        List<Multicooker> listMulticooker = readFileStream(filename);

        System.out.println("Данные из файла:");
        listMulticooker.forEach(System.out::println);
        System.out.println();

        System.out.println("Сортировка по наименованию:");
        listMulticooker.stream().sorted(Comparator.comparing(Multicooker::getName)).forEach(System.out::println);
        System.out.println();

        System.out.println("Сортировка по цене:");
        listMulticooker.stream().sorted(Comparator.comparingInt(Multicooker::getPrice).reversed()).forEach(System.out::println);
        System.out.println();

        System.out.println("Мултиварка с наивысшим рейтингом:");
        Multicooker maxByScore = listMulticooker.stream()
                .sorted(Comparator.comparingInt(Multicooker::getPrice))
                .max(Comparator.comparingDouble(Multicooker::getScore)).get();
        System.out.println(maxByScore);
        System.out.println();

        System.out.println("Коллекция мультиварок белого и серебристого цветов:");
        List<Multicooker> listColours = listMulticooker.stream()
                .filter(mc -> Objects.equals(mc.getColour(), "серебристый") || Objects.equals(mc.getColour(), "белый"))
                .toList();
        listColours.forEach(System.out::println);
        System.out.println();

        System.out.println("Средняя оценка покупателей:");
        OptionalDouble avgScore = listMulticooker.stream()
                .mapToDouble(Multicooker::getScore)
                .average();
        System.out.printf("%.2f", avgScore.getAsDouble());
        System.out.println();
        System.out.println();

        System.out.println("Количество мультиварок бренда Polaris с оценкой покупателей 4.8 и более:");
        long count = listMulticooker.stream()
                .filter(mc -> Objects.equals(mc.getBrand(), "Polaris"))
                .filter(mc -> mc.getScore() >= 4.8)
                .count();
        System.out.println(count);
        System.out.println();

        System.out.println("У всех ли мультиварок оценка покупателей больше 4,5?:");
        boolean question1 = listMulticooker.stream()
                .allMatch(mc -> mc.getScore() > 4.5);
        System.out.println(question1);
        System.out.println();

        System.out.println("Есть ли мультиварка стоимостью более 10 тыс. руб?:");
        boolean question2 = listMulticooker.stream()
                .anyMatch(mc -> mc.getPrice() > 10000);
        System.out.println(question2);
        System.out.println();

        System.out.println("Разделение мультиварок на две коллекции:");
        System.out.println("Мльтиварки с высоким рейтингом:");
        List<Multicooker> listHighScore = listMulticooker.stream()
                .filter(mc -> mc.getScore() >= 4.5)
                .toList();
        listHighScore.forEach(System.out::println);
        System.out.println("Мльтиварки с низким рейтингом:");
        List<Multicooker> listLowScore = listMulticooker.stream()
                .filter(mc -> mc.getScore() < 4.5)
                .toList();
        listLowScore.forEach(System.out::println);
        System.out.println();

        System.out.println("Группировка мультиварок по бренду:");
        Map<String, List<Multicooker>> grouped = listMulticooker.stream()
                .collect(groupingBy(Multicooker::getBrand));
        grouped.forEach((key, value) -> System.out.println(key + ":" + value));
        System.out.println();

        System.out.println("Формирование строки:");
        String string = listMulticooker.stream()
                .filter(mc -> Objects.equals(mc.getBrand(), "Scarlett"))
                .map(Multicooker::getName)
                .collect(joining(", ", "«Модели мультиварок бренда Scarlett:", ".»"));
        System.out.println(string);

    }

    public static ArrayList<Multicooker> readFileStream(String filename) throws IOException {
        File file = new File(filename);
        ArrayList<Multicooker> list = new ArrayList<>();
        try (Stream<String> linesStream = Files.lines(file.toPath()).skip(1)) {
            linesStream.forEach(line -> {
                String[] values = line.split(";");
                list.add(new Multicooker(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        Integer.parseInt(values[4]),
                        Float.parseFloat(values[5])));
            });
        }
        return list;
    }
}
