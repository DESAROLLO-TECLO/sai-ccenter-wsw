package mx.com.teclo.sai.ccenter.ws.persistencia.hibernate.dto.infraccion;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="V_INFRACCIONES")
public class VinfraccionesDTO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "INFRACCION")
	private String infraccion;
	
	@Column(name = "PLACA")
	private String placa;
	
	@Column(name = "FECHA")
	private String Fecha;
	
	@Column(name = "MOTIVO_ID")
	private Long motivoId;
	
	@Column(name = "MOTIVO")
	private String motivo;
	
	@Column(name = "SANSION_ID")
	private Long sancionId;
	
	@Column(name = "SANSION")
	private String sancion;
	
	@Column(name = "MONTO")
	private Double monto;
	
	@Column(name = "DESCUENTO")
	private Double descuento;
	
	@Column(name = "ACTUALIZACION")
	private Double actualizacion;
	
	@Column(name = "VALOR_ACTUALIZADO")
	private Double valorActualizado;
	
	@Column(name = "RECARGOS")
	private Double aecargos;
	
	@Column(name = "DIAS_PISO")
	private Double diasPiso;
	
	@Column(name = "DERECHO_PISO")
	private Double derechoPiso;
	
	@Column(name = "ARRASTRE")
	private Double arrastre;
	
	@Column(name = "TOTAL")
	private Double total;
	
	@Column(name = "MAYOR_TRES")
	private char mayorTres;
	
	@Column(name = "NCI")
	private String nci;
	
	@Column(name = "INFRAC_PAGADA")
	private String infracPagada;
	
	@Column(name = "INFRAC_PARA_PAGO")
	private String infracParaPago;
	
	@Column(name = "INFRAC_IMPRESA")
	private String infracImpresa;
	
	@Column(name = "FECHA_VENCIMIENTO")
	private Date FechaVencimiento;
	
	@Column(name = "INFRAC_M_FECHA_HORA")
	private Date infracMFechaHora;
	
	
	public String getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		Fecha = fecha;
	}
	public Long getMotivoId() {
		return motivoId;
	}
	public void setMotivoId(Long motivoId) {
		this.motivoId = motivoId;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Long getSancionId() {
		return sancionId;
	}
	public void setSancionId(Long sancionId) {
		this.sancionId = sancionId;
	}
	public String getSancion() {
		return sancion;
	}
	public void setSancion(String sancion) {
		this.sancion = sancion;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public Double getDescuento() {
		return descuento;
	}
	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}
	public Double getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(Double actualizacion) {
		this.actualizacion = actualizacion;
	}
	public Double getValorActualizado() {
		return valorActualizado;
	}
	public void setValorActualizado(Double valorActualizado) {
		this.valorActualizado = valorActualizado;
	}
	public Double getAecargos() {
		return aecargos;
	}
	public void setAecargos(Double aecargos) {
		this.aecargos = aecargos;
	}
	public Double getDiasPiso() {
		return diasPiso;
	}
	public void setDiasPiso(Double diasPiso) {
		this.diasPiso = diasPiso;
	}
	public Double getDerechoPiso() {
		return derechoPiso;
	}
	public void setDerechoPiso(Double derechoPiso) {
		this.derechoPiso = derechoPiso;
	}
	public Double getArrastre() {
		return arrastre;
	}
	public void setArrastre(Double arrastre) {
		this.arrastre = arrastre;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public char getMayorTres() {
		return mayorTres;
	}
	public void setMayorTres(char mayorTres) {
		this.mayorTres = mayorTres;
	}
	public String getNci() {
		return nci;
	}
	public void setNci(String nci) {
		this.nci = nci;
	}
	public String getInfracPagada() {
		return infracPagada;
	}
	public void setInfracPagada(String infracPagada) {
		this.infracPagada = infracPagada;
	}
	public String getInfracParaPago() {
		return infracParaPago;
	}
	public void setInfracParaPago(String infracParaPago) {
		this.infracParaPago = infracParaPago;
	}
	public String getInfracImpresa() {
		return infracImpresa;
	}
	public void setInfracImpresa(String infracImpresa) {
		this.infracImpresa = infracImpresa;
	}
	public Date getFechaVencimiento() {
		return FechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}
	public Date getInfracMFechaHora() {
		return infracMFechaHora;
	}
	public void setInfracMFechaHora(Date infracMFechaHora) {
		this.infracMFechaHora = infracMFechaHora;
	}
	
}
