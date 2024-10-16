package labTwo;
// Імпорт пакету з класом Car
import labTwoClasses.Car;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.*;

public class labTwoMain {
    
    /**
     * Виводить інформацію про машини з масиву.
     * 
     * @param array Масив об'єктів Car
     */
    public static void outputArrayData(Car[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i].outputCarData();
        }
    }
    
    /**
     * Виводить машини, що підпадають під введену модель, і повертає список їх ідентифікаторів.
     * 
     * @param array Масив об'єктів Car
     * @param enteredModel Введена модель для пошуку
     * @return Список ідентифікаторів машин, що відповідають моделі
     */
    public static ArrayList<Integer> outputTaskOne(Car[] array, String enteredModel) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> returnArray = new ArrayList<>();
        
        System.out.println("Машини, що підпадають введеній моделі (" + enteredModel + "): ");
        for(int i = 0; i < array.length; i++) {
            if(array[i].getModel().equals(enteredModel)) {
                array[i].outputCarData();
                returnArray.add(array[i].getId());    
            }
        }
        
        return returnArray;
    }
    
    /**
     * Виводить машини, що експлуатуються більше ніж вказана кількість років.
     * 
     * @param array Масив об'єктів Car
     * @param returnedArray Список ідентифікаторів машин для перевірки
     */
    public static void outputTaskTwo(Car[] array, ArrayList<Integer> returnedArray) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть кількість років, щоб побачити машини що експлуатуються більше років ніж введене число: ");
        int enteredYear = Integer.valueOf(scanner.nextLine());
        System.out.println("Машини що відпадають введеному мінімальному експлуатаційному віку: ");
        for(int i = 0; i < array.length; i++) {
        	for(int j = 0; j < returnedArray.size(); j ++) {
                if( (2024 - enteredYear) >= array[i].getManufactureYear() && array[i].getId() == returnedArray.get(j)) {
                    array[i].outputCarData();
                }
        	}
        }
    }
    
    /**
     * Виводить машини, що відповідають заданому року випуску і перевищують вказану ціну.
     * 
     * @param array Масив об'єктів Car
     */
    public static void outputTaskThree(Car[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть рік випуску машини: ");
        int enteredYear = Integer.valueOf(scanner.nextLine());
        System.out.print("Введіть ціну для пошуку: ");
        int enteredPrice = Integer.valueOf(scanner.nextLine());
        
        for(int i = 0; i < array.length; i ++) {
            if(array[i].getManufactureYear() == enteredYear && array[i].getPrice() > enteredPrice ) {
                array[i].outputCarData();
            }
        }
    }
    
    /**
     * Основний метод програми для введення даних і виконання завдань.
     * 
     * @param args Аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створення об'єкту сканер
        Scanner scanner = new Scanner(System.in);
        // Визначення кількості об'єктів в масиві об'єктів класу Car
        System.out.print("Введіть кількість об'єктів в масиві: ");
        int N = Integer.valueOf(scanner.nextLine());
        // Ініціалізація масиву об'єктів класу Car
        Car[] array = new Car[N];
        
        // Ініціалізація об'єктів масиву, введення даних користувачем
        int j = 1;
        for (int i = 0; i < N; i++) {
            System.out.println("Введіть дані для " + j + "-ї машини.");
            System.out.print("Введіть марку машини: ");
            String enteredModel = scanner.nextLine();
            System.out.print("Введіть рік випуску машини: ");
            int enteredManufactureYear = Integer.valueOf(scanner.nextLine());
            System.out.print("Введіть ціну машини (в доларах): ");
            int enteredPrice = Integer.valueOf(scanner.nextLine());
            System.out.print("Введіть реєстраційний номер машини: ");
            int enteredRegistrationNumber = Integer.valueOf(scanner.nextLine());
            System.out.println("");
            
            array[i] = new Car(i+1, enteredModel, enteredManufactureYear, enteredPrice, enteredRegistrationNumber);
            j++;
        }
        
        System.out.print("Введіть модель машини: ");
        String enteredModel = scanner.nextLine();
        
        outputArrayData(array);
        outputTaskTwo(array, outputTaskOne(array, enteredModel));
        outputTaskThree(array);
    }
}
