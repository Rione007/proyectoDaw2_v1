package cibertec.pe.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MovimientoCaja {


		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idMovimientoCaja;

	    @ManyToOne
	    private Caja caja;

	    private LocalDateTime fecha;

	    @Enumerated(EnumType.STRING)
	    private TipoMovimiento tipo;

	    private BigDecimal monto;

	    private String descripcion;
	    
	    
	    public MovimientoCaja () {}
	    
	    
	    public enum TipoMovimiento
	    {
	    	INGRESO,
	    	EGRESO
	    }


		public MovimientoCaja(Long idMovimientoCaja, Caja caja, LocalDateTime fecha, TipoMovimiento tipo,
				BigDecimal monto, String descripcion) {
			super();
			this.idMovimientoCaja = idMovimientoCaja;
			this.caja = caja;
			this.fecha = fecha;
			this.tipo = tipo;
			this.monto = monto;
			this.descripcion = descripcion;
		}


		public Long getIdMovimientoCaja() {
			return idMovimientoCaja;
		}


		public void setIdMovimientoCaja(Long idMovimientoCaja) {
			this.idMovimientoCaja = idMovimientoCaja;
		}


		public Caja getCaja() {
			return caja;
		}


		public void setCaja(Caja caja) {
			this.caja = caja;
		}


		public LocalDateTime getFecha() {
			return fecha;
		}


		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}


		public TipoMovimiento getTipo() {
			return tipo;
		}


		public void setTipo(TipoMovimiento tipo) {
			this.tipo = tipo;
		}


		public BigDecimal getMonto() {
			return monto;
		}


		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}


		public String getDescripcion() {
			return descripcion;
		}


		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}



	    
	    
	    
	    
	    
	    
	    
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



