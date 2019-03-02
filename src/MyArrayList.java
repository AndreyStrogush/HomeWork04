import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Collection;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private int size;
    transient Object[] elementData;     //for methods addAll, grow etc.
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    @Override
    public boolean add(T element) {
        add(element, elementData, size);
        return true;
    }


    private void add(T element, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = element;
        size = s + 1;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // add the element to get the resizing
        add(element);
        // shift the elements
        for (int i = size - 1; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        // put the new one in the right place
        elementData[index] = element;
    }

    @Override
    public T remove(int index) {
        T element = get(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
        return element;
    }

    @Override
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public void clear() {
        final Object[] es = elementData;
        for (int to = size, i = size = 0; i < to; i++)
            es[i] = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (elementData[index] == null) {
            throw new NullPointerException();
        }
        return (T) elementData[index];
    }

    @Override
    public T set(int index, T element) {
        T old = get(index);
        elementData[index] = element;
        return old;
    }

    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override
    public int indexOf(Object target) {
        for (int i = 0; i < size; i++) {
            if (equals(target, elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object target) {
        for (int i = size - 1; i >= 0; i--) {
            if (equals(target, elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        T[] copy = Arrays.copyOf((T[]) elementData, size);
        return Arrays.asList(copy).iterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        // make a copy of the array
        T[] copy = Arrays.copyOf((T[]) elementData, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        // make a copy of the array
        T[] copy = Arrays.copyOf((T[]) elementData, size);
        // make a list and return an iterator
        return Arrays.asList(copy).listIterator(index);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, array.getClass());
        System.arraycopy(elementData, 0, array, 0, size);
        if (array.length > size)
            array[size] = null;
        return array;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj : collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        T[] copy = Arrays.copyOfRange((T[]) elementData, fromIndex, toIndex);
        return Arrays.asList(copy);
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                newCapacity(minCapacity));
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    private int newCapacity(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

}
