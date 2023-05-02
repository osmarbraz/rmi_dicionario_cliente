
import java.rmi.Remote;

/**
 * Interface dos métodos remotos.
 *
 * @author osmar
 */
public interface Dicionario extends Remote {

    public String traduzir(String palavra) throws java.rmi.RemoteException;

}