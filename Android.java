package week1.day1;

public class Android {
    String OS="Oreo";
    float OSVersion=8.0f;
    boolean update=true;
    long ModelNum= 998989892;
    int ReleaseYear =2017;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Android ass=new Android();
		String oS2 = ass.OS;
		float oSVersion2 = ass.OSVersion;
		boolean update2 = ass.update;
		long modelNum2 = ass.ModelNum;
		int releaseYear2 = ass.ReleaseYear;
		
		System.out.println("Android Version:"+oS2);
		System.out.println("Android Version number:"+oSVersion2);
		System.out.println("Update Provided:"+update2);
		System.out.println("Model number:"+modelNum2);
		System.out.println("Release Year:"+releaseYear2);
		
		

	}

}
