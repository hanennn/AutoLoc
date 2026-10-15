package tn.esprit.autoloc.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.Entities.Employe;
import tn.esprit.autoloc.Exceptions.ResourceNotFoundException;
import tn.esprit.autoloc.Repositories.EmployeRepo;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class EmployeServiceImpl implements IEmploye {

    private final EmployeRepo employeRepo;

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepo.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepo.deleteById(id);
    }

    @Override
    public Set<Employe> retrieveEmploye() {
        return new HashSet<>(employeRepo.findAll());
    }

    @Override
    public Employe retrieveById(Long id) {
        return employeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employe", id));
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        return employeRepo.save(employe);
    }
}