package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Model.UserModel;

public interface UserRepository extends JpaRepository<UserModel,Long> {

}
