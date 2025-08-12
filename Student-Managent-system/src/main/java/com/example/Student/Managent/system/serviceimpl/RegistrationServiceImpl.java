package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Registration;
import com.example.Student.Managent.system.service.RegistrationService;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public List<Registration> getAllRegistrations() {
        return List.of();
    }

    @Override
    public void saveRegistration(Registration registration) {

    }

    @Override
    public Registration getRegistrationById(Long registrationId) {
        return null;
    }

    @Override
    public void deleteRegistration(Long registrationId) {

    }
}
