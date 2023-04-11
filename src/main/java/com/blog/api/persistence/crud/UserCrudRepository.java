package com.blog.api.persistence.crud;

import com.blog.api.persistence.entity.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserCrudRepository extends CrudRepository<User, Integer> {
}
