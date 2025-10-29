package pj9_List.Array_List;


public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Constructor không tham số — tạo mảng mặc định 10 phần tử
    public MyList() {
        element = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int compacity) {
        element = new Object[compacity];
    }

    // Them phan tu vao vi tri index
    public void add(int index, E element){
        if(index > 0 && index < size){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1); // cộng thêm 1 chỗ vào list
        for(int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
    }

    public void ensureCapacity(int minCapacity){
        if(minCapacity > elements.length){
            int newC
        }
    }
}
