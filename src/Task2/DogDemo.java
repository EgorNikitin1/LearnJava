package Task2;

import java.util.Arrays;

public class DogDemo {
    public static void main(String[] args) {

        DogOwner dogOwner1 = new DogOwner("Адольф");

        Dog dog1 = new Dog("Шпала", 3, dogOwner1);
        Dog dog2 = new Dog("Шпак", 9, dogOwner1);
        Dog dog3 = new Dog("Обака", 36, dogOwner1);

        Dog[] doges = new Dog[3];
        doges[0] = dog1;
        doges[1] = dog2;
        doges[2] = dog3;

        Arrays.sort(doges); // Comparable
        // Arrays.sort(doges, new DogesComparator()); // Comparator
        System.out.println(Arrays.toString(doges));


        DogRecord dogRecord1 = new DogRecord("Шпала", 3, dogOwner1);
        DogRecord dogRecord2 = new DogRecord("Шпак", 9, dogOwner1);
        DogRecord dogRecord3 = new DogRecord("Обака", 36, dogOwner1);

        DogRecord[] dogesRecord = new DogRecord[3];
        dogesRecord[0] = dogRecord1;
        dogesRecord[1] = dogRecord2;
        dogesRecord[2] = dogRecord3;

        // Arrays.sort(dogesRecord); // Comparable
        Arrays.sort(dogesRecord, new DogesRecordComparator()); // Comparator
        System.out.println(Arrays.toString(dogesRecord));
    }
}
