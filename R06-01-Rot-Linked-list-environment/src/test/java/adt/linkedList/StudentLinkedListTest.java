package adt.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class StudentLinkedListTest {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new RecursiveSingleLinkedListImpl<>();
		lista2 = new RecursiveSingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		Assert.assertFalse(lista1.isEmpty());
		Assert.assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		Assert.assertEquals(3, lista1.size());
		Assert.assertEquals(0, lista2.size());
		lista1.remove(3);
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(0,lista1.size());
		lista1.insert(1);
		lista1.remove(1);
		Assert.assertEquals(0,lista1.size());
		lista2.insert(5);
		lista2.insert(5);
		lista2.insert(5);
		lista2.insert(5);
		lista2.insert(5);
		lista2.remove(5);
		lista2.remove(5);
		Assert.assertEquals(3,lista2.size());

	}

	@Test
	public void testSearch() {
		Assert.assertTrue(2 == lista1.search(2));
		Assert.assertNull(lista1.search(4));
		Assert.assertFalse(3 == lista1.search(2));
		Assert.assertTrue(3 ==lista1.search(3));
		Assert.assertTrue(1 ==lista1.search(1));
		Assert.assertNull(lista1.search(5));
		lista1.insert(4);
		Assert.assertTrue(4 == lista1.search(4));
		lista1.remove(4);
		Assert.assertNull(lista1.search(4));

	}

	@Test
	public void testInsert() {
		Assert.assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		Assert.assertEquals(5, lista1.size());

		lista1.insert(null);
		Assert.assertTrue(5 == lista1.size());

		Assert.assertEquals(0, lista2.size());
		lista2.insert(4);
		Assert.assertTrue(1==lista2.size());
		lista2.insert(7);
		Assert.assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		Assert.assertEquals(1, lista1.size());
		lista2.remove(3);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		lista2.insert(1);
		lista2.insert(2);
		lista2.insert(3);
		Assert.assertArrayEquals(new Integer[] {1,2,3}, lista2.toArray());
		lista2.remove(3);
		Assert.assertEquals(2,lista2.size());
		Assert.assertArrayEquals(new Integer[] {1,2} , lista2.toArray());
		lista2.remove(2);
		Assert.assertEquals(1,lista2.size());
		Assert.assertArrayEquals(new Integer[] {1} , lista2.toArray());
		lista2.remove(1);
		Assert.assertEquals(0,lista2.size());
		Assert.assertArrayEquals(new Integer[] {} , lista2.toArray());


	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());
		Assert.assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
		lista2.insert(5);
		Assert.assertArrayEquals(new Integer[] {5}, lista2.toArray());
		lista2.insert(5);
		Assert.assertArrayEquals(new Integer[] {5,5}, lista2.toArray());
		lista2.insert(5);
		Assert.assertArrayEquals(new Integer[] {5,5,5}, lista2.toArray());
		lista2.remove(5);
		Assert.assertArrayEquals(new Integer[] {5,5}, lista2.toArray());
		lista2.remove(5);
		Assert.assertArrayEquals(new Integer[] {5}, lista2.toArray());
		lista2.remove(5);
		Assert.assertArrayEquals(new Integer[] {}, lista2.toArray());

	}
}