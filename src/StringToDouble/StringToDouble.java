package StringToDouble;

import java.util.Scanner;

/**
 * Created by duozhun on 2016/10/24.
 */


public class StringToDouble {

	public void StringToDouble() {
		while ( true ) {
			try {
				double num = 0;
				Scanner input = new Scanner(System.in);
				String str = input.next();
				Boolean strResult = str.matches("^[-+]?[0-9]+\\.?[0-9]+$");
				if ( strResult == true ) {
				int y1 = str.indexOf(".");
				int y2 = str.indexOf("-");
				int y3 = str.indexOf("+");
				char[] ch = str.toCharArray();

				//正小数
				if ( y1 != - 1 && y2 == - 1 && y3 == - 1 ) {
					str = str.replace(".", "");
					char[] ch1 = str.toCharArray();
					for ( int i = 0 ; i < ch1.length ; i++ ) {
						char d = ch1[ i ];
						int x1 = d - 48;
						num += x1 * Math.pow(10, ch1.length - i - 1);
					}
					num = num * Math.pow(10, y1 - ch1.length);
				}
				//正数
				else if ( y1 == - 1 && y2 == - 1 && y3 == - 1 ) {
					char[] ch1 = str.toCharArray();
					for ( int i = 0 ; i < ch1.length ; i++ ) {
						char d = ch1[ i ];
						int x1 = d - 48;
						num += x1 * Math.pow(10, ch1.length - i - 1);
					}
				}
				//负数
				else if ( y1 == - 1 && y2 == 0 && y3 == - 1 ) {
					str = str.replace("-", "");
					char[] ch1 = str.toCharArray();
					for ( int i = 0 ; i < ch1.length ; i++ ) {
						char d = ch1[ i ];
						int x1 = d - 48;
						num += x1 * Math.pow(10, ch1.length - i - 1);
					}
					num = - num;
				}
				//负小数
				else if ( y1 != - 1 && y2 == 0 && y3 == - 1 ) {
					str = str.replace(".", "");
					str = str.replace("-", "");
					char[] ch1 = str.toCharArray();
					for ( int j = 0 ; j < ch1.length ; j++ ) {
						char d = ch1[ j ];
						int x1 = d - 48;
						num += x1 * Math.pow(10, ch1.length - j - 1);
					}
					num = - num * Math.pow(10, y1 - ch1.length - 1);
				}
				//带正号的小数
				else if ( y1 != - 1 && y2 == -1 && y3 == 0 ) {
					str = str.replace(".", "");
					str = str.replace("+", "");
					char[] ch1 = str.toCharArray();
					for ( int j = 0 ; j < ch1.length ; j++ ) {
						char d = ch1[ j ];
						int x1 = d - 48;
						num += x1 * Math.pow(10, ch1.length - j - 1);
					}
					num =  num * Math.pow(10, y1 - ch1.length - 1);
				}
				System.out.println("成功转化为double型,值为:" + num);
				} else System.out.println("输入的不是数值型字符串,请重新输入");
			} catch ( Exception e ) {
				System.out.println("输入的不是数值型字符串,请重新输入");
			}
			continue;
		}

	}

	public static void main(String[] args) {
		StringToDouble lrr = new StringToDouble();
		lrr.StringToDouble();
	}
}




