package SearchingAlgorithms;

import java.util.Comparator;

public class MergeSort<T extends Comparable<T>> {

    public T[] sort(T[] array) {
        return sort(array, new Comparator<T>() {
            @Override
            public int compare(T el1, T el2) {
                return el1.compareTo(el2);
            }
        });
    }

    public T[] sort(T[] array, Comparator<T> comparator) {
        if(array.length <= 1 ){
            return array;
        }
        
        T[] leftPart =  (T[]) new Comparable[array.length / 2];
        T[] rightPart = (T[]) new Comparable[array.length -  leftPart.length];

        System.arraycopy(array, 0, leftPart, 0, leftPart.length);
        System.arraycopy(array, leftPart.length, rightPart, 0, rightPart.length);

        sort(leftPart);
        sort(rightPart);

        merge(leftPart, rightPart, array, comparator);
        return array;
    }

    private void merge(T[] leftPart, T[] rightPart, T[] resultArray, Comparator<T> comparator){

        int indexOfLeftPart = 0;

        int indexOfRightPart = 0;

        int indexOfResultArray = 0;

        while(indexOfLeftPart < leftPart.length && indexOfRightPart < rightPart.length) {

            if (comparator.compare(leftPart[indexOfLeftPart], rightPart[indexOfRightPart]) == -1) {
                resultArray[indexOfResultArray] = leftPart[indexOfLeftPart];
                indexOfLeftPart++;
            }
            else{
                resultArray[indexOfResultArray] = rightPart[indexOfRightPart];
                indexOfRightPart++;
            }
            indexOfResultArray++;
        }

        System.arraycopy(leftPart, indexOfLeftPart, resultArray, indexOfResultArray, leftPart.length - indexOfLeftPart);
        System.arraycopy(rightPart, indexOfRightPart, resultArray, indexOfResultArray, rightPart.length - indexOfRightPart);
    }

}
