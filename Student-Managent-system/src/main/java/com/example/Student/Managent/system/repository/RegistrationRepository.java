package com.example.Student.Managent.system.repository;

import com.example.Student.Managent.system.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration,Long> {
}
