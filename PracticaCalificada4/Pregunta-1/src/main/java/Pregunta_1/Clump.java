package Pregunta_1;

public class Clump {
    public int countClumps(int[] nums) {
        int countClumps = 0;
        boolean clumpFound = false;
        for (int i = 0; i < nums.length -1; i++) {
            int currentValue = nums[i];
            int nextValue = nums[i+1];
            if (currentValue == nextValue) {
                if (clumpFound == false) {
                    clumpFound = true;
                    countClumps++;
                }
            } else {
                clumpFound = false;
            }
        }
        return countClumps;
    }
}
