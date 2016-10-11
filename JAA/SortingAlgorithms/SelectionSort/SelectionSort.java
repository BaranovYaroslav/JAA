package SearchingAlgorithms;

import java.util.Comparator;

public class SelectionSort<T extends Comparable<T>> {

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
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if(comparator.compare(array[min], array[j]) == 1){
                    min = j;
                }
            }
            if(min != i) {
                T temp = array[i];
                array[i] = array[min];
                array[min] = temp;
            }
        }
        return  array;
    }

}
