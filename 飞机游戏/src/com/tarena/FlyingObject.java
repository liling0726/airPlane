package com.tarena;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class FlyingObject {
	int width;//��
	int height;//��
	int x;
	int y;
	BufferedImage img;//ͼƬ
	Random random=new Random();
	public abstract void step();
	abstract boolean OUtOfBound();//true����Խ��
}
