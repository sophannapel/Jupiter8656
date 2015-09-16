package edu.mum.cs.cs425.demos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonDAOTests {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void testSaveOrderWithItems() throws Exception {
	}
}
