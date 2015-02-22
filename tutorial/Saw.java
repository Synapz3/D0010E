package tutorial;

public class Saw {

	public static void main(String[] args) {
		int x = 4;
		triangel(x);
		sawtooth(3, 2);
		//HelloWorld.main(args);
	}
	
	static void triangel(int a) {
		for (int i = 1; i <= a; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} 
	static void sawtooth(int a, int b){
		for (int i = 0; i < b; i++){
			triangel(a);
		}
	}
}
