package edu.hm.cs.a1_reflection_123;

import java.lang.reflect.Field;

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
        String res = "";

        Class< ? > cut = obj.getClass();

        Field[] fields = cut.getDeclaredFields();
        res += "Instance of " + cut.getName() + ":\n";

        for (Field field: fields) {
            if (field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class) != null) {
                RenderMe a = field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class);
                if (a.with().equals("edu.hm.cs.a1_reflection_123.Renderer")){
                    System.out.println("wked");
                }

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

                }

            }



        }
        System.out.printf(res);


        return res;
    }

}
