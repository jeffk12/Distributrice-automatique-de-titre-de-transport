
import java.io.IOException;
import java.util.Scanner;

public class Main {


    //Clavier
    static Scanner scanner = new Scanner(System.in);

    //Gestion du menu precedent
    static String menu_precedent = new String();


    //Entrees au clavier de l'utilisateur à chaque question
    static String choix_categorie = new String();
    static String choix_type = new String();
    static String choix_reduction = new String();
    static String choix_payement = new String();
    static String choix_quitter = new String();
    static String confirmation_payement = new String();

    //variables de tarifs dans la facture final
    static double prix_initial;
    static double prix_final;
    double reduction;
    static final double TPS = 0.05;
    static final double TVQ = 0.09975;

    //variable d'operation de ayement comptant
    static double montant_cash;
    static double monnaie_rendue;


    //Tarifs constants
    static final double PASSAGE_1_ORDINAIRE = 3.50;
    static final double PASSAGE_2_ORDINAIRE = 6.50;
    static final double PASSAGE_10_ORDINAIRE = 30.00;
    static final double PASSAGE_1_ENFANT = 2.50;
    static final double PASSAGE_2_ENFANT = 4.25;
    static final double PASSAGE_10_ENFANT = 19.00;
    static final double PASSAGE_1_65ANS = 1.00;
    static final double PASSAGE_2_65ANS = 2.00;
    static final double PASSAGE_10_65ANS = 9.00;
    static final double SOIREE_ILLIMITEE = 5.75;
    static final double PASSAGE_1_JOUR = 10.00;
    static final double PASSAGE_WEEKEND = 14.50;
    static final double PASSAGE_3_JOUR = 20.50;
    static final double HEBDO_ORDINAIRE = 28.00;
    static final double HEBDO_ENFANT = 16.75;
    static final double HEBDO_65ANS = 8.50;
    static final double MENSUEL_ORDINAIRE = 90.50;
    static final double MENSUEL_ENFANT = 54.00;
    static final double MENSUEL_ETUDIANT = 54.00;
    static final double MENSUEL_65ANS = 27.00;
    static final double QUATRE_MOIS_ENFANT = 212.00;
    static final double QUATRE_MOIS_ETUDIANT = 212.00;
    static final double QUATRE_MOIS_65ANS = 106.00;
    static final double PASSAGE_GROUPE = 19.00;
    static final double YUL_AEROPORT = 10.00;
    static final double PASSAGE_747 = 10.00;


    //Informations de facturation
    static String categorie = new String();
    static String type = new String();
    static String tarif = new String();

    public static void main(String[] args) {

        gestion_menu_categorie();
    }

    /***************************************************************************
     *                      LES MESSAGES D'AFFICHAGES                          *
     **************************************************************************/

    public static void message_bienvenue() {

        System.out.println("******************************************");
        System.out.println("*     Bienvenue a la STM                 *");
        System.out.println("*   Categorie des Titre de transport:    *");
    }

    public static void message_de_Fin() {

        System.out.println("\n\n\n******************************************");
        System.out.println("*********  Merci et a Bientot!   *********");
        System.out.println("******************************************\n\n\n");
    }

    public static void message_confirmation_payement() {

        System.out.println("\n******************************************");
        System.out.println("         CONFIRMATION DE PAYEMENT         ");
        System.out.println("******************************************");
        System.out.println("*  O  Oui                                *");
        System.out.println("*  N  Non                                *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");

    }

    public static void message_reception_payement() {

        System.out.println("\n******************************************");
        System.out.println("              PAYEMENT RECU               ");
        System.out.println("******************************************");
    }

    public static void message_quitter() {

        System.out.println("******************************************");
        System.out.println("*   ETES VOUS SUR DE VOULOIR QUITTER?    *");
    }

    public static void message_erreur_type() {

        System.out.println("******************************************");
        System.out.println("*         ERREUR DE CHOIX DE TYPE        *");
    }


    /***************************************************************************
     *                      LES AFFICHAGES DES MENUS                           *
     **************************************************************************/


    public static void menu_categorie() {

        System.out.println("*   Choisissez une categorie de titre:   *");
        System.out.println("******************************************");
        System.out.println("*  P passage                             *");
        System.out.println("*  S Soirees: journees ou Fin de semaine *");
        System.out.println("*  C abonnement: hebdo mensuel ou 4 mois *");
        System.out.println("*  G Groupe                              *");
        System.out.println("*  A Autre                               *");
        System.out.println("*  Q Quitter                             *");
        System.out.println("******************************************");
        System.out.print("Choisissez une categorie d'abonnement : ");
    }

    public static void menu_P() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez un type de titre:         *");
        System.out.println("******************************************");
        System.out.println("*  1  1                  3,50$           *");
        System.out.println("*  2  2                  6,50$           *");
        System.out.println("*  3  10                 30,00$          *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de titre :           ");
    }

    public static void menu_S() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez un type de titre:         *");
        System.out.println("******************************************");
        System.out.println("*  1  Soiree illimitee    5,00$          *");
        System.out.println("*  2  1 jour             10,00$          *");
        System.out.println("*  3  Week-end illimite  14,00$          *");
        System.out.println("*  4  3 jours            20,00$          *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de titre :           ");
    }

    public static void menu_C() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez un type de titre:         *");
        System.out.println("******************************************");
        System.out.println("*  1  Hebdo              28,00$          *");
        System.out.println("*  2  Mensuel            90,50$          *");
        System.out.println("*  3  4 mois             212,50$         *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de titre :           ");
    }

    public static void menu_G() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez un type de titre:         *");
        System.out.println("******************************************");
        System.out.println("*  1  Groupe             19,00$          *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de titre :           ");
    }

    public static void menu_A() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez un type de titre:         *");
        System.out.println("******************************************");
        System.out.println("*  1  YUL Aeroport       10,00$          *");
        System.out.println("*  2  Passage 747        10,00$          *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de titre :           ");
    }

    public static void menu_Q() {

        System.out.println("*   Choisissez votre prochaine action    *");
        System.out.println("******************************************");
        System.out.println("*  M  Menu Precedent                     *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez une option :                 ");

    }

    public static void menu_Reduction() {

        System.out.println("******************************************");
        System.out.println("*   Choisissez votre reduction:          *");
        System.out.println("******************************************");
        System.out.println("*  1         Enfant                      *");
        System.out.println("*  2         Etudiant                    *");
        System.out.println("*  3         +65 ans                     *");
        System.out.println("*  4         Tarif ordinaire             *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le type de reduction :       ");
    }

    public static void menu_Payement() {

        System.out.println("******************************************");
        System.out.println("*  Choisissez votre mode de payement     *");
        System.out.println("******************************************");
        System.out.println("*  1         Comptant                    *");
        System.out.println("*  2         Debit/Credit                *");
        System.out.println("*  Q  Quitter                            *");
        System.out.println("******************************************");
        System.out.print("Choisissez le mode payement :           ");
    }


    /***************************************************************************
     *                GESTION DE FONCTIONNEMENT DES MENUS                      *
     **************************************************************************/

    public static void gestion_menu_categorie() {

        message_bienvenue();
        menu_categorie();
        menu_precedent = "menu_categorie";
        choix_categorie = scanner.next();

        switch (choix_categorie) {

            case "P":
            case "p":
                categorie = "Passages";
                gestion_menu_P();
                break;
            case "S":
            case "s":
                categorie = "Soirées, Journees ou Fin de semaine";
                gestion_menu_S();
                break;
            case "C":
            case "c":
                categorie = "Abonnements";
                gestion_menu_C();
                break;
            case "G":
            case "g":
                categorie = "Groupe";
                gestion_menu_G();
                break;
            case "A":
            case "a":
                categorie = "Aeroport";
                gestion_menu_A();
                break;
            case "Q":
            case "q":
                message_quitter();
                gestion_menu_Q(menu_precedent);
                break;
            default:
                System.out.println("******************************************");
                System.out.println("*      ERREUR DE CHOIX DE CATEGORIE      *");
                gestion_menu_Q(menu_precedent);
        }
    }

    public static void gestion_menu_P() {

        menu_P();
        menu_precedent = "menu_P";
        choix_type = scanner.next();

        switch (choix_type) {

            case "1":
                type = "1 passage";
                gestion_menu_reduction_1_passage();
                break;
            case "2":
                type = "2 passages";
                gestion_menu_reduction_2_passages();
                break;
            case "3":
                type = "10 passages";
                gestion_menu_reduction_10_passages();
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }
    }

    public static void gestion_menu_S() {

        menu_S();
        menu_precedent = "menu_S";
        choix_type = scanner.next();

        switch (choix_type) {
            case "1":
                type = "Soiree illimitee";
                tarif = "Ordinaire";
                prix_initial = SOIREE_ILLIMITEE;
                break;
            case "2":
                type = "1 journee";
                tarif = "Ordinaire";
                prix_initial = PASSAGE_1_JOUR;
                break;
            case "3":
                type = "Week-end illimitee";
                tarif = "Ordinaire";
                prix_initial = PASSAGE_WEEKEND;
                break;
            case "4":
                type = "Week-end illimitee";
                tarif = "Ordinaire";
                prix_initial = 20.00;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        //On va directement au payement parce qu'il n'ya pas de reduction sur
        //les tarifs Soirées, Journees ou Fin de semaine
        gestion_menu_payement();
    }

    public static void gestion_menu_C() {

        menu_C();
        menu_precedent = "menu_C";
        choix_type = scanner.next();

        switch (choix_type) {
            case "1":
                type = "Hebdomadaire";
                gestion_menu_reduction_hebdo();
                break;
            case "2":
                type = "Mensuel";
                gestion_menu_reduction_mensuel();
                break;
            case "3":
                type = "4 mois";
                gestion_menu_reduction_4_mois();
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }
    }

    public static void gestion_menu_G() {

        menu_G();
        menu_precedent = "menu_G";
        choix_type = scanner.next();

        switch (choix_type) {
            case "1":
                type = "1 adulte + 10 enfants";
                tarif = "Ordinaire";
                prix_initial = PASSAGE_GROUPE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        //On va directement au payement parce qu'il n'ya pas de reduction sur
        //les tarifs de groupe
        gestion_menu_payement();
    }

    public static void gestion_menu_A() {

        menu_A();
        menu_precedent = "menu_categorie";
        choix_type = scanner.next();

        switch (choix_type) {
            case "1":
                type = "YUL_Aeroport";
                tarif = "Ordinaire";
                prix_initial = YUL_AEROPORT;
                break;
            case "2":
                type = "Passage 747-Ouest";
                tarif = "Ordinaire";
                prix_initial = PASSAGE_747;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }


        //On va directement au payement parce qu'il n'ya pas de reduction sur
        //les tarifs du bus 747
        gestion_menu_payement();

    }

    public static void gestion_menu_Q(String menu_precedent) {

        menu_Q();
        choix_quitter = scanner.next();

        switch (choix_quitter) {

            case "m":
            case "M":

                switch (menu_precedent) {

                    case "menu_categorie":
                        gestion_menu_categorie();
                        break;
                    case "menu_P":
                        gestion_menu_P();
                        break;
                    case "menu_S":
                        gestion_menu_S();
                        break;
                    case "menu_C":
                        gestion_menu_C();
                        break;
                    case "menu_G":
                        gestion_menu_G();
                        break;
                    case "menu_A":
                        gestion_menu_A();
                        break;
                    case "menu_reduction_1_passage":
                        gestion_menu_reduction_1_passage();
                        break;
                    case "menu_reduction_2_passages":
                        gestion_menu_reduction_2_passages();
                        break;
                    case "menu_reduction_10_passages":
                        gestion_menu_reduction_10_passages();
                        break;
                    case "menu_reduction_hebdo":
                        gestion_menu_reduction_hebdo();
                        break;
                    case "menu_reduction_mensuel":
                        gestion_menu_reduction_mensuel();
                        break;
                    case "menu_reduction_4_mois":
                        gestion_menu_reduction_4_mois();
                        break;
                    case "menu_payement":
                        gestion_menu_payement();
                        break;
                    case "menu_payement_comptant":
                        gestion_payement_comptant();
                        break;
                    case "menu_confirmation_payement":
                        gestion_confirmation_payement(choix_payement);
                        break;
                    default:
                        break;
                }
                break;
            case "q":
            case "Q":
                message_de_Fin();
                gestion_menu_categorie();
                break;
            default:
                System.out.println("ERREUR DE SAISIE! VEUILLEZ RECOMMENCER");
                gestion_menu_categorie();
        }
    }

    public static void gestion_menu_reduction_1_passage() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_1_passage";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = PASSAGE_1_ENFANT;
                break;
            case "2":
                tarif = "Etudiant";
                prix_initial = PASSAGE_1_ORDINAIRE;
                System.out.println("Pas de reduction disponible");
                break;
            case "3":
                tarif = "+65ans";
                prix_initial = PASSAGE_1_65ANS;
                break;
            case "4":
                tarif = "Ordinare";
                prix_initial = PASSAGE_1_ORDINAIRE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }
        gestion_menu_payement();
    }

    public static void gestion_menu_reduction_2_passages() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_2_passages";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = PASSAGE_2_ENFANT;
                break;
            case "2":
                tarif = "Ordinaire";
                prix_initial = PASSAGE_2_ORDINAIRE;
                System.out.println("Pas de reduction disponible");
                break;
            case "3":
                tarif = "+65 ans";
                prix_initial = PASSAGE_2_65ANS;
                break;
            case "4":
                tarif = "Ordinaire";
                prix_initial = PASSAGE_2_ORDINAIRE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        gestion_menu_payement();

    }

    public static void gestion_menu_reduction_10_passages() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_10_passages";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = PASSAGE_10_ENFANT;
                break;
            case "2":
                tarif = "Ordinaire";
                prix_initial = PASSAGE_10_ORDINAIRE;
                System.out.println("Pas de reduction disponible");
                break;
            case "3":
                tarif = "+65 ans";
                prix_initial = PASSAGE_10_65ANS;
                break;
            case "4":
                tarif = "Ordinaire";
                prix_initial = PASSAGE_10_ORDINAIRE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        gestion_menu_payement();

    }

    public static void gestion_menu_reduction_hebdo() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_hebdo";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = HEBDO_ENFANT;
                break;
            case "2":
                tarif = "Ordinaire";
                prix_initial = HEBDO_ORDINAIRE;
                System.out.println("Pas de reduction disponible");
                break;
            case "3":
                tarif = "+65 ans";
                prix_initial = HEBDO_65ANS;
                break;
            case "4":
                tarif = "Ordinaire";
                prix_initial = HEBDO_ORDINAIRE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        gestion_menu_payement();
    }

    public static void gestion_menu_reduction_mensuel() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_mensuel";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = MENSUEL_ENFANT;
                break;
            case "2":
                tarif = "Etudiant";
                prix_initial = MENSUEL_ETUDIANT;
                break;
            case "3":
                tarif = "+65 ans";
                prix_initial = MENSUEL_65ANS;
                break;
            case "4":
                tarif = "Orinaire";
                prix_initial = MENSUEL_ORDINAIRE;
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        gestion_menu_payement();
    }

    public static void gestion_menu_reduction_4_mois() {

        menu_Reduction();
        choix_reduction = scanner.next();
        menu_precedent = "menu_reduction_4_mois";

        switch (choix_reduction) {

            case "1":
                tarif = "Enfant";
                prix_initial = QUATRE_MOIS_ENFANT;
                break;
            case "2":
                tarif = "Etudiant";
                prix_initial = QUATRE_MOIS_ETUDIANT;
                break;
            case "3":
                tarif = "+65 ans";
                prix_initial = QUATRE_MOIS_65ANS;
                break;
            case "4":
                System.out.println("    Pas offert au tarif ordianire");
                System.out.println("Vous devez avoir une carte au tarif " +
                        "reduit");
                gestion_menu_reduction_4_mois();
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }

        gestion_menu_payement();
    }

    public static void gestion_menu_payement() {

        message_bienvenue();
        affichage_facturation();
        menu_Payement();
        choix_payement = scanner.next();
        menu_precedent = "menu_payement";
        boolean accepted_payment = false;
        boolean quitting = false;

        while (!accepted_payment && !quitting) {
            switch (choix_payement) {

                case "1":
                    gestion_payement_comptant();
                    break;
                case "2":
                    gestion_payement_carte();
                    break;
                case "Q":
                case "q":
                    gestion_menu_categorie();
                    break;
                default:
                    message_erreur_type();
                    gestion_menu_Q(menu_precedent);
            }
        }
        if (accepted_payment)
        {message_de_Fin();}
    }

    public static void gestion_payement_comptant() {

        menu_precedent = "menu_payement_comptant";

        System.out.println("******************************************");


        //Remboursement
        String montant = new String();
        prix_final = prix_initial * (1 + TPS + TVQ);
        do {
            System.out.println("Inserer un montant egale ou superieure a:");
            System.out.print(String.format("%29.2f $\n", prix_final));

            if (scanner.hasNextDouble()) {
                montant_cash = scanner.nextDouble();
                // variable to false
            } else {
                System.out.println("VEUILLEZ ENTRER UN NOMBRE");
                scanner.next();
                gestion_payement_comptant();
            }
        } while (montant_cash < prix_final);

       gestion_confirmation_payement(choix_payement);

        monnaie_rendue = montant_cash - prix_final;
        affichage_facturation();

        System.out.println("\n-------------Remboursement---------------\n");
        System.out.println(String.format("Montant Recue: %14.2f $", montant_cash));
        System.out.println(String.format("Monnaie Rendue: %13.2f $", monnaie_rendue));

        System.out.println("\n------------------------------------------");


    }

    public static void gestion_payement_carte() {

        System.out.println("******************************************");
        System.out.println("Inserer votre carte de credit");

        gestion_confirmation_payement(choix_payement);
    }

    public static void gestion_confirmation_payement(String choix_payement) {

        message_confirmation_payement();
        menu_precedent = "menu_confirmation_payement";
        confirmation_payement = scanner.next();

        switch (confirmation_payement) {
            case "O":
            case "o":
                message_reception_payement();
                break;
            case "N":
            case "n":

                switch (choix_payement){

                    case "1":
                        System.out.println("Retirez votre monnaie et recommencez");
                        break;
                    case "2":
                        System.out.println("Retirez votre carte et recommencez");
                        break;
                    default:

                }

                gestion_menu_payement();
                break;
            case "Q":
            case "q":
                gestion_menu_categorie();
                break;
            default:
                message_erreur_type();
                gestion_menu_Q(menu_precedent);
        }
    }


    public static void affichage_facturation () {


        System.out.println("\n******************************************");
        System.out.println("                 FACTURE                  ");
        System.out.println("******************************************");
        System.out.println("\nCategorie: \t\t" + categorie);
        System.out.println("Type:      \t\t" + type);
        System.out.println("Tarif:     \t\t" + tarif);
        System.out.println(String.format("\nPrix initial: %15.2f $", prix_initial));
        System.out.println(String.format("TPS: %24.2f $", prix_initial * TPS));
        System.out.println(String.format("TVQ: %24.2f $", prix_initial * TVQ));
        System.out.println("------------------------------------------");
        System.out.println(String.format("Prix total: %17.2f $",
                prix_initial * (1 + TPS + TVQ)));
    }
}


