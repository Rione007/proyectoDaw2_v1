package cibertec.pe.service.interfaces;

import java.util.List;
import java.util.Optional;

import cibertec.pe.entities.Empresa;

public interface IEmpresaService {
	public List<Empresa> getEmpresa();

    Optional<Empresa> getEmpresaId(Long id);

    Empresa createEmpresa(Empresa emp);

    Empresa updateEmpresa(int id, Empresa emp);

    void deleteEmpresa(int id);
}
