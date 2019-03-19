package fr.afpa.formation.mecanique.exception;


/**
 * <b>EXCEPTION DU TYPE CI-DESSOUS :</b><br/>
 * TYPE : 'COMMNDE -ID EXISTE PAS'
*/
public class NotAvailableException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * <b>CONSTRUCTEUR AVEC UN ARGUMENT</b><br/>
     * @param pMessage Le message de l'exception
     */
	public NotAvailableException(String pMessage) {
        super(pMessage);
    }
}
