package com.mitrais.research.springhibernate.dao;

import com.mitrais.research.springhibernate.model.Role;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Gama Ogi Prayogo
 */
@Transactional
public interface RoleDao {
    public void save(Role role);
    public void update(Role role);
    public void delete(Role role) ;
    @Transactional(readOnly = true)
    public Role get(Role role);
}
