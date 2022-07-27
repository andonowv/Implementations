package LinkedListImp;

import java.util.*;

public class LinkedListImplementationn<T> implements List<T> {
    private static class Node<T> {

        T data;
        Node<T> last;

        Node(T data) {
            this.data = data;
            last = null;
        }
    }

    Node<T> first;
    int size = 0;

    //ok
    @Override
    public int size() {
        return size;
    }

    //ok
    @Override
    public boolean add(T data) {
        Node<T> toInsert = new Node<>(data);
        if (first == null) {
            first = toInsert;
        } else {
            Node<T> temp = first;
            while (temp.last != null) {
                temp = temp.last;
            }
            temp.last = toInsert;
        }
        size++;
        return true;
    }


    //ok
    public void print() {
        Node<T> temp = first;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.last;
        }
    }

    //ok
    public T peek() {
        if (first == null) {
            System.err.println("Cannot peek from empty head");
            return null;
        } else {
            return (T) first.data;
        }
    }

        //ok
    @Override
    public void add(int index, T data) {
        Node<T> node = new Node<T>(data);
        node.data = data;
        node.last = null;

        if (index == 0) {
            addFirst(data);
        }

        Node<T> n = first;
        for (int i = 0; i < index - 1; i++) {
            n = n.last;
        }
        node.last = n.last;
        n.last = node;
    }

    //ok
    public void addLast(T obj) {
        Node<T> toInsert = new Node<T>(obj);
        if (first == null) {
            first = toInsert;
        } else {
            Node<T> temp = first;
            while (temp.last != null) {
                temp = temp.last;
            }
            temp.last = toInsert;
        }
        size++;
    }

    //ok
    public void addFirst(T param) {
        Node<T> toInsert = new Node<T>(param);
        if (first == null) {
            first = toInsert;
        } else {
            Node<T> node = new Node<T>(param);
            node.data = param;
            node.last = first;
            first = node;
        }
        size++;
    }

    //ok
    @Override
    public T set(int index, T element) {

        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }

        Node<T> toInsert = new Node<T>(element);
        toInsert.data = element;

        if (index == 0) {
            addFirst(element);
        }

        Node<T> n = first;
        for (int i = 0; i < index; i++) {
            n = n.last;
            if (index - 1 == i){
                n.data= element;
            }
        };
        return element;
    }

    //ok
    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    //ok
    @Override
    public int indexOf(Object o) {
        int index = -1;
        Node<T> temp = first;;
        for (int i = 0; i < size; i++) {
            if (temp.data == (T) o){
                index = i;
            }
            temp = temp.last;
        }

        return index;
    }

    //ok
    @Override
    public boolean contains(Object o) {
        Node<T> temp = first;;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals((T) o)){
                return true;
            }
            temp = temp.last;
        }
        return false;

    }

    //ok
    @Override
    public Object[] toArray() {
        Node <T> temp = first;
        Object [] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = temp.data;
            temp = temp.last;
        }
        return array;
    }

    //ok
    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        Node<T> temp = first;;
        for (int i = 0; i < size; i++) {
            if (temp.data == (T) o){
                index = i;
            }
            temp = temp.last;
        }

        return index;
    }

    //ok
    public void clear() {
        Node<T> temp = first;
        while (temp != null) {
            temp.data = null;
            temp = temp.last;
            size--;
        }

    }

    // ok
    @Override
    public T get(int index) {
        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = first;
        Node<T> temp1 = null;
        for (int i = 0; i < size; i++) {
            if (index == i){
                temp1 = (Node<T>) temp;
            }
            temp = temp.last;
        }
        return (T) temp1.data;
    }

    //ok
    @Override
    public T remove(int index) {
        Node <T> current = first.last;
        Node <T> prev = null;
        Node <T> temp = first;

        if (index > size || index < 0){
            throw new IndexOutOfBoundsException();
        }
        if (index == 0){
            first = first.last;
            size--;
            return (T) first;
        }else if (index +1 == size){
            for (int i = 0; i < size - 1; i++) {
                temp = temp.last;
            }
            size--;
            temp = null;
            return null;
        }
        else {
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.last;
                current = temp.last;
            }
        }
        prev.last = current;
        size --;
        return (T) current.data;
    }

    //ok
    @Override
    public boolean remove(Object o) {
        Node <T> current = first;
        while (current != null){
            if (o == current.data){
                return true;
            }
        }
        return false;
    }

    //ok
    public boolean containsAll(Collection<?> a) {
        for (Object current : a) {
            if (a.contains(current)){
                return true;
            }else {
                return false;
            }
        }
        return false;
    }
    //???
    @Override
    public <T1> T1[] toArray(T1[] a) {
        Node <T> temp = first;
        Object [] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = temp.data;
            temp = temp.last;
        }
        return (T1[]) array;
    }

    // ???
    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T element : c){

        }
        return true;
    }

    //???
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }
    //???
    @Override
    public boolean retainAll(Collection<?> c) {
        T [] array = (T[]) new Object[10];
        for (Object current : c) {
            if (c.contains(current)){
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == null){
                        array [i] = (T) current;
                    }
                }
            }
        }
        return false;
    }

    //???
    @Override
    public boolean removeAll(Collection<?> c) {
        Node <T> current = first.last;
        Node <T> prev = null;
        Node <T> temp = first;
        for (Object element : c) {
            if (element.equals(c)){

            }
        }

        return false;
    }


// ---------------------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node <T> current = first;

            @Override
            public boolean hasNext() {
                return current.last != null;
            }

            @Override
            public T next () {
                T value = (T) current.data;
                current = current.last;
                return (T) value;
            }
        };
    }
}
