package com.tarena;

import java.awt.image.BufferedImage;
import java.util.Random;

public abstract class FlyingObject {
	int width;//宽
	int height;//高
	int x;
	int y;
	BufferedImage img;//图片
	Random random=new Random();
	public abstract void step();
	abstract boolean OUtOfBound();//true代表越界
}
