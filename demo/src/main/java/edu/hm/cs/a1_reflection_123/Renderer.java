package edu.hm.cs.a1_reflection_123;

import java.lang.reflect.Field;

/**
 * Created by MatHe on 29.03.2017.
 */
public class Renderer {

    Object obj;

    Renderer(Object obj){
        this.obj = obj;
    }

    public String render(){


        Class<?> cut = obj.getClass();

        Field[] fields = cut.getFields();

        for (Field field: fields){
            if (field.getAnnotation(edu.hm.cs.a1_reflection_123.RenderMe.class) != null) {
                field.toString();
                /*
                tests++;
				Object ott = cut.getConstructor().newInstance();
				try {
					method.invoke(ott);
					successes++;
				} catch(InvocationTargetException e){
					fails++;
				}
                 */
            }



        }


        return "";
    }

}
