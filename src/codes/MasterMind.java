package codes;

import java.util.Scanner;

public class MasterMind {
	
	 public static final int totalnumberofpossiblities = 1296, x = 4;
     public static int arrInt[][] = new int[totalnumberofpossiblities][x]; // instantiating the main array that is with 1296 different possibilities for each color
     // The arrInt variable is needed as to allow for the comparison the various to the order of their occurrence 
     public static boolean Possibility[] = new boolean [totalnumberofpossiblities]; // instantiating the array to test possibilities
     public static Scanner Input = new Scanner(System.in); // initializing the scanner

	/* Directory for output
	 * 1 is red
	 * 2 is blue
	 * 3 is yellow 
	 * 4 is ____________ ******* fill OUT ONCE GAME IS FOUND
	 * 5 is ____________ ******* fill OUT ONCE GAME IS FOUND
	 * 6 is ____________ ******* fill OUT ONCE GAME IS FOUND
	 * The above is based off the order of occurrence of the colors from right to left
	 */
		
	public static int errortrapinteger(String entrance)
	{ // error trapping the integer
		int number = 0;
		
		do 
		{
			try
			{
				number = -1;
				System.out.print(entrance);
				number = Input.nextInt(); 
				System.out.println();						
			}
			catch(Exception e)
			{
				Input.next();
				System.out.println();
			}
			
		} while ((number < 0));
		
		return number;
	    }
	    
	public static void PopulateSolutions()
	{ // populating the array with all the possible solutions from 1111 to 6666
	        
	    /* Project Outline
		 * The six loops are to dictate 1296 solutions not numbers
		 * First Solution = 1111
		 * Second Solution = 1112
		 * ............
		 * Last Solution = 6666
		 * Six is the max number as there are 6 different numbers
		 * After population, display the arrays that do not have a 0 value
		 * The 0 value is to be assigned over time!
		 */
	        
	    int tempTotalnumberofpossibilities = 0; // to dictate the advent of each individual solution
			
		for(int firstcounter = 1; firstcounter < 7; firstcounter++)
		{ // the first number in the solution
			for(int Secondcounter = 1; Secondcounter < 7; Secondcounter++)
			{ // the second number in the solution
				for(int ThirdCounter = 1; ThirdCounter < 7; ThirdCounter++)
				{ // the third number in the solution
					for(int FourthCounter = 1; FourthCounter < 7; FourthCounter++)
					{ // the fourth number in the solution								
						//for(int tempTotalnumberofpossibilities = 0; tempTotalnumberofpossibilities < totalnumberofpossiblities; tempTotalnumberofpossibilities++)
						//{ /// Change the above for loop as it resets the value of the solutions
	                                                // DONE!!
							for(int TempX = 0; TempX < x; TempX++)
							{ // to dictate the placing of each indicidual number in a solution                                                                                                                    
								/// 11/10 - this works!
								// System.out.println(firstcounter); // test
								if(TempX == 0)
									arrInt[tempTotalnumberofpossibilities][TempX] = firstcounter;
									//System.out.println(arrInt[tempTotalnumberofpossibilities][TempX] = firstcounter); // test
								else if(TempX == 1)
									arrInt[tempTotalnumberofpossibilities][TempX] = Secondcounter;
									// System.out.println(arrInt[tempTotalnumberofpossibilities][TempX] = Secondcounter); // test
								else if(TempX == 2)
									arrInt[tempTotalnumberofpossibilities][TempX] = ThirdCounter;
								else if(TempX == 3)
									arrInt[tempTotalnumberofpossibilities][TempX] = FourthCounter;
	                        } // end individual number placement loop						
	                                                
	                       tempTotalnumberofpossibilities++; // the change in each possible solution
	                       // This loop will terminate once the alloted for loops have all reached their respective means of culimination in the form of the final solution - 6666
					//	}
						
					} 
				}
			}
		} // end last for-loop
	            
	         //   DisplayArray(); test case
	} 
	
	public static void PopulateBoolean()
     {
         for(int BooleanPossibility = 0; BooleanPossibility < totalnumberofpossiblities; BooleanPossibility++)
	                Possibility[BooleanPossibility] = true; // setting all possible solutions in the parallel array to be true 
     }
     
