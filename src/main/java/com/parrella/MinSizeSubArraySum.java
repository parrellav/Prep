package com.parrella;

import java.util.*;

public class MinSizeSubArraySum {

    public static void main(String []args) {
        ProblemToSolve problem = new ProblemToSolve(7, new int[] { 2,3,1,2,4,3 });

        Answer expected = new Answer(2, new int[] {4,3});

        Solver solver = new Solver();
        Answer actual = solver.solve(problem);
        System.out.println(expected);
        System.out.println(actual);

    }
}

class Solver {

    public Answer solve(ProblemToSolve aProblem) {
        int target = aProblem.target;
        int[] nums = aProblem.nums;
        int currentSum = 0;
        List<Integer> intList = new ArrayList<>();
        Answer answer = null;
        for (int num : nums) {
            currentSum += num;
            intList.add(num);
            if (currentSum >= target) {
                answer = new Answer(intList.size(), intList.stream().mapToInt(Integer::intValue).toArray());
                currentSum = 0;
                intList = new ArrayList<>();
            }

        }
        return answer;
    }
}

class ProblemToSolve {

    public int target;
    public int[] nums;

    public ProblemToSolve(int aTarget, int[] someNums) {
        target = aTarget;
        nums = someNums;
    }

    @Override
    public String toString() {
        return "target=" + this.target + "  nums=" + Arrays.toString(this.nums);
    }

}

class Answer {
    public int size;
    public int[] subArray;

    public Answer(int aSize, int[] someNums) {
        size = aSize;
        subArray = someNums;
    }

    @Override
    public String toString() {
        return "size=" + this.size + "  nums=" + Arrays.toString(this.subArray);
    }
}