class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxBannana = 0;
        int optimumBannana = Integer.MAX_VALUE;
        for(int i : piles)
            maxBannana = Math.max(i, maxBannana);
        
        int start = 1;
        while(start<=maxBannana){
            int mid = start + (maxBannana-start)/2;
            int timeTaken = timeTakenToFinshBananna(piles,mid);
            if(timeTaken <= h){
                optimumBannana = Math.min(optimumBannana, mid);
                maxBannana = mid -1;
            }else if(timeTaken > h){     
                start = mid +1;           
            }
            
        }
        return optimumBannana == Integer.MAX_VALUE ? 0 : optimumBannana;

    }
    int timeTakenToFinshBananna(int[] piles, int speed){
        int totalTime = 0;
        for(int i : piles){
            totalTime += (int) Math.ceil((double) i / speed);
        }
        return totalTime;
    }
}
