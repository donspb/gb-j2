package geekbrains.jt.homework4;

import java.util.Arrays;

public class Main {

    private static class someThread extends Thread {

        float[] arr;
        int ext;

        someThread(float[] arr, int ext) {
            this.arr = arr;
            this.ext = ext;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + ext) / 5) * Math.cos(0.2f + (i + ext) / 5) * Math.cos(0.4f + (i + ext) / 2));
            }
        }
    }


    static final int size = 10_000_000;
    static final int halfSize = size / 2;

    public static void main(String[] args) {
        float[] arr = new float[size];
        Arrays.fill(arr, 1);
        System.out.println(simpleChanger(arr));
        Arrays.fill(arr, 1);
        System.out.println(complexChanger(arr));
    }

    static long simpleChanger(float[] arr) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        return System.currentTimeMillis() - startTime;
    }

    static long complexChanger(float[] arr) {
        long startTime = System.currentTimeMillis();
        float[] halfArrayOne = new float[halfSize];
        float[] halfArrayTwo = new float[halfSize];

        System.arraycopy(arr,0, halfArrayOne, 0, halfSize);
        System.arraycopy(arr, halfSize, halfArrayTwo, 0, halfSize);

        someThread firstThread = new someThread(halfArrayOne, 0);
        someThread secondThread = new someThread(halfArrayTwo, halfSize);
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstThread.arr, 0, arr, 0, halfSize);
        System.arraycopy(secondThread.arr, 0, arr, halfSize, halfSize);

        return System.currentTimeMillis() - startTime;
    }

}
