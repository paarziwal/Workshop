package com.prajwal.passenger.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.prajwal.passenger.entity.PassengerEntity;
import com.prajwal.passenger.repository.PassengerRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Service
public class PassengerService {
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	private PassengerRepo stu;
	
	public PassengerEntity savedata(PassengerEntity s) {
		return stu.save(s);
	}
	public void deleteDepartmentById(int id) {
		stu.deleteById(id);
	}
	public PassengerEntity updatedata(PassengerEntity s) {
		return stu.saveAndFlush(s);
    }
	
//	public List<PassengerEntity> getByAttribute(String attribute){
//		return stu.findAllPassengerNative(attribute);
//	}
//	public Passenger readEM(String name) {
//		Query q = this.entityManager.createQuery("SELECT e FROM Passenger e WHERE e.name = :name");
//				q.setParameter("name", name);
//		return (Passenger) q.getSingleResult();
//	}
	public List<PassengerEntity> findall() {
		// TODO Auto-generated method stub
		return stu.findAll();
		
	}
}