     public static void DisplayArray()
	{
	    // boolean Possibility[] = new boolean [totalnumberofpossiblities]; // instantiating the array to test possibilities
		System.out.println("*********************Possible Solutions******************");
		for(int tempTotalnumberofpossibilities = 0; tempTotalnumberofpossibilities < totalnumberofpossiblities; tempTotalnumberofpossibilities++)
		{ // the variable that is used to indicate the occurrence of each new solution
	      //  System.out.println("X"); // test case
                 if(Possibility[tempTotalnumberofpossibilities])
                 { // dictating the terms for the possible solutions
                             // this will only initiate if it is still perceived as a possibility by the parallel boolean loop
                     for(int TempX = 0; TempX < x; TempX++)
                     {
                         System.out.print(arrInt[tempTotalnumberofpossibilities][TempX]);
                     }	

                     System.out.println();	
                } 
		}
		System.out.println("*********************************************************");
	}
	
	public static void CheckArray(int FirstGuess)
	{ // populating the array with sequential numbers
	        int Correct, WrongSpot;
	
	        Correct = errortrapinteger("\nHow many were correct? "); // numbers that are in the correct spot
	        WrongSpot = errortrapinteger("How many are in the wrong spot? "); // numbers that have an existence in the solution but are in the wrong spot
	        
	        for(int tempTotalnumberofpossibilities = 0; tempTotalnumberofpossibilities < totalnumberofpossiblities; tempTotalnumberofpossibilities++)
	        { // to only check the numbers that have been verified to be correct.....
	            int NumberofCorrect = 0;
                 
                 if(!Possibility[tempTotalnumberofpossibilities])
                     continue;   
	                
	            for(int TempX = 0; TempX < x; TempX++)
	            { // to dictate the placement of all the possible solutions
	                if(arrInt[FirstGuess][TempX] == arrInt[tempTotalnumberofpossibilities][TempX])
	                {
	                    NumberofCorrect = NumberofCorrect + 1; // recording the number of solutions that are correct
	                    //  System.out.println(NumberofCorrect);  
	                } 
	            }
	                
	              //  System.out.println(NumberofCorrect); // test     
	            if(NumberofCorrect != Correct) // if the number of solutions correct is not equal to the measured value
	                Possibility[tempTotalnumberofpossibilities] = false; // dictating that the certain solutions in the parallel array with the same index as false      

	         //   }
	         //   System.out.println(NumberofCorrect); // test case  
	            CheckWrongSpot(WrongSpot, FirstGuess); // initiating the program to check for values in the wrong spot
	      }
	}
	            
	public static void CheckWrongSpot(int WrongSpot, int FirstGuess)
	{        
	    for(int tempTotalnumberofpossibilities = 0; tempTotalnumberofpossibilities < totalnumberofpossiblities; tempTotalnumberofpossibilities++)
	    {   
             if(Possibility[tempTotalnumberofpossibilities])
             {
                     // to only check the numbers that have been verified to be correct.....
	        		
	        	int NumberofWrongSpot = 0;
		        int[] SolutionCopy = {arrInt[tempTotalnumberofpossibilities][0], arrInt[tempTotalnumberofpossibilities][1], arrInt[tempTotalnumberofpossibilities][2], arrInt[tempTotalnumberofpossibilities][3]};
		        // the above array list would need to be put outside the if statement as solutions that have been matched do not need to be matched again
		        int[] FirstGuessCopy = {arrInt[FirstGuess][0], arrInt[FirstGuess][1], arrInt[FirstGuess][2], arrInt[FirstGuess][3]};		        	
		        	
	            	for(int TempX = 0; TempX < x; TempX++)
	                { // to dictate the placement of all the possible solutions
	            	  // both the copy arrays would need to be outside the for-loops as they would be reset otherwise
	            		
                        // if()
	            		if(FirstGuessCopy[TempX] == SolutionCopy[TempX])
                             {
                                 SolutionCopy[TempX] = -1;
                                 FirstGuessCopy[TempX] = -1;
                                 //continue;
                                 //  TempX = TempX+1; // if the number is already in its correct spot, then the next slot will be checked
                             }
                             
                     } // to seperate loops are needed as the program will not work when some numbers haven't yet been checked for their possiblities and they are compared to the next occurence
	                
                     for(int TempX = 0; TempX < x; TempX++)
                     {       
                         for(int TempX2 = 0; TempX2 < x; TempX2++)
                             { // to dictate the placement of all the possible solutions
                                 if(FirstGuessCopy[TempX] == -1)
                                     break; // no need to check as this slot in the address has already been compared to a number in the correct slot

                                 if(FirstGuessCopy[TempX] == SolutionCopy[TempX2])
                                 {
                                      NumberofWrongSpot = NumberofWrongSpot + 1; // measuring the number of solutions that are correct	                                
                                      SolutionCopy[TempX2] = -1;
                                      FirstGuessCopy[TempX] = -1;
                                     // TempX2 = x+1; // no need to check as this slot in the address has already been compared to a number in the correct slot
                                      break; // this command will end this for loop
                                        // continue;
                                         //   TempX = TempX+1; // so that if a color exists then, the next index will be checked
                                 } 
                             }
	                }	  
                             
                    // System.out.println(NumberofWrongSpot);
                     if(NumberofWrongSpot != WrongSpot) // if the number of solutions correct is not equal to the measured value
                          Possibility[tempTotalnumberofpossibilities] = false;	               
                     
             }
	    }
	}
	
