package com.employee1;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class OperationsTest {

	@Test
	void testInsertion() throws ClassNotFoundException, SQLException {
		int res=Operations.insertion();
		assertEquals(res, 1);
		
	}

}
