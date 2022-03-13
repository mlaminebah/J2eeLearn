package j2eelearn.modules.chapitre1;

import j2eelearn.modules.ChapitreContents;

/**
 * Cette classe est un singleton qui contient les informations des leçons et Quiz du chapitre 1 ('servlet')
 * On y a fait recours pour tout simplement alléger la lisibilité du code
 */
public class Chapitre1Contents implements ChapitreContents {
    private static Chapitre1Contents inst = null;
    private static String [] info;
    private static String [] questions;
    private static String [] reponses;
    
    private Chapitre1Contents () {
        info = new String [] {
            ("<html>"
            + " <h2>Qu’est ce que l’API servlet ?</h2>"
			+ "    <p>"
			+ "        C’ est un ensemble d'interfaces et de classes Java, rangées dans les packages <strong>javax.servlet</strong> et <strong>javax.servlet.http</strong>"
			+ "        <ol><li><b>avax.servlet :</b> contient les classes pour développer des serlvets génériques indépendantes d'un protocole</li>"
			+ "        <li><b>javax.servlet.http :</b> contient les classes pour développer des servlets qui reposent sur le protocole http utilisé par les serveurs web.</li>"				+ "        </ol>"
			+ "    </p>"
            + " <p><b>Voici plusieurs interfaces, méthodes  et exceptions définis dans javax.servlet</b></p>"
            + "    <table border =\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"693\">"
            + "        <td>Javax.servlet</td><td>Nom</td><td>Rôle</td></tr>"
            + "        <tr><td rowspan=\"7\">Les interfaces</td><td>RequestDispatcher</td><td>Définition d'un objet qui permet le renvoi d'une requête vers une autre ressource du serveur (une autre servlet, une JSP .....)</td></tr>"
            + "        <tr><td>Servlet</td><td>Définition de base d'une servlet</td></tr>"
            + "        <tr><td>ServletConfig</td><td>Définition d'un objet pour configurer la servle</td></tr>"
            + "        <tr><td>ServletContext</td><td>Définition d'un objet pour obtenir des informations sur le contexte d'exécution de la servlet</td></tr>"
            + "        <tr><td>ServletRequest</td><td>Définition d'un objet contenant la requête du client</td></tr>"
            + "        <tr><td>ServletResponse </td><td>Définition d'un objet qui contient la réponse renvoyée par le servlet</td></tr>"
            + "        <tr><td>SingleThreadModel</td><td>Permet de définir une servlet qui ne ré pondra qu'à une seule requête à la fois </td></tr>"
            + "        <tr><td rowspan=\"3\">Les Classes</td><td>GenericServlet</td><td>Classe définissant une Servlet indépendante de tout protocole</td></tr>"
            + "        <tr><td>ServletInputStream</td><td>Flux permettant la lecture de données de la requête cliente</td></tr>"
            + "        <tr><td>ServletOutPutStream</td><td>Flux permettant l'envoi de la réponse de la Servlet</td></tr>"
            + "        <tr><td rowspan=\"2\" >Les Exceptions</td><td>ServletException</td><td>Exception générale en cas de problème durant l'exécution de la servlet</td></tr>"
            + "        <tr><td>UnavailableException</td><td>Exception levé si la servlet n'est pas disponible</td></tr>"
            + "    </table><br/>"
            + "    </table><br/>"
			+ "	   <h2>L’interface Servlet</h2>"
			+ "    <p>"
			+ "        Une servlet est une classe Java qui implémente l'interface javax.servlet.Servlet.<br/>"
			+ "        Cette interface définit 5 méthodes  qui permettent au conteneur web de dialoguer<br/>"				+ "        avec la servlet : elle encapsule ainsi les méthodes nécessaires à la communication<br/>"
			+ "        entre le conteneur et la servlet."
			+ "    </p>"
			+ "    <table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"800\">"
			+ "            <tr><td>Méthode</td> <td >Rôle</td></tr>"
			+ "            <tr><td>void service (ServletRequest res,ServletResponse res)</td><td>Cette méthode est exécutée par le conteneur lorsque la servlet est sollicitée : chaque requête du client déclenche une seule exécution de cette ressources.Cette méthode pouvant être exécutée par plusieurs threads,"
			+ "                il faut prévoir un processus d’exclusion pour l’utilisation de certaines ressources</td></tr>"
			+ "            <tr><td>Void init(ServletConfig conf)</td> <td>Initialisation de la servlet. Cette méthode est appelée une"
			+ "                seule fois après l’instanciation de la servlet. Aucun traitement ne peut être effectué par la servlet tant que l’exécution de cette méthode n’est pas terminée.</td></tr> "
			+ "            <tr><td>ServletConfig getServletConfig()</td> <td>Renvoie l’objet ServletConfig passé à la méthode init() </td></tr>"
			+ "            <tr><td>Void destroy()</td><td>Cette méthode est appelée lors de la destruction de la"				+ "                servlet. Elle permet de libérer proprement certaines ressources (fichiers, bases de données …). C’est le serveur qui appelle cette méthode </td></tr>   "
			+ "            <tr><td>String getServletInfo()</td><td>Renvoie des informations sur le servlet</td></tr>"
			+ "    </table>"
            + "</html>"),
        };
        //Les questions posées : TDO : à remplacer par les bonnes
        questions = new String [] {
			"Question 1 :........................................?",
			"Question 2 :........................................?",
			"Question 3 :........................................?",
			"Question 4 :........................................?",
			"Question 5 :........................................?"
        };
        //Les réponses possibles : TDO : à remplacer par les bonnes
        reponses = new String [] {
            "reponse  1","reponse  2","reponse  3","reponse  4","reponse 5",
			"reponse 6","reponse 7","reponse 8","reponse 9","reponse10",
			"reponse11","reponse12","reponse13","reponse14","reponse15"
        };
    }

