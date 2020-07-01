package com.michael.page.mssatisfaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MsSatisfactionApplicationTests {

    @Test
    public void mockTest() {
        ArrayList arrayList = mock(ArrayList.class);
        arrayList.add("Object 1");
        arrayList.add("Object 2");
        arrayList.add("Object 3");
        System.out.println(arrayList.size());
    }

}
