package com.prajwal.passenger.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import com.prajwal.passenger.entity.PassengerEntity;
import com.prajwal.passenger.service.PassengerService;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin
public class PassengerController {
		
 @Autowired
 private PassengerService ss;
 
// @Operation(summary = "Add Passenger")
// @ApiResponses(value = {
//     @ApiResponse(responseCode = "201", description = "Passenger Added"),
//     @ApiResponse(responseCode = "400", description = "Invalid Input"),
//     @ApiResponse(responseCode = "401", description = "Invalid Credentials")
// })
// @ResponseStatus(HttpStatus.CREATED)
 @PostMapping("/savedata")
 public String savingPassenger(@RequestBody PassengerEntity s) {
	  ss.savedata(s);
	  return "saved";
 }
 
 @GetMapping("/findall")
 public List<PassengerEntity> listing() {
	 return ss.findall();
 }
 
// @GetMapping("/find/{attribute}")
//	public List<PassengerEntity> getAttribute(@PathVariable String attribute){
//	 List<PassengerEntity>allPassenger=ss.getByAttribute(attribute);
//	 return allPassenger;
//}
 	
 
 @DeleteMapping("/deleteById/{id}")
 public String deleteDepartmentById(@PathVariable("id") int id) {
	  ss.deleteDepartmentById(id);
	  return "deleted";
 }
 @PutMapping("/update")
 public Boolean updatestudent(@RequestBody PassengerEntity s) {
	 return ss.updatedata(s)!=null;   
 }
}
