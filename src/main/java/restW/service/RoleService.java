package restW.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restW.model.Role;
import restW.repository.RoleRepository;

import java.util.List;

@Slf4j
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getById(Integer id) {
        //log.info("In RoleService getById{}", id);
        return roleRepository.findOne(id);
    }

    public void save(Role role) {
        //log.info("In RoleService save {}", role);
        roleRepository.save(role);
    }

    public void delete(Integer id) {
        //log.info("In RoleService delete {}", id);
        roleRepository.delete(id);
    }

    public List<Role> getAll() {
        //log.info("In RoleService getAll");
        return roleRepository.findAll();
    }
}
