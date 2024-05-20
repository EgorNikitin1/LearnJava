package Task7;

import java.util.*;
/**
 * Класс "Магазин" осуществляет продажу мебели и уведомляет бухгалтерию и склад о новой покупке
 */
public class Shop {

    public static void main(String[] args){
        System.out.println("Добро пожаловать в магазин мебели! В наличии столы, диваны, шкафы, кухни, кресла и многое другое!");
        System.out.println("Если Вы хотите совершить покупку, введите название мебели!");
        System.out.println("Для вывода в консоль текущей выручки введите \"income\",\" \"  и пароль администратора");
        System.out.println("Для просмотра количества товара на складе введите \"товары\"");
        System.out.println("Для завершения работы введите \"break\"");

        Update update = new Update();

        Accounting acc = Accounting.getInstance(update);
        Warehouse wh = new Warehouse(update);
        DeliveryService ds = new DeliveryService(update);
        String item;

        Map <String, Integer> price = new HashMap<>(); //ценник
        price.put("стол", 10000);
        price.put("шкаф", 50000);
        price.put("кресло", 7500);
        price.put("кухня", 150000);
        price.put("диван", 35000);
        price.put("кровать", 25000);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            item = scanner.nextLine();
            if (item.equals("break")){
                break;
            } else if (item.equals("товары")) {wh.printWarehouse();}
            else {
                if (item.contains("income ")) {
                    acc.getIncome(item.substring(item.indexOf(" ") + 1));
                } else {
                    if (price.containsKey(item)) {
                        try {
                            update.updateItem(item);
                            update.updateIncome(price.get(item));
                        } catch (Exception ignored) {
                            System.out.println("Товар \"" + item + "\" закончился.");
                        }
                    } else {System.out.println("Товара \"" + item + "\" нет на складе.");}
                }
            }
        }
    }
}
