package Task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class Patent {
    private String patNumber;
    private int regYear;
    private ArrayList<String> inventors;

    @Override
    public String toString() {
        return "Patent{" +
                "patNumber='" + patNumber + '\'' +
                ", regYear=" + regYear +
                ", inventors=" + inventors +
                '}';
    }
}
