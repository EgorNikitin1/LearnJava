package Task2;

public record DogRecord(String name, int age, DogOwner dogOwner) implements Comparable<DogRecord> {
    public DogRecord {
        if (age < 0) {
            throw new IllegalArgumentException("Собака с отрицательным возрастом!");
        }
    }
//    public DogRecord(String name, int age, DogOwner dogOwner) {
//        this.name = name;
//        this.age = age;
//        this.dogOwner = dogOwner;
//    }

    @Override
    public int compareTo(DogRecord dog) {
        int result = name.compareToIgnoreCase(dog.name);
        if(result == 0) {
            return Integer.valueOf(age).compareTo(dog.age);
        }
        else {
            return result;
        }
    }
}
