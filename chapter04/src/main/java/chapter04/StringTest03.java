package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
//		String s1 = "Hello" + "World" + "Java" + 17;
		String s1 = new StringBuffer("Hello")
				.append("World")
				.append("Java")
				.append(17)
				.toString();
		//StringBuilder
		//String.valueOf(17) input to string
	
		System.out.println(s1);
		
		String s2 = "";
		for (int i = 0; i< 100000; i++) {
//			s2 += i; 와 아래가 동일
//			s2 = new StringBuffer(s2).append(i).toString();
//			메모리에 new 객체 생성하는게 시간 걸림.... 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100000; i++)
		{
			sb.append(i);
		}
		
//		System.out.println(sb);
		
		String s3 = sb.toString();
		
		// String method들...
		String s4 = "aBcABCabc";
		
		System.out.println(s4.length());
		System.out.println(s4.charAt(0));
		System.out.println(s4.contains("A"));
		System.out.println(s4.indexOf("abc"));
		System.out.println(s4.indexOf("abc", 7));
		System.out.println(s4.substring(3));
		System.out.println(s4.substring(3, 5));
		
		String s5 = "        ab    cd   ";
		String s6 = "efg,hij,lmn,opq,rst";

		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println(s5.trim());
		System.out.println(s6.replace(",", ""));
		System.out.println(s6.replaceAll(" ", "") + "---");
		
		
		String[] tokens = s6.split(",");
		
		for(String s : tokens) {
			System.out.println(s);
		}
		
		String[] tokens2 = s6.split(" ");
		for(String s : tokens2)
		{
			System.out.println(s);
		}
		
		
		
	}

}
