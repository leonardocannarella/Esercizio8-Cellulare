import java.lang.String;
/**
 * Cellulare
 * 
 * @author (Leonardo Cannarella) 
 * @version (1.0 - 31/10/2019)
 */
public class Cellulare
{
    private String marca;
    private String modello;
    private String operatore;
    private String numTel;
    private String sms;
    private String box[];
    private boolean acceso;
        
    public Cellulare(String marca, String modello, String operatore, String numTel)
    {
        box=new String[20];
        setMarca(marca);
        setModello(modello);
        setOperatore(operatore);
        setNum(numTel);
        acceso=false;
    }
    
    private void setMarca(String m)
    {
        marca=m;
    }
    
    private void setModello(String mo)
    {
        modello=mo;
    }
    
    private void setOperatore(String op)
    {
        operatore=op;
    }
    
    private void setNum(String num)
    {
        numTel=num;
    }
    
    public String getNumTel()
    {
        return numTel;
    }
    
    public void accendi()
    {
        acceso=true;
    }
    
    public void spegni()
    {
        acceso=false;
    }
    
    public boolean write(String testo)
    {
        if(testo.length()<=160)
        {
            return true;
        }
        return false;
    }
    
    public String send(Cellulare dest, String num, String testo)
    {
        boolean esito=false;
        if(acceso==true)
        {
            esito=write(testo);
            if(esito==true)
            {
                if(num==dest.getNumTel())
                {
                    receive(dest, testo);
                    return "Il messaggio è stato inviato con successo!";
                }
                return "I parametri sono errati!";
            }
            else
                return "Il messaggio è troppo lungo!";
        }
        else
            return "Il telefono è spento!";
    }
    
    public String receive(Cellulare dest, String testo)
    {
        int i=0;
        while((dest.box[i]!=null)&&(i<20))
        {
            i++;
        }
        if(dest.box[i]==null)
        {
            dest.box[i]=testo;
            return "Il messaggio è stato inviato!";
        }
        else
            return "La casella dei messaggi è piena!";
    }
    
    
    public String delete(int n)
    {
        box[n]=null;
        return "Il messaggio "+n+ " è stato cancellato!";
    }
}
