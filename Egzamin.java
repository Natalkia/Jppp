
package egzamin.jppp;

/*
Napisać klasę Egzamin reprezentującą informację o ocenach
z egzaminu z programowania. Klasa powinna zawierać pole prywatne
float [][]oceny- tablicę z listą ocen studentów (pierwszy wymiar-
numer studenta, drugi wymiar0 numer zadania). Konstruktor
z parametrami (liczba studentów, liczba zadań) powinien 
tworzyć i zainicjować odpowiednie elementy tablicy na wartość 0.
Zdefiniować metody publiczne:
-float obliczSrednia(int student)- oblicza i zwraca średnią
arytmetyczną dla podanego studenta
-boolean zaliczonyEgzamin (int student)- zwarac true, jeśli średnia 
ocen jest większa lub równa 3.0, w przeciwnym wypadku false
-void wpiszOcene(int student, int zadanie, float ocena)-
dodaje nową ocenę
-void piszDane()- wyświetla na ekran oceny studentów
(w jednym wierszu: numer studenta, lista ocen, średnia ocen)
rozdzielone spacjami
 */
public class Egzamin {
    private float[][] oceny;
  
Egzamin (int nr_studenta, int nr_zadania){
    oceny= new float [nr_studenta][nr_zadania];
}
float obliczSrednia(int student){
    float suma=0;
    for(int i=0;i<oceny[student].length;i++){
        suma +=oceny [student][i];
    }
    float srednia= suma/oceny [student].length;
    return srednia;
}
boolean zaliczonyEgzamin(int student){
    if(obliczSrednia(student)>3)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void wpiszWynik(int student, int modul, float ocena){
    oceny [student][modul]=ocena;
}
void piszDane(int student){
    System.out.print(student+"");
    for(int i=0;i<oceny[student].length;i++){
        System.out.println(oceny[student][i]+"");
    }
        System.out.println(obliczSrednia(student)+"");
}
}
