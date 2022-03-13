package j2eelearn.modules.chapitre7;

import javax.swing.JLabel;
import javax.swing.JPanel;

import j2eelearn.modules.ChapitreContents;
import j2eelearn.modules.ChapitreEvent;

public class Chapitre7 implements ChapitreEvent{
	private JPanel north;
    private JPanel south;
    private JPanel lessonsPane;
    private JPanel tpPanes;
    private JLabel [] lessons = {new JLabel("Définition/"),new JLabel("API Servlet")};//TDO:contenu à modifier
    private JLabel [] tps = {new JLabel("TP1 /"),new JLabel("Quiz 1")};//TDO: contenu à modifier
    
    private ChapitreContents content = Chapitre7Contents.getInstance();
    
    public Chapitre7 (String chap,JPanel north, JPanel south) {
    	//TDO:
    }
    @Override
	public void effectLessons(String chap) {
		// TODO Auto-generated method stub : À gérer en s'inspirant des autres chapitres
		
	}

	@Override
	public void effectTps(String chap) {
		// TODO Auto-generated method stub : à gérer en s'inspirant des autres chapitres
		
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
