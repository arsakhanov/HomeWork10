package ru.arsakhanov;

import java.util.Scanner;

/**
 * Класс считывает с консоли строки, которые будут использованы в методе класса MyClass
 */
public class ReadConsole {
    /**
     * Метод считывает строки с консоли и возвращает написанное, если очередная строка пустая
     *
     * @return возвращает текст с консоли в виде строки типа String
     */
    public String readConsole() {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите код, который хотите поместить в метод doWork");
        System.out.println("после пустой строки (дважды нажать enter) ваш код сохранится в методе");
        while (true) {
            String current = scan.nextLine();
            if (current.equals("")) break;
            stringBuilder.append(current);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
