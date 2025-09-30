public class VArray {
    private int nextIndex = 0;
    private int[] array = null;

    public VArray(int arraySize) {
        array = new int[arraySize];
    }

    public void add(int input) {
        if(nextIndex < array.length) {
            array[nextIndex] = input;
            nextIndex++;
        }
        else {
            extend();
            array[nextIndex] = input;
            nextIndex++;
        }
    }

    public int size() {
        return nextIndex;
    }

    public int capacity() {
        return array.length;
    }

    private void extend() {
        int[] tmp = new int[array.length * 2];
        copy(array, tmp);
        array = tmp;
    }

    private void copy(int[] src, int[] dest) {
        for(int i = 0; i < src.length; i++) {
            dest[i] = src[i];
        }
    }

    public boolean insert(int index, int input) {
        if(index >= nextIndex) {
            return false;
        }

        if(nextIndex == array.length) {
            extend();
        }

        for(int i = nextIndex; i >= index; i--) {
            array[i+1] = array[i];
        }

        array[index] = input;
        nextIndex++;
        return true;
    }

    public void printAll() {
        for(int i =0; i <nextIndex; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean remove(int index) {
        if (index >= nextIndex) {
            return false;
        }

        for (int i = index; i < nextIndex - 1; i++) {
            array[i] = array[i + 1];
        }

        nextIndex--;
        return true;
    }

    public static void main(String[] args) {
        VArray v = new VArray(5);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for(int i =0; i < 7; i++) {
            v.add(i);
        }

        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100);
        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.remove(10);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for(int i = 50; i < 55; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}

