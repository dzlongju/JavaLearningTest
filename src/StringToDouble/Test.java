package StringToDouble;

import java.util.Scanner;

/**
 * Created by duozhun on 2016/10/27.
 */
public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.next();
		System.out.println("转化为double:  "+Double.parseDouble(str));
	}
}
