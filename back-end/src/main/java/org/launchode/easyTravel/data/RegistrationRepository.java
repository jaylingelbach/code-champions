package org.launchode.easyTravel.data;


import org.launchode.easyTravel.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends CrudRepository<User, Integer>{
}
