package Model;

public class Sejour {
    private String Hote ;
    private String NbrPersonnesRecherchees ;
    private String NbrJours ;
    private String Restauration ;
    private String Competances ;
    private String Dates ;

    public Sejour() {
        super();
    }
    public Sejour(String Hote, String NbrPersonnesRecherchees, String NbrJours, String Restauration, String Competances, String Dates)
    {
        this.Hote = Hote;
        this.NbrPersonnesRecherchees = NbrPersonnesRecherchees ;
        this.NbrJours = NbrJours ;
        this.Restauration = Restauration ;
        this.Competances = Competances ;
        this.Dates = Dates ;

    }
    public String getHote() {
        return Hote;
    }
    public void setHote(String hote) {
        Hote = hote;
    }
    public String getNbrPersonnesRecherchees() {
        return NbrPersonnesRecherchees;
    }
    public void setNbrPersonnesRecherchees(String nbrPersonnesRecherchees) {
        NbrPersonnesRecherchees = nbrPersonnesRecherchees;
    }
    public String getNbrJours() {
        return NbrJours;
    }
    public void setNbrJours(String nbrJours) {
        NbrJours = nbrJours;
    }
    public String getRestauration() {
        return Restauration;
    }
    public void setRestauration(String restauration) {
        Restauration = restauration;
    }
    public String getCompetances() {
        return Competances;
    }
    public void setCompetances(String competances) {
        Competances = competances;
    }
    public String getDates() {
        return Dates;
    }
    public void setDates(String dates) {
        Dates = dates;
    }



}