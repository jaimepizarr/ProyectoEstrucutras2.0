/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDA;

import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



/**
 *
 * @josephavila
 */
public class CircularLinkedList<E> implements List<E>, Iterable<E> {

    private Node<E> last;
    private int current;

    public CircularLinkedList() {
        last = null;
        current = 0;
    }

    @Override
    public Iterator<E> iterator() {
        if (isEmpty()) {
            throw new IllegalStateException("Lista vacia");
        }
        Iterator<E> it = new Iterator<E>() {
            Node<E> p = last.next;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E temp = p.data;
                p = p.next;
                return temp;
            }

        };
        return it;
    }

    private class Node<E> {

        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    @Override
    public boolean addFirst(E e) {
        if (e == null) {
            return false;
        }
        Node<E> p = new Node(e);
        if (isEmpty()) {
            last = p;
            last.next = p;
        } else {
            Node<E> second = last.next;
            last.next = p;
            p.next = second;
        }
        current++;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        Node<E> n = new Node<>(e);
        if (isEmpty()) {
            last = n;
            last.next = last;
        } else {
            n.next = last.next;
            last.next = n;
            last = n;
        }
        current++;
        return true;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        } else {
            return last.next.data;
        }
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new IllegalStateException("La lista está vacía.");
        } else {
            return last.data;
        }
    }

    @Override
    public int indexOf(E e) {
        if (e == null || isEmpty()) {
            return -1;
        }
        Node<E> q = last.next;
        for (int i = 0; i < current; i++) {
            if (q.data.equals(e)) {
                return i;
            }
            q = q.next;
        }
        return -1;
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        }
        if (last.next == last) {
            last.data = null; // help GC
            last.next = last = null;
        } else {
            last.data = null; // help GC
            Node<E> prev = getPrevious(last);
            prev.next = last.next;
            last = prev;
        }
        current--;
        return true;
    }

    private Node<E> getPrevious(Node<E> n) {
        if (n == last.next) {
            return last;
        }
        Node<E> q = last.next;
        Node<E> prev = null;
        do {
            if (q.next == n) {
                prev = q;
            }
            q = q.next;
        } while (q != last);
        return prev;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }

        Node<E> newFirst = last.next.next;
        last.next.data = null;
        last.next.next = null;
        last.next = newFirst;
        current--;
        return true;
    }

    private Node<E> getNode(int index) {
        if (index == current - 1) {
            return last;
        }
        Node<E> n = last.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    @Override
    public boolean insert(int index, E e) {
        if (index > current || index < 0) {
            throw new IndexOutOfBoundsException("El indice pedido supera el tamaño de la lista.");
        }
        if (e == null || isEmpty()) {
            return false;
        }
        if (index == 0) {
            return addFirst(e);
        }
        if (index == current) {
            return addLast(e);
        }
        Node<E> q = new Node(e);
        Node<E> prev = getNode(index - 1);
        Node<E> sgte = prev.next;
        prev.next = q;
        q.next = sgte;
        current++;
        return true;
    }

    @Override
    public boolean set(int index, E e) {
        if (e == null) {
            return false;
        }
        if (index >= current || index < 0) {
            throw new IndexOutOfBoundsException("Indice fuera del limite");
        }
        if (index == current - 1) {
            last.data = e;
        } else {
            Node<E> q = getNode(index);
            q.data = e;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= current) {
            throw new IndexOutOfBoundsException("El indice esta fuera del limite");
        }
        if (index == current - 1) {
            return last.data;
        } else {
            Node<E> p = getNode(index);
            return p.data;
        }
    }

    @Override
    public boolean contains(E e) {
        Node<E> p = last.next;
        do {
            if (p.data.equals(e)) {
                return true;
            }
            p = p.next;
        } while (p != last.next);
        return false;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= current) {
            return false;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == current - 1) {
            return removeLast();
        }

        Node<E> q = getNode(index - 1);
        Node<E> p = q.next;
        p.data = null;//HELP GC
        p.next = null; //HELP GC

        q.next = p.next;
        current--;
        return true;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> p = last.next;
        for (int i = 0; i < current - 1; i++)//hasta el penultimo
        {
            sb.append(p.data);
            sb.append(",");
            p = p.next;

        }
        sb.append(last.data);
        sb.append("]");
        return sb.toString();
    }
}