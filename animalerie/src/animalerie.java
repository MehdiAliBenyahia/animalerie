import java.util.Scanner;
class Animaux {
    private String nom;
    private String type;
    private String son;

    Animaux(String n, String t) {
        nom = n;
        if (t != "chat" && t != "chien" && t != "perroquet") {
            System.out.println("entrez un type d'animal valide");
        } else {
            type = t;
        }
        if (t == "chat") {
            son = "miaou";
        } else if (t == "chien") {
            son = "waouf";
        } else if (t == "perroquet") {
            son = "siffle";
        }
    }

    public String GetNom() {
        return nom;
    }

    public String GetType() {
        return type;
    }

    public String GetSon() {
        return son;
    }

    public void SetNom(String n) {
        nom = n;
    }

    public void sonAnimal() {
        if (type == "chat") {

        }
    }

    public void quiSuisJe() {
        System.out.println("Bonjour je m'appelle " + nom + ". Je suis un " + type + " et mon son caracteristique est " + son);
    }

    public void parler() {
        System.out.println(this.GetSon());
    }
}

class Animalerie {
    private Animaux[] listeAnimaux;

    Animalerie(int n) {
        listeAnimaux = new Animaux[n];
    }

    public void add(Animaux a) {
        int i = 0;
        while(listeAnimaux[i] != null) {
            i++;
        }
        if(i > listeAnimaux.length) {
            System.out.print("impossible d'ajouter un animal, veuillez en supprimer un");
        } else {
            listeAnimaux[i] = a;
        }
    }

    public int gettailleliste() {
        return listeAnimaux.length;
    }

    public void suppAnimal(Animaux a) {
        for (int i = 0; i < listeAnimaux.length; i++) {
            Animaux test = listeAnimaux[i];
            if (test == a) {
                listeAnimaux[i] = null;
            }
        }
    }

    public void affiche() {
        for (int i = 0; i < listeAnimaux.length; i++) {
            if(listeAnimaux[i] != null) {
                listeAnimaux[i].quiSuisJe();
            }
        }
    }
}

class InterfaceAnimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bonjour, pour commencer veuillez entrer la taille de votre animalerie supperieure a 0");
        String taille = sc.nextLine();
        Animalerie animalerie = new Animalerie(Integer.parseInt(taille));
        System.out.println("Pour ajouter un animal tapez 1");
        String commencement = sc.nextLine();
        if (commencement.equals("1")) {
            System.out.println("Entrez le nom de l'animal");
            String nomanimal = sc.nextLine();
            System.out.println("Quel est le type de l'animal ? attention : vous ne pouvez choisir qu'entre chien/chat/perroquet");
            String typeanimal = sc.nextLine();
            Animaux a1 = new Animaux(nomanimal, typeanimal);
            animalerie.add(a1);
        } else {
            System.out.println("D'accord... au revoir");
            System.exit(-1);
        }
        System.out.print("Pour ajouter un nouvel animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5");
        String reponse = sc.nextLine();
        if (reponse.equals("1")) {
            System.out.println("Entrez le nom de l'animal");
            String nomanimal = sc.nextLine();
            System.out.println("Quel est le type de l'animal ? attention : vous ne pouvez choisir qu'entre chien/chat/perroquet");
            String typeanimal = sc.nextLine();
            Animaux a1 = new Animaux(nomanimal, typeanimal);
            animalerie.add(a1);
            System.out.println("Pour continuer à ajouter un animal, tapez 1, pour afficher les animaux deja presents tapez 2, pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ");
            reponse = sc.nextLine();
        } else if (reponse.equals("2")) {
            animalerie.affiche();
            System.out.println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ");
            reponse = sc.nextLine();
        }  else if (reponse.equals("3")) {
            System.out.println("Quel est le nom de l'animal que vous souhaitez faire parler ?");
            String animalparler = sc.nextLine();

            System.out.println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ");
            reponse = sc.nextLine();
        } else if (reponse.equals("4")) {
            System.out.println("quel est le nom de l'animal que vous voulez supprimer ?");
            String animalsupp = sc.nextLine();

            System.out.println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ");
            reponse = sc.nextLine();
        } else if (reponse.equals("5")) {
            System.out.println("au plaisir de vous revoir !");
            System.exit(-1);
        }
    }
}