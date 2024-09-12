package gr.codehub.xml.s01reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectorDog {

    public static void main(String[] args) throws Exception {
        Dog dog = new Dog("Alan"); // we could also create using reflection
        Class clazz = dog.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("*****************");
            System.out.println("Method name: " + method.getName());
            int modifier = method.getModifiers();
            System.out.println("Modifier: " + Modifier.toString(modifier));
            System.out.println("Return type: " + method.getReturnType());
            if (modifier == Modifier.PUBLIC) {
                System.out.println("CALLING PUBLIC METHOD " + method.getName());
                method.invoke(dog);
            } else if (modifier == Modifier.PRIVATE) {
                System.out.println("Changing accessibility of method from 'private' to 'public'");
                method.setAccessible(true);
                System.out.println("CALLING PRIVATE METHOD " + method.getName());
                method.invoke(dog);
            }
            // so how do we call protected method and the default access methods?
        }
    }
}
