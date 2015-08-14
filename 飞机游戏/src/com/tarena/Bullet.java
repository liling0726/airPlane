package com.tarena;

import java.util.Random;

import util.Image;

public class Bullet extends FlyingObject{
 int speed=3;
 public Bullet(int x,int y){
		img=Image.getImage("bullet.png");
		width=img.getWidth();
		height=img.getHeight();
		this.x=x-width/2;
		this.y=y;
 }
	@Override
	boolean OUtOfBound() {
		// TODO Auto-generated method stub
		if(y<=-height)
			return true;
		return false;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		y=y-speed;
	}

}
