
package egzamin.jppp;

import java.io.RandomAccessFile;


public class EGZAMINJppp {
/*
    Dany jest plik danych, w którym są zapisane kolejno czwórki danych:
    numer zamówienia (int)
    nazwa towaru (String)
    cena (double)
    liczba sztuk (int)
    Napisać funkcję Zamówienie, która jako pierwszy 
    parametr otrzymuje nazwę tego pliku. Funkcja zwraca 
    liczbę zamówionych sztuk towaru, którego nazwa przekazana 
    jest przez drugi parametr. Dodatkowo, w podanym pliki, 
    funkcja wprowadza rabat w wysokości 10 procent dla wszystkich
    towarów, których cena jest większa niż 50 i zamówiono ich
    przynajmnniej 25 sztuk. Danych nie można wczytać do tablicy.
  
*/
static int Zamowienie(String plik, String nazwa){
    int nr_zam;
    String naz_tow;
    double cena;
    int l_sztuk; 
    int daj_szt=0;
    long poz,poz1;
    try{
        RandomAccessFile raf= new RandomAccessFile(plik,"rw");
        raf.seek(0);
        while(raf.length()>raf.getFilePointer()){
            nr_zam=raf.readInt();
            naz_tow=raf.readUTF();
            poz=raf.getFilePointer();
            cena=raf.readDouble();
            l_sztuk=raf.readInt();
            poz1=raf.getFilePointer();
            if(naz_tow.equals(nazwa)){
                daj_szt=l_sztuk;
            }
            if(cena>50 && l_sztuk>=25){
                cena=cena*0.9;
                raf.seek(poz);
                raf.writeDouble(cena);
                raf.seek(poz1);
            }
        }
        raf.close();
    }
   catch(Exception e){
   }
    return daj_szt;
}
}