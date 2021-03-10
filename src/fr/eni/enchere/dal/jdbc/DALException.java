package fr.eni.enchere.dal.jdbc;

import java.util.List;

public class DALException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Constructeurs
	public DALException() {
		super();
	}
	
	public DALException(String message) {
		super(message);
	}
	
	public DALException(String message, Throwable exception) {
		super(message, exception);
	}

	//Méthodes
	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche DAL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
	
    /**
     * Returns the list of the error codes stored in the instance
     * @return List
     */
    public List<Integer> getListErrorCodes()
    {
        return this.getListErrorCodes();
    }

	public void addError(int errorSelect) {
		// TODO Auto-generated method stub
		
	}
	
}