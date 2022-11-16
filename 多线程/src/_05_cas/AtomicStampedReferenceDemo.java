package _05_cas;

import java.util.concurrent.atomic.AtomicStampedReference;


class Book {
    int id;
    String name;

    public Book(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class AtomicStampedReferenceDemo {


    public static void main(String[] args) {
//        Book javaBook = new Book(1, "javaBook");
//
//        AtomicStampedReference<Book> atomicStampedReference
//                = new AtomicStampedReference<>(javaBook, 1);
//        System.out.println(atomicStampedReference.getReference());
//
//        Book mysqlBook = new Book(2, "mysqlBook");
//
//        atomicStampedReference.compareAndSet(javaBook,mysqlBook,1,2);
//        System.out.println(atomicStampedReference.getReference());
//
//        atomicStampedReference.compareAndSet(mysqlBook,javaBook,2,3);
//        System.out.println(atomicStampedReference.getReference());

        AtomicStampedReference<Integer> atomicStampedReference
                = new AtomicStampedReference<>(100, 1);
        System.out.println(atomicStampedReference.getReference());


        atomicStampedReference.compareAndSet(100, 101,
                1, 2);
        System.out.println(atomicStampedReference.getReference());

        atomicStampedReference.compareAndSet(101, 100,
                2, 3);
        System.out.println(atomicStampedReference.getReference());

    }
}
