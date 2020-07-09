package com.wipro.mettl;

public class UserIDGeneration {

	public String userIdGeneration(String input1,String input2,int input3,int input4){
		// Read only region end
		String firstName = input1;
		String lastName = input2;
		int pin = input3;
		int N = input4;
		
		String longerName;
		String smallerName;
		StringBuilder userId = new StringBuilder();   //To use append like functions
		
		if (firstName.length() > lastName.length()) {   //For finding the length of the two strings
			longerName = firstName;
			smallerName = lastName;
		} else if (firstName.length() < lastName.length())  {
			longerName = lastName;
			smallerName = firstName;
		} else {
			if (firstName.compareTo(lastName) < 1 ) {  //Here it will check char by char and gives the smaller and longer string.
				longerName = lastName;
			    smallerName = firstName;
			} else {
				longerName = firstName;
			    smallerName = lastName;
			}
		}
		
		userId.append(smallerName.charAt(smallerName.length() - 1));     //Roy= y
		userId.append(longerName);   //Output=yRajiv
		
		for (int i = 0; i < userId.length(); i++) {
			if (Character.isUpperCase(userId.charAt(i)))
				userId.setCharAt(i, Character.toLowerCase(userId.charAt(i)));   //Toggling  //yRajiv->yrajiv
			else
				userId.setCharAt(i, Character.toUpperCase(userId.charAt(i)));    //Output=YrAJIV
		}
		
		userId.append(String.valueOf(pin).charAt(N - 1));  //YrAJIV7    (560037) (it will append the 5th index value means N-1=6-1=5th which is 7 here 
		userId.append(String.valueOf(pin).charAt(String.valueOf(pin).length() - N));  //YrAJIV75      560037  (6-6=0th index number) 

		
		return userId.toString();   //YrAJIV75
	}
}
