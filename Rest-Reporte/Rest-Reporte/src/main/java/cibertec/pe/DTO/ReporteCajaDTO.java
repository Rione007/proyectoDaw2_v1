package cibertec.pe.DTO;

import java.math.BigDecimal;

public class ReporteCajaDTO {

	
	   private BigDecimal ingresos;
	    private BigDecimal egresos;
	    private BigDecimal saldo;

	    public ReporteCajaDTO() {
	    }

		public ReporteCajaDTO(BigDecimal ingresos, BigDecimal egresos, BigDecimal saldo) {
			super();
			this.ingresos = ingresos;
			this.egresos = egresos;
			this.saldo = saldo;
		}
		
		
		
		
		
		
		

		public ReporteCajaDTO(BigDecimal egresos, BigDecimal saldo) {
			super();
			this.egresos = egresos;
			this.saldo = saldo;
		}

		public BigDecimal getIngresos() {
			return ingresos;
		}

		public void setIngresos(BigDecimal ingresos) {
			this.ingresos = ingresos;
		}

		public BigDecimal getEgresos() {
			return egresos;
		}

		public void setEgresos(BigDecimal egresos) {
			this.egresos = egresos;
		}

		public BigDecimal getSaldo() {
			return saldo;
		}

		public void setSaldo(BigDecimal saldo) {
			this.saldo = saldo;
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
