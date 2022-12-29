package com.senani.demo;

import com.senani.demo.mocktest.BusinessImpl;
import com.senani.demo.mocktest.DataService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//to replace mocks and inject mocks with real mocks, extension that can initialize mocks
@ExtendWith(MockitoExtension.class)
public class CommonTests {
    @Autowired
    Common common;

    //JUnit doesn't guarantee the execution in the same order that methods have been added
    @Test
    void testCalculateSquare_byValueFive() {
        //fail("Not implemented yet");
        assertTrue(common == null);
        assertNull(common);
        //assertNotNull(common);
    }

    @Test
    void testCalculateSquare_byValueFour() {
        Common common1 = new Common();
        assertEquals(16, common1.calculateSquare(4), "common1.calculateSquare(4) not equal 16");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @AfterEach
    void afterEach() {
        System.out.println("After Each");
    }

    @Mock
    DataService dataServiceMock;

    @InjectMocks //to inject mocks into BusinessImpl
    BusinessImpl businessImpl;

    @Test
    void getLargestFromAllData_basicScenario() {
        DataService dataService1 = mock(DataService.class);
        when(dataService1.retreiveData()).thenReturn(new int[]{10, 21});
        BusinessImpl businessImpl1 = new BusinessImpl(dataService1);
        assertEquals(20, businessImpl1.getLargestFromAllData());
    }

    @Test
    void getLargestFromAllData_withAnnotations() {
        when(dataServiceMock.retreiveData()).thenReturn(new int[]{10, 20});
        assertEquals(20, businessImpl.getLargestFromAllData());
    }

    @Test
    void listMocking() {
        List listMock = mock(List.class);
        when(listMock.get(Mockito.anyInt())).thenReturn("Hello");
        assertEquals("Hello", listMock.get(5));
    }
}
