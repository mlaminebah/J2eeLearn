package j2eelearn.contents;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import j2eelearn.modules.ChapitreEvent;
import j2eelearn.modules.chapitre1.Chapitre1;
import j2eelearn.modules.chapitre1.Chapitre1Contents;
import j2eelearn.modules.chapitre2.Chapitre2Contents;
import j2eelearn.modules.chapitre3.Chapitre3Contents;
import j2eelearn.modules.chapitre4.Chapitre4Contents;
import j2eelearn.modules.chapitre5.Chapitre5Contents;
import j2eelearn.modules.chapitre6.Chapitre6Contents;
import j2eelearn.modules.chapitre7.Chapitre7Contents;
import j2eelearn.utils.Intros;

import java.awt.*;
import java.awt.event.*;
import j2eelearn.utils.Utils;

/***
 * Cette classe est en quelques sorte le coeur de fonctionnement de la classe EeastPanel
 * En fonction de l'évnènement sur le panel de l'entête ou celui à droite un nouveau JPanel est créé pour changer
 * le EastPanel
 * Vous remarquerez le bloc du milieu est divisé en 2 . C'est pourquoi cette classe compose 2 JPanels south et north
 */
public  class BodyPane {
    private JPanel pane;
    private JPanel south;
    private JPanel north;
    private JLabel tit;

