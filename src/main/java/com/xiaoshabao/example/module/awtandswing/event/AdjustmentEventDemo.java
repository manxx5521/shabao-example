package com.xiaoshabao.example.module.awtandswing.event;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Scrollbar;
import java.awt.TextField;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdjustmentEventDemo extends Frame{
	private static final long serialVersionUID = 5560141900906761472L;
	Scrollbar slider;
	TextField value;
	Label label;
	
	public AdjustmentEventDemo(){
		super("滚动条");
		init();
	}
	public void init(){
		setLayout(new GridLayout(1,3));//设置网格布局管理器
		slider=new Scrollbar(Scrollbar.HORIZONTAL,0,1,0,100);//方向，初始值，可见量，最小，最大
		//注册调整事件监听
		slider.addAdjustmentListener(new AdjustmentEventHandler());
		value=new TextField("0",5);//初始化为0，有5位数
		value.setEditable(false);//设置不可编辑
		label=new Label("0~100");
		label.setBackground(Color.CYAN);
		add(label);//添加到frame
		add(slider);
		add(value);
		setSize(300,50);
		setVisible(true);
		addWindowListener(new WindowAdapter(){//窗口适配
			@Override
			public void windowClosing(WindowEvent evt){ //实现windowClosing
				setVisible(false);  //设置窗口不可见
				dispose();   //释放窗口组件资源
				System.exit(0);  //关闭窗口
			}
			
		});
	}

	public static void main(String[] args) {
		new AdjustmentEventDemo();
	}
	//监听处理
	class AdjustmentEventHandler implements AdjustmentListener{
		//实现adjustmentVauleChanged方法
		@Override
		public void adjustmentValueChanged(AdjustmentEvent eve){
			value.setText(Integer.toString(((Scrollbar)eve.getSource()).getValue()));
			     //设置了value的值
		}
	}

}


