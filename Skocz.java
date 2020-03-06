
package egzamin.jppp;

/*
Napisać klasę Skoki, reprezentującą informacje o konkursach skoków narciarskich.
Klasa powinna zawierać pole prywatne float [][]konkursy- tablicę z listą wyników
skoczków(pierwszy wymiar- numer skoczka, drugi wymiar- numer konkursu).
Konstruktor z dwoma parametrami (liczba skoczków, liczba konkursów)powinien 
tworzyć i zainicjować odpowiednie elementy tablicy na wartość 0.
Zdefiniować metody publiczne:
-float sredniaWynikow(int skoczek)- oblicza i zwraca średnią wyników punktowych w sezonie
dla podanego skoczka),
-boolean dobrySezon(int skoczek, float punkty)- zwraca true, jeśli średnia wyników
punktowych w sezonie przekroczyła podaną wartość, w przeciwnym wypadku false,
-void wpiszWynik(int skoczek, int konkurs, float punkty)-dodaje nowy wynik skoczka,
-void piszDane(int skoczek)- wyświetla na konsolę wyniki skoczka ( w jednym wierszu:
numer skoczka, lista wyników, średnia wynikóa) rozdzielone spacjami

 */
public class Skocz {
  private float[][]konkursy;
  
Skocz (int l_skoczkow, int l_konkursow){
    konkursy= new float [l_skoczkow][l_konkursow];
}
float sredniaWynikow(int skoczek){
    float suma=0;
    for(int i=0;i<konkursy[skoczek].length;i++){
        suma +=konkursy [skoczek][i];
    }
    float srednia= suma/konkursy [skoczek].length;
    return srednia;
}
boolean dobrySezon(int skoczek,float punkty){
    if(sredniaWynikow(skoczek)>punkty)
    {
        return true;
    }
    else
    {
        return false;
    }
}
void wpiszWynik(int skoczek, int konkurs, float punkty){
    konkursy [skoczek][konkurs]=punkty;
}
void piszDane(int skoczek){
    System.out.print(skoczek+"");
    for(int i=0;i<konkursy[skoczek].length;i++){
        System.out.println(konkursy[skoczek][i]+"");
    }
        System.out.println(sredniaWynikow(skoczek)+"");
}
}
