package com.snake.frame;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;

import com.snake.snake.SnakePanel;

public class SnakeFrame extends JFrame implements ActionListener {
	//����Ϸ����
	SnakePanel p = new SnakePanel(this);
	//�˵���
	JMenuBar menubar = new JMenuBar();
	//�ļ��˵�
	JMenu fileMenu = new JMenu("�ļ�");
	JMenuItem startItem = new JMenuItem("��ʼ");
	JMenuItem pauseItem = new JMenuItem("��ͣ");
	JMenuItem runItem = new JMenuItem("����");
	JMenuItem exitItem = new JMenuItem("�˳�");
	//���ò˵�
	JMenu optionMenu = new JMenu("����");
		//�ȼ��˵�
		JMenu degreeMenu = new JMenu("�ȼ�");
		JRadioButtonMenuItem lowItem = new JRadioButtonMenuItem("����");
		JRadioButtonMenuItem midItem = new JRadioButtonMenuItem("�м�");
		JRadioButtonMenuItem hightItem = new JRadioButtonMenuItem("�߼�");
		ButtonGroup degreeGroup = new ButtonGroup();
		//show grid�˵�
		JCheckBoxMenuItem showGridItem = new JCheckBoxMenuItem("��ʾ����");
	//�����˵�
		JMenu helpMenu = new JMenu("����");
		JMenuItem helpItem = new JMenuItem("����ָ��");
	//��Ϸ�ٶ�
		private long speed = 0;
	//�����ĵ�	
		String helpStr = "you know that~";
		public JTextField scoreField;
	
	//������
	public SnakeFrame(){
		setJMenuBar(menubar);
		fileMenu.add(startItem);
		fileMenu.add(pauseItem);
		fileMenu.add(runItem);
		fileMenu.add(exitItem);
		menubar.add(fileMenu);
		
		lowItem.setSelected(true);
		degreeGroup.add(lowItem);
		degreeGroup.add(midItem);
		degreeGroup.add(hightItem);
		degreeMenu.add(lowItem);
		degreeMenu.add(midItem);
		degreeMenu.add(hightItem);
		optionMenu.add(degreeMenu);
		showGridItem.setSelected(true);
		optionMenu.add(showGridItem);
		helpMenu.add(helpItem);
		menubar.add(optionMenu);
		menubar.add(helpMenu);
		Container contentPanel = getContentPane();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(p);
		JPanel scorePanel = new JPanel();
		JLabel scoreLabel = new JLabel("��  �֣�");
		scoreField = new JTextField("0",15);
		scoreField.setEnabled(false);
		scoreField.setHorizontalAlignment(0);
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreField);
		contentPanel.add(scorePanel);
		
		startItem.addActionListener(this);
		pauseItem.addActionListener(this);
		runItem.addActionListener(this);
		exitItem.addActionListener(this);
		lowItem.addActionListener(this);
		midItem.addActionListener(this);
		hightItem.addActionListener(this);
		helpItem.addActionListener(this);
		showGridItem.addActionListener(this);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startItem){
			p.startGame(speed);
		}else if(e.getSource()==pauseItem){
			p.stopGame();
		}else if(e.getSource()==runItem){
			p.returnGame();
		}else if(e.getSource()==exitItem){
			System.exit(0);
		}else if(e.getSource()==lowItem){
			speed = 200;
		}else if(e.getSource()==midItem){
			speed = 100;
		}else if(e.getSource()==hightItem){
			speed = 50;
		}else if(e.getSource()==showGridItem){
			if(!showGridItem.isSelected()){
				p.setBackground(Color.lightGray);
			}else{
				p.setBackground(Color.darkGray);
			}
		}
		else if(e.getSource()==helpItem){
			JOptionPane.showConfirmDialog(p, helpStr, "ָ��", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
