//package StringToDouble;
//
//import java.util.Scanner;
//
///**
// * Created by duozhun on 2016/10/24.
// */
//public class StringToDoubleTest {
//	public static void main(String[] args) {
//		while ( true ) {
//			try {
//				double num = 0;
//				Scanner input = new Scanner(System.in);
//				String str = input.next();
////				String regEx = "^[0-9]+\\.?[0-9]{0,2}$";
////				boolean result= Pattern.compile(regEx).matcher(str).find();
//				Boolean strResult = str.matches("^[0-9]+\\.?[0-9]{0,2}$");
//				if ( strResult == true ) {
//					int y1 = str.indexOf(".");
//					int y2 = str.indexOf("-");
//					int y3 = str.indexOf("+");
//					char[] ch = str.toCharArray();
//					if ( y1 != - 1 && y2 == - 1 && y3 == - 1 ) {
//						str = str.replace(".", "");
//						char[] ch1 = str.toCharArray();
//						System.out.println("新的str为" + str + ",y1的位置:" + y1);
//						for ( int i = 0 ; i < ch1.length ; i++ ) {
//							System.out.println("i的位置" + i);
//							char d = ch1[ i ];
//							int x1 = d - 48;
//							num += x1 * Math.pow(10, ch1.length - i - 1);
//							System.out.println("x1的第" + i + "位数的数值:" + x1);
//							System.out.println("循环中的num:" + num);
//						}
//						num = num * Math.pow(10, y1 - ch1.length);
//					} else if ( y1 != - 1 && y2 == 0 && y3 == - 1 ) {
//						str = str.replace(".", "");
//						str = str.replace("-", "");
//						char[] ch1 = str.toCharArray();
//						for ( int j = 0 ; j < ch1.length ; j++ ) {
//							char d = ch1[ j ];
//							int x1 = d - 48;
//							num += x1 * Math.pow(10, ch1.length - j - 1);
//						}
//						num = - num * Math.pow(10, y1 - ch1.length - 1);
//					} else if ( y1 != - 1 && y2 == - 1 && y3 == 0 ) {
//						str = str.replace(".", "");
//						str = str.replace("+", "");
//						char[] ch1 = str.toCharArray();
//						for ( int j = 0 ; j < ch1.length ; j++ ) {
//							char d = ch1[ j ];
//							int x1 = d - 48;
//							num += x1 * Math.pow(10, ch1.length - j - 1);
//						}
//						num = num * Math.pow(10, y1 - ch1.length - 1);
//					}
//
//					System.out.println("成功转化为double型,值为:" + num);
//				}
//				else System.out.println("输入的不是数值型字符串,请重新输入");
//			} catch ( Exception e ) {
//				System.out.println("输入的不是数值型字符串,请重新输入");
//			}
//			continue;
//		}
//
//	}
//}
