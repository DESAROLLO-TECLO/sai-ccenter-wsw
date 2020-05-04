package mx.com.teclo.sai.ccenter.ws.util.enums;


public enum Codigos {
	SUCCESS("200"), NOT_DATA_FOUND("404"), ERROR_SERVIDOR("500"), BAD_REQUEST("400");
	
	private String codigoId;

	private Codigos(String codigoId) {
		this.codigoId = codigoId;

	}

	/**
	 * @return the procesoId
	 */
	public String getProcesoId() {
		return codigoId;
	}

	/**
	 * @param procesoId
	 *            the procesoId to set
	 */
	public void setProcesoId(String codigoId) {
		this.codigoId = codigoId;
	}
	
	static Codigos getArchivoTipo(String x) {
		for (Codigos currentType : Codigos.values()) {
	      if (x.equals(currentType.getProcesoId())) {
	        return currentType;
	      }
	    }
	    return null;
	  }
}
