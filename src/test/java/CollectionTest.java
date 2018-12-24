import collection.Collection;

public class CollectionTest {

    public static void main(String[] args) throws Exception {
        testAddition();
        testIsEmpty();
        testMakeEmpty();
        testIfPresent();
        testRemovalOfAnObject();
    }

    private static void testAddition() throws Exception {
        Collection letters = new Collection();
        String letter = "this is a letter";
        letters.insert(letter);

        if (!letters.getElement(0).equals(letter)) {
            throw new Exception("the elements are not equal");
        }
        System.out.println("Adding elements passed as expected");
    }

    private static void testIsEmpty() throws Exception {
        Collection someCollection = new Collection();
        if (!someCollection.isEmpty()) {
            throw new Exception("expected collection to be empty but it is not");
        }
        System.out.println("Collection is empty as expected");
    }

    private static void testMakeEmpty() throws Exception {
        Collection someCollection = new Collection();
        someCollection.insert("an element");
        if (someCollection.isEmpty()) {
            throw new Exception("expected collection to not be empty");
        }
        someCollection.makeEmpty();
        if (!someCollection.isEmpty()) {
            throw new Exception("expected collection to be empty but it is not");
        }
        System.out.println("Collection has been made empty as expected");
    }

    private static void testRemovalOfAnObject() throws Exception {
        Collection someCollection = new Collection();

        String element = "element to insert";
        someCollection.insert(element);

        someCollection.remove(element);

        if(someCollection.isPresent(element)) {
            throw new Exception("expected element to have been removed but it was not");
        }

        System.out.println("Element was removed as expected");
    }

    private static void testIfPresent() throws Exception {
        Collection someCollection = new Collection();
        String element = "element to insert";
        someCollection.insert(element);

        if (!someCollection.isPresent(element)) {
            throw new Exception("expected isPresent to return true for this element: " + element);
        }

        System.out.println("Element was found in the list as expected");
    }
}
