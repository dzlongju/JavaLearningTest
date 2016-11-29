package ailistringtodouble;

import java.util.Scanner;
import java.util.regex.*;
/**
 * 将String类型转换成Double类型
 */
public class transformation {
    //判断字符串是否可以转换成合法的Double类型
    public boolean match(String str){
        Pattern p1 = Pattern.compile("[-]?[1-9][0-9]*\\.[0-9]+"); //正负xx.xx; 排除0.xxx(避免000.xx）/ .xx/ xx.
        Pattern p2 = Pattern.compile("[-]?[0]\\.[0-9]+"); //正负0.xxx
        Pattern p3 = Pattern.compile("[-]?[1-9][0-9]*|0"); //正负整数或0
        if (p1.matcher(str).matches()|| p2.matcher(str).matches()|| p3.matcher(str).matches()) {
            return true;
        }
        else {
            return false;
        }
    }

    //将String转换成Double类型
    public void str2double(String str) {
        if (str.equals("exit")){
           return;
        }
        if (match(str)) {
            boolean flag = true;
            //排除掉+和-
            if (str.charAt(0) == '-') {
                str = str.substring(1);
                flag = false;
            } else if (str.charAt(0) == '+') {
                str = str.substring(1);
            }
            Double dou = new Double(0);
            String a[] = str.split("\\.");
            //对整数部分进行转换
            for (int i = 0; i < a[0].length(); i++) {
                int temp = (int) a[0].charAt(i) - 48;  //a[0].charAt(i)的ASCII码-48为对应的数字，因为'0'-'9'的ASCII码依次为48-57
                for (int j = 0; j < a[0].length() - i - 1; j++) {
                    temp = temp * 10;
                }
                dou = dou + temp;
            }
            //当存在小数点且小数点后有数字时,对小数部分进行转换
            if (str.indexOf(".") != -1 && str.indexOf(".") != str.length() - 1) {
                for (int i = 0; i < a[1].length(); i++) {
                    double temp = (double) a[1].charAt(i) - 48;
                    for (int j = 0; j < i + 1; j++) {
                        temp = temp / 10;
                    }
                    dou = dou + temp;
                }
            }
            //当为负数时，要把结果变成负数
            if (!flag) {
                dou = 0 - dou;
            }
            System.out.println(dou);
        }
        else {
            System.out.println("无法转换为Double类型！");
        }
    }

    public static void main (String[] args) {
        //创建输入对象
        Scanner sc=new Scanner(System.in);
        //用str获取用户输入的字符串
        String str=null;
        do{
            System.out.println("请输入一个字符串：");
            str = sc.next();
            transformation rr = new transformation();
            rr.str2double(str);
        }while (!(str).equals("exit"));  //输入"exit"退出程序
    }
}
