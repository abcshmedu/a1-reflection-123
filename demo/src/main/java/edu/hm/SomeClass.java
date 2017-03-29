package edu.hm;

import edu.hm.cs.a1_reflection_123.RenderMe;

import java.util.Date;

/**
 * Created by MatHe on 29.03.2017.
 */
public class SomeClass {
    @RenderMe
    private int foo;
    @RenderMe(with="edu.hm.renderer.ArrayRenderer") int[] array = {1, 2, 3,};
    @RenderMe private Date date = new Date(123456789);
    public SomeClass(int foo) {
        this.foo = foo;
    }

}
