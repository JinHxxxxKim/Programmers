package src;

import java.util.Stack;

public class Solution18 {
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            deliveryStack.push(deliveries[i]);
            pickupStack.push(pickups[i]);
        }


        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {

            while (!deliveryStack.isEmpty() && deliveryStack.peek() == 0) {
                deliveryStack.pop();
            }
            while (!pickupStack.isEmpty() && pickupStack.peek() == 0) {
                pickupStack.pop();
            }
            answer += 2 * Math.max(deliveryStack.size(), pickupStack.size());

            int currDeliveryNum, currPickupNum;

            int deliveryNum = 0;
            while (!deliveryStack.isEmpty()) {
                currDeliveryNum = deliveryStack.pop();
                if (currDeliveryNum < cap - deliveryNum) {
                    deliveryNum += currDeliveryNum;
                } else {
                    deliveryStack.push(currDeliveryNum - cap + deliveryNum);
                    break;
                }
            }

            int pickupNum = 0;
            while (!pickupStack.isEmpty()) {
                currPickupNum = pickupStack.pop();
                if (currPickupNum < cap - pickupNum) {
                    pickupNum += currPickupNum;
                } else {
                    pickupStack.push(currPickupNum - cap + pickupNum);
                    break;
                }
            }
        }
        return answer;
    }
}
