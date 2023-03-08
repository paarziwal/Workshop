package com.prajwal.passenger.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.prajwal.passenger.entity.PassengerEntity;
public interface PassengerRepo extends JpaRepository<PassengerEntity, Integer>
{
//	@Query(
//			value = "select * from passenger p where p.name =?1 ",
//			nativeQuery= true)
//	List<Passenger> findAllPassengerNative(String name);
}