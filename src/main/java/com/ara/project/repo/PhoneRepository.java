package com.ara.project.repo;

import com.ara.project.model.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneRepository extends CrudRepository<Phone,Long> {
}
