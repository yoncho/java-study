package prob04;

import java.util.Arrays;

public class StringUtil {

	public static String concatenate(String[] strArr) {
		
		//방법1
//		int arrCount = strArr.length;
//		String concatString = new String();
//		
//		for(int i = 0; i< arrCount; i++)
//		{
//			concatString = concatString.concat(strArr[i]);
//		}
//		return concatString;
		
		//방법2
		return String.join("", strArr);
	}
	
}
