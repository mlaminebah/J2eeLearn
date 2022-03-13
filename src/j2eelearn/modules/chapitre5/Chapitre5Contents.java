package j2eelearn.modules.chapitre5;

import j2eelearn.modules.ChapitreContents;

/**
 * Cette classe est un singleton qui contient les informations des leçons et Quiz du chapitre 5 ('JSP')
 * On y a fait recours pour tout simplement alléger la lisibilité du code
 */

public class Chapitre5Contents implements ChapitreContents {
	private static Chapitre5Contents instance = null;
	private static String [] info;
    private static String [] questions;
    private static String [] reponses;
    
	private Chapitre5Contents () {
		//TDO: remplir les tableaux info, question, et reponses 
	}
	
	/****
	 * 
	 * @return une instance unique de la classe
	 */
	public static Chapitre5Contents getInstance () {
		if (instance == null) 
			instance = new Chapitre5Contents();
		return instance;
	}
	
	public String [] getQuestions () {
        return questions;
    }

    /****
     * 
     * @return un tableau des réponses possibles du quizz
     */
    public String [] getReponses () {
        return this.reponses;
    }

    //en fonction de l'indice du tableau : la fonction renvoie la chaine correspondante
    public String getNeeds (int i) {
        return this.info [i];
    }
    /** TDO: à remplacer par le bon text
     * 
     * @return une chaine de caractère correspondant au texte de la première page d'accueil du chapitre
     */
    public String getIntro () {
    	return new String ("<html>"+
                "intro Taglibs Le Java EE est une extension de Java ...................<br/>"+
                "........................................................<br/><br/>" +
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "Il permet facilement ...................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "........................................................<br/>"+
                "Bon courage"+
            "</html>");
    }
    /****
     * 
     * @return Le tp ou des tps de cet Chapitres
     */
    public String getTextTP () {
    	return new String ("instruction++++++");
    }
}
