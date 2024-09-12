package gr.codehub.xml.s01reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectorThis {
    private double d;
    public static final int i = 37;
    String s = "testing";
    protected NullPointerException myProtectedException = null;

    public static void main(String args[]) throws ClassNotFoundException {
        String className = "gr.codehub.xml.s01reflection.ReflectorThis";
        System.out.println("This demo scans the fields of this class (" + className + ")");
        Class cls = Class.forName(className);
        Field[] fieldList = cls.getDeclaredFields();
        for (int i = 0; i < fieldList.length; i++) {
            Field field = fieldList[i];
            System.out.println("name = " + field.getName());
            System.out.println("declaring class = " + field.getDeclaringClass());
            System.out.println("type = " + field.getType());
            int mod = field.getModifiers();
            System.out.println("modifiers = " + Modifier.toString(mod));
            System.out.println("-----");
        }
    }
}
