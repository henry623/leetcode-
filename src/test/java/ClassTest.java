import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ClassTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class1.class;
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        System.out.println(constructor);
        constructor.setAccessible(true);
        Object instance = constructor.newInstance();
        System.out.println(instance);
    }


}
