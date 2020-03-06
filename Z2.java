
package egzamin.jppp;

import java.io.RandomAccessFile;

public class Z2 {
   /*
    Dany jest plik, w którym zapisano (w postaci wewnętrznej)kolejne
    trójki danych tworzące informację o lekach:
    nazwa leku(String)
    cena leku(double)
    refundacja(boolean)
    Napisać funkcję zmniejszającą (bezpośrednio w pliku, bez wczytywania
    całego pliku do pamięci) o 15 procent cenę leków refundowanych 
    (refundacja==true) i zwracającąjako wartość nazwę leku 
    o najmniejszej cenie (liczonej po ewentualnej refundcji). Jeśli
    jest takich więcej, to należy zwrócić dowolny z nich. Nazwa pliku
    jest przekazana jako paramentr funkcji.
    */ 
    static String funkcja(String plik){
        String naz_leku;
       int cena_leku;
       double c_leku=0;
        boolean ref;
        long poz,poz1;
        double min=0;
        String zw="";
        try{
            RandomAccessFile raf= new RandomAccessFile(plik,"rw");
            raf.seek(0);
            while(raf.length()>raf.getFilePointer()){
               naz_leku=raf.readUTF();
               poz=raf.getFilePointer();
               cena_leku=raf.readInt();
               ref=raf.readBoolean();
               poz1=raf.getFilePointer();
               if(ref==true){
                   c_leku= cena_leku *0.85;
                   raf.seek(poz);
                   raf.writeDouble(cena_leku);
                   raf.seek(poz1);   
               }
               if(min>= c_leku){
                   min=cena_leku;
                   zw=naz_leku;
               }
            }
            raf.close();
        }
        catch(Exception e){
            
        }
        return zw;
    }
}

