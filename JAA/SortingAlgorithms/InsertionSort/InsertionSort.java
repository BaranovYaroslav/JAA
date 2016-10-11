package SearchingAlgorithms;

import java.util.Comparator;

public class InsertionSort<T extends Comparable<T>> {

    private Comparator<T> defaultComparator = new Comparator<T>() {
        @Override
        public int compare(T el1, T el2) {
            return el1.compareTo(el2);
        }
    };

    public T[] sort(T[] array) {
        return sort(array, defaultComparator);
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        for (int j = 1; j < array.length; j++) {
            T key = array[j];
            int i = j - 1;
            while(i >= 0 && comparator.compare(array[i], key) == 1){
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
        return array;
    }

}
