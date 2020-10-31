package adt.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentQueueTest {

	public Queue<Integer> queue1;
	public Queue<Integer> queue2;
	public Queue<Integer> queue3;
	public Queue<Integer> queueTam0;

	@Before
	public void setUp() throws QueueOverflowException {

		getImplementations();

		// Fila com 3 elementos não cheia.
		queue1.enqueue(1);
		queue1.enqueue(2);
		queue1.enqueue(3);

		// Fila com 2 elementos de tamanho 2. Fila cheia.
		queue2.enqueue(1);
		queue2.enqueue(2);

	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		queue1 = new QueueDoubleLinkedListImpl<>(5);
		queue2 = new QueueDoubleLinkedListImpl<>(2);
		queue3 = new QueueDoubleLinkedListImpl<>(4);
		queueTam0 = new QueueDoubleLinkedListImpl<>(0);
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead() {
		assertEquals(new Integer(1), queue1.head());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertFalse(queue1.isFull());
	}

	@Test
	public void testEnqueue() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
										// foi iniciada!!!
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
														// tamanho que a fial
														// foi iniciada!!!
	}

	// MÉTODOS DE TESTE
	@Test
	public void testHead2() {
		assertEquals(new Integer(1), queue1.head());
		assertEquals(null,queue3.head());
	}

	@Test
	public void testIsEmpty2() {
		assertFalse(queue1.isEmpty());
		assertTrue(queue3.isEmpty());
	}

	@Test
	public void testIsFull2() {
		assertFalse(queue1.isFull());

		try {
			queue1.enqueue(new Integer(4));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(queue1.isFull());
	}

	@Test
	public void testEnqueue2() {
		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertFalse(queue1.isFull());

		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(queue1.isFull());

		try {
			queue1.enqueue(new Integer(5));
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(expected = QueueOverflowException.class)
	public void testEnqueueComErro2() throws QueueOverflowException {
		queue2.enqueue(new Integer(5)); // vai depender do tamanho que a fila
		// foi iniciada!!!
	}

	@Test
	public void testDequeue2() {


		try {
			assertEquals(new Integer(1), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(new Integer(2),queue1.head());

		try {
			assertEquals(new Integer(2), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(new Integer(3),queue1.head());

		try {
			assertEquals(new Integer(3), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue(queue1.isEmpty());
		assertEquals(null,queue1.head());

		try {
			assertEquals(new Integer(3), queue1.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(expected = QueueUnderflowException.class)
	public void testDequeueComErro2() throws QueueUnderflowException {
		assertEquals(new Integer(1), queue3.dequeue()); // vai depender do
		// tamanho que a fial
		// foi iniciada!!!
	}

	@Test
	public void testaInsereNull2()throws QueueOverflowException{
		queue3.enqueue(null);
		assertTrue(queue3.isEmpty());

		queue1.enqueue(null);
		assertEquals(new Integer (1),queue1.head());
	}

	@Test
	public void insereERemoveMuitosElementos2() throws QueueOverflowException, QueueUnderflowException{
		queue3.enqueue(new Integer(1));
		queue3.enqueue(new Integer(2));
		queue3.dequeue();
		assertEquals(new Integer(2),queue3.head());
		queue3.enqueue(new Integer(3));
		queue3.enqueue(new Integer(4));
		queue3.dequeue();
		assertEquals(new Integer(3),queue3.head());
		queue3.enqueue(new Integer(5));
		queue3.enqueue(new Integer(6));
		queue3.dequeue();
		assertEquals(new Integer(4),queue3.head());
		queue3.enqueue(new Integer(3));
		assertTrue(queue3.isFull());
		queue3.dequeue();
		queue3.enqueue(new Integer(7));

		try{
			queue3.enqueue(new Integer(8));
		} catch(QueueOverflowException e){
			e.printStackTrace();
		}
	}

	@Test
	public void testandoQueueTam02() throws QueueOverflowException, QueueUnderflowException {
		assertTrue(queueTam0.isEmpty());
		assertTrue(queueTam0.isFull());
		try{
			queueTam0.enqueue(new Integer(3));
		} catch (QueueOverflowException e){
			e.printStackTrace();
		}

		try{
			queueTam0.dequeue();
		} catch (QueueUnderflowException e){
			e.printStackTrace();
		}
	}
}