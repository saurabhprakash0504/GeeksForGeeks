package com.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestElement {

    static class ClosesetElement {
        int diff;
        int index;

        public int getDiff() {
            return diff;
        }

        public void setDiff(int diff) {
            this.diff = diff;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        ClosesetElement() {

        }

        ClosesetElement(int diff, int index) {
            this.diff = diff;
            this.index = index;
        }


        int[] findKClosesetElement(int[] arr, int k, int number) {
            PriorityQueue<ClosesetElement> priorityQueue = new PriorityQueue<>(new Comparator<ClosesetElement>() {
                @Override
                public int compare(ClosesetElement o1, ClosesetElement o2) {
                    return o2.getDiff() - o1.getDiff();
                }
            });

            for (int i = 0; i < k; i++) {
                int diff = Math.abs(arr[i] - number);
                priorityQueue.add(new ClosesetElement(diff, i));
            }

            for (int i = k; i < arr.length; i++) {
                int diff = Math.abs(arr[i] - number);
                if (priorityQueue.peek().getDiff() > diff) {
                    priorityQueue.poll();
                    priorityQueue.add(new ClosesetElement(diff, i));
                }
            }

                   List<ClosesetElement> list= priorityQueue.stream().sorted(Comparator.comparing(ClosesetElement::getDiff)).collect(Collectors.toList());
                  // return priorityQueue.stream().sorted(Comparator.comparing(ClosesetElement::getDiff)).mapToInt(ClosesetElement::getDiff).toArray();

                   list.stream().forEach(data -> System.out.println(arr[data.getIndex()]));

            return null;
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 30, 5, 40, 38, 80, 70};
        ClosesetElement closesetElement = new ClosesetElement();
        closesetElement.findKClosesetElement(arr, 3, 35);
       // Arrays.stream(closesetElement.findKClosesetElement(arr, 3, 35)).forEach(data -> System.out.println(arr[data]));

    }

}
