package Task5;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Patent {
    private String patNumber;
    private int regYear;
    private ArrayList<String> inventors;

    public Patent(String patNumber, int regYear, ArrayList<String> inventors) {
        this.patNumber = patNumber;
        this.regYear = regYear;
        this.inventors = inventors;
    }

    @Override
    public String toString() {
        return "Patent{" +
                "patNumber='" + patNumber + '\'' +
                ", regYear=" + regYear +
                ", inventors=" + inventors +
                '}';
    }
}
