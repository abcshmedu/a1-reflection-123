package edu.hm.cs.a1_reflection_123;

import edu.hm.SomeClass;
import edu.hm.renderer.Fail2SomeClass;
import edu.hm.renderer.FailSomeClass;
import edu.hm.renderer.OwnSomeClass;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MatHe on 29.03.2017.
 */
public class RendererTest {

    private SomeClass toRender;
    private Renderer renderer;
    @Before
    public void setUp() {


    }
    @Test
    public void testRendering() throws Exception {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.SomeClass:\n" +
                "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\ndate (Type java"+
                        ".util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

    @Test
    public void testRenderingMethod() throws Exception {
        OwnSomeClass toRender = new OwnSomeClass(5);
        renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.renderer.OwnSomeClass:\n"+
                        "foo (Type int): 5\n"+
                        "Method: doSTM returns: int\n"
                , renderer.render());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRenderingExeption() throws Exception {
        FailSomeClass toRender = new FailSomeClass();
        renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.renderer.FailSomeClass:\n"+
                        "foo (Type int): 5\n"+
                        "Method: doSTM returns: int\n"
                , renderer.render());
    }

    @Test(expected = RuntimeException.class)
    public void testRenderingExeption2() throws Exception {
        Fail2SomeClass toRender = new Fail2SomeClass();
        renderer = new Renderer(toRender);
        assertEquals("Instance of edu.hm.renderer.FailSomeClass:\n"+
                        "foo (Type int): 5\n"+
                        "Method: doSTM returns: int\n"
                , renderer.render());
    }

}