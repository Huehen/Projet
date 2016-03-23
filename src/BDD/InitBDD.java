package BDD;

public class InitBDD {
    public static void initCompleteBDD() {
        initTableSave();
    }
    
    public static void initTableSave() {
        Requete rq = new Requete();
        
        rq.request("DROP TABLE SAVE;");
        rq.request("CREATE TABLE SAVE(ID NUMBER, CONSTRAINT PK_MUR PRIMARY KEY (ID));");
    }
}
