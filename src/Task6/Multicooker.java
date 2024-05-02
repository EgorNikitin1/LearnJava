package Task6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Multicooker {
    private int id;
    private String name;
    private String brand;
    private String colour;
    private int price;
    private float score;

    @Override
    public String toString() {
        return "Multicooker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", price=" + price +
                ", score=" + score +
                '}';
    }
}