    public BodyPane (String titre,int etat) {
        this.pane = new JPanel(new BorderLayout(10, 10));
        this.pane.setBorder(new EmptyBorder(25,15,15,15));
        this.north = new JPanel (new GridLayout (2,1));//north qui est constitué de 2 lignes
        south = new JPanel(); //le south qui contient les informations de la page

        if (titre.compareTo("Home") == 0) { 
            createNorth("Bienvenue Chez J2eeLearn",etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        } else {
            createNorth(titre,etat);
            this.pane.add (this.north,BorderLayout.NORTH);
        }
        
        tit = new JLabel();//le titre
        createSouth(titre);
        this.pane.add(south);
    }
    //le nouveau JPanel renvoyé
    public JPanel getPane () {
        return this.pane;
    }
    //modifie le JPanel du nord
    private void createNorth (String titre,int etat) {
        JPanel titrePane = new JPanel(Utils.getInstance().fcenter);
		this.north.setBorder(Utils.getInstance().lineborder);
		
        JPanel lessonsPane = new JPanel(Utils.getInstance().fleft);//un panel des lessons du module ou chapitre
        JPanel tpsPane     = new JPanel(Utils.getInstance().fright);//un panel des tps du module ou chapitre
        JPanel lessons     = new JPanel();

        if (etat != 0) {
            lessons = ChapsPane(titre,etat);
        }  else {
                tit = new JLabel (titre);
        }

        tit.setFont(new Font("Serif", Font.PLAIN, 30));
		titrePane.add(tit);

        this.north.add(titrePane);
		this.north.add(lessons);
    }
    //modifie le panel du sud
    private void createSouth (String action) {
		this.south.setBorder(Utils.getInstance().lineborder);
        this.south.add(creatConteHome(),BorderLayout.NORTH);
        switch (action) {
            case "Home":
                this.south.removeAll();
                this.south.add(creatConteHome(),BorderLayout.NORTH);
            break;
            case "Faq":
                this.south.removeAll();
                //TDO: faire le nécessaire pour la FAQ
            break;
            case "Glossaire":
                this.south.removeAll();
                //TDO: faire le nécessaire pour le glossaire
            break;
            case "Help":
                this.south.removeAll();
                //TDO: faire le nécessaire pour le help
            break;
            default:
                this.south.removeAll();
                this.south.add(createChapIntro(action),BorderLayout.NORTH);
            break;
            
        }
        south.revalidate();
        south.repaint();
    }

   //en fonction du titre chap ou autres des informations sont affichées
    //pour les chapitre ou module par défaut c'est l'intro qui est affiché
    public JPanel createChapIntro (String chap) {
        JPanel home = new JPanel(Utils.getInstance().fleft);
        String mgs = new String ("");
        switch (chap) {
            case "SERVLET":
                mgs = Chapitre1Contents.getInstance().getIntro();//intro chap1
            break;
            case "JSP":
                mgs = Chapitre2Contents.getInstance().getIntro();//intro chap2
            break;
            case "MVC":
                mgs = Chapitre3Contents.getInstance().getIntro();//intro chap3
            break;
            case "Web Listeners":
                mgs =  Chapitre4Contents.getInstance().getIntro();//intro chap4
            break;
            case "TagLib":
                //TDO: à remplacer par les bonnes info
                mgs = Chapitre5Contents.getInstance().getIntro();//intro chap5
            break;
            case "Déployer":
                //TDO: à remplacer par les bonnes info
                mgs = Chapitre6Contents.getInstance().getIntro();//intro chap6
            break;
            case "JSF":
                //TDO: à remplacer par les bonnes info
                mgs = Chapitre7Contents.getInstance().getIntro();//intro chap7
            break;
            default:
                mgs = Intros.getInst().homeText();//message d'accueil
            break;
        }
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }
    //gestion des lessons du module ou chapitre avec les évènements qui vont avec
    private JPanel eventLessons (String chap) {
        JPanel lessonsPane = new JPanel(Utils.getInstance().fleft);
        this.tit = new JLabel(chap);
        ChapitreEvent ch;
        switch (chap) {
            case "SERVLET":
                ch = new Chapitre1(chap, north, south);
                lessonsPane = ch.getLessonsPane();//panel lessons du chapitre ou module 1
                this.north =  ch.getNorth();
                this.south = ch.getSouth();
            break;
            case "JSP":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 2
                this.tit = new JLabel("Java Server Pages");
            break;
            case "MVC":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 3
                this.tit = new JLabel("Architecture MVC");
            break;
            case "Web Listeners":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 4
            break;
            case "TagLib":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 5
                this.tit = new JLabel("Création d'une Librairie de Tags");
                
            break;
            case "Déployer":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe chapitre 
                this.tit = new JLabel("Déploiement War & Tomcat");
            break;
            case "JSF":
                //TDO : créer une classe pour ce chapitre en s'inspirant de la classe Déployer
                this.tit = new JLabel("Java Server Faces");
            break;
        }
        return lessonsPane;
    }
    //gestion des Tps du module ou chapitre avec les évènements qui vont avec
    private JPanel eventsTps (String chap) {
        JPanel tpsPane = new JPanel(Utils.getInstance().fright);
        ChapitreEvent ch;
        switch (chap) {
            case "SERVLET":
                ch = new Chapitre1(chap, north, south);
                tpsPane = ch.getTpsPane();//le Panel TP & Quiz de ce chapitre ou module
                this.north =  ch.getNorth();
                this.south = ch.getSouth();
            break;
            case "JSP":
                //TDO: Faire de meeme pour le chapitre ou module 2 : Classe Chapitre 
            break;
            case "MVC":
                //TDO:
            break;
            case "Web Listeners":
                //TDO:
            break;
            case "TagLib":
            //TDO:
            break;
            case "Déployer":
                //TDO:
            break;
            case "JSF":
            //TDO:
            break;
        }
        return tpsPane;
    }
    //pour le chapitre chap concerné un JPanel contenant ses leçons et ses Tps et Quiz
    private JPanel ChapsPane (String chap,int etat) {
        JPanel lessons = new JPanel(new GridLayout(1,2));
        lessons.add(eventLessons(chap));
		lessons.add(eventsTps(chap));
        return lessons;
    }
    //
    public JPanel creatConteHome () {
        JPanel home = new JPanel(Utils.getInstance().fleft);
        String mgs = Intros.getInst().homeText();
        JLabel label = new JLabel (mgs);
        label.setFont(new Font("Serif", Font.ITALIC, 13));
        home.add(label);
        return home;
    }
 
}
