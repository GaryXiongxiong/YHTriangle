/*
 * @Author: Gary J
 * @Date: 2019-07-20 21:02:41
 * @LastEditors: Gary J
 * @LastEditTime: 2019-07-20 21:40:40
 * @Description: Calculate YangHui Triangle by DP and Recursion algorithm.
 */
import java.util.ArrayList;
import java.util.Scanner;
public class YHTriangle{
    /**
     * @description:  Calculate YangHui Triangle by DP algorithm
     * @param int x   The row of target number.
     * @param int y   The column of target number.
     * @return: The target number
     */
    public static int yhTriangleUsingDP(int x, int y){
        // 创建二维数组
        ArrayList<ArrayList<Integer>> yh = new ArrayList<ArrayList<Integer>>();
        // 采用动态规划算法，基于杨辉三角形规定由上而下进行计算
        for(int i = 0;i<x;i++){
            // 求x行第y个，即只需求出x行所有元素即可
            yh.add(new ArrayList<Integer>());
            for(int j = 0;j<i+1;j++){
                // 第n行有n个元素，所以我们在第i+1行添加i+1个元素
                if(j == 0 || j == i){
                    // 最两边的数字均为1
                    yh.get(i).add(1); 
                }
                else{
                    // 中间的数字为顶部两数字之和，即矩阵中其上方与其左上方数字之和
                    yh.get(i).add(yh.get(i-1).get(j)+yh.get(i-1).get(j-1));
                }
            }
        }
        // 计算结束
        return yh.get(x-1).get(y-1);
    }
    /**
     * @description:  Calculate YangHui Triangle by Recursion algorithm
     * @param int x   The row of target number.
     * @param int y   The column of target number.
     * @return: The target number
     */
    public static int yhTriangleUsingRecursion(int x,int y){
        // 用递归求杨辉三角形，首先要确定基底，即第一行仅有一个1，之后每行的最左侧及最右侧为1
        if(y-1 == 0 || x == y) return 1;
        //其余的数字均等于其上部与左上部之和（已在用DP算法的解法中说明）
        else{
            return yhTriangleUsingRecursion(x-1, y-1)+yhTriangleUsingRecursion(x-1, y);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String[] ins = in.split(" ");
        // 动态规划法
        System.out.println(yhTriangleUsingDP(Integer.parseInt(ins[0]), Integer.parseInt(ins[1])));
        // 递归算法
        System.out.println(yhTriangleUsingRecursion(Integer.parseInt(ins[0]), Integer.parseInt(ins[1])));
    }
}
