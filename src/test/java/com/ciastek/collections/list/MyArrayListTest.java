package com.ciastek.collections.list;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class MyArrayListTest {
    private MyList list;

    @BeforeMethod
    public void setUp() {
        list = new MyArrayList();
    }

    @Test
    public void should_list_be_empty_when_created() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void should_list_not_be_empty_when_element_added() {
        Integer element = 5;
        list.add(element);

        assertFalse(list.isEmpty());
    }

    @Test
    public void should_size_return_0_when_invoked_on_empty_list() {
        int expectedSize = 0;
        int actualSize = list.size();

        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @DataProvider
    public Object[][] elementsToAdd(){
        return new Object[][] {
                {0, 1, 5, 78, 99, 56},
                {0, 18, 5, 78, 9},
                {8, 1, 9, 12, 6, 23, 41, 56}
        };
    }

    @Test(dataProvider = "elementsToAdd")
    public void should_size_return_number_of_added_elements_to_empty_list(Integer[] elements) {
        Arrays.stream(elements).forEach(list::add);

        int expectedSize = elements.length;
        int actualSize = list.size();

        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void should_throw_exception_when_get_invoked_on_empty_list(){
        list.get(0);
    }

    @Test(dataProvider = "elementsToAdd")
    public void should_return_element_on_provided_index_when_get(Integer[] elements){
        Arrays.stream(elements).forEach(list::add);

        Random rand = new Random();
        int indexToGet = rand.nextInt(elements.length -1);

        Integer expectedElement = elements[indexToGet];
        Integer actualElement = list.get(indexToGet);

        assertThat(actualElement).isEqualTo(expectedElement);
    }

    @Test
    public void should_return_false_when_list_does_not_contain_element(){
        list.add(5);
        Integer elementToFind = 10;

        assertFalse(list.contains(elementToFind));
    }

    @Test
    public void should_return_true_when_list_contains_element(){
        Integer elementToFind = 10;

        list.add(elementToFind);

        assertTrue(list.contains(elementToFind));
    }

    @Test
    public void should_return_false_when_contains_invoked_with_null(){
        list.add(5);

        assertFalse(list.contains(null));
    }

    @Test(expectedExceptions = IndexOutOfBoundsException.class)
    public void should_throw_exception_when_set_invoked_with_not_existing_index(){
        list.add(5);
        Integer newElement = 10;

        list.set(1, newElement);
    }

    @Test
    public void should_change_element_when_set_invoked_with_existing_index(){
        list.add(5);
        Integer newElement = 10;
        int index = 0;

        list.set(index, newElement);
        Integer actualElement = list.get(index);

        assertThat(actualElement).isEqualTo(newElement);
    }

    @Test
    public void should_return_previous_element_when_set(){
        Integer firstElement = 5;
        list.add(firstElement);
        Integer newElement = 10;
        int index = 0;

        Integer previousElement = list.set(index, newElement);

        assertThat(previousElement).isEqualTo(firstElement);
    }
}