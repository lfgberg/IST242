import java.util.ArrayList;

public class Tester {

    public static void main(String[] args) {

        System.out.println("------- ints:");
        // uncomment chunks of this as you proceed...
        SearchAndSortAlgoModel<Integer> ints =
                new SearchAndSortAlgoModel<>(6, 5, 3, 1, 8, 7, 2, 4);
        System.out.println(ints.linearSearchRecursive(8));   // 4
        System.out.println(ints.linearSearchRecursive(22));  // -1
        System.out.println(ints.linearSearchRecursive(4));   // 7
        System.out.println(ints.linearSearchRecursive(6));   // 0
        System.out.println(ints.linearSearchRecursive(3));   // 2

        System.out.println("\n------- books:");

        SearchAndSortAlgoModel<Book> bks = new SearchAndSortAlgoModel<>(
                new Book("Catcher in the Rye", 234),
                new Book("Ulysses", 730),
                new Book("Moby Dick", 427),
                new Book("War and Peace", 1225),
                new Book("Command and Control: " +
                        "Nukes and the Damascus Arkansas Accident", 632),
                new Book("Wuthering Heights", 400));

        System.out.println(bks.linearSearchRecursive(
                new Book("Catcher in the rye", 234))); // -1
        System.out.println(bks.linearSearchRecursive(
                new Book("Catcher in the Rye", 233))); // -1
        System.out.println(bks.linearSearchRecursive(
                new Book("Catcher in the Rye", 234))); // 0
        System.out.println(bks.linearSearchRecursive(
                new Book("War and Peace", 1224))); // -1
        System.out.println(bks.linearSearchRecursive(
                new Book("War and Peace", 1225))); // 3
        System.out.println(bks.linearSearchRecursive(
                new Book("Wuthering Heights", 400))); // 5

        System.out.println("\n------- sorting numbers:");

        SearchAndSortAlgoModel<Integer> s =
                new SearchAndSortAlgoModel<>(6, 5, 3, 1, 8, 7, 2, 4); // [1, 2, 3, 4, 5, 6, 7, 8]
        System.out.println(s.selectionSortRecursive());
        s = new SearchAndSortAlgoModel<>(1, 0);
        System.out.println(s.selectionSortRecursive());  // [0, 1]
        s = new SearchAndSortAlgoModel<>(0, 1);
        System.out.println(s.selectionSortRecursive());  // [0, 1]
        s = new SearchAndSortAlgoModel<>(6, 2, 3, 7);
        System.out.println(s.selectionSortRecursive()); // [2, 3, 6, 7]

        s = new SearchAndSortAlgoModel<>(7, 6, 5, 4, 3, 2, 1, 0, 20);
        System.out.println(s.selectionSortRecursive()); // [0, 1, 2, 3, 4, 5, 6, 7, 20]

        System.out.println(s.mergeSortRecursive()); // [0, 1, 2, 3, 4, 5, 6, 7, 20]

        s = new SearchAndSortAlgoModel<>(7);
        System.out.println(s.selectionSortRecursive()); // [7]

        s = new SearchAndSortAlgoModel<>(1, 0, 3);
        System.out.println(s.selectionSortRecursive()); // [0, 1, 3]

        s = new SearchAndSortAlgoModel<>(new ArrayList<Integer>());
        System.out.println(s.selectionSortRecursive()); // []

        s = new SearchAndSortAlgoModel<>(7, 7, 0);
        System.out.println(s.selectionSortRecursive()); // [0, 7, 7]

        s = new SearchAndSortAlgoModel<>(7, 5, 0, 6);
        System.out.println(s.selectionSortRecursive()); // [0, 5, 6, 7]

        s = new SearchAndSortAlgoModel<>(1, 3, 5, 6, 7, 8);
        System.out.println(s.selectionSortRecursive()); // [1, 3, 5, 6, 7, 8] <- already in order!

        System.out.println("\n------- sorting some books:");

        SearchAndSortAlgoModel<Book> b = new SearchAndSortAlgoModel<>(
                new Book("Wuthering Heights", 400),
                new Book("Catcher in the Rye", 234),
                new Book("War and Peace", 1225));
        System.out.println(b.selectionSortRecursive());
        // [Catcher in the Rye, Wuthering Heights, War and Peace]

        System.out.println("\n------- binary search:");

        SearchAndSortAlgoModel<Integer> bs =
                new SearchAndSortAlgoModel<>(0, 44, 66, 77, 99, 200);
        System.out.println(bs.binarySearchRecursive(44));   // 1
        System.out.println(bs.binarySearchRecursive(0));    // 0
        System.out.println(bs.binarySearchRecursive(33));   // -1
        System.out.println(bs.binarySearchRecursive(200));  // 5
        System.out.println(bs.binarySearchRecursive(99));   // 4
        bs = new SearchAndSortAlgoModel<>(200);
        System.out.println(bs.binarySearchRecursive(201));  // -1
        System.out.println(bs.binarySearchRecursive(200));  // 0
        bs = new SearchAndSortAlgoModel<>(200, 550, 800);
        System.out.println(bs.binarySearchRecursive(550));  // 1
        System.out.println(bs.binarySearchRecursive(800));  // 2
        System.out.println(bs.binarySearchRecursive(200));  // 0
    }

    // NOTE: you'll need to be using JDK 17 to handle records. If you don't want
    // to use JDK 17, comment the book record out below out and uncomment the
    // normal Book "class" below
    //
    // (the two are equivalent -- but the class version is slightly longer)
    public record Book(String title, int pgCount) implements Comparable<Book> {
        @Override
        public int compareTo(Book o) {
            return this.pgCount - o.pgCount;
        }

        @Override
        public String toString() {
            return String.format("book: %s (%dpgs)", title, pgCount);
        }
    }
}
