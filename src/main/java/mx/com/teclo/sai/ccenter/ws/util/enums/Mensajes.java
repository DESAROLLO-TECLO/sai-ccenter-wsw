package mx.com.teclo.sai.ccenter.ws.util.enums;

public enum Mensajes {
MSJ_SUCCESS("Resultado encontrado"), MSJ_NOT_DATA_FOUND("No se encontraron resultados"), MSJ_ERROR_SERVIDOR("Error en el servidor"), MSJ_BAD_REQUEST("El parametro requerido es nulo");
	
	private String mensaje;

	private Mensajes(String mensaje) {
		this.mensaje = mensaje;

	}

	/**
	 * @return the procesoId
	 */
	public String getProcesoId() {
		return mensaje;
	}

	/**
	 * @param procesoId
	 *            the procesoId to set
	 */
	public void setProcesoId(String mensaje) {
		this.mensaje = mensaje;
	}
	
	static Mensajes getArchivoTipo(String x) {
		for (Mensajes currentType : Mensajes.values()) {
	      if (x.equals(currentType.getProcesoId())) {
	        return currentType;
	      }
	    }
	    return null;
	  }
}
