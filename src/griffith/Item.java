package griffith;

public class Item {
	//Private properties to store item details
      private String name;// Name of the item
      private double basePrice;// Base price of the item
      private double vat;// Vat rate of the item
      
      public Item(String name, double basePrice, double vat) {
    	  this.name= name;//Initialize name
    	  this.basePrice = basePrice;//Initialize base price
    	  this.vat =vat;//Initialize Vat price
      }
      
      public double salePrice() {
    	  //Method to calculate the sale price
    	  return basePrice * (1 +vat/100);
      }
      
      public String getName() {
    	  //Method to retrieve the name of the item
    	  return name;
      }
      
      public double getBasePrice() {
    	  //Method to retrieve the baseprice of the item
    	  return basePrice;
      }
      public double getVat() {
    	  //Method to retrieve the base price of the tiem
    	  return vat;
      }
}
