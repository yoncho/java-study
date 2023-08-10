package exception;

public class ExceptionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		int b = 10 -a;
		System.out.println("Some Code1");
		
		try {
			System.out.println("Some Code2");

			int result = a/b;
			System.out.println("Some Code3");
		}
		catch(Exception ex)
		{
			/*
			 * 예외 처리 [회사/ 팀 별 지정 방법]
			 * 1) 로깅 (file logging) 
			 * 2) 사용자에게 표시 (error 내용)
			 * 3) 정상 종료 (자원 정리)
			 *  System.exit(1); // poosix 규약 
			 *  	0 : 정상적인 종료
			 *  	1 : 실패 (예외) 강제 종료
			 * */
			
			ex.printStackTrace();
			System.out.println("ERROR : " + ex.toString());
//			System.exit(1);
			return;
		} 
		finally //exception 발생했을 떄 catch 이후 동작
		{
			//자원 정리
			// 파일 닫거나 socket 닫기, db connect close 등등...
			System.out.println("파일 정리");
		}
		//원칙적으로 이곳에 코드를 두지 않음 : try catch finally 안에서 코드 작업을 다 하는게 좋음...
		System.out.println("Some Code4");
	}

}
