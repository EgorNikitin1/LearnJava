package Task2;

public class Dog implements Comparable<Dog> {
    private String name;
    private Integer age;
    private DogOwner dogOwner;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public DogOwner getDogOwner() {
        return dogOwner;
    }

    public Dog(String name, int age, DogOwner dogOwner) {
        this.name = name;
        this.age = age;
        this.dogOwner = dogOwner;
    }

    @Override
    public int compareTo(Dog dog) {
        int result = name.compareToIgnoreCase(dog.name);
        if(result == 0) {
            return Integer.valueOf(age).compareTo(dog.age);
        }
        else {
            return result;
        }
    }
    @Override
    public String toString() {
        return "Dog{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
