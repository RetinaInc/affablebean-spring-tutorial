package com.hvn.velocity.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.hvn.velocity.domain.Member;
import com.hvn.velocity.repository.MemberDao;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTests {

	/** {@link MemberService} instance under test */
	@InjectMocks
	private MemberService service;
	
	/**
	 * Mock objects declaration
	 */
	@Mock private MemberDao mockMemberDao;
	
	/**
	 * Method to perform setup work for each test.
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Method to perform tear down work for each test.
	 */
	@After
	public void tearDown() throws Exception {
		Mockito.reset(mockMemberDao);
	}

	/**
	 * Test {@link MemberService#getAll()}
	 */
	@Test
	public void getAll() {
		// arrange
		List<Member> memberList = Arrays.asList(new Member());
		Mockito.when(mockMemberDao.findAll()).thenReturn(memberList);
		// exercise
		List<Member> expectedList = service.getAll();
		// verify
		assertThat(expectedList).isEqualTo(memberList);
		Mockito.verify(mockMemberDao).findAll();
	}

}
