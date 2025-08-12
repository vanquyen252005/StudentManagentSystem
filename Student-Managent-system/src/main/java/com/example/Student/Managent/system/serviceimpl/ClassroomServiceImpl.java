package com.example.Student.Managent.system.serviceimpl;

import com.example.Student.Managent.system.entity.Classroom;
import com.example.Student.Managent.system.repository.ClassroomRepository;
import com.example.Student.Managent.system.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<Classroom> getAllClassrooms() {
        return (List<Classroom>) classroomRepository.findAll();
    }

    @Override
    public void saveClassroom(Classroom classroom) {
    classroomRepository.save(classroom);
    }

    @Override
    public Classroom getClassroomById(Long classroomId) {
        Optional<Classroom> classroom = classroomRepository.findById(classroomId);
        if(classroom.isPresent()) {
            return classroom.get();
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteClassroom(Long classroomId) {
    classroomRepository.deleteById(classroomId);
    }

    @Override
    public List<Classroom> getClassesByDepartmentId(Long departmentId) {
        return(List<Classroom>) classroomRepository.findByDepartmentId(departmentId);
    }
}
