package com.example.devoirfinale.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.devoirfinale.model.Role;
@Repository
public interface  RoleRepository  extends JpaRepository<Role,Integer>{
	public Role findByNom(String nom);

}
