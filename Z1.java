
package egzamin.jppp;

import java.io.RandomAccessFile;

public class Z1 {
    /*
    Dany jest plik, w któym zapisano (w postaci wewnętrznej)kolejne trójki
    danych tworzące informacje o budynkach:
    nazwa domu (String)
    liczba kondygnacji(int)
    cena(double)
    Napisać funkcję zwiększającą(bezpośrenio w pliku, bez wczytywania
    całego pliku do pamięci) o 20% procent cenę domów parterowych
    i zwracającą jako wartość nazwę domu o największej liczbie 
    kondygnacji (jeśli jest takich więcej, to dowolny z nich). Nazwa
    pliku jest przekazana jako parametr funkcji.
    */
    static String funkcja(String plik){
        String naz_domu;
        int l_kond;
        double cena;
        long poz,poz1;
        int max=0;
        String zw= "";
        try{
            RandomAccessFile raf= new RandomAccessFile(plik,"rw");
            raf.seek(0);
            while(raf.length()>raf.getFilePointer()){
                naz_domu= raf.readUTF();
                l_kond=raf.readInt();
                poz=raf.getFilePointer();
                cena=raf.readDouble();
                if(l_kond==0){
                    cena=cena*1.2;
                    raf.seek(poz);
                    raf.writeDouble(cena);
                }
                if(max<l_kond){
                    max=l_kond;
                    zw=naz_domu;
                }
            }
            raf.close();
        }
        catch(Exception e){
            
        }
        return zw;
    }
}
