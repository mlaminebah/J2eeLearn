package j2eelearn.utils;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import j2eelearn.j2eelearn.J2eeLearn;

import javax.swing.SwingConstants; 
import java.awt.*;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.util.HashMap;

/***
 * Cette classe est un singleton pour avoir une seule instance de la classe
 * les attributs et fonctions présentes dans cette classe peuvent être utilisées par plusieurs classes
 * Pour éviter à chaque fois de recharger les images on le fait qu'une fois dans cette classe
 **/
public class Utils {

    private static Utils instance = null;
    private static ImageIcon imgHome;
    private static ImageIcon imgCourse;
    private static ImageIcon imgFaq;
    private static ImageIcon imgGlossaire;
    private static ImageIcon imgSuccess;
    private static ImageIcon imgEchec;
    private static ImageIcon imgHelp;
    
    public static FlowLayout fleft   = new FlowLayout (FlowLayout.LEFT);
    public static FlowLayout fright  = new FlowLayout (FlowLayout.RIGHT);
    public static FlowLayout fcenter = new FlowLayout (FlowLayout.CENTER);
    public static Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    public static Border lineborder = BorderFactory.createLineBorder(new Color(0xB0AFAE));

    private JLabel [] chapitres = {
        new JLabel("SERVLET"),new JLabel("JSP"),new JLabel("MVC"),
        new JLabel("Web Listeners"),new JLabel("TagLib"),new JLabel("Déployer"),
        new JLabel("JSF")};

    public String [] entete = {"Home","Faq","Glossaire","Help"};

    private Utils () {
        //Dans ce constructeur on charge toutes les images une seule fois
        imgCourse    = new ImageIcon (J2eeLearn.class.getResource("/icons/course.png"));
        imgHome      = new ImageIcon (J2eeLearn.class.getResource("/icons/home.png")); 
        imgGlossaire = new ImageIcon (J2eeLearn.class.getResource("/icons/glossaire.png"));
        imgFaq       = new ImageIcon (J2eeLearn.class.getResource("/icons/faq.jpg"));
        imgHelp      = new ImageIcon (J2eeLearn.class.getResource("/icons/help.png"));
        imgEchec     = new ImageIcon (J2eeLearn.class.getResource("/icons/echec.png"));
        imgSuccess   = new ImageIcon (J2eeLearn.class.getResource("/icons/success.png"));

    }

    public static Utils getInstance () {
        if (instance == null) {
            instance = new Utils();
        }
        return instance;
    }

    /*
        args : x pour le height , y pour le width et imgName le nom de l'image sans le path
        retour : 
               - l'imageIcon correspondante dimensionné avec x et y 
               - sinon renvoie une ImageICon vide
    */
    public  static ImageIcon getImageIcon (int x,int y,String imgName) {
        if ("/icons/course.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgCourse.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/home.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgHome.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/glossaire.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgGlossaire.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/faq.jpg".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgFaq.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/help.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgHelp.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/echec.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgEchec.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else if ("/icons/success.png".compareTo("/icons/"+imgName) == 0)
                return new ImageIcon (imgSuccess.getImage().getScaledInstance(x, y, Image.SCALE_SMOOTH));
        else 
                return new ImageIcon();
    }
    /*Cette fonction crée un tableau de label contenant les différents modules ou chapitre qui seront affichés
    sur le bloc de Gauche
    */
    public JLabel [] createChapitre () {

        int i = 0;
        for (i = 0;i < chapitres.length; i ++ ) {
            chapitres[i].setBorder(lineborder);
            chapitres[i].setHorizontalAlignment(SwingConstants.LEFT);
            chapitres[i].setIcon(getImageIcon(25,25,"course.png"));
            chapitres[i].setIconTextGap(10);
            chapitres[i].setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            chapitres[i].setOpaque(true);
        }
        return chapitres;
    }
    public int size () {
        return this.chapitres.length;
    }
    //efface la couleur des jlabels passés en paramètre
    public void eraseBackground (JLabel []labs) {    
        for (int i = 0;  i < labs.length; i ++) {
            labs[i].setBackground(null);
            labs[i].setForeground(Color.BLACK);
         }
     }

    public final String eS (int i) {
        return entete [i];
    }
    
    /****
	 * 
	 * @param responses un tableau de toutes les reponses
	 * @return une HashMap qui  associe à chaque question une liste de 3 reponses
	 */
	public HashMap<Integer, JRadioButton []> initMapRes (String [] responses,String [] reponses ) {
		HashMap<Integer, JRadioButton [] > res = new HashMap<>();
		for (int i = 1, j = 0; i <= reponses.length ; i ++) {
			JRadioButton [] rep = new JRadioButton [3];
			for (int k = 0; k < 3 && j < reponses.length; j ++,k ++) {
				rep [k] = new JRadioButton (responses[j]);
			}
			res.put(i, rep);
		}
		return res;
	}
	/****
	 * 
	 * @param size : le nombre de question
	 * @return une HashMap associe à chaque question 2 JLabel V ou F qui seront affichés en fonction de la reponse selectionnée
	 */
	public HashMap<Integer, JLabel []> initMapNote (int size) {
		HashMap<Integer, JLabel [] > res = new HashMap<>();
		for (int i = 1; i <= size; i ++) {
			JLabel [] note = {new JLabel(getImageIcon (10,10,"success.png")),new JLabel (getImageIcon (10,10,"echec.png"))};
			res.put(i, note);
		}
		return res;
	}
	/****
	 * 
	 * @param question: une question 
	 * @param reponse : la liste des reponses de la question concernée
	 * @param note    : un tableau de label (V,F) qui seront liés à chaque question mais qui restent invisible initialement
	 * @return		  : Un JPanel contenant une question , la liste de reponse à selectionner ainsi que 2 jlabels cachés
	 */
	public JPanel question (String question,JRadioButton [] reponse,JLabel [] note) {
		JPanel quest = new JPanel (new GridLayout(2,1));
		
		ButtonGroup qGroup = new ButtonGroup();
		JPanel btn = new JPanel ();
		for (int i = 0; i < reponse.length; i ++) {
			qGroup.add(reponse[i]);
			btn.add(reponse[i]);
		}
		
		JPanel q = new JPanel ();
		q.add(new JLabel(question));
		for (int i = 0; i < note.length; i ++) {
			q.add(note[i]);
			note[i].setVisible(false);
		}
				
		quest.add(q);
		quest.add(btn);
		return quest;
	}
	
	/****
	 * 
	 * @param b : un tableau de RadioButton
	 * @param i :  l'indice du boutton concerné
	 * @return  : true si le boutton i est selectionné sinon false
	 */
	public boolean isS (JRadioButton []b,int i) {
		return b[i].isSelected();
	}
	/**
	 * cache tous les JLables F et V associés à chaque question
	 */
	public void hideAllNote (HashMap<Integer, JLabel [] > notes) {
		for (int i = 1; i <= notes.size(); i ++) {
			notes.get(i)[0].setVisible(false);
			notes.get(i)[1].setVisible(false);
		}
	}
	/****
	 * Rend visible un JLabel
	 * @param lab : un tableau de JLabel
	 * @param i   : l'indice du JLabel
	 * 	 */
	public void showNote (JLabel [] lab,int i) {
		lab [i].setVisible(true);
	}
	
}

