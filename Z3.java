
package egzamin.jppp;

import java.io.RandomAccessFile;

/*
Dany jest plik, w którym zapisano (w postaci wewnętrznej)
kolejne czwórki danych tworzące informacje o osobach:
nazwisko osoby (String)
wiek osoby (int)
pensja osoby (double)
płeć osoby (char)
Napisać funkcję zwiększającą( bezpośrednio w pliku, bez
wczytywania całego pliku do pamięci) o 5 procent pensję
kobietom w wieku powyżej 50 lat i zwracają jako wartość nazwisko 
najmłodszej kobiety( jeśli jest ich więcej, to dowolną
z nich). Nazwa pliku jest przekazana jako parametr funkcji.
 */
public class Z3 {
    static String funkcja(String plik){
        String naz;
        String zw="";
        int wiek;
        int por=0;
        double pensja;
        char plec;
        long poz,poz1;
        try{
            RandomAccessFile raf= new RandomAccessFile (plik,"rw");
            raf.seek(0);
            while(raf.length()>raf.getFilePointer()){
                naz=raf.readUTF();
                wiek=raf.readInt();
                poz=raf.getFilePointer();
                pensja=raf.readDouble();
                plec=raf.readChar();
                poz1=raf.getFilePointer();
                if(plec=='K' && wiek>50){
                    pensja-=pensja*1.05;
                    raf.seek(poz);
                    raf.writeDouble(pensja);
                    raf.seek(poz1);
                }
                if(por>wiek){
                    por=wiek;
                    zw=naz;
                }
            }
        }
        catch (Exception e){
            
        }
        return zw;
    }
}
