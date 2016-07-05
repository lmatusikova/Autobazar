package sk.upjs.ics.autobazar;

import java.util.List;


public interface InzeratDao {
    public void pridat(Inzerat inzerat);
    
    public List<Inzerat> dajVsetky();
    
    public List<Inzerat> vyhladaj(String znacka, String model, String odRocnik, String doRocnik);
    
    public void odstranit(Inzerat inzerat);
    
}
