package sk.upjs.ics.autobazar;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Inzerat {
    private Long id;

    private String znacka;

    private String model;

    private String rocnik;

    private Long objem;

    private Date datumPridania;
    
    private Long cena;

    public Long getCena() {
        return cena;
    }

    public void setCena(Long cena) {
        this.cena = cena;
    }
    
    private SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy");

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRocnik() {
        return rocnik;
    }

    public void setRocnik(String rocnik) {
        this.rocnik = rocnik;
    }

    public Long getObjem() {
        return objem;
    }

    public void setObjem(Long objem) {
        this.objem = objem;
    }

    public Date getDatumPridania() {
        return datumPridania;
    }

    public void setDatumPridania(Date datumPridania) {
        this.datumPridania = datumPridania;
    }

    @Override
    public String toString() {
        return this.znacka +" "+ this.model +", Rok vyroby: "+ this.rocnik +", Objem: "+ this.objem+"\n\n";
    }
    
    public String toString2() {
        return "Znacka: "+ this.znacka +"\n"+"Model: "+ this.model +"\n"+"Rok vyroby: "+ this.rocnik +"\n"+"Objem: "+ this.objem+"\n"+"Datum pridania: "+ dateFormat.format(this.datumPridania);
    }
    
}
