package cibertec.pe.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entities.Empresa;
import cibertec.pe.repository.IEmpresaRepository;
import cibertec.pe.service.interfaces.IEmpresaService;

@Service
public class EmpresaService implements IEmpresaService {

    @Autowired
    private IEmpresaRepository repo;

    @Override
    public List<Empresa> getEmpresa() {
        return repo.findAll();
    }

    @Override
    public Optional<Empresa> getEmpresaId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Empresa createEmpresa(Empresa emp) {
        return repo.save(emp);
    }

    @Override
    public Empresa updateEmpresa(int id, Empresa emp) {

        Optional<Empresa> empresa = repo.findById((long) id);

        if (empresa.isPresent()) {

            Empresa data = empresa.get();

            data.setRazonSocial(emp.getRazonSocial());
            data.setRuc(emp.getRuc());
            data.setDireccion(emp.getDireccion());
            data.setTelefono(emp.getTelefono());

            return repo.save(data);
        }

        return null;
    }

    @Override
    public void deleteEmpresa(int id) {
        repo.deleteById((long) id);
    }
}