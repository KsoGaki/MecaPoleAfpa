package fr.afpa.formation.mecanique.exception;

/**
 * <b>EXCEPTION DU TYPE CI-DESSOUS :</b><br/>
 * TYPE : 'COMMANDE EXISTE DEJA'
 */

public class AlreadyExistsException extends RuntimeException {


    /**
	 * */
	private static final long serialVersionUID = 1L;

	/**
     * <b>CONSTRUCTEUR AVEC UN ARGUMENT</b><br/>
     * @param pMessage Le message de l'exception
     */
	public AlreadyExistsException (String pMessage) {
        super(pMessage);
    }
}
