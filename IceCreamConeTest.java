import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
*
*/

public class IceCreamConeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
/**
*
*/    
   @Before public void setUp() {
   }
/**
*
*/   
   @Test public void gettersSettersTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
   
      Assert.assertEquals("getLabel test", "label", myCone.getLabel());
      Assert.assertEquals("getRadius test", 1, myCone.getRadius(), .001);
      Assert.assertEquals("getHeight test", 2, myCone.getHeight(), .001);
   
      Assert.assertTrue("setLabel test", myCone.setLabel("new label"));
      Assert.assertFalse("setLabel test", myCone.setLabel(null));
   
      Assert.assertTrue("setRadius test", myCone.setRadius(5));
      Assert.assertFalse("setRadius test", myCone.setRadius(-2));
      
      Assert.assertTrue("setHeight test", myCone.setHeight(2));
      Assert.assertFalse("setHeight test", myCone.setHeight(-3));
   }
/**
*
*/   
   @Test public void surfaceAreaTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
   
      Assert.assertEquals("surfaceArea test", ((((1) * (Math.PI)) 
          * (Math.sqrt(Math.pow(2, 2) 
          + Math.pow(1, 2)))) + (Math.pow(1, 2) 
          * Math.PI * 2)), myCone.surfaceArea(),
         .001);
   
   }
/**
*
*/   
   @Test public void volumeTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      
      Assert.assertEquals("volume test", ((((2 * Math.PI) 
         * (Math.pow(1, 2))) / 3) + ((2 * Math.PI 
         * (Math.pow(1, 3))) / 3)), myCone.volume(), .001);
   
   }
/**
*
*/   
   @Test public void toStringTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      
      Assert.assertFalse("toString test", myCone.toString().contains(
         "is a cone with radius = 1.0 units"));
   
   }
/**
*
*/   
   @Test public void getCountTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      myCone.resetCount();
      myCone.getCount();
     
      Assert.assertEquals("getCount test", 0, myCone.getCount());
   
   }
/**
*
*/   
   @Test public void resetCountTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      
      myCone.resetCount();
      Assert.assertEquals(0, myCone.getCount());
   
   }
/**
*
*/   
   @Test public void equalsTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      String myString = "";
      IceCreamCone myCone2 = myCone;
      
      Assert.assertTrue("equals test", myCone.equals(myCone2));
      Assert.assertFalse("equals test", myCone.equals(myString));
   
   }
/**
*
*/   
   @Test public void hashCodeTest()
   {
      IceCreamCone myCone = new IceCreamCone("label", 1, 2);
      Assert.assertEquals("hashCode test", 0, myCone.hashCode());
   
   }


   /** A test that always fails. 
   @Test public void defaultTest() {
      Assert.assertEquals("Default test added by jGRASP. Delete "
            + "this test once you have added your own.", 1, 2);
   }*/
}
