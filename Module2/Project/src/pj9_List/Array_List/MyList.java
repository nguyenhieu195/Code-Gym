package pj9_List.Array_List;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    // Constructor không tham số — tạo mảng mặc định 10 phần tử
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int compacity) {
        elements = new Object[compacity];
    }

    // Them phan tu vao vi tri index
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1); // cộng thêm 1 chỗ vào list
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    // đảm bảo dung lượng ô chứa còn trống, nếu không sẽ nhân đôi dung lượng
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity); // nếu không đủ chỗ thì gấp đôi mảng
            Object newElements[] = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i]; // gán các phần tử trong mảng cũ vào mảng mới
            }
            elements = newElements; //gán mảng cũ bằng mảng mới
        }

    }

    // xoá pt tại index
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " size: " + size);
        }
        @SuppressWarnings("unchecked")
        E remove = (E) elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1]; //dịch sang trái
        }

        elements[--size] = null;
        return remove;
    }

    public int size() {
        return size;
    }

    // Kiểm tra xem phần tử có tồn tại trong danh sách không
    public boolean contains(E e) {
        return indexOf(e) >= 0;
    }

    // trả về chỉ số đầu tiền của phần tử hoặc -1 nếu không tìm thấy
    public int indexOf(E o){
        for (int i = 0; i < size; i++) {
            if(elements[i].equals(o)) return i;
        }
        return -1;
    }

    // thêm phần tử vào cuối danh sách
    public boolean add(E e){
        ensureCapacity(size +1 );
        elements[size++] = e;
        return true;
    }

    // lấy phần tử theo chỉ số
    public E get(int i){
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException("Index: " + i + " size: " + size);
        }
        return (E) elements[i];
    }

    public MyList<E> clone(){
        MyList<E> newList = new MyList<>();
        for (int i = 0; i < size; i++) {
            newList.add(i, get(i));
        }
        return newList;
    }
    public void clear(){
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
    
    public void display(){
        System.out.print("[");
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println("]\n");
    }
}
