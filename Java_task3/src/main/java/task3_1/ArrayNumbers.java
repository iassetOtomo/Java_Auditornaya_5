package task3_1;

public class ArrayNumbers {
    public int[] arrayNumbers;

    public int getMax(){
        int max = arrayNumbers[0];

        for (int i : arrayNumbers){
            if (i > max){
                max = i;
            }
        }

        return max;
    }
    public int getMin(){
        int min = arrayNumbers[0];

        for (int i : arrayNumbers){
            if (i < min){
                min = i;
            }
        }

        return min;
    }

    public float getAvg(){
        float lenth = arrayNumbers.length;
        float sum = 0;

        for (int i : arrayNumbers){
            sum += i;
        }

        return sum/lenth;
    }
}
