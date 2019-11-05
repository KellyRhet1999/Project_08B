import java.util.Scanner;
import java.io.FileNotFoundException;
/**
* Rhet Kelly
* 10/25/19
* Project_08A
* Gives user options for a cone.
*/

public class IceCreamConeList2MenuApp
{
/**
* @param args Command line arguments (not used).
* @throws FileNotFoundException for scanning file.
*/

   public static void main(String[] args) throws FileNotFoundException
   {
      char choice = 'Q';
      String labelIn = "";
      double radiusIn = 0;
      double heightIn = 0;
      String fileName = "";
   
      String coneListName = "*** no list name assigned ***";
      IceCreamCone[] coneList = new IceCreamCone[100];
      int num = 0;
      IceCreamConeList2 noConeList = new IceCreamConeList2(coneListName, 
         coneList, num);
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Cone List System Menu"
         + "\nR - Read File and Create IceCreamCone List"
         + "\nP - Print IceCreamCone List"
         + "\nS - Print Summary"
         + "\nA - Add IceCreamCone"
         + "\nD - Delete IceCreamCone"
         + "\nF - Find IceCreamCone"
         + "\nE - Edit IceCreamCone"
         + "\nQ - Quit");
      
      do
      {
         System.out.print("Enter Code [R, P, S, A, D, F, E, or Q]: ");
         choice = scan.nextLine().toUpperCase().charAt(0);
         
         
         
         switch (choice)
         {
            case 'R':
               System.out.print("\tFile name: ");
               fileName = scan.nextLine();
               noConeList = noConeList.readFile(fileName);
               
               System.out.println("\tFile read in and IceCreamCone"
                  + " List created");
               System.out.println("");
                  
               break;
               
            case 'P':
               System.out.println(noConeList.toString());
               break;
               
            case 'S':
               System.out.println(noConeList.summaryInfo());
               break;
               
            case 'A':
               IceCreamCone addIceCreamCone = new IceCreamCone(labelIn,
                  radiusIn, heightIn);
                  
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
               addIceCreamCone.setLabel(labelIn);
               
               System.out.print("\tRadius: ");
               radiusIn = Double.parseDouble(scan.nextLine());
               addIceCreamCone.setRadius(radiusIn);
               
               System.out.print("\tHeight: ");
               heightIn = Double.parseDouble(scan.nextLine());
               addIceCreamCone.setHeight(heightIn);
                  
               System.out.println("\t*** IceCreamCone added ***");
               System.out.println("");
               break;
               
            case 'D':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
            
               if (noConeList.deleteIceCreamCone(labelIn) == null) {
                  System.out.println("\t\"" + labelIn + "\" not found\n");
                 
               }
               else {
                  System.out.println("\t\"" + labelIn + "\" deleted\n");
               }
               break;
               
            case 'F':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
            
               if (noConeList.findIceCreamCone(labelIn) == null)
               {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
                  
               }
               else
               {
                  System.out.println(
                     noConeList.findIceCreamCone(labelIn).toString());
                  System.out.println("");
               }
               break;
               
            case 'E':
               System.out.print("\tLabel: ");
               labelIn = scan.nextLine();
               
               System.out.print("\tRadius: ");
               radiusIn = Double.parseDouble(scan.nextLine());
               
               System.out.print("\tHeight: ");
               heightIn = Double.parseDouble(scan.nextLine());
               
               if (noConeList.findIceCreamCone(labelIn) == null)
               {
                  System.out.println("\t\"" + labelIn + "\" not found");
                  System.out.println("");
               }
               else
               {
                  noConeList.editIceCreamCone(labelIn, radiusIn, heightIn);
                  System.out.println("\t\""
                     + labelIn + "\" successfully edited");
                  System.out.println("");
               }
               break;
               
            case 'Q':
               
               break;
               
            default:
               System.out.println("\t*** invalid code ***");
               System.out.println("");
         }
      
      } while (choice != 'Q');
   
   
   
   
   }
}