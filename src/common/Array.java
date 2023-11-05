package common;

public class Array<E> {

    private E[] data;

    private int size;

    /**
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 默认构造函数
     */
    public Array() {
        this(10);
    }

    // 数组元素个数
    public int getSize() {
        return size;
    }

    // 数组容量
    public int getCapacity() {
        return data.length;
    }

    // 是否为空数组
    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (size == data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal, index >= 0 and index < size. ");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }



    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal, index >= 0 and index < size. ");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal, index >= 0 and index < size. ");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return true;
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) return i;
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal, index >= 0 and index < size. ");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length / 4 && size / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }
    
    public E removeFirst() {
        return remove(0);
    }
    
    public E removeLast() {
        return remove(size - 1);
    }
    
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public void removeAllElement(E e) {
        while (contains(e)) {
            remove(find(e));
        }
    }
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, getCapacity()));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i].toString());
            if (i != size - 1) {
                res.append(',');
            }
        }
        res.append(']');
        return res.toString();
    }

}
