package mx.com.teclo.sai.util.enumerados;

public enum ParametrosBitacoraEnum {

	TAI_BITACORA_CAMBIOS("TAI_BITACORA_CAMBIOS"), ORIGEN_W("W");
	
	private String parametro;
	
	private ParametrosBitacoraEnum(String parametro) {
		this.setParametro(parametro);
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	static ParametrosBitacoraEnum getArchivoTipo(Integer x) {
		for (ParametrosBitacoraEnum currentType : ParametrosBitacoraEnum.values()) {
	      if (x.equals(currentType.getParametro())) {
	        return currentType;
	      }
	    }
	    return null;
	}
}
