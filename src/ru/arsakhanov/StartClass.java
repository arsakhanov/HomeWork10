package ru.arsakhanov;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Класс который выполняет класс загруженный из MyClassLoader
 */
public class StartClass {

    /**
     * метод принимает на вход файл и строит из него путь для classloader
     * и запускает метод doWork из класса MyClass
     *
     * @param file
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public void start(File file) throws ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InstantiationException,
            InvocationTargetException {
        int pointIndex = file.getAbsolutePath().lastIndexOf(".");
        String absulutePatch = file.getAbsolutePath().substring(0, pointIndex);

        MyClassLoader loader = new MyClassLoader();
        Class<?> cl = loader.findClass(absulutePatch);
        System.out.println(cl);

        Method method = cl.getMethod("doWork");
        System.out.println(method);
        method.invoke(cl.newInstance());
    }
}
