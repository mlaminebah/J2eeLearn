package j2eelearn.modules.chapitre1;


import javax.swing.JLabel;
import javax.swing.JPanel;

import j2eelearn.modules.ChapitreContents;
import j2eelearn.modules.ChapitreEvent;
import j2eelearn.utils.Intros;
import j2eelearn.utils.Utils;

import java.awt.*;
import java.awt.event.*;

/***
 * Cette classe contient les infos et tps du tps ou chapitre1 avec les évnènements qui vont avec
 */
public class Chapitre1 implements ChapitreEvent{
    private JPanel north;
    private JPanel south;
    private JPanel lessonsPane;
    private JPanel tpPanes;
    private JLabel [] lessons = {new JLabel("Définition/"),new JLabel("API Servlet")};
    private JLabel [] tps = {new JLabel("TP1 /"),new JLabel("Quiz 1")};
    
    private ChapitreContents content = Chapitre1Contents.getInstance();
    
    public Chapitre1 (String chap,JPanel north, JPanel south) {
        this.north = north;
        this.south = south;
        this.lessonsPane =  new JPanel(Utils.getInstance().fleft);
        this.tpPanes = new JPanel(Utils.getInstance().fright);

        this.effectLessons(chap);
        this.effectTps(chap);
    }
    
    @Override
    public void effectLessons (String chap) {
        for (int i = 0; i < lessons.length; i ++)
            lessonsPane.add (lessons[i]);
        
        	lessons[0].addMouseListener(new MouseAdapter () {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Utils.getInstance().eraseBackground (lessons);
                        //ut.eraseBackground (tps);
                        lessons[0].setForeground(Color.BLUE);
                        System.out.println(chap+" "+lessons[0].getText());
                        south.removeAll();
                        south.revalidate();
                        JLabel label = new JLabel (content.getIntro());
                        label.setFont(new Font("Serif", Font.ITALIC, 13));
                        south.add(label);
                        south.repaint();
                    }
        });
        lessons[1].addMouseListener(new MouseAdapter () {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Utils.getInstance().eraseBackground (lessons);
                        //ut.eraseBackground (tps);
                        lessons[1].setForeground(Color.BLUE);
                        System.out.println(chap+" "+lessons[1].getText());
                        south.removeAll();
                        south.revalidate();
                        JLabel label = new JLabel (content.getNeeds(0));
                        label.setFont(new Font("Serif", Font.ITALIC, 13));
                        south.add (label);
                        south.repaint();
                    }
        });
    }
    //TDO: cliq tps
    @Override
    public void effectTps (String chap) {
        for (int i = 0; i < tps.length; i ++) 
            tpPanes.add(tps[i]);
        
        tps [0].addMouseListener(new MouseAdapter () {
            @Override
                    public void mouseClicked(MouseEvent e) {
                        Utils.getInstance().eraseBackground (tps);
                        tps[0].setForeground(Color.BLUE);
                        System.out.println(chap+" "+tps[0].getText());
                        south.removeAll();
                        south.revalidate();
                        //TDO: à rajouter sur le JPanel south le text du tp
                        JLabel label = new JLabel (content.getTextTP());
                        label.setFont(new Font("Serif", Font.ITALIC, 13));
                        south.add(label);
                        south.repaint();
                    }
        });
        tps [1].addMouseListener(new MouseAdapter () {
            //Gestion du Quiz1
            @Override
                    public void mouseClicked(MouseEvent e) {
                        Utils.getInstance().eraseBackground (tps);
                        tps[1].setForeground(Color.BLUE);
                        System.out.println(chap+" "+tps[1].getText());
                        south.removeAll();
                        south.revalidate();
                        south.add(new Quiz1().getPane());
                        south.repaint();
                    }
        });
    }
    
    
    @Override
	public JPanel getNorth() {
		// TODO Auto-generated method stub
		return this.north;
	}

	@Override
	public JPanel getSouth() {
		// TODO Auto-generated method stub
		return this.south;
	}

	@Override
	public JPanel getLessonsPane() {
		// TODO Auto-generated method stub
		return this.lessonsPane;
	}

	@Override
	public JPanel getTpsPane() {
		// TODO Auto-generated method stub
		return this.tpPanes;
	}

}
