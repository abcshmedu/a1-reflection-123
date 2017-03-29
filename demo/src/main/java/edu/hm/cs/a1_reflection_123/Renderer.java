package edu.hm.cs.a1_reflection_123;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by MatHe on 29.03.2017.
 */
public class Renderer {

    Object obj;

    Renderer(Object obj){
        this.obj = obj;
    }

    public String render() {
        String res= "";

        Class<?> cut = obj.getClass();

        Field[] fields = cut.getDeclaredFields();
        res += "Instance of "+ cut.getName()+ ":\n";

        for (Field field: fields){
            if (field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class) != null) {

                try {
                    field.setAccessible(true);
                    Object abw = field.get(obj);
                    res += field.getName()+" ";
                    if (field.getType().isPrimitive()){
                        res +=  "(Type "+field.getType() + "): ";
                    }
                    else{
                        res +=  "(Type "+field.getType().toString().substring(6) + "): ";
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
