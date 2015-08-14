package com.tarena;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import util.Image;

public class HeroPlane extends FlyingObject{
	static final BufferedImage[] images={Image.getImage("hero0.png"),Image.getImage("hero1.png")};

	
	public HeroPlane(){
	
	img=Image.getImage("hero0.png");
	width=img.getWidth();
	height=img.getHeight();
	x=150;
	y=400;
}
/*
 * Ӣ�ۻ�����ķ���
*/
	int bullettime=0;
	final static int SINGLE_BULLET=20;
	int fire=SINGLE_BULLET*3;//20����1���ӵ���40����2�ţ�60����3�ţ�����������������
public List<Bullet> shoot(){
	List<Bullet> bulletList=new ArrayList<Bullet>();
	if(bullettime%10==0)
	{
	if(fire<=20){
		int bulletY=y-20;
		int bulletX=x+width/2;
		Bullet bullet=new Bullet(bulletX, bulletY) ;
		bulletList.add(bullet);
	}else{
		int num=fire/SINGLE_BULLET;
		num=num>5?5:num;
		int bulletY=y-20;
		for(int i=0;i<num;i++){
			int bulletX=x+width/(num+1)*i;
			Bullet b=new Bullet(bulletX, bulletY) ;
			bulletList.add(b);
		}
		
	}
	}
	bullettime++;
	return bulletList;
}
public void moveTo(int x2, int y2) {
	// TODO Auto-generated method stub
	this.x=x2-width/2;
	this.y=y2-height/2;
}
int index=0;
@Override
public void step() {
	// TODO Auto-generated method stub
	img=images[index++/30%(images.length)];
	
}

@Override
boolean OUtOfBound() {
	// TODO Auto-generated method stub
	return false;
}

}
