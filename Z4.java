
package egzamin.jppp;

/*
Napisać funkcję PESEL, która jako parametr otrzymuje 2-wymiarową tablicę łańcuchów
klasy String, które są znakowym zapisem numerów PESEL. Funkcja przekształca
każdy PESEL, napisany w pierwszym wymiarze tablicy, a liczbę i sprawdza, czy 
jest poprawny. Aby sprawdzić czy dany PESEL jest poprawny, należy obliczyć
wartość wyrażenia:
a+3b+7c+9d+e+3f+7g+9h+i+3j+k
gdzie a...k oznaczją kolejne cyfry numeru PESEL.Jeśli otrzymany wynik jest
podzielny przez 10, to oznacza, że numer PESEL  jest poprawny. Funkcja 
wpisuje słowo "POPRAWNY" lub "BLEDNY" do odpowiednich elementów w drugim wymiarze 
tablicy i zwraca tablicę 1- wymiarową zawierające wyliczone liczby dla kolejnych
numerów PESEL
 */
public class Z4 {
    int []Pesel (String [][] tablica){
        int [] Zwrot= new int [tablica[0].length];
        for(int i=0; i<tablica[0].length;i++){
            String linia= tablica[0][i];
            char [] prz=linia.toCharArray();
            int [] numerki= new int[prz.length];
            for(int j=0;j<prz.length;j++){
                numerki[j]=Character.getNumericValue(prz[j]);
            }
            int wynik=numerki[0]+ 3*numerki[1];
            Zwrot [i]=wynik;
            wynik %=10;
            if(wynik>0){
                tablica[1][i]="Bledny";
            }
            else{
                tablica[1][i]="Poprawny";
            }
        }
        return Zwrot;
    }
}
