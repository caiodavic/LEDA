package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveDoubleLinkedListImpl<>();
		lista2 = new RecursiveDoubleLinkedListImpl<>();
		lista3 = new RecursiveDoubleLinkedListImpl<>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
		lista1.insert(5);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1, 5}, lista1.toArray());
		lista1.insert(7);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1, 5,7}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(7);
		Assert.assertArrayEquals(new Integer[] {7,4, 3, 2, 1, 5,7}, lista1.toArray());


	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		lista1.insert(5);
		lista1.insert(6);
		Assert.assertArrayEquals(new Integer[] { 2, 1,5,6 }, lista1.toArray());
		lista1.remove(5);
		Assert.assertArrayEquals(new Integer[] { 2, 1,6 }, lista1.toArray());
		lista1.insert(3);
		Assert.assertArrayEquals(new Integer[] { 2, 1,6,3 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 2, 1, 6 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 2 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());

	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		lista1.insert(4);
		Assert.assertArrayEquals(new Integer[] { 3, 2,4}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
		Assert.assertEquals(2,lista1.size());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertEquals(1,lista1.size());
		Assert.assertArrayEquals(new Integer[] {3}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertEquals(0,lista1.size());
		Assert.assertEquals(1,lista3.size());
	}

	@Test
	public void testRemoveInsert(){
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		Assert.assertEquals(3,lista1.size());
		lista1.insert(5);
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);;
		Assert.assertEquals(5,lista1.size());
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1,5 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		lista1.remove(3);
		Assert.assertEquals(3,lista1.size());
		Assert.assertArrayEquals(new Integer[] { 4,2, 1 }, lista1.toArray());
		lista1.insert(7);
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1,7 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(10);
		Assert.assertArrayEquals(new Integer[] {10, 2, 1,7 }, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {10, 2, 1}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {10, 2}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {10}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).insertFirst(1);
		Assert.assertArrayEquals(new Integer[] {1}, lista1.toArray());
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista1.toArray());
	}

	@Test
	public void testRemoveEmpty(){
		lista2.remove(5);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

	}

	@Test
	public void insertNull(){
		lista1.insert(null);
		Assert.assertEquals(3,lista1.size());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());

		((DoubleLinkedList<Integer>) lista1).insertFirst(null);
		Assert.assertEquals(3,lista1.size());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());


	}

}