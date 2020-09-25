package ru.arsakhanov;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс который находит javac и компилит файлы MyClass.java и Worker.java
 */
public class Compil {

    /**
     * метод компилит файл MyClass.java после того, как в него запишется код
     * написанный на консоли. Если код компилируется, то метод успешно завершится
     * а если нет, то выбростися исключение
     *
     * @return возвращает откоспилированный файл с типом File
     * @throws IOException
     * @throws InterruptedException
     */
    public File getJavac() throws IOException, InterruptedException {
        ReadConsole readConsole = new ReadConsole();
        WorkWithFiles wwf = new WorkWithFiles();
        wwf.writeInFile(readConsole.readConsole());
        File javaFiles = new File("E://InnoProjects/HomeWork10/src/ru/example/*.java");
        File MyClassFile = new File("E://InnoProjects/HomeWork10/src/ru/example/MyClass.java");
        Properties p = System.getProperties();
        String sep = p.getProperty("file.separator");
        String jrePath = p.getProperty("java.home");
        int lastIndex = jrePath.lastIndexOf(sep);
        String javac = jrePath.substring(0, lastIndex) + sep + "jdk1.8.0_251" + sep + "bin" + sep + "javac";
        if (p.getProperty("sun.desktop").equals("windows"))
            javac += ".exe";
        else javac += ".sh";
        File jc = new File(javac);
        if (!jc.isFile())
            throw new FileNotFoundException("Компилятор по адресу " + jc.getAbsolutePath() + " недоступен ");
        System.out.println("Компилируем " + jc.getAbsolutePath() + " " + javaFiles.getAbsolutePath());
        Process p1 = Runtime.getRuntime().exec(javac + " " + javaFiles.getAbsolutePath());
        //Если javac завершился с ошибкой, выбрасываем Exception
        //Если надо узнать причину ошибки, то лучше всего вызвать компилятор через консоль
        if (p1.waitFor() != 0)
            try {
                throw new Exception("Ошибка");
            } catch (Exception e) {
                e.printStackTrace();
            }

        System.out.println("Компиляция завершена");
        return MyClassFile;
    }
}
