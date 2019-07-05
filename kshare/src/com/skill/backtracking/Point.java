package com.skill.backtracking;

public class Point {
	int r = 0;
	int c = 0;
	public Point() {
		// TODO Auto-generated constructor stub
	}
	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
@Override
public String toString() {
	return "("+r+","+c+")";
}	
}
