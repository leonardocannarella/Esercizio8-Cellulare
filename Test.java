
/**
 * Test
 * 
 * @author (Leonardo Cannarella) 
 * @version (1.0 - 31/10/2019)
 */
public class Test
{
    public static void main(String[] args) {
        Cellulare nuriel,signo;
        
        nuriel=new Cellulare("Samsung","Galaxy A40","CoopVoce","3665047724");
        signo=new Cellulare("iPhone","X","Tre","3897689858");
        
        nuriel.accendi();
        signo.accendi();
        System.out.println(nuriel.send(signo, "3897689858", "Ciao Signo"));
        System.out.println(nuriel.send(signo, "3897689858", "Come stai?"));
        
        System.out.println(signo.send(nuriel, "3665047724", "Ciao Nuri"));
        System.out.println(signo.send(nuriel, "3665047724", "Tutto bene tu?"));
    }
}
