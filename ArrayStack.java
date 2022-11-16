import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * A simple stack implementation. Uses array as internal representation.
 *
 * @author Sedgewick and Wayne
 * @author Acuna
 * @version 1.0
 * @param <Item> item type
 */
public class ArrayStack<Item> extends Stack<Item> {
    private Item[] data;
    private int n = 0;
    private final static int CAPACITY = 100;
    private String name;

    public ArrayStack() {
        this(CAPACITY);
    }
    public ArrayStack(int cap) {
        data = (Item[]) new Object[cap];
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public Item push(Item item) {
        if(data.length == n)
            resize();
        data[n++] = item;
        return item;
    }


    @Override
    public Item pop() {
        if(isEmpty())
            throw new NoSuchElementException();

        return data[--n];
    }

    @Override
    public Item peek() {
        if(isEmpty())
            throw new NoSuchElementException();

        return data[n-1];
    }

    private void resize() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String toString(){
        String toReturn = "";
        for(int i=0; i<n; i++){
            toReturn += data[i] + " ";
        }
        return toReturn;
    }

    public String getName() {
        return name;
    }

    public void setName(String pName){
        name = pName;
    }
}