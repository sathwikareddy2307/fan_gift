package com.edubridge.fanapp.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.fanapp.model.Fan;
import com.edubridge.fanapp.service.FanService;
import com.edubridge.fanapp.service.FanServiceImpl;

public class FanMain {
	public static void main(String[] args) {

		FanService service = new FanServiceImpl();
		Fan c = null;

		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("Welcome to Fan App");
			System.out.println("*********");
			System.out.println("1. Add Fan");
			System.out.println("2. View Fan");
			System.out.println("3. Search Fan");
			System.out.println("4. Update Fan");
			System.out.println("5. Delete Fan");
			System.out.println("6. Delete All Fan");
			System.out.println("0. Exit");
			System.out.println("Please choose the Option");
			option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("ADD NEW FAN");
				System.out.println("----------------");
				System.out.println("Please enter brand");
				String brand = in.next();
				System.out.println("Please enter colour");
				String colour = in.next();
				System.out.println("Please enter price");
				Float price = in.nextFloat();
				System.out.println("Please enter rating");
				float rating = in.nextFloat();
				c = new Fan();
				c.setBrand(brand);
				c.setColour(colour);
				c.setPrice(price);
				c.setRating(rating);

				int status = service.addFan(c);
				if (status == 1) {
					System.out.println("New fan Added!");
				} else {
					System.out.println("Something is wrong");
				}

				break;
			case 2:
				System.out.println("view Fan");
				List<Fan> fans = service.findFan();
				System.out.println("ID\tBRAND\tCOLOUR\tPRICE\tRATIING");
				System.out.println("-----\t-----\t-----\t------");
				for (Fan fan : fans) {
					System.out.println(fan.getId() + "\t" + fan.getBrand() + "\t" + fan.getColour() + "\t"
							+ fan.getPrice()+"\t"+fan.getRating());
				}
				break;
			case 3:

				System.out.println("Search Fan BY Brand");
				System.out.println("Please enter Fan brand");
				brand = in.next();

				Fan searchFan = service.findFanByBrand(brand);

				if (searchFan != null) {
					System.out.println("Fanfound:");
					System.out.println(searchFan.getId() + "\t" + searchFan.getBrand() + "\t"
							+ searchFan.getColour() + "\t" + searchFan.getPrice()+"\t"+searchFan.getRating());

				} else {
					System.out.println("Fan not found.");
				}
				break;

			case 4:
				
				System.out.println("Update Fan");
				System.out.println("Please enter Fan brand");
				brand = in.next();
				searchFan = service.findFanByBrand(brand);

				if (searchFan != null) {
					System.out.println(searchFan.getId() + "\t" + searchFan.getBrand() + "\t"
							+ searchFan.getColour() + "\t" + searchFan.getPrice()+"\t"+searchFan.getRating());

					System.out.println("Please enter Fan brand");
					 brand = in.next();
					System.out.println("Please enter fan colour");
					colour = in.next();
					System.out.println("Please enter fan price");
					price = in.nextFloat();
					System.out.println("Please enter fan rating");
					rating = in.nextFloat();
					// System.out.println("Plzz Enter id");
					// int id = in.nextInt();

					Fan updateFan = new Fan();

					updateFan.setBrand(brand);
					updateFan.setColour(colour);
					updateFan.setPrice(price);
					updateFan.setRating(rating);
					updateFan.setId(searchFan.getId());

					int updateStatus = service.updateFan(updateFan);

					    if (updateStatus == 1) {
						
						 System.out.println("Updated Succesfully");
						
					   } else {
						
						System.out.println("SomeThing is wrong Added");
					  }
					
				} else {
					
					System.out.println("No fan found with name");
					
				}
				break;
			case 5:
				System.out.println("Delete Fan");
				System.out.print("Plese enter fan brand : ");
				brand= in.next();
				
				searchFan = service.findFanByBrand(brand);
				if(searchFan != null) {
					
					int deleteStatus = service.deleteFanByBrand(brand);
				    if(deleteStatus==1) {
				    	System.out.println("Deleted Successfully");
				    }else {
				    	System.out.println("somthing went wrong");
				    }
				}else {
					System.out.println("No Fan Found");
				}
				
				break;
			case 6:
				System.out.println("Are Uh Sure delete all Fans[Y/N]");
				String deleteConformStatus=in.next();
				
				if(deleteConformStatus.equalsIgnoreCase("Y")) {
				   service.deleteAllFan();
				   System.out.println("All Fans are Deleted");
				}
				
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");
				break;

			}

		} while (option != 0);
	}

}
