package prob2;

public class SmartPhone extends MusicPhone {
	public void execute(String function)
	{
		if ("음악".equals(function))
		{
//			super.execute(function);
			System.out.println("다운로드해서 "+ function +"재생");
		}
		if ("통화".equals(function))
		{
			super.execute(function);
		}
		if ("앱".equals(function)) {
			System.out.println(function + "실행");
		}
	}
}
