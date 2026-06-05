package cibertec.pe.service.interfaces;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entities.Sucursal;

public interface ISucursalService {

	public List<Sucursal> getSucursal();

    Optional<Sucursal> getSucursalId(Long id);

    Sucursal createSucursal(Sucursal emp);

    Sucursal updateSucursal(int id, Sucursal emp);

    void deleteSucursal(int id);
}
