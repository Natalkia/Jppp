
package egzamin.jppp;

/*
Napisać klasę Studia reprezentującą informacje o ocenach z modułów.
Klasa powinna zawierać pole prywatne float [][]moduły- tablicę
z listą ocen styudentów (pierwszy wymiar-numer studenta,
drugi wymian-numer modułu). Konstruktor z dwoma parametrami
(licza studentów, liczba modułów) poowinien tworzyć i zainicjować
odpowiednie elementy tablicy na wartość 0. Zdefiniować metody
publiczne:
-float obliczSrednis(int student)- oblicza i zwraca wartość arytmetyczną
dla podanego studenta
-boolean zaliczonyRok(int student)- zwraca true, jeśli średnia
ocen jest większa lub równa 3.0, w przeciwnym wypadku false
-void wpiszModul(int student, int modul, float ocena)- dodaje
nową ocenę modułu
-void piszDane(int student)- wyświeta na konsolę oceny
studentów( w jednym wierszu: numer studenta, liczba ocen, zaliczony rok)
rozdzielone spacjami.
 */
public class Studia {
    private float[][]moduly;
  
Studia (int nr_studenta, int nr_modulu){
    moduly= new float [nr_studenta][nr_modulu];
}
float obliczSrednia(int student){
    float suma=0;
    for(int i=0;i<moduly[student].length;i++){
        suma +=moduly [student][i];
    }
    float srednia= suma/moduly [student].length;
    return srednia;
}
boolean zaliczonyRok (int student){
    if(obliczSrednia(student)>=3)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void wpiszModul(int student, int modul, float ocena){
    moduly [student][modul]=ocena;
}
void piszDane(int student){
    System.out.print(student+"");
    for(int i=0;i<moduly[student].length;i++){
        System.out.println(moduly[student][i]+"");
    }
        System.out.println(obliczSrednia(student)+"");
}
}
