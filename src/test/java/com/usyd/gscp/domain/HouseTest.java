package com.usyd.gscp.domain;
import junit.framework.TestCase;

public class HouseTest extends TestCase {
	private House house;
	protected void setUp() throws Exception{
		house = new House();
	}
	public void testSetAndGetId(){
		int id = 1;
		house.setId(id);
		assertEquals(house.getId(),id,0);
	}
	public void testSetAndGetType(){
		String type = "type";
		assertNull(house.getType());
		house.setType(type);
		assertEquals(house.getType(),type);
	}
	public void testSetAndGetDescription(){
		String description = "description";
		assertNull(house.getDescription());
		house.setDescription(description);
		assertEquals(house.getDescription(),description);
	}
	public void testSetAndGetPricePw(){
		int price = 1;
		house.setPrice(price);
		assertEquals(house.getPrice(),price);
	}
	public void testSetAndGetSuburb(){
		String suburb = "suburb";
		assertNull(house.getSubrub());
		house.setSubrub(suburb);
		assertEquals(house.getSubrub(),suburb);
	}
	public void testSetAndGetPostcode(){
		int postcode = 1;
		house.setPostcode(postcode);
		assertEquals(house.getPostcode(),postcode);
	}
	public void testSetAndGetImage(){
		String image = "image";
		assertNull(house.getImage());
		house.setImage(image);;
		assertEquals(house.getImage(),image);
	}
	public void testSetAndGetBedroom(){
		int bedroom = 1;
		house.setBedroom(bedroom);
		assertEquals(house.getBedroom(),bedroom);
	}
	
}
