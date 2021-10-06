import java.util.*;
import java.awt.Point;

public class PredatorPray_test{
	
	public static void main(String[] args) {
		
		runSimulation(10,1,500);
		
	}
	/////runs a simulation of a pray and a predator in a grid.///////
	public static void runSimulation(int n, int s, int t) {
		if(n<=0||s<=0||t<0) {
			System.out.println("n="+n+" s="+s+" t="+t);
			System.out.println("Illegal Parameters!");
			return;
		}
		//constant for victory
		boolean cat = false;
		
		// Initial positions of pray and predator
		Random rand = new Random();
		Point pray = new Point (rand.nextInt(n-1),rand.nextInt(n-1));
		Point predator = new Point (rand.nextInt(n-1),rand.nextInt(n-1));
		
		//Show positions before simulation
		System.out.println("n="+n+" s="+s+" t="+t);
		System.out.println("["+pray.x+";"+pray.y+"]"+"["+predator.x+";"+predator.y+"]");
		if(pray.x==predator.x&&pray.y==predator.y) {
			System.out.println("Catch!");
			return;
		}
		int i = 0;
		while (i < t && cat == false) {
			//Pray and Predator positions are updated
			int [] curPray=positionUpdate(pray,n,s);
			pray.x=curPray[0];
			pray.y=curPray[1];
			int [] curPred=positionUpdate_predator(pray, predator,s,n);
			predator.x=curPred[0];
			predator.y=curPred[1];
			
			System.out.println("["+pray.x+";"+pray.y+"]"+"["+predator.x+";"+predator.y+"]");
			
			//Checks if pray has been caught
			if (curPred[0]==curPray[0]&&curPred[1]==curPray[1]) {
				System.out.println("Catch!");
				cat = true;
				}
			i++;
		}
		//checks if predator failed
		if(cat==false) {
			System.out.println("Failure!");
		}
	}
	//////This method create new position for the pray ////////
	public static int[] positionUpdate(Point x,int n, int s) {
		
		//random distance from [-s;s] is added to current position
		 Random rand = new Random();
		 int p1 =x.x-s+rand.nextInt((2*s)+1);
		 int p2 =x.y-s+rand.nextInt((2*s)+1);
		
		 
		 //checks if only the y-coordinate is out of bounds
		 if(p2 < 0 ) {
			 p2 = 0;
		 }else if (p2 >= n) {
			 p2 = n-1;
		 }
		//checks if only the x-coordinate is out of bounds
		 if(p1 < 0) {
			 p1 = 0;
		 }else if (p1 >= n) {
			 p1 = n-1;
		 }
		 
		 int[] Arr = {p1,p2};
		 return Arr;
	}

	public static int[] positionUpdate_predator(Point pray, Point predator,int s, int n) {
		int newP1 = predator.x;
		int newP2 = predator.y;
		
		if (Math.abs(pray.x-predator.x)<=s) {
			newP1 += pray.x-predator.x;
		}
		else if  (Math.abs(pray.x-predator.x)>s){
		    if (pray.x-predator.x<0){
		        newP1+=-s;
		    }
			else{
			    newP1+=s;
			}
		}
		if (Math.abs(pray.y-predator.y)<=s) {
			newP2 += pray.y-predator.y;
		}
		else if (Math.abs(pray.y-predator.y)>s) {
			if (pray.y-predator.y<0){
		        newP2+=-s;
		    }
			else{
			    newP2+=s;
			}
		}
		
		
		int[] Arr = {newP1,newP2};
		return Arr;
	}
}

