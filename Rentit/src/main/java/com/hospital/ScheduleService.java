package com.hospital;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ScheduleService {
	
	@Autowired
    private ScheduleRepository repo;
     
    public List<Schedule> listAll() {
        return repo.findAll();
    }
     
    public void save(Schedule schedule) {
        repo.save(schedule);
    }
     
    public Schedule get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

	

}

