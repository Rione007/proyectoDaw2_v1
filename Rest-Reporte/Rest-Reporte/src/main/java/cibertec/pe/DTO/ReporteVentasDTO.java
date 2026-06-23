package cibertec.pe.DTO;

public class ReporteVentasDTO {
	
	
	
    private long cantidadVentas;
    private double totalIngresos;
    
    public ReporteVentasDTO () {}

	public ReporteVentasDTO(long cantidadVentas, double totalIngresos) {
		super();
		this.cantidadVentas = cantidadVentas;
		this.totalIngresos = totalIngresos;
	}

	public long getCantidadVentas() {
		return cantidadVentas;
	}

	public void setCantidadVentas(long cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}

	public double getTotalIngresos() {
		return totalIngresos;
	}

	public void setTotalIngresos(double totalIngresos) {
		this.totalIngresos = totalIngresos;
	}
    
    
    
    
    
    

}
