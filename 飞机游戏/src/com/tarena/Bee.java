package com.tarena;

import java.util.Random;

import javax.swing.JPanel;

import util.Image;

public class Bee extends FlyingObject{
 final static 	int LEFT=0;
 final static 	int RIGHT=1;;
	int direction;//0代表左方，1代表右方
	int speedx=3;
	int speedy=1;
	JPanel jp;
public Bee(JPanel jp){
	this.jp=jp;
	img=Image.getImage("bee.png");
	width=img.getWidth();
	height=img.getHeight();
	x=random.nextInt(jp.getWidth()-width);
	y=-height;
	direction=random.nextInt(2);
}
	@Override
	boolean OUtOfBound() {
		if(y>=jp.getHeight())
			return true;
		else return false;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		y=y+speedy;
		if(direction==LEFT){
			x=x-speedx;
			if(x<=0)
				direction=RIGHT;
		}
		else if(direction==RIGHT){
			x=x+speedx;
			if(x>=jp.getWidth()-width)
				direction=LEFT;
		}
	}

}
