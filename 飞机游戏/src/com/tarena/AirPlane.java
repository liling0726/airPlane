package com.tarena;

import java.util.Random;

import javax.swing.JPanel;

import util.Image;

public class AirPlane extends FlyingObject{
	int speed=2;
	JPanel jp;
public AirPlane(JPanel jp){
	this.jp=jp;
	img=Image.getImage("airplane.png");
	width=img.getWidth();
	height=img.getHeight();
	x=random.nextInt(400-width);
	y=-height;
}
//�ӵ��򵽷ɻ�
public void hit(Bullet bullet){
	int x1=x-bullet.width;
	int x2=x+width;
	int y1=x-bullet.height;
	int y2=x+height;
}

//����ͼƬ�ص��γ�����������
@Override
public void step() {
	// TODO Auto-generated method stub
	y=y+speed;
}
@Override
boolean OUtOfBound() {
	// TODO Auto-generated method stub
	if(y>=jp.getHeight())
		return true;
	else return false;
}
}
