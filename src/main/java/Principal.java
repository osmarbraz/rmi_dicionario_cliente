
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;

/**
 * Programa cliente do objeto dicionário.
 *
 * Classe que obtêm uma instância do objeto no servidor.
 *
 * @author osmar
 */
public class Principal {

    public static void main(String args[]) {
        try {
            //Referência para rmiregistry na porta 1099
            Registry registro = LocateRegistry.getRegistry("localhost");
            //Localiza a referência do objeto remoto no servidor 
            Object obj = registro.lookup("dicionario");
            //ou Object obj = Naming.lookup("rmi://localhost/mensagens");
            Dicionario dicionario = (Dicionario) obj;
            int opcao = -1;
            while (opcao != 9) {
                opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu do dicionario: \n1 - Traduzir \n9 - Sair"));
                if (opcao == 1) {
                    String palavraptbr = JOptionPane.showInputDialog("Digite uma palavra em portugues:");

                    String palavraen = dicionario.traduzir(palavraptbr);

                    if (!palavraen.equals("-1")) {
                        System.out.println("Palavra em inglês:" + palavraen);
                    } else {
                        System.out.println("Palavra " + palavraptbr + " nao existe no dicionario.");
                    }
                }
            }
        } catch (RemoteException ree) {
            System.out.println("Excecao: " + ree.getMessage());
        } catch (NotBoundException nbe) {
            System.out.println("Excecao: " + nbe.getMessage());
        }
    }
}