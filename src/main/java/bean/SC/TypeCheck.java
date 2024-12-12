package bean.SC;

import java.util.ArrayList;
import java.util.Arrays;

public class TypeCheck {
	private static ArrayList<String> check = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8"));
	
	public static ArrayList<String> typeCheck(String[] type)  {
		ArrayList<String> chekedType = new ArrayList<String>();
		if (type == null) {
			return chekedType;
		}
		for (String str : type) {
			if (check.contains(str)) {
				chekedType.add(str);
			}
		}
		return chekedType;
	}
	
	public static void main(String[] args) {
		// テスト用
        String[] input = {"9", "10"};
        ArrayList<String> result = typeCheck(input);
        System.out.println("有効な災害種別: " + result);
	}
}
