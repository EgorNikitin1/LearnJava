package Task7;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс "Склад"
 */
public class Warehouse implements Observer {
    Map<String, Integer> quantity = new HashMap<>();
    Subject accounting;

    public Warehouse(Subject accounting){
        this.accounting = accounting;
        quantity.put("стол", 10);
        quantity.put("шкаф", 5);
        quantity.put("кресло", 5);
        quantity.put("кухня", 2);
        quantity.put("диван", 3);
        quantity.put("кровать", 2);
        accounting.registerObserver(this);
    }

    public void update(int income, String item){                    //обрабаьывает запрос на покупку
        int prevValue = quantity.get(item);
        System.out.println(item);
        if (prevValue == 0) {
            System.out.println("Товара \"" + item + "\" нет на складе.");
        } else {
            System.out.println("Спасибо за покупку!");
            quantity.put(item, --prevValue);
        }
    }
    public void printWarehouse(){                      //распечатывает список товаров на складе
        for (var pr: quantity.entrySet()) {
            System.out.println(pr + " шт.");
        }
    }
}
