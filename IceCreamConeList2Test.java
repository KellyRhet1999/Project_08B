import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.io.FileNotFoundException;

/**
   */
public class IceCreamConeList2Test {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   /**
   */
   @Test public void getTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 3);
   
      Assert.assertEquals("getName test", "label", myList.getName());
      Assert.assertEquals("getList test", coneList, myList.getList());
   }
   /**
   */
   @Test public void numberOfIceCreamConesTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 3);
   
      Assert.assertEquals("numberOfIceCreamCones test", 3, 
         myList.numberOfIceCreamCones());
   }
   /**
   */
   @Test public void totalSurfaceAreaTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      IceCreamCone d = new IceCreamCone("label", 12.3, 25.5);
      coneList[0] = c;
      coneList[1] = d;
      IceCreamConeList2 myList = new IceCreamConeList2("label", 
         coneList, 1);
   
      Assert.assertEquals("totalSurfaceArea test", c.surfaceArea(), 
         myList.totalSurfaceArea(), .001);
   }
   /**
   */
   @Test public void totalVolumeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      IceCreamCone d = new IceCreamCone("label", 12.3, 25.5);
      coneList[0] = c;
      coneList[1] = d;
      IceCreamConeList2 myList = new IceCreamConeList2("label",
         coneList, 1);
      
      Assert.assertEquals("totalVolume test", c.volume(),
         myList.totalVolume(), .001);
   }
   /**
   */
   @Test public void averageSurfaceAreaTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      IceCreamCone d = new IceCreamCone("label", 12.3, 25.5);
      coneList[0] = c;
      coneList[1] = d;
      IceCreamConeList2 myList = new IceCreamConeList2("label",
         coneList, 1);
         
      Assert.assertEquals("averageSurfaceArea Test", c.surfaceArea(),
         myList.averageSurfaceArea(), .001);
         
      IceCreamCone[] coneList2 = new IceCreamCone[100];
      IceCreamConeList2 myList2 = new IceCreamConeList2("label", 
         coneList, 0);
      Assert.assertEquals("averageSurfaceArea test for 0 elements",
         0, myList2.averageSurfaceArea(), .001);
   }
   /**
   */
   @Test public void averageVolumeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      IceCreamCone d = new IceCreamCone("label", 12.3, 25.5);
      coneList[0] = c;
      coneList[1] = d;
      IceCreamConeList2 myList = new IceCreamConeList2("label",
         coneList, 1);
         
      Assert.assertEquals("averageVolume test", c.volume(),
         myList.averageVolume(), .001);
   }
   /**
   */
   @Test public void toStringTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      coneList[0] = c;
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList,
         3);
      
      Assert.assertFalse("toString test",
         myList.toString().contains("is a icecone with radius = 1.0 units"));
      
   }
   /**
   */
   @Test public void summaryInfoTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("label", 1, 2);
      coneList[0] = c;
      IceCreamConeList2 myList = new IceCreamConeList2("icecreamcones",
         coneList, 1);
      
      Assert.assertFalse("summaryInfo test",
         myList.summaryInfo().contains("Nunber of Ice Cream Cones: 1"));
    
   }
   /**
   * @throws FileNotFoundException for reading a file
   */
   @Test public void readFileTest() throws FileNotFoundException
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 1);
   
      myList.readFile("IceCreamCone_data_1.txt");
   
      Assert.assertEquals("readFile test", "IceCreamCone Test List", 
         myList.getName());
   }
   /**
   */
   @Test public void addIceCreamConeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 0);
      myList.addIceCreamCone("c", 1, 2);
   
      Assert.assertEquals("addIceCreamCone test", 1,
         myList.numberOfIceCreamCones());
   }
   /**
   */
   @Test public void findIceCreamConeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("Ex1", 1, 2);
      IceCreamCone d = new IceCreamCone("Ex 2", 12.3, 25.5);
      IceCreamCone e = new IceCreamCone("Ex 3", 123.4, 900);
      coneList[0] = c;
      coneList[1] = d;
      coneList[2] = e;
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 3);
   
      Assert.assertEquals("findIceCreamCone test", d,
         myList.findIceCreamCone("Ex 2"));
   }
   /**
   */
   @Test public void deleteIceCreamConeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("Ex1", 1, 2);
      IceCreamCone d = new IceCreamCone("Ex 2", 12.3, 25.5);
      IceCreamCone e = new IceCreamCone("Ex 3", 123.4, 900);
      coneList[0] = c;
      coneList[1] = d;
      coneList[2] = e;
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 3);
      
      myList.deleteIceCreamCone("Ex 2");
      
      Assert.assertEquals("deleteIceCreamCone test", null, coneList[2]);
   }
   /**
   */
   @Test public void editIceCreamConeTest()
   {
      IceCreamCone[] coneList = new IceCreamCone[100];
      IceCreamCone c = new IceCreamCone("Ex1", 1, 2);
      IceCreamCone d = new IceCreamCone("Ex 2", 12.3, 25.5);
      IceCreamCone e = new IceCreamCone("Ex 3", 123.4, 900);
      coneList[0] = c;
      coneList[1] = d;
      coneList[2] = e;
      IceCreamConeList2 myList = new IceCreamConeList2("label", coneList, 3);
      
      myList.editIceCreamCone("Ex 2", 2, 3);
      
      Assert.assertEquals("editIceCreamCone test", 2, coneList[1].getRadius(),
         .001);
   }
   /**
   */
   @Test public void findIceCreamConeWithShortestRadiusTest()
   {
   
   }
   /**
   */
   @Test public void findIceCreamConeWithLongestRadiusTest()
   {
   
   }
   /**
   */
   @Test public void findIceCreamConeWithLargestVolumeTest()
   {
   
   }
   /**
   */
   @Test public void findIceCreamConeWithSmallestVolumeTest()
   {
   
   }


   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 0, 1);
   }**/
}
