package j2eelearn.modules;

/****
 * 
 * @author minesabry 
 * Une interface des différentes méthodes communes aux chapitres mais avec des traitements différents
 *
 */
public interface ChapitreContents {
	public String [] getQuestions ();
	public String [] getReponses ();
	public String getNeeds (int i);
	public String getIntro ();
	String getTextTP ();
}