	public static int PossibilityCounter()
     {
       int PossibilityCounter = 0;
       
       for(int TempPossibility = 0; TempPossibility < totalnumberofpossiblities; TempPossibility++)
                 if(Possibility[TempPossibility])
                     PossibilityCounter++; 
       
       return PossibilityCounter;
     }
     
     public static int GuessGenerator()
     {
         int FirstGuess = 0; // the first guess of the round to be analyzed
                 
         do
         { // doing this while a random index is generated that has an assesment of true in the parallel array
             FirstGuess = (int)(Math.random()*totalnumberofpossiblities); // generating the index for the first guess
         } while(!Possibility[FirstGuess]);

         return FirstGuess; // returning the randomly generated index
     }
     
     public static void GuessPrinter(int FirstGuess)
     {
         System.out.print("You should guess: "); // first half of the sentence 
         // there is no need to check if the solutions are possible as this loop will only be initiated once                   
         
         for(int TempX = 0; TempX < x; TempX++)
             System.out.print(arrInt[FirstGuess][TempX]); // second half of the sentence
             
         System.out.println(); // for spacing purposes
     }
     
     public static void Title()
     {
         System.out.println("****************************************************");
         System.out.println("Welcome to Nihal's MasterMind Game Interface!!");
         System.out.println("****************************************************\n");
     }
     
     public static void main(String[] args) 
	{// Main Program where all programs are initiated upon start-up
         
         int PossibilityCounter, FirstGuess;
	        
         Title(); // the opening statement of the interface
         
	     // the methods cannot sequentially call themselves as some methods are needed to be called more than once
         PopulateSolutions(); // populating the main array with solutions
         PopulateBoolean(); // populating the parallel boolean array with all possibilities set to true
	    //  DisplayArray(); //test case
         
         do{ // a loop that will continue until there is only one "true" solution is left                
             FirstGuess = GuessGenerator(); // generating the random index for the first guess of the round   
             GuessPrinter(FirstGuess); // printing out the address associated with the randomly generated index

             // All statements to ask for how many are in the correct slot can be found in the method that checks for the number of slots in the correct spot
             // The above action has been taken to minimize clutter in the main 
             // The method that checks for the number of slots in the wrong spot is "called" by the method that checks for the corretc spot, again to minimize clutter in the main
             CheckArray(FirstGuess); // checking for the number of slots in the correct spot
             DisplayArray(); // displaying all the possiblities that are true
             
             PossibilityCounter = PossibilityCounter(); // checking for the number of solutions that are still true
                         
	    } while(PossibilityCounter != 1);  // ending the loop when the solution has been found
         
         System.out.println("\nYou have now ended Nihal's MasterMind Game Interface!\n"); // closing statement for better organization
	}
}