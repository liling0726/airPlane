package com.tarena;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import util.Image;

public class FlyPanel extends JPanel{
	HeroPlane hero=new HeroPlane();
	
	ArrayList<FlyingObject>  flyings=new ArrayList<FlyingObject>();
	List<Bullet> bulletList=new ArrayList<Bullet>();
	public FlyPanel(){
		/**
		 * �������ϵĵ���¼�
		 * ʹ״̬��0--��1,��ʼ��Ϸ
		*/
		class MyMouseListener extends MouseAdapter{
			
		
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//״̬��0--��1
				status=Constant.RUNNING;
			}	
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				if(status==Constant.RUNNING){
					int x=e.getX();
					int y=e.getY();
					hero.moveTo(x,y);
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				if(status==Constant.PAUSE){
					status=Constant.RUNNING;
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if(status==Constant.RUNNING){
					status=Constant.PAUSE;
				}
			}
		}
		MyMouseListener lister=new MyMouseListener();
		 addMouseListener(lister);
		 addMouseMotionListener(lister);
		 
		 /*
		  * �ػ�
		 */
			class MyTimerTask extends TimerTask{

				public void flyingStep(){
					hero.step();
					for(int i=0;i<flyings.size();i++)
					{
						flyings.get(i).step();
				
					}
					//�ӵ���һ��
					for(int i=0;i<bulletList.size();i++)
					{
						bulletList.get(i).step();
				
					}
				}
				int count=0;//����
				Random rand=new Random();
				public void enter(){
					if(count%100==0)
					{int type=rand.nextInt(20);
						if(type==0||type==10)
						{
							Bee bee=new Bee(FlyPanel.this);
							flyings.add(bee);
						}
						else{
					AirPlane airplane=new AirPlane(FlyPanel.this);
					flyings.add(airplane);
					}
					
					}
					count++;
				}
				public void  checkOutOfBound(){
					for(int i=0;i<flyings.size();i++)
					{
					if(flyings.get(i).OUtOfBound())
					{
						flyings.remove(i);
						i--;
						//System.out.println("Խ��");
					}
					}
					for(int j=bulletList.size()-1;j>=0;j--){
						if(bulletList.get(j).OUtOfBound())
						{
							bulletList.remove(j);//�ӵ�ɾ��
			
							//System.out.println("Խ��");
						}
					}
				}
				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(status==Constant.RUNNING){
						//�������볡
						enter();
						
						//��������һ��
						flyingStep();
						//���
						bulletList.addAll(hero.shoot());
						//���Խ��
						checkOutOfBound();
					}
					repaint();
				}
				
			}
			MyTimerTask task =new MyTimerTask();
			Timer timer=new Timer();
			timer.schedule(task, 10,10);

	}
	@Override
	/*
	 * ����ϻ�ͼ
	*/
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		paintBackgound(g);
		paintScoreAndLife(g);
		paintHeroPlane(g);
		paintFlyings(g);
		paintStatus(g);
		
	}
	private void paintFlyings(Graphics g) {
		// TODO Auto-generated method stub
		//�۷��С�ɻ�
		for(int i=0;i<flyings.size();i++)
		g.drawImage(flyings.get(i).img, flyings.get(i).x,flyings.get(i).y, null);
	//�ӵ�
		for(int j=0;j<bulletList.size();j++)
		g.drawImage(bulletList.get(j).img, bulletList.get(j).x,bulletList.get(j).y, null);
	}
	private void paintHeroPlane(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(hero.img, hero.x,hero.y, null);
	}
	/*��Ϸ״̬ 
	 * 0����ready
	1����running,
	2����pause 
	3 ���� gameover
	*/
	int status=0;
	private void paintStatus(Graphics g) {
		// TODO Auto-generated method stub
		switch(status){
		case Constant.READY:
			
			BufferedImage ready=Image.getImage("start.png");
			g.drawImage(ready, 0, 0, null);
			break;
		case Constant.RUNNING:
			;break;
		case Constant.PAUSE:
			BufferedImage pause=Image.getImage("pause.png");
			g.drawImage(pause, 0, 0, null);break;
		case Constant.GAMEOVER:BufferedImage gameover=Image.getImage("gameover.png");
		g.drawImage(gameover, 0, 0, null);break;
		}
		
	}
	private void paintBackgound(Graphics g) {
		// TODO Auto-generated method stub
	
		
		//�Զ������
		BufferedImage img=Image.getImage("background.png");
		g.drawImage(img, 0, 0, null);
		}
	//������Ϸ������
	void paintScoreAndLife(Graphics g){
		Font font=new Font("΢���ź�",Font.BOLD,20);
		g.setFont(font);
		Color color=new Color(225,30,49);
		g.setColor(color);
		g.drawString("SCORE:0", 20, 30);
		g.drawString("LIFE:3", 20, 50);
	}

}
