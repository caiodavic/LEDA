package adt.bst.extended;

import adt.bst.BST;
import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		Integer floor = null;
		BST<Integer> tree = new BSTImpl<Integer>();
		this.insert(tree,array,0);

		if(!tree.isEmpty()){
			floor = floor((BSTNode<Integer>) tree.getRoot(),numero);
		}

		return floor;
	}

	private Integer floor(BSTNode<Integer> node, double numero){
		Integer floor = null;
		if(node.isEmpty()){
			return null;
		}
		else{
			if(node.getData() == numero){
				floor = node.getData();
			} else if(node.getData() > numero){
				if(!node.getLeft().isEmpty())
					floor = floor((BSTNode<Integer>) node.getLeft(),numero);
			} else {
				Integer floorRight = null;
				if(!node.getRight().isEmpty()){
					 floorRight = this.floor((BSTNode<Integer>)node.getRight(),numero);
				}
				if(floorRight != null){
					floor = floorRight;
				} else {
					floor = node.getData();
				}

			}
		}

		return floor;
	}

	private void insert(BST<Integer> tree,Integer[] array, int index){
		if(index<array.length){
			tree.insert(array[index]);
			this.insert(tree,array,index+1);
		}
	}


	@Override
	public Integer ceil(Integer[] array, double numero) {
		Integer ceil = null;
		BSTImpl<Integer> tree = new BSTImpl<Integer>();
		this.insert(tree,array,0);

		if(!tree.isEmpty()){
			ceil = this.ceil(tree.getRoot(), numero);
		}
		return ceil;
	}

	public Integer ceil(BSTNode<Integer> node, double numero){
		Integer ceil = null;
		if(node.isEmpty()){
			return null;
		}
		else{
			if (node.getData() == numero){
				ceil = node.getData();
			}else if(node.getData() < numero){
				if(!node.getRight().isEmpty())
					ceil = ceil((BSTNode<Integer>) node.getRight(),numero);
			} else {
				Integer ceilLeft = null;
				if(!node.getLeft().isEmpty()){
					ceilLeft = this.ceil((BSTNode<Integer>) node.getLeft(), numero);
				}
				if(ceilLeft != null){
					ceil = ceilLeft;
				} else {
					ceil = node.getData();
				}
			}
		}
		return ceil;
	}
}
