import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity){
        this.size = capacity;
    }

    public void ensureCapa(){
        int newSize = this.elements.length * 2;
        this.elements = Arrays.copyOf(this.elements,newSize);
    }

    public void add(int index, E element){
        if (this.size == this.DEFAULT_CAPACITY){
            this.ensureCapa();
        }
        this.elements[this.size++] = element;
    }

    public E remove(int index){
        E temp = (E) this.elements[index];
        for (int i = index; i < size; i++){
            this.elements[i] = this.elements[i+1];
        }
        this.size--;
        return temp;
    }

    public int size(){
        return this.size;
    }

    public Object clone(){
        MyList myList = new MyList<E>();
        myList.elements = this.elements;
        myList.size = this.size;
        return myList;
    }

    public boolean contains(E o){
        for (int i = 0; i < size; i++){
            if (this.elements[i] == o){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        int index = -1;
        for (int i = 0; i < size; i++){
            if ((E) this.elements[i] == o){
                index = i;
                break;
            }
        }
        return index;
    }

    public E get (int i){
        return (E) this.elements[i];
    }

    public void clear(){
        this.size = 0;
        this.elements = null;
    }
}
