package LifeGame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UI extends JFrame {
	//public JFrame frame;
	//public Logic[][] m_map;
	//public Graphics g;
	
	public UI() {
		JFrame frame = new JFrame();
		//frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(0,0,480,550);
		setTitle("第0次演化");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Logic[][] m_map=new Logic[30][30];
		m_map=Map.initMap();
		Map.getNumberAroundCell(m_map);
		
		JPanel panel = new JPanel();
		panel.setBounds(0,0,480,550);
		panel.setLayout(null);
		frame.getContentPane().add(panel);
		panel.setBackground(Color.white);
		
		frame.setVisible(true);	
		
		Graphics g=panel.getGraphics();
		
		/*for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				g.setColor(Color.WHITE);
				g.drawRect(i*15, j*15, 15, 15);   //绘制底层的格子
			}*/
		
		g.setColor(Color.WHITE);
		for(int j=0;j<30;j++) {
			g.drawLine(j*15, 0, j*15, 450);
		}
		for(int i=0;i<30;i++) {
			g.drawLine(0, i*15, 450, i*15);
		}
		
		for(int i=0;i<30;i++)
			for(int j=0;j<30;j++)
			{
				if(m_map[i][j].getStatus()==1)
				{
					g.setColor(Color.BLACK);
					g.fillRect(i*15, j*15, 15, 15);   //填充活细胞
				}
			}
		
	
		Time t=new Time(frame, m_map, g);
	}

}
