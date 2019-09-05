package base.datastruct;

/**
 *不用中间变量交换两个变量的值：中心思想 -> 使一个变量成为temp；
 *
 * 1、加减法：该方法可以交换整型和浮点型数值的变量，但在处理浮点型的时候有可能出现精度的损失。
 *
 * a = a + b;
 *
 * b = a - b;
 *
 * a = a - b;
 *
 * 2、异或法：可以完成对整型变量的交换，对于浮点型变量它无法完成交换。（使用位运算交换两个数，是利用了异或的自反性： a^b^b=a^0=a;）
 *
 * a = a^b;
 *
 * b = a^b;
 *
 * a = a^b;
 *
 * 3、乘除法：可以处理整型和浮点型变量，但在处理浮点型变量时也存在精度损失问题。而且乘除法比加减法要多一条约束：b必不为0。
 *
 * a = a * b
 *
 * b = a / b
 *
 * a = a / b
 *
 * 其中加减，乘除容易越界，用位运算异或效率最高，且不会越界。
 *
 */
public class 冒泡 {
    public static void main(String[] args) {
        int[] iarr = {4,3,1,6,8,9};
        int len = iarr.length -1;

        for(int i = 0;i < len;i++){
            for(int j = 0;j < len - i;j++){
                交换0(iarr,j);// swap
            }
        }

        for(int a : iarr) System.out.println(a);

    }

    static void 交换(int[] iarr,int j){
        if( iarr[j] < iarr[j+1] ){
            int temp = iarr[j];
            iarr[j] = iarr[j+1];
            iarr[j+1] = temp;
        }
    }


    static void 交换0(int[] iarr,int j){
        if( iarr[j] < iarr[j+1] ){
            iarr[j] = iarr[j] + iarr[j+1];
            iarr[j+1] = iarr[j] - iarr[j+1];
            iarr[j] = iarr[j] - iarr[j+1];
        }
    }


    static void 交换1(int[] iarr,int j){
        if( iarr[j] < iarr[j+1] ){
            iarr[j] = iarr[j] ^ iarr[j+1];
            iarr[j+1] = iarr[j] ^ iarr[j+1];
            iarr[j] = iarr[j] ^ iarr[j+1];
        }
    }



}
