package mx.com.teclo.sai.ccenter.ws.persistencia.vo.respuesta;

public class RespuestaVO {
	
	private String codigoHttp;
	private String descripcion;
	private DepositoVO depositoVO;
	private InfraccionesVO infraccionesVO;
	private String idRegistro;
	
	public String getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getCodigoHttp() {
		return codigoHttp;
	}
	public void setCodigoHttp(String codigoHttp) {
		this.codigoHttp = codigoHttp;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public DepositoVO getDepositoVO() {
		return depositoVO;
	}
	public void setDepositoVO(DepositoVO depositoVO) {
		this.depositoVO = depositoVO;
	}
	public InfraccionesVO getInfraccionesVO() {
		return infraccionesVO;
	}
	public void setInfraccionesVO(InfraccionesVO infraccionesVO) {
		this.infraccionesVO = infraccionesVO;
	}
}
