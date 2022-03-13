package j2eelearn.modules.chapitre2;

import j2eelearn.modules.ChapitreContents;

/**
 * Cette classe est un singleton qui contient les informations des leçons et Quiz du chapitre 2 ('JSP')
 * On y a fait recours pour tout simplement alléger la lisibilité du code
 */

public class Chapitre2Contents implements ChapitreContents {
	private static Chapitre2Contents instance = null;
	private static String [] info;
    private static String [] questions;
    private static String [] reponses;
    
	private Chapitre2Contents () {
		//TDO: remplir les tableaux info, question, et reponses 
	}
	
	/****
	 * 
	 * @return une instance unique de la classe
	 */
	public static Chapitre2Contents getInstance () {
		if (instance == null) 
			instance = new Chapitre2Contents();
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
    /**
     * 
     * @return une chaine de caractère correspondant au texte de la première page d'accueil du chapitre
     */
    public String getIntro () {
    	return new String ("<html>"+
                "intro 2 Le Java EE est une extension de Java ...................<br/>"+
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
