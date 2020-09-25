package ru.arsakhanov;

import java.io.*;

/**
 * класс для работы с файлом
 * записывает из строки текст в файл MyClass.java
 */
public class WorkWithFiles {
    /**
     * метод записыват в файл MyClass.java строку, которая была записана в консоли
     * так же в методе описывается структура java файла, чтобы он мог работать
     * @param str строка типа String
     */
    public void writeInFile(String str) {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("src/ru/example/MyClass.java")))) {
            bw.write("package ru.example;\n");
            bw.write("public class MyClass implements Worker{\n");
            bw.write("@Override\n");
            bw.write("public void doWork(){\n");
            bw.write(str);
            bw.write("\n");
            bw.write("}\n");
            bw.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
