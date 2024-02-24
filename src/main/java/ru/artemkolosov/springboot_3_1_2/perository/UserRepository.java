package ru.artemkolosov.springboot_3_1_2.perository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.artemkolosov.springboot_3_1_2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
