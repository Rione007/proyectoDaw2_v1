package cibertec.pe.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.pe.entities.Sucursal;
import cibertec.pe.repository.ISucursalRepository;
import cibertec.pe.service.interfaces.ISucursalService;

@Service
public class SucursalService implements ISucursalService {

    @Autowired
    private ISucursalRepository repo;

    @Override
    public List<Sucursal> getSucursal() {
        return repo.findAll();
    }

    @Override
    public Optional<Sucursal> getSucursalId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Sucursal createSucursal(Sucursal suc) {
        return repo.save(suc);
    }

    @Override
    public Sucursal updateSucursal(int id, Sucursal suc) {

        Optional<Sucursal> sucursal = repo.findById((long) id);

        if (sucursal.isPresent()) {

            Sucursal data = sucursal.get();

            data.setNombre(suc.getNombre());
            data.setDireccion(suc.getDireccion());
            data.setTelefono(suc.getTelefono());
            data.setEmpresa(suc.getEmpresa());

            return repo.save(data);
        }

        return null;
    }

    @Override
    public void deleteSucursal(int id) {
        repo.deleteById((long) id);
    }
}