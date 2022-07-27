package ArrayListImp;

import java.util.*;

public class ArrayListImplementation<T> implements List<T> {
    private Object[] myStore;
    private int actSize = 0;

    public <T> ArrayListImplementation() {
        int defaultSize = 10;
        myStore = new Object[defaultSize];
    }

    // ok
    @Override
    public boolean add(T o) {
        int defaultSize = myStore.length;
        if (actSize - 1 == defaultSize) {
            increaseListSize();
        }
        myStore[actSize] = o;
        actSize++;
        return true;
    }

    //ok
    @Override
    public T get(int index) {
        if (index < actSize && index >=0) {
            return (T) myStore[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //ok
    @Override
    public T remove(int index) {
        T result = null;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = (T) myStore[i];
                myStore[i] = null;
                actSize--;
            }
        }
        for (int i = index; i <= actSize - 1; i++) {
            myStore[i] = myStore[i + 1];
        }
        return result;
    }

    //ok
    @Override
    public void add(int index, T element) {
        actSize++;

        int defaultSize = myStore.length;
        if (actSize - 1 == defaultSize) {
            increaseListSize();
        }
        for (int i = actSize; i >= index; i--) {
            myStore[i + 1] = myStore[i];
        }
        myStore[index] = element;
    }

    //ok
    @Override
    public int size() {
        return actSize;
    }

    //ok
    private void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length * 2);
    }

    //ok
    @Override
    public boolean isEmpty() {
        return actSize == 0;
    }

    //ok
    private void shiftToLeft(int start) {
        actSize--;
        if (actSize <= 0) {
            return;
        }
        if (actSize != start) {
            System.arraycopy(myStore, start + 1, myStore, start, actSize - start);
        }
        myStore[actSize] = null;
    }

    //ok
    @Override
    public boolean remove(Object o) {
        if ((actSize == 0)) {
            return false;
        }
        int i;
        for (i = 0; i < actSize; i++) {
            if (myStore[i] == null && o == null) {
                break;
            }
            if ((myStore[i] != null) && (myStore[i].equals(o))) {
                break;
            }
        }
        if (i < actSize) {
            shiftToLeft(i);
            return true;
        }
        actSize--;
        return false;
    }

    //ok
    @Override
    public int lastIndexOf(Object o) {
        for (int i = actSize; i >= 0; i--) {
            if (myStore[i] == o) {
                return i;
            }
        }
        return -1;
    }

    //ok
    @Override
    public void clear() {
        for (int i = 0; i <= actSize; i++) {
            myStore[i] = null;
            actSize--;
        }
    }

    //ok
    @Override
    public Object set(int index, Object element) {
        for (int i = 0; i <= index - 1; i++) {
            if (i == index - 1) {
                myStore[i] = element;
            }
        }
        actSize++;
        return null;
    }

    //ok
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < actSize; i++) {
            if (myStore[i].equals(o)) {
                return i;
            }
        };
        return -1;
    }

    //ok
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            int temp = fromIndex;
            fromIndex = toIndex;
            toIndex = temp;
        }
        if ((fromIndex < 0) || (toIndex > actSize)) {
            return null;
        }
        List myArrayList = new ArrayList(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            myArrayList.add(myStore[i]);
        }
        return myArrayList;
    }

    //ok
    @Override
    public Object[] toArray() {
        return myStore;
    }

    //ok
    @Override
    public boolean containsAll(Collection<?> c) {
        if (c == null) {
            return false;
        }
        if (c.size() == 0) {
            return true;
        }
        for (Object element : c) {
            if (contains(element)) {
            } else {
                return false;
            }
        }
        return true;
    }

    //ok
    @Override
    public boolean retainAll(Collection<?> c) {
        if (c == null) {
            return true;
        }
        if (c.size() == 0) {
            clear();
            return true;
        }
        int i = 0;
        boolean modyfied = false;
        while (i < actSize) {
            if (c.contains(myStore[i])) {
                i++;
            } else {
                shiftToLeft(i);
                modyfied = true;
            }
        }
        return modyfied;
    }


    //ok
    public boolean contains(Object o) {
        Iterator<T> it = iterator();
        if (o==null) {
            while (it.hasNext())
                if (it.next()==null)
                    return true;
        } else {
            while (it.hasNext())
                if (o.equals(it.next()))
                    return true;
        }
        return false;
    }

    //ok
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c){
            if (c.size() < actSize){
                increaseListSize();
            }
            add(element);
        }
        return true;
    }



    //ok
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        int i = index;
        for (T element : c){
            add(i,element);
            increaseListSize();
            i++;
        }
        return true;
    }

    //ok
    public void ensureCapacity(int minCapacity) {
        increaseListSize();
    }

    //???
    @Override
    public <T> T[] toArray(T[] a) {
        T [] newArray = (T[]) new Object[actSize];
        System.arraycopy(myStore, 0, newArray, 0, actSize);
        return (T[]) newArray;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object element : c) {
            remove(element);
        }
        return false;
    }

// ------------------------------------------------------------------------------------------------------------------
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return this.currentIndex < myStore.length;
            }

            @Override
            public T next() {
                return (T) myStore [this.currentIndex++];
            }
        };

    }
}
