// Lab09astv100.java
// Janee Yeak
// 14 December 2020
// The purpose of this lab is to demonstrate knowledge of creating 
// a class with object methods, instantiate multiple objects of the 
// created class, and then call the object methods from the main 
// program method.  Additionally, this lab requires knowledge of the 
// GUI input output and string to number conversion.

import java.util.Scanner;

public class Lab09bstv100
{
   private static int num1, den1;   // numerator and denominator of the 1st rational number
   private static int num2, den2;   // numerator and denominator of the 2nd rational number

   public static void main (String[] args)
   {
      enterData();

      Rational r1 = new Rational(num1,den1);
      Rational r2 = new Rational(num2,den2);
      Rational r3 = new Rational();

     	Rational mul = Rational.multiply(r1,r2);
      System.out.println("\n\n" + r1.getOriginal() + " * " + r2.getOriginal() + "  =  " + mul.getReduced());
      Rational div = Rational.divide(r1,r2);
      System.out.println("\n" + r1.getOriginal() + " / " + r2.getOriginal() + "  =  " + div.getReduced());
      Rational add = Rational.add(r1,r2);
      System.out.println("\n" + r1.getOriginal() + " + " + r2.getOriginal() + "  =  " + add.getReduced());
      Rational sub = Rational.subtract(r1,r2);
      System.out.println("\n" + r1.getOriginal() + " - " + r2.getOriginal() + "  =  " + sub.getReduced());
      System.out.println();
   }

   public static void enterData()
   {
      Scanner input = new Scanner(System.in);
      System.out.print("\nEnter the 1st numerator ----> ");
      num1 = input.nextInt();
      System.out.print("\nEnter the 1st denominator --> ");
      den1 = input.nextInt();
      System.out.print("\nEnter the 2nd numerator ----> ");
      num2 = input.nextInt();
      System.out.print("\nEnter the 2nd denominator --> ");
      den2 = input.nextInt();
   }
}

class Rational
{
   private int firstNum;      	// entered numerator
   private int firstDen;      	// entered denominator
   private int reducedNum;  	   // reduced numerator
   private int reducedDen;  	   // reduced denominator
   private int gcf;              // greatest common factor
   
  public Rational()
  {
     int firstNum;
     int firstDen;
  }
   
  public Rational(int num1, int num2)
  {
     firstNum = num1;
     firstDen = num2;
     reduce();
  }
  
  public int getNum() { return firstNum;}
  public void setNum(int firstNum) { this.firstNum = firstNum;}
  public int getDen() { return firstDen;}
  public void setDen(int firstDen) { this.firstDen = firstDen;}
 
  public int getGCD(int a, int b) 
  {
     
      if (a % b == 0) 
      {
          return b; 
      }
      
	   return getGCD(b, a % b);
  }

  void reduce() 
  {
      int gcd = getGCD(firstNum, firstDen);
      firstNum /= gcd;
      firstDen /= gcd;
   }

  public String getReduced()
  {
     String redND = firstNum + "/" + firstDen;
     return redND;
  }
  
  public String getOriginal()
  {
     String original = this.firstNum + "/" + this.firstDen;
     return original;

  }
  
  public static Rational add(Rational a, Rational b) 
  {
	  int numer = (a.firstNum * b.firstDen) + (b.firstNum * a.firstDen);
	  int denr = a.firstDen * b.getDen();
	  return new Rational(numer, denr);
  }
  
  public static Rational subtract(Rational a, Rational b) 
  {
      int newNum = (a.firstNum * b.firstDen) - (b.firstNum * a.firstDen);
	   int newDen = a.firstDen * b.firstDen;
	   Rational result = new Rational(newNum, newDen);
	   return result;
  }
  
  public static Rational multiply(Rational a, Rational b) 
  {
	   int newNum = a.firstNum * b.firstNum;
	   int newDen = a.firstDen * b.firstDen;
	   Rational result = new Rational(newNum, newDen);
	   return result;
  }
  
  public static Rational divide(Rational a, Rational b) 
  {
	  int newNum = a.firstNum * b.firstDen;
	  int newDen = a.firstDen * b.firstNum;
	  Rational result = new Rational(newNum, newDen);
	  return result;
  }
  
  private void getGCF(int n1,int n2)
  {
      int rem = 0;
      do
      {
         rem = n1 % n2;
         if (rem == 0)
            gcf = n2;
         else
         {
            n1 = n2;
           n2 = rem;
         }
      }
      while (rem != 0);
   }
}
