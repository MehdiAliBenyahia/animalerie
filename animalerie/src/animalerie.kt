import java.util. *

internal class Animaux(private var nom: String, t: String) {
    private var type: String? = null
    private var son: String? = null
    fun GetNom(): String {
        return nom
    }

    fun GetType(): String? {
        return type
    }

    fun GetSon(): String? {
        return son
    }

    fun SetNom(n: String) {
        nom = n
    }

    fun sonAnimal() {
        if (type === "chat") {
        }
    }

    fun quiSuisJe() {
        println("Bonjour je m'appelle $nom. Je suis un $type et mon son caracteristique est $son")
    }

    fun parler() {
        println(GetSon())
    }

    init {
        if (t !== "chat" && t !== "chien" && t !== "perroquet") {
            println("entrez un type d'animal valide")
        } else {
            type = t
        }
        if (t === "chat") {
            son = "miaou"
        } else if (t === "chien") {
            son = "waouf"
        } else if (t === "perroquet") {
            son = "siffle"
        }
    }
}

internal class Animalerie(n: Int) {
    private val listeAnimaux: Array<Animaux?>
    fun add(a: Animaux?) {
        var i = 0
        while(listeAnimaux[i] != null) {
            i++
        }
        if (i > listeAnimaux.size) {
            print("impossible d'ajouter un animal, veuillez en supprimer un")
        } else {
            listeAnimaux[i] = a
        }
    }

    fun gettailleliste(): Int {
        return listeAnimaux.size
    }

    fun suppAnimal(a: Animaux) {
        for (i in listeAnimaux.indices) {
            val test = listeAnimaux[i]
            if (test === a) {
                listeAnimaux[i] = null
            }
        }
    }

    fun affiche() {
        for (i in listeAnimaux.indices) {
            if (listeAnimaux[i] != null) {
                listeAnimaux[i]!!.quiSuisJe()
            }
        }
    }

    init {
        listeAnimaux = arrayOfNulls(n)
    }
}

internal object InterfaceAnimal {
    @JvmStatic
    fun main(args: Array<String>) {
        val sc = Scanner(System.`in`)
        println("Bonjour, pour commencer veuillez entrer la taille de votre animalerie supperieure a 0")
        val taille = sc.nextLine()
        val animalerie = Animalerie(taille.toInt())
        println("Pour ajouter un animal tapez 1")
        val commencement = sc.nextLine()
        if (commencement == "1") {
            println("Entrez le nom de l'animal")
            val nomanimal = sc.nextLine()
            println("Quel est le type de l'animal ? attention : vous ne pouvez choisir qu'entre chien/chat/perroquet")
            val typeanimal = sc.nextLine()
            val a1 = Animaux(nomanimal, typeanimal)
            animalerie.add(a1)
        } else {
            println("D'accord... au revoir")
            System.exit(-1)
        }
        print("Pour ajouter un nouvel animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5")
        var reponse = sc.nextLine()
        if (reponse == "1") {
            println("Entrez le nom de l'animal")
            val nomanimal = sc.nextLine()
            println("Quel est le type de l'animal ? attention : vous ne pouvez choisir qu'entre chien/chat/perroquet")
            val typeanimal = sc.nextLine()
            val a1 = Animaux(nomanimal, typeanimal)
            animalerie.add(a1)
            println("Pour continuer à ajouter un animal, tapez 1, pour afficher les animaux deja presents tapez 2, pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ")
            reponse = sc.nextLine()
        } else if (reponse == "2") {
            animalerie.affiche()
            println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ")
            reponse = sc.nextLine()
        } else if (reponse == "3") {
            println("Quel est le nom de l'animal que vous souhaitez faire parler ?")
            val animalparler = sc.nextLine()
            println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ")
            reponse = sc.nextLine()
        } else if (reponse == "4") {
            println("quel est le nom de l'animal que vous voulez supprimer ?")
            val animalsupp = sc.nextLine()
            println("Pour ajouter un animal tapez 1, pour afficher les animaux deja presents tapez 2,  pour faire parler un animal tapez 3, pour supprimer un animal tapez 4, pour quitter l'application tapez 5 ")
            reponse = sc.nextLine()
        } else if (reponse == "5") {
            println("au plaisir de vous revoir !")
            System.exit(-1)
        }
    }
}