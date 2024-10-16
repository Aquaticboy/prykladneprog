package labOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Клас для генерації чисел Люка.
 */
public class LucasNumber {
    public int a;
    public int b;
    public int N;
    public List<Integer> lucasNumber_list = new ArrayList<>();

    /**
     * Конструктор за замовчуванням. Ініціалізує перші два числа Люка.
     */
    public LucasNumber() {
        a = 2;
        b = 1;
        N = 5;
    }

    /**
     * Конструктор, який дозволяє вказати кількість чисел Люка.
     *
     * @param N1 кількість чисел Люка
     */
    public LucasNumber(int N1) {
        a = 2;
        b = 1;
        N = N1;
    }

    /**
     * Виводить значення змінних об'єкта.
     */
    public void printObjectValues() {
        System.out.println(a);
        System.out.println(b);
        System.out.println(N);
        System.out.println(lucasNumber_list);
    }

    /**
     * Заповнює список числами Люка.
     */
    public void fillLucasNumber_list() {
        this.lucasNumber_list.add(this.a);
        this.lucasNumber_list.add(this.b);

        for (int i = 0; i < this.N; i++) {
            int nextNumber = a + b;
            this.lucasNumber_list.add(nextNumber);
            a = b;
            b = nextNumber;
        }
    }

    /**
     * Перевіряє, чи можна числа Люка представити у вигляді 'w^3 - 1'.
     */
    public void validationTest() {
        double temp1, temp2;
        for (int i = 0; i < this.N; i++) {
            temp1 = this.lucasNumber_list.get(i) + 1;
            temp2 = Math.cbrt(temp1);
            if ((temp2 % 1) == 0) {
                System.out.println("Число Люка (" + this.lucasNumber_list.get(i) + ") можна записати у вигляді 'w^3 - 1'");
            } else {
                System.out.println("Число Люка (" + this.lucasNumber_list.get(i) + ") не можна записати у вигляді 'w^3 - 1'");
            }
        }
    }
}
