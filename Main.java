package com.company;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	public static boolean moreInput() {
		System.out.println("Would you like to find a body mass index? Y/N");
		String answer;

		Scanner yn = new Scanner(System.in);
		answer = yn.nextLine();

		if ((answer.charAt(0) == 'Y') || (answer.charAt(0) == 'y'))
			return true;
		if ((answer.charAt(0) != 'N') || (answer.charAt(0) != 'n')) {
			System.out.println("please enter a Y or y or N or n");
			moreInput();
		}
		return false;
	}


	public static double getUserHeight() {
		double height=-1.0;
		Scanner inputs= new Scanner(System.in);

		while(height<=0.0) {
			System.out.println("Please enter a positive height");
			height = inputs.nextDouble();

		}
		return height;
	}


	public static double getUserWeight() {
		double weight = -1.0;
		Scanner inputs=new Scanner(System.in);
		while(weight<=0.0){
			System.out.println("Please enter a positive weight");
			weight=inputs.nextDouble();
		}
		return weight;

	}
	public static void displayBmiInfo(BodyMassIndex bmi){
		System.out.println("Current body mass index is "+bmi);
	}
	public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData) {
		for (int i=0; i<bmiData.size();i++){
			if (bmiData.get(i) < 18.5){
				System.out.println("underweight");
				continue;
			}
			if (bmiData.get(i)< 24.9){
				System.out.println("normal weight");
				continue;
			}
			if (bmiData.get(i) < 29.9) {
				System.out.println("overweight");
				continue;
			}
			System.out.println("obese");
		}
			}

	}


	public static void main(String[] args) {
		ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

		while (moreInput()) {
			double height = getUserHeight();
			double weight = getUserWeight();

			BodyMassIndex bmi = new BodyMassIndex(height, weight);
			bmiData.add(bmi);

			displayBmiInfo(bmi);
		}

		displayBmiStatistics(bmiData);
	}



}
