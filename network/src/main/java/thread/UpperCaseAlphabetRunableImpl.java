package thread;

public class UpperCaseAlphabetRunableImpl extends UpperCaseAlphabet implements Runnable {

	@Override
	public void run() {
		print();
	}

}
