	package cibertec.pe.entites;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.ManyToOne;
	
	@Entity
	public class Stock {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    private Integer cantidad;
	
	    @ManyToOne
	    @JoinColumn(name = "producto_id")
	    private Producto producto;
	
	    @ManyToOne
	    @JoinColumn(name = "almacen_id")
	    private Almacen almacen;
	    
	    
	    
	    public Stock() {}



		public Stock(Long id, Integer cantidad, Producto producto, Almacen almacen) {
			super();
			this.id = id;
			this.cantidad = cantidad;
			this.producto = producto;
			this.almacen = almacen;
		}



		public Stock(Integer cantidad, Producto producto, Almacen almacen) {
			super();
			this.cantidad = cantidad;
			this.producto = producto;
			this.almacen = almacen;
		}



		public Long getId() {
			return id;
		}



		public void setId(Long id) {
			this.id = id;
		}



		public Integer getCantidad() {
			return cantidad;
		}



		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}



		public Producto getProducto() {
			return producto;
		}



		public void setProducto(Producto producto) {
			this.producto = producto;
		}



		public Almacen getAlmacen() {
			return almacen;
		}



		public void setAlmacen(Almacen almacen) {
			this.almacen = almacen;
		}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}