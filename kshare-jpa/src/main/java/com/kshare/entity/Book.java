package com.kshare.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
//@DiscriminatorValue(value = "book")
@PrimaryKeyJoinColumn(name = "book_Id")
public class Book extends Publication{

private int pages;

public Book(int pages) {
	super("Fight");
	this.pages = pages;
}

public Book() {
	super("Love");
}

public int getPages() {
	return pages;
}

public void setPages(int pages) {
	this.pages = pages;
}

}
