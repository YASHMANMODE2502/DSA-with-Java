import java.util.ArrayList;

public class ContainerWithMaxWater {

    // Brute Forch Approch O(n^2)
    public static int Container_with_MaxWater(ArrayList<Integer> height)  {
        
        int maxWater = 0;
        for (int i=0; i<height.size(); i++) {
            for (int j=i+1; j<height.size(); j++) {
                int ht = Math.min(height.get(i), height.get(j));
                int weidth = j-i;
                int currWater = ht*weidth;
                maxWater = Math.max(maxWater, currWater);
            }
        }

        return maxWater;
    }

    public static int ContainMaxWater_optemised(ArrayList<Integer> height) {
        int maxWater = 0;
        int leftPtr = 0;
        int rightPtr = height.size()-1;

        while(leftPtr<rightPtr) {
            
            int ht = Math.min(height.get(leftPtr), height.get(rightPtr));
            int weidth = rightPtr-leftPtr;

            int currWater = ht * weidth;
            maxWater = Math.max(maxWater, currWater);

            if (height.get(leftPtr)<height.get(rightPtr)){
                leftPtr++;
            } else{
                rightPtr--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(ContainMaxWater_optemised(height));
    }
}
