import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

class Ekran extends Canvas{
	int x=200;
	int y=200;	
	static int kolorki;
	ArrayList<Point> punkty = new ArrayList<Point>();	
	Ekran ()
	{		
			super();			
			addKeyListener(new KeyAdapter() 
				{
					public void keyPressed(KeyEvent ke){
					    if(ke.getKeyCode()==KeyEvent.VK_UP)
						    {				    		
					    	y-=20;
						    punkty.add(new Point(x,y)); 
						    }
					    if(ke.getKeyCode()==KeyEvent.VK_DOWN)
						    {
					    	y+=20;
						    punkty.add(new Point(x,y));
						    }
					    if(ke.getKeyCode()==KeyEvent.VK_LEFT)
						    {
					    	x-=20;
						    punkty.add(new Point(x,y));
						    }
					    if(ke.getKeyCode()==KeyEvent.VK_RIGHT)
						    {
					    	x+=20;
						    punkty.add(new Point(x,y));
						    }
					    repaint();
					}
					
			});

			
			
	
	
	
	}
				public void paint(Graphics g)
					{
						x=200;
						y=200;
						Color black = new Color(0, 0, 0);
						Color red = new Color(255, 0, 0);
						Color domyslny = new Color(50,200, 0);
						
						for(Point p:punkty) 
							{		
									g.setColor(domyslny);
									if(kolorki==2) 
										{
											g.setColor(black);
										}
									else if(kolorki==1) 
										{
											g.setColor(red);
										}
								
								g.drawLine(x,y, (int)p.getX(), (int)p.getY());
								x=(int)p.getX();
								y=(int)p.getY();
							}
						
					}

}
public class Labki extends JFrame {
	
	Labki (String nazwa){
		super(nazwa);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}
			public static void main(String args[]){
			
				Labki okno = new Labki("Komunikator");				
				okno.setSize(600,500);
				okno.setLayout(new FlowLayout());
				JPanel a = new JPanel();				
				JCheckBox czerwony = new JCheckBox("Czerwony");
				JCheckBox czarny = new JCheckBox("Czarny");
				okno.add(czerwony, BorderLayout.EAST);
				okno.add(czarny, BorderLayout.EAST);
				czerwony.addActionListener(new B1());
				czarny.addActionListener(new B2());
				if(czerwony.isSelected()==true) 
					{
						
					}
				if(czarny.isSelected()==true) 
					{
											
					}

				JPanel b = new JPanel();
				Ekran e = new Ekran();
				
				e.setSize(400,400);
		        e.setBackground(Color.white);
		        b.add(e);
				okno.add(b);
				okno.add(a);				
				okno.addWindowListener(new WindowAdapter(){
				public void windowClosing(WindowEvent e)
					{
						System.out.println("Dziękujemy za pracę...");
					}
				
				
				
	 });
okno.setVisible(true);
}
			
}// koniec public class Komunikator


class B1 implements ActionListener {
public void actionPerformed(ActionEvent e) {
Ekran.kolorki= 1;
}
}

class B2 implements ActionListener {
public void actionPerformed(ActionEvent e) {
Ekran.kolorki= 2;
}
}