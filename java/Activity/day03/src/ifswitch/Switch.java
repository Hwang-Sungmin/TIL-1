package ifswitch;

public class Switch {

	public static void main(String[] args) {
		// Switch - admin Permission Control
		int a = 2;
		String str = "";
		switch (a) {
		case 1:
			str += "1��";			
		case 2:
			str += "2��";			
		case 3:
			str += "3��";
			break;
		default:
			str = "Fail";
			break;
		}
		System.out.println(str);
	}

}
