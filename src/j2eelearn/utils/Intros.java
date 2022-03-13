package j2eelearn.utils;
/*
Cette classe est un singleton et contient les texts d'intros des chapitres ou modules
*/
//TDO : il faudra après remplacer les textes par les bons
public class Intros {
    private static Intros intro = null;
    private static String [] intros;

    private Intros () {
        //TDO : Ses différents textes doivent être remplacés par les bons
        intros = new String [] {
            new String ("<html>"+
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
                "</ol></html>"),
            new String ("<html>"+
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
            "</html>"),
            new String ("<html>"+
                    "intro 3 Le Java EE est une extension de Java ...................<br/>"+
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
            "</html>"),
            new String ("<html>"+
                "intro 4 Le Java EE est une extension de Java ...................<br/>"+
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
            "</html>"),
            new String("<html>"+
                "intro 5 Le Java EE est une extension de Java ...................<br/>"+
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
            "</html>"),
            new String ("<html>"+
                "intro 6 Le Java EE est une extension de Java ...................<br/>"+
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
            "</html>"),
            new String ("<html>"+
                "intro 7 Le Java EE est une extension de Java ...................<br/>"+
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
            "</html>"),
            new String ( "<html>"+
                "J2eeLearn est un plugin qui a pour but de vous aider à monter en<br/>"+
                "compétences sur l'ecosystème Java EE<br/><br/>" +
                "Durant tout le long de cet apprentissage vous serez guidé et vous aurez des<br/>"+
                "tp guidés à faire pour chaque chapitre, mais aussi des quiz non obligatoires que vous<br/>"+
                "pourrez passer pour situer vos connaissances<br/><br/>"+
                "Avant d'aborder ce cours il vous faut les prérequis suivants :<br/>"+
                "<ul> <li>Avoir installer java sur sa machine</li>"+
                "<li>Éclipse qui fonctionne</li>"+
                "<li>Savoir programmé en java (notions de classe,objet,héritage,interface,<br/>"+
                "...)</li>"+
            "</html>")
        };
    }
    /****
     * 
     * @return une instance unique de notre classe Intros
     */
    public static Intros getInst () {
        if (intro == null)
            intro = new Intros();
        return intro;
    }
    
    /***
     * 
     * @return renvoie le text de la page d'accueil de notre plugin
     */
    public String homeText () {
        return new String ( "<html>"+
                "J2eeLearn est un plugin qui a pour but de vous aider à monter en<br/>"+
                "compétences sur l'ecosystème Java EE<br/><br/>" +
                "Durant tout le long de cet apprentissage vous serez guidé et vous aurez des<br/>"+
                "tp guidés à faire pour chaque chapitre, mais aussi des quiz non obligatoires que vous<br/>"+
                "pourrez passer pour situer vos connaissances<br/><br/>"+
                "Avant d'aborder ce cours il vous faut les prérequis suivants :<br/>"+
                "<ul> <li>Avoir installer java sur sa machine</li>"+
                "<li>Éclipse qui fonctionne</li>"+
                "<li>Savoir programmé en java (notions de classe,objet,héritage,interface,<br/>"+
                "...)</li>"+
            "</html>");
    }
}
