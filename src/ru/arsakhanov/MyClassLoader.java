package ru.arsakhanov;

import java.io.*;

/**
 * собственный загрузчик классов
 */
public class MyClassLoader extends ClassLoader {
    /**
     * Переопределенный метод findClass, которому надо передать путь к файлу с расширением .class
     * метод сначала проверяет существует ли класс
     * потом с помощью потока считвает файл в массив байт
     * и с помощью функции defineClass загружает класс
     * @param name имя класса
     * @return возвращает класс, который загрузил
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(name + ".class");
        if (!f.isFile())
            throw new ClassNotFoundException("Нет такого класса " + name);
        try (InputStream ins = new BufferedInputStream(new FileInputStream(f))) {
            byte[] b = new byte[(int) f.length()];
            ins.read(b);
            Class<?> c = defineClass(null, b, 0, b.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException("Проблемы с байт кодом");
        }

    }
}

