package j2eelearn.modules.chapitre1;
import java.awt.BorderLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import j2eelearn.utils.Utils;
/****
 * 
 * @author minesabry
 * Cette classe gère le quiz du chapitre 1
 *
 */
public class Quiz1 {
	private JPanel pane;
	private JButton valider;
	private JLabel aprLab;
	
	// Les Questions
	private String [] questions = Chapitre1Contents.getInstance().getQuestions(); 
	
    //Les réponses possibles
	private String [] reponses =  Chapitre1Contents.getInstance().getReponses();
	
	private HashMap<Integer, JRadioButton [] > reponse;
	private HashMap<Integer, JLabel [] > notes;
	private Utils ut = Utils.getInstance();
	
	
	public Quiz1 () {
		this.pane = new JPanel (new BorderLayout());
		JPanel questionsPane = new JPanel (new GridLayout (questions.length,2));
		JPanel paneValider = new JPanel (new FlowLayout(FlowLayout.RIGHT));
		JPanel appreciations = new JPanel (new BorderLayout());
		this.aprLab = new JLabel ();
		
        this.reponse = ut.initMapRes(this.reponses, this.reponses);
		        this.notes = ut.initMapNote(questions.length);
		
		for (int i = 0; i < questions.length ; i ++) {
			questionsPane.add(ut.question(questions[i],this.reponse.get(i+1),this.notes.get(i+1)));
		}
		
		this.valider = new JButton("Valider");
		
		valider.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				//TDO: en supposant que les bonnes reponses sont r1,r5,r9,r10,r14 : refaire en changeant
                //simplement les indices lors de l'appel ut.isS(reponse.get(i))
				int nbTrue = 0;
				ut.hideAllNote(notes);
				if (ut.isS(reponse.get(1),0))  {
					ut.showNote (notes.get(1),0);
					nbTrue ++;
				} else ut.showNote (notes.get(1),1);
				
				if (ut.isS(reponse.get(2),1)) {
					ut.showNote (notes.get(2),0);
					nbTrue ++;
				} else ut.showNote (notes.get(2),1);
			
	
				if (ut.isS(reponse.get(3),2)) {
					ut.showNote (notes.get(3),0);
					nbTrue ++;
				} else ut.showNote (notes.get(3),1);
					
				if (ut.isS(reponse.get(4),0)) {
					ut.showNote (notes.get(4),0);
					nbTrue ++;
				} else ut.showNote (notes.get(4),1);
				
				if (ut.isS(reponse.get(5),1)) {
					ut.showNote (notes.get(5),0);
					nbTrue ++;
				} else ut.showNote (notes.get(5),1);
				
				double val =  ((double)nbTrue/(double)questions.length)*100;
				String rep;
				if (val < 50) {
					rep = new String("<html>Avec "+val+"% de réussite<br/>"+ 
						 "Nous vous conseillons<br/>"+"de revoir le chapitre"+"</html>");
					aprLab.setText(rep);
					aprLab.setForeground(Color.RED);
				}
				else {
					rep = new String("<html>Avec "+(val)+"% de réussite<br/>"+"Vous pouvez passer <br/>"+"au suivant sans crainte"+"</html>");
					aprLab.setText(rep);
					aprLab.setForeground(new Color(0x008000));
				}
				aprLab.setVisible(true);

			}
		});
		
		valider.setBackground(new Color (0x228be6));
        valider.setFont(new Font("Serif",Font.BOLD|Font.PLAIN,15));
        valider.setForeground(Color.WHITE);
		appreciations.add(aprLab,BorderLayout.NORTH);
		appreciations.setBorder(new EmptyBorder(40,0,0,50));
		aprLab.setVisible(false);
		paneValider.add(valider);
		
		pane.add(questionsPane,BorderLayout.WEST);
		pane.add(appreciations,BorderLayout.EAST);
		pane.add(paneValider,BorderLayout.SOUTH);
		
	}
	
	public JPanel getPane () {
		return this.pane;
	}
	
}
