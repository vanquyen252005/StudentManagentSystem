package com.example.Student.Managent.system.service;


import com.example.Student.Managent.system.entity.Registration;

import java.util.List;

public interface RegistrationService {
    public List<Registration> getAllRegistrations();
    public void saveRegistration(Registration registration);
    public Registration getRegistrationById(Long registrationId);
    public void deleteRegistration(Long registrationId);
}
