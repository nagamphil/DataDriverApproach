package Base;

public class Rough {
public static void main(String[] args) {
	//System.out.println(System.getProperty("user.dir"));
	String TestCasesName = "LoginTestCase";
	for(int rownumber=2; rownumber<=data.getRowCount("TestCasesList"); rownumber++ ) {
		String Actualtestcase = data.getCellData("TestCasesList", 0, rownumber);
		if(TestCasesName.equals(Actualtestcase)) {
			String Runmodestatus = data.getCellData("TestCasesList", 2, rownumber);
			if(Runmodestatus.equals("Y")) {
				System.out.println("Run the testcases");
				
			}
			else
			{
				System.out.println("skip the testcases");
			}
		}
	}
}
}
