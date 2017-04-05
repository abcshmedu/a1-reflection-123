package edu.hm.renderer;


/**
 * Created by MatHe on 05.04.2017.
 */
public class ArrayRenderer {
    /**
     * renders array.
     * @param array array to render.
     * @return rendered array.
     */
    public String render(int[] array) {
        String result = "array (Type int[]) [";

        for (int i = 0; i < array.length; i++) {
            result += array[i] + ", ";
        }
        result += "]\n";
        return result;
    }
}
