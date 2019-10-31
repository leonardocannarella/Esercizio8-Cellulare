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
    private String sendbox[];
    private String receivedbox[];
    private boolean acceso;
        
    public Cellulare(String marca, String modello, String operatore, String numTel)
    {
        sendbox=new String[20];
        receivedbox=new String[20];
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
        int i=0;
        boolean esito=false;
        if(acceso==true)
        {
            esito=write(testo);
            if(esito==true)
            {
                if(num==dest.getNumTel())
                {
                    dest.receive(testo);
                    while((sendbox[i]!=null)&&(i<20))
                    {
                        i++;
                    }
                    if (sendbox[i]==null)
                        sendbox[i]=testo;
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
    
    public void receive(String testo)
    {
        int i=0;
        while((receivedbox[i]!=null)&&(i<20))
        {
            i++;
        }
        if(receivedbox[i]==null)
        {
            receivedbox[i]=testo;
        }
    }
    
    
    public String delete(int n)
    {
        receivedbox[n]=null;
        sendbox[n]=null;
        return "Il messaggio "+n+ " è stato cancellato!";
    }
    
    public String toString()
    {
        int i=0;
        String r="ricevuti: \n";
        String s="inviati: \n";
        int a;
        while(i!=20)
        {
            a=i+1;
            if((receivedbox[i])!=null)
                r=r+" mess "+ a+ " "+receivedbox[i]+"\n";
            i++;
        }
        
        i=0;
        while(i!=20)
        {
            a=i+1;
            if((sendbox[i])!=null)
                s=s+" mess "+ a+ " "+sendbox[i]+"\n";
            i++;
        }
        
        return r+s;
        
        
    }
}
