package labOne;

import java.util.Scanner;

/**
 * Основний клас програми для генерації і перевірки чисел Люка.
 */
public class LucasNumberVariant14 {

    /**
     * Основний метод програми.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть кількість чисел Люка: ");
        int n = Integer.valueOf(scanner.nextLine());

        LucasNumber a = new LucasNumber(n);
        a.fillLucasNumber_list();
        a.validationTest();
    }
}
