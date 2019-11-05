import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
* Rhet Kelly
* 10/25/19
* Project_08A
*
* Displays a list of cones.
*/

public class IceCreamConeList2
{
   private String listName;
   private IceCreamCone[] coneList = new IceCreamCone[100];
   private int elements;

/**
* @param listNameIn input for the name
* @param coneListIn input for the list
* @param elementsIn input for the number of cones
*/

   public IceCreamConeList2(String listNameIn, IceCreamCone[] coneListIn,
      int elementsIn) 
   {
      listName = listNameIn;
      coneList = coneListIn;
      elements = elementsIn;             
   }

/**
* @return returns the name of the list
*/

   public String getName()
   {
      return listName;
   }
   
   /**
   * @return returns the list size
   */
   
   public int numberOfIceCreamCones()
   {
      return elements;
   }

/**
* @return returns the surface area
*/

   public double totalSurfaceArea()
   {
      double total = 0;
      int index = 0;
      while (index < elements)
      {
         total += coneList[index].surfaceArea();
         index++;
      }
      return total;
   }
   
   /**
   * @return returns the total volume
   */
   
   public double totalVolume()
   {
      double total = 0;
      int index = 0;
      while (index < elements)
      {
         total += coneList[index].volume();
         index++;
      }
      return total;
   }
   
   /**
   * @return returns average surface area
   */
   
   public double averageSurfaceArea()
   {
      double total = 0;
      int index = 0;
      
      if (elements > 0)
      {
         while (index < elements)
         {
            total += coneList[index].surfaceArea();
            index++;
         }
         total = total / elements;
         
      }
      return total;
   }
   
   /**
   * @return returns the average volume
   */
   
   public double averageVolume()
   {
      double total = 0;
      
      if (elements > 0)
      {
         int index = 0;
         while (index < elements)
         {
            total += coneList[index].volume();
            index++;
         }
      
         total = total / elements;
      }
      return total;
   }
   
   /**
   * @return returns the string
   */
   
   public String toString()
   {
      String result = listName + "\n";
      int index = 0;
      while (index < elements)
      {
         result += "\n" + coneList[index] + "\n";
         index++;
      }
      return result;
   }
   
   /**
   * @return returns cone information
   */
   
   public String summaryInfo()
   {
      DecimalFormat dFmt = new DecimalFormat("#,##0.0##");
      String result = "";
      return ("\n----- Summary for " + getName() + " -----")
         + ("\nNumber of IceCreamCone Objects: " + numberOfIceCreamCones())
         + ("\nTotal Surface Area: ") + dFmt.format(totalSurfaceArea())
         + ("\nTotal Volume: ") + dFmt.format(totalVolume())
         + ("\nAverage Surface Area: ") + dFmt.format(averageSurfaceArea())
         + ("\nAverage Volume: ") + dFmt.format(averageVolume())
         + ("\n");
   }
   
   
   /**
   * @return array list of ice cream cones.
   */
   
   public IceCreamCone[] getList()
   {
      return coneList;
   }
   
   /**
   * @throws FileNotFoundException for reading the file.
   * @param fileName is the file name.
   * @return returns the list
   */
   
   public IceCreamConeList2 readFile(String fileName)
      throws FileNotFoundException
   {
      Scanner scanFile = new Scanner(new File(fileName));
      listName = scanFile.nextLine();
      
      if (new File(fileName) == null)
      {
         return null;
      }
      
      while (scanFile.hasNext())
      {
         String labelIn = scanFile.nextLine();
         double radiusIn = Double.parseDouble(scanFile.nextLine());
         double heightIn = Double.parseDouble(scanFile.nextLine());
      
         IceCreamCone newCone = new IceCreamCone(labelIn, radiusIn, heightIn);
         coneList[elements] = newCone;
         elements++;
      }
      
      IceCreamConeList2 newConeList = new IceCreamConeList2(listName,
         coneList, elements);
      return newConeList;
   
   }
   
