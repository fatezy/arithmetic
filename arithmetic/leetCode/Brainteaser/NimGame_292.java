package Brainteaser;

/**
 * author： 张亚飞
 * time：2016/5/3  16:01
 */
//You are playing the following Nim Game with your friend: There is a heap of stones on the table,
// each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
// You will take the first turn to remove the stones.
//
//        Both of you are very clever and have optimal strategies for the game.
// Write a function to determine whether you can win the game given the number of stones in the heap.
//
//        For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove,
// the last stone will always be removed by your friend.
    //给你一堆石头，每隔人每次可以拿走一个到三个，问先手会不会去成功
    //通过观察可以知道只要不是4的倍数，先手一定成功
public class NimGame_292 {
    public boolean canWinNim(int n) {
        if(n%4==0)
            return false;
        else
            return true;
    }


}
