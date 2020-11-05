package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		if(this.isFull())throw new HashtableOverflowException();

		if(element != null && search(element) == null){
			int probe = 0;
			int hashElement = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,probe);
			while(this.table[hashElement] != null && !this.table[hashElement].equals(deletedElement)){
				hashElement = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,++probe);
				COLLISIONS++;

			}
			this.table[hashElement] = element;
			elements++;
		}
	}

	@Override
	public void remove(T element) {
		if(element != null && this.search(element) != null && !this.isEmpty()){
			int probe = 0;
			int hashElement = ((HashFunctionQuadraticProbing<T>)this.hashFunction).hash(element,probe);
			while (this.table[hashElement] != null && probe < table.length) {
				if(this.table[hashElement].equals(element)) {
					this.table[hashElement] = deletedElement;
					COLLISIONS-=probe;
					elements--;
					break;
				}
				hashElement = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, ++probe);
			}
		}
	}

	@Override
	public T search(T element) {
		T retorno = null;
		if (element != null && !this.isEmpty()) {
			int index = indexOf(element);
			if (index != -1) {
				retorno = (T) this.table[index];
			}

		}
		return retorno;
	}

	@Override
	public int indexOf(T element) {
		int index = -1;
		if (element != null && !this.isEmpty()){
			int probe = 0;
			int hashElement = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, probe);

			while (this.table[hashElement] != null && probe < table.length) {
				if(this.table[hashElement].equals(element)) {
					index = hashElement;
					break;
				}
				hashElement = ((HashFunctionQuadraticProbing<T>) this.hashFunction).hash(element, ++probe);
			}

		}
		return index;
	}
}