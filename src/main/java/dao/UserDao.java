package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dto.UserDto;

public class UserDao 
{

	EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
	EntityManager em=emf.createEntityManager();
	EntityTransaction t=em.getTransaction();
	
	public void save(UserDto dto)
	{
		t.begin();
		em.persist(dto);
		t.commit();
	}
//	public UserDto Login(long mob)
//	{
//		return em.find(UserDto.class, mob);
//	}
	public UserDto logine(String email)
	{
		 List<UserDto> list = em.createQuery("select x from UserDto x where email=?1").setParameter(1, email).getResultList();
//		em.createQuery("select x from UserDto x where email=?1").setParameter(1, email); when written in JBQL
		//return em.find(UserDto.class,mob); this method is taken only when mobile number is given as primary key.
	 if (list.isEmpty()) 
	 {
		return null;
	}
	 else
	 {
		 return list.get(0);
	 }
	}
	public UserDto loginm(long mob)
	{
		List<UserDto> list = em.createQuery("select x from UserDto x where mobile=?1").setParameter(1,mob).getResultList();
	    if(list.isEmpty()) 	
	    {
	    	return null;
	    }
	    else{
	    	return list.get(0);
	    }
	}
	public 	List<UserDto> fetchall()
	{
		 return em.createQuery("select x from UserDto x").getResultList();
	}
	public UserDto find(int id)
	{
		return em.find(UserDto.class, id);
	}
	public void delete(UserDto userdto)
	{
		t.begin();
		em.remove(userdto);
		t.commit();
	}
	public void Update(UserDto userdto)
	{
		t.begin();
		em.merge(userdto);
		t.commit();
	}
}
