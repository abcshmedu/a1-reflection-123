package edu.hm.cs.a1_reflection_123;

import edu.hm.renderer.ArrayRenderer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Class.*;

/**
 * Created by MatHe on 29.03.2017.
 */
public class Renderer implements IRenderer {

    private static final int LENGTH_OF_CLASS_STRING = 6;
    private Object obj;

    /**
     * Creates Renderer to obj.
     * @param obj object to read from.
     */
    Renderer(Object obj) {
        this.obj = obj;
    }

    /**
     * Renders the Object.
     * @return string to use in JUnit.
     */
    public String render() {
        ArrayRenderer renderArray = new ArrayRenderer();

        String res = "";

        Class< ? > cut = obj.getClass();

        Field[] fields = cut.getDeclaredFields();
        res += "Instance of " + cut.getName() + ":\n";

        for (Field field: fields) {
            if (field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class) != null) {
                RenderMe annotation = field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class);
                    if (annotation.with().equals("edu.hm.cs.a1_reflection_123.Renderer")) {
                        //region normal
                        try {
                            field.setAccessible(true);
                            Object abw = field.get(obj);
                            res += field.getName() + " ";
                            if (field.getType().isPrimitive()) {
                                res +=  "(Type " + field.getType() + "): ";
                            }
                            else {
                                res +=  "(Type " + field.getType().toString().substring(LENGTH_OF_CLASS_STRING) + "): ";
                            }
                            res += field.get(obj).toString();
                            res += "\n";
                        } catch(IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        //endregion
                    }
                    else {
                        //region int array
                        Object intArray = new Object();
                        field.setAccessible(true);
                        try {
                             intArray = field.get(obj);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                        res += renderArray.render((int[])intArray);

                        //endregion
                }
            }
        }
        Method[] methods = cut.getDeclaredMethods();


        for (Method method: methods) {
            if (method.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class) != null) {
                try {
                    if (method.getReturnType() != void.class) {
                        method.setAccessible(true);
                        res += "Method: ";
                        res += method.getName();
                        res += " returns: ";
                        res += method.getReturnType();
                        res += "\n";
                        method.invoke(obj);
                    } else {
                        throw new IllegalAccessException();
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return res;
    }

}
