package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//  0-jackets 1-hoodies 2-shorts 3-shoes
    private int categoryId;
    private String name;
//  1-men 2-women 3-kid 
    private int gender;
    private double price;
    private short stack;
    private String image;

    /**
     * @return the id
     */
    public int getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
	this.id = id;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
	return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the price
     */
    public double getPrice() {
	return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
	this.price = price;
    }

    /**
     * @return the stack
     */
    public short getStack() {
	return stack;
    }

    /**
     * @param stack the stack to set
     */
    public void setStack(short stack) {
	this.stack = stack;
    }

    /**
     * @return the gender
     */
    public int getGender() {
	return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(int gender) {
	this.gender = gender;
    }

    /**
     * @return the image
     */
    public String getImage() {
	return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
	this.image = image;
    }
  

}
