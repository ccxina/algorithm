package common;


import lang.Array;
import lang.ArrayStack;
import lang.LinkedList;

public class Main {

    public static void main(String[] args) {

        Array<Integer> array = new Array<>(10);
        for (int i = 0; i < 10; i++) {
            array.addLast(1);
        }
        System.out.println(array);
        array.add(1, 100);

        System.out.println(array);
        array.remove(2);
        array.removeElement(1);
        System.out.println(array);
        array.removeAllElement(1);
        System.out.println(array);


        Array<Student> studentArray = new Array<>();
        studentArray.addLast(new Student(1, "aa"));
        studentArray.addLast(new Student(1, "aa"));
        studentArray.addLast(new Student(1, "aa"));
        System.out.println(studentArray);

        System.out.println("Linked List =>>>>>>>>>>>");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5 ; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

//        linkedList.add(1, 100);
        linkedList.addLast(999);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);


//        ArrayStack<Integer> stack = new ArrayStack<>(10);
//        for (int i = 0; i < 5 ; i ++) {
//            stack.push(i);
//        }
//        System.out.println(stack);


        ArrayStack<Character> stack = new ArrayStack<>();

        String s = "{{[[]]}}(())";
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
                System.out.println(stack);
            } else {
                if (c == '}' && stack.peek() == '{' ) {
                    
                    System.out.println(stack);
                    stack.pop();
                } else if (c == ')' && stack.peek() == '(' ) {
                    System.out.println(stack);
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[' ) {
                    System.out.println(stack);
                    stack.pop();
                }
            }
        }
        System.out.println(stack);


        int[][] cost = {{1,4,3},{2,3,1},{2,3,4}};
        maxCost(cost);
    }

    public static int maxCost(int[][] cost) {
        int m = cost.length, n = cost[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = cost[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + cost[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + cost[0][j];
        }

        printRoute(cost, 0, 0);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];

                if (cost[i - 1][j] > cost[i][j - 1]) printRoute(cost, i - 1, j);
                else printRoute(cost, i, j - 1);
            }
        }
        printRoute(cost, m - 1, n - 1);
        return dp[m - 1][n - 1];
    }

    public static void printRoute(int[][] cost, int i, int j){
        System.out.print(cost[i][j] + " ");
    }

}
