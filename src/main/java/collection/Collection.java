package collection;

public class Collection {

    private Object[] objects;

    public Collection() {
        objects = new Object[10];
    }

    public boolean isEmpty() {
        for (Object object : objects) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    public void makeEmpty() {
        objects = new Object[0];
    }

    public void insert(Object newObject) {
        if (!isEmpty()) {
            int firstEmptyIndex = findFirstEmptyIndex();

            if (firstEmptyIndex != -1) {
                objects[firstEmptyIndex] = newObject;

            } else {
                Object[] temp = objects;
                objects = new Object[objects.length * 2];
                System.arraycopy(temp, 0, objects, 0, temp.length);
            }
        } else {
            objects = new Object[2];
            objects[0] = newObject;
        }
    }

    public void remove(Object element) {
        for (int i = 0; i< objects.length; i++) {
            if (element.equals(objects[i])) {
                objects[i] = null;
                break;
            }
        }

        System.out.println("Could not find element: " + element);
    }

    public boolean isPresent(Object element) {
        for (Object object : objects) {
            if (element.equals(object)) {
                return true;
            }
        }

        return false;
    }

    public Object getElement(int position) {
        return objects[position];
    }

    private int findFirstEmptyIndex() {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