   /**
   * @param labelIn is the label.
   * @param radiusIn is the radius.
   * @param heightIn is the height.
   */
   
   public void addIceCreamCone(String labelIn, double radiusIn, double heightIn)
   {
      Scanner scan = new Scanner(System.in);
   
      IceCreamCone coneAdd = new IceCreamCone(labelIn, radiusIn, heightIn);
      coneList[elements] = coneAdd;
      elements++;
   
   }
   
   /**
   * @param labelIn is the label.
   * @return returns the result.
   */
   
   public IceCreamCone findIceCreamCone(String labelIn)
   {
      IceCreamCone result = null;
      for (int i = 0; i < elements; i++)
      {
         if (coneList[i].getLabel().equalsIgnoreCase(labelIn))
         {
            result = coneList[i];
            break;
         }
      }
      return result;
   }
   /**
   * @param labelIn is the label.
   * @return returns the result.
   */
   
   public IceCreamCone deleteIceCreamCone(String labelIn)
   {
      IceCreamCone result = null;
      
      for (int i = 0; i < elements; i++) {
         if (coneList[i].getLabel().equalsIgnoreCase(labelIn)) {
            result = coneList[i];
            for (int j = i; j <= elements - 1; j++)
            {
               coneList[j] = coneList[j + 1];
            }
            coneList[elements - 1] = null;
            elements--;
            break;
         }
      }
      return result;
   }
   
   /**
   * @param labelIn is the label.
   * @param radius is the radius.
   * @param height is the height.
   * @return returns the result.
   */
   
   public boolean editIceCreamCone(String labelIn, double radius, double height)
   {
      IceCreamCone result = null;
      boolean a = false;
      
      for (int i = 0; i < elements; i++)
      {
         if (coneList[i].getLabel().equalsIgnoreCase(labelIn))
         {
            coneList[i].setRadius(radius);
            coneList[i].setHeight(height);
            result = coneList[i];
            a = true;
         }
      }
   
      return a;
   }
   /**
   * @return returns the result
   */
   public IceCreamCone findIceCreamConeWithShortestRadius()
   {
      IceCreamCone result;
      if (elements <= 0)
      {
         result = null;
      }
      else
      {
         double min = coneList[0].getRadius();
         result = coneList[0];
         for (int i = 1; i < elements; i++)
         {
            if (coneList[i].getRadius() < min)
            {
               min = coneList[i].getRadius();
               result = coneList[i];
            }
         }
      }
      return result;
   }
   /**
   * @return returns the result
   */
   public IceCreamCone findIceCreamConeWithLongestRadius()
   {
      IceCreamCone result;
      if (elements <= 0)
      {
         result = null;
      }
      else
      {
         double max = coneList[0].getRadius();
         result = coneList[0];
         for (int i = 1; i < elements; i++)
         {
            if (coneList[i].getRadius() > max)
            {
               max = coneList[i].getRadius();
               result = coneList[i];
            }
         }
      }
      return result;
   }
   /**
   * @return returns the result
   */
   public IceCreamCone findIceCreamConeWithSmallestVolume()
   {
      IceCreamCone result;
      if (elements <= 0)
      {
         result = null;
      }
      else
      {
         double min = coneList[0].volume();
         result = coneList[0];
         for (int i = 1; i < elements; i++)
         {
            if (coneList[i].volume() < min)
            {
               min = coneList[i].volume();
               result = coneList[i];
            }
         }
      }
      return result;
   }
   /**
   * @return returns the result
   */
   public IceCreamCone findIceCreamConeWithLargestVolume()
   {
      IceCreamCone result;
      if (elements <= 0)
      {
         result = null;
      }
      else
      {
         double max = coneList[0].volume();
         result = coneList[0];
         for (int i = 1; i < elements; i++)
         {
            if (coneList[i].volume() > max)
            {
               max = coneList[i].volume();
               result = coneList[i];
            }
         }
      }
      return result;
   }
   
   

}