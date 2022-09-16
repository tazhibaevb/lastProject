package kg.megacom.lastproject.repositories;

import kg.megacom.lastproject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
