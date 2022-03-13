package j2eelearn.modules.chapitre2;

import javax.swing.JLabel;
import javax.swing.JPanel;

import j2eelearn.modules.ChapitreContents;
import j2eelearn.modules.ChapitreEvent;
import j2eelearn.modules.chapitre1.Chapitre1Contents;

//TDO: à faire
public class Chapitre2 implements ChapitreEvent {
	private JPanel north;
    private JPanel south;
    private JPanel lessonsPane;
    private JPanel tpPanes;
    private JLabel [] lessons = {new JLabel("Définition/"),new JLabel("API Servlet")};//TDO:contenu à modifier
    private JLabel [] tps = {new JLabel("TP1 /"),new JLabel("Quiz 1")};//TDO: contenu à modifier
    
    private ChapitreContents content = Chapitre2Contents.getInstance();
    
    public Chapitre2 (String chap,JPanel north, JPanel south) {
    	//TDO:
    }
    
	@Override
	public void effectLessons(String chap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void effectTps(String chap) {
		// TODO Auto-generated method stub
		
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
