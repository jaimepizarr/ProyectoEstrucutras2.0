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
public class CircularLinkedList<E> implements List<E>,Iterable<E>{
    private Node<E> last;
    private int current;
    public CircularLinkedList()
    {
        last = null;
        current = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private class Node<E>
    {
        private E data;
        private Node<E> next;
        
        public Node(E data)
        {
            this.data = data;
            this.next = null;
        }        
    }

    @Override
    public boolean addFirst(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
        }  else {
            n.next = last.next;
            last.next = n;
        }
        current++;

        return true;
    }


    @Override
    public boolean addLast(E e) {
        Node<E> n = new Node<>(e);
        if(isEmpty()){
            last = n;
            last.next = last;
        }
        else
        {
            n.next = last.next;
            last.next = n;
            last = n;
        }
        current++;
        return true;
    }

    @Override
    public E getFirst() {
       return last.next.data;
    }

    @Override
    public E getLast() {
         return last.data;
    }

    @Override
    public int indexOf(E e) {
        if(e==null ){
            return -1;
        }
        int count=0;
        for (Node q = last.next; q!=last; q=q.next){
            if(q.data.equals(e)){
                return count;
            }
            count++;
        }
        return -1;
    }

    @Override
    public int size() {
       return current;
    }

    @Override
    public boolean removeLast() {
        if(isEmpty()) return false;
        else if(last == last.next){
            last.data=null; // help GC
            last =last.next= null;
        }
        else
        {
            Node<E> prev = getPrevious(last);
            last.data = null; // help GC
            prev.next = last.next;
            last = prev;
        }
        current --;
        return true;
    }
    private Node<E> getPrevious(Node<E> p)
    {
        if(p == last.next) return last;
        Node<E> q =last.next;
        while(q!=null && q.next!=p)
            q = q.next;
        return q;
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty()) return false;
        if( last== last.next)
        {
            last.data = null;//help GC
            last.next = last = null;

        }
        else
        {
            Node<E> p = last.next;
            last.next = p.next;
            p.data = null;//help GC
            p.next = null;
        }
        current--;
        return true;
    }

    @Override
    public boolean insert(int index, E e) {
        if(e==null||index<0||index>current)    return false;
        if(index==0) return addFirst(e);
        if(index==current) return addLast(e);
        Node<E> p= new Node<>(e);
        Node<E> n =getNode(index-1);
        p.next=n.next;
        n.next=p;
        current++;
        return true;
    }
    private Node<E> getNode(int index){
        if(index<0 ||index>=current) return null;
        if(index==current-1) return last;
         Node<E> mochilero=last.next;

        for(int i=0;i<index;i++){
            mochilero=mochilero.next;

        }
        return mochilero;
    }
     @Override
    public boolean set(int index, E e) {
        if(e==null||index<0||index>=current) return false;
        Node<E> n = getNode(index);
        n.data=e;
        return true;
    }
    @Override
    public boolean isEmpty() {
        return current==0;
    }
     @Override
    public E get(int index) {
        return  getNode(index).data;
    }
     @Override
    public boolean contains(E e) {
        Node<E> p = last.next;
        do{
            if(p.data.equals(e))
                return true;
            p=p.next;
        }while(p!=last.next);
        return false;
    }
     @Override
    public boolean remove(int index) {
        if(index<0||index>=current) return false;
        if(index==0) return removeFirst();
        if(index==current-1)  return removeLast();


        Node<E> n=getNode(index-1);
        Node<E> p=n.next;
        p.data=null;//HELP GC
        n.next=p.next;
        p.next=null;
        current--;
        return true;
    }


}