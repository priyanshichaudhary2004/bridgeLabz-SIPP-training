package java_class_and_obj;

public class PalindromeChecker {
String text;
PalindromeChecker(String text){
	this.text=text;
}
public  boolean ispalindrome() {
	int left=0;
	int right=text.length()-1;
	while(left<right) {
		char leftchar=text.charAt(left);
		char rightchar=text.charAt(right);
		
		if(leftchar==' ') {
			left++;
			continue;
		}
			else if(rightchar==' ') {
			right--;
			continue;
		}
		
		
		
		if(leftchar != rightchar) {
			return false;
		}
		left++;
		right--;
		
	}
	return true;
}
	public void displayInfo() {
		if(ispalindrome()) {
			System.out.println("the text is palindrome");
			
		}else {
			System.out.println("the text is not palindrome");
		}
	}

	public static void main(String[]args) {
		 PalindromeChecker t1=new  PalindromeChecker("madam");
		 
		 t1.displayInfo();
PalindromeChecker t2=new  PalindromeChecker("racing car");
		 
		 t2.displayInfo();
		
	}

}
