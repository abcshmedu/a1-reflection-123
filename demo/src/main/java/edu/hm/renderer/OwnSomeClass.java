package edu.hm.renderer;

import edu.hm.cs.a1_reflection_123.RenderMe;

/**
 * Created by MatHe on 05.04.2017.
 */
public class OwnSomeClass {
    @RenderMe
    int foo;
    public OwnSomeClass(int foo) {
        this.foo = foo;
    }
    @RenderMe
    public int doSTM(){
        return 42;
    }
}
