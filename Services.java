package com.restsecurity.programtic.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import com.restsecurity.programtic.example.model.SecurityMessage;
import com.restsecurity.programtic.example.model.Student;


@Path("/rest")
public class Services {

	//below resource method is authorized of fixed path /rest/student/list
	@GET
	@Path("/student/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> studentList(@Context SecurityContext securityContext){
		List<Student> studentList =null;
		if(securityContext.isUserInRole("client")){
			
			SecurityMessage SM=new SecurityMessage();
			SM.setRolename("You are logged in with role:"+securityContext.getUserPrincipal().getName());
			SM.setAuth_type("Authentication Type:"+securityContext.getAuthenticationScheme());
			
			
			studentList = new ArrayList<Student>();
			Student st1 = new Student();
			st1.setFirstName("Emily");
			st1.setLastName("Watson");
			st1.setSchool("Edinburgh High School");
			st1.setId(1001);
			st1.setStandard(5);
			st1.setSecurityMessage(SM);
			studentList.add(st1);
			
			
			Student st2 = new Student();
			st2.setFirstName("Sarah");
			st2.setLastName("Williams");
			st2.setSchool("MountainView High School");
			st2.setId(1002);
			st2.setStandard(6);
			st2.setSecurityMessage(SM);
			studentList.add(st2);
		}else{
			throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
		}
		
		return studentList;
	}
	
	@GET
	@Path("/student/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudentById(@PathParam("id")int id,@Context SecurityContext securityContext){
		Student st1 =null;
		if(securityContext.isUserInRole("admin")){
			st1 = new Student();
			st1.setFirstName("Anil");
			st1.setLastName("Kumar");
			st1.setSchool("Edinburgh High School");
			st1.setId(id);
			st1.setStandard(5);
			
		}else{
			throw new WebApplicationException(Response.status(Response.Status.UNAUTHORIZED).build());
		}
		
		
		return Response.ok(st1).build();
	}
}