    public static Chapitre1Contents getInstance () {
        if (inst == null) {
            inst = new Chapitre1Contents();
        }
        return inst;
    }

    /****
     * 
     * @return le tableau des questions du quiz
     */
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
                "<p>Une <strong>servlet</strong> est un programme qui s'exécute côté serveur <br/>en tant qu'extension du serveur.Elle reçoit une requête du client, <br/>elle effectue des traitements et renvoie le résultat.<br/> Une servlet peut être invoquée plusieurs fois en même temps <br/>pour répondre à plusieurs requêtes simultanées.<br/>"+
                "La liaison entre la servlet et le client peut être directe <br/>ou passer par un intermédiaire comme par exemple un serveur <strong>http</strong>.</p>"+
                "<p>Son fonctionnement en <strong>HTTP</strong>  se présente ainsi :<p/>"+
                "<ol>"+
                    "<li>Le serveur reçoit du navigateur la requête <strong>http</strong> qui a recours à une <strong>servlet</strong></li>"+
                    "<li>Si c'est la première sollicitation de la servlet, le serveur l'instancie.<br/>Les servlets sont stockés (sous forme de fichiers .class) <br/>dans un répertoire particulier du serveur.<br/>Ce répertoire dépend du serveur d'applications utilisé.<br/>"+
                    "La servlet reste en mémoire jusqu'à l'arrêt du serveur.<br/>Certains serveurs d'applications permettent aussi d'instancier <br/>des servlets dès le lancement du serveur.<br/>"+
                    "Au fil des requêtes, la servlet peut être appelée par plusieurs <br/>threads lancés par le serveur. Ce principe de fonctionnement évite <br/>d'instancier un objet de type servlet à chaque requête <br/>et permet de maintenir un ensemble de ressources <br/>actives telles qu'une connexion à une base de données</li>"+
                    "<li>Le serveur crée un objet qui représente la requête http ainsi que <br/>l'objet qui contiendra la réponse et les envoie à la <strong>servlet</strong></li>"+
                    "<li>La servlet crée dynamiquement la réponse sous forme de page html <br/>transmise par un flux dans l'objet contenant la réponse. <br/>La création de cette réponse utilise bien sûr la requête du client<br/> mais aussi un ensemble de ressources incluses sur le serveur <br/>telles que des fichiers ou des bases de données.</li>"+
                    "<li>Le serveur récupère l'objet réponse et envoie la page html au client.</li>"+
                    "</ol></html>"
        );
    }
    /****
     * 
     * @return Le tp ou des tps de cet Chapitres
     */
    public String getTextTP () {
    	return new String ("instruction++++++");
    }
}
