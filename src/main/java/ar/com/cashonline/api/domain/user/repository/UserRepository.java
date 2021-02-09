package ar.com.cashonline.api.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.cashonline.api.domain.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
