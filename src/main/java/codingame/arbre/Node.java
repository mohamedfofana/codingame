package main.java.codingame.arbre;

import java.util.List;

public class Node {
	
	public int value;
	public int val;
	public Node left;
	public Node parent;
	public List<Node> neighbors;
	Node right;
	
	public Node(int v, Node left, Node right) {
		this.left = left;
		this.right = right;
		this.value = v;
	}
	
	public Node(int val2) {
		// TODO Auto-generated constructor stub
	}

	public Node(int i, Object object, Node head, Object object2) {
		// TODO Auto-generated constructor stub
	}

	public Node getGauche() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getDroite() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Ceci affiche les valeurs de l'arbre en ordre pr���fixe. 
	 * Dans cet ordre, chaque n���ud est visit��� ainsi que chacun de ses fils.
	 */
	void parourirPrefixe(){
			System.out.println(this);
			if (getGauche() != null){
				getGauche().parourirPrefixe();
			}
			if (getDroite() != null){
				getDroite().parourirPrefixe();
			}
	}
	
	/**
	 * Dans un parcours postfixe ou suffixe, 
	 * on affiche chaque n���ud apr���s avoir affich��� chacun de ses fils.
	 */
	void parourirPostfixe(){
			if (getGauche() != null){
				getGauche().parourirPrefixe();
			}
			if (getDroite() != null){
				getDroite().parourirPrefixe();
			}
			System.out.println(this);
	}
	
	/**
	 * Un parcours infixe, comme ci-dessus, visite chaque noeud entre les n���uds de son sous-arbre de gauche 
	 * et les n���uds de son sous-arbre de droite. C'est une mani���re assez commune de parcourir un arbre binaire de recherche, 
	 * car il donne les valeurs dans l'ordre croissant.
	 */
	void parourirInfixe(){
			if (getGauche() != null){
				getGauche().parourirPrefixe();
			}
			System.out.println(this);
			if (getDroite() != null){
				getDroite().parourirPrefixe();
			}
	}
	
	/**
	 * Limiter aun
	 * @param v
	 * @return
	 */
	Node rechercheRecursive(int v){
		Node result = null;
		if (getGauche() != null){
			result = getGauche().rechercheRecursive(v);
		}
		if (getValue() == v){
			return this;
		}		
		if (result == null && getDroite() != null){
			result =  getDroite().rechercheRecursive(v);
		}
		return result;
	}
	
	Node recherche(int v){
		Node result = null;
		if( getValue() == v){
			result = this;
		}
		if (getGauche() != null){
			result = getGauche().recherche(v);
		}
		if (result == null && getDroite() != null){
			result = getDroite().recherche(v);
		}
		return result;
	}
	
	// OK
	Node rechercheIteratif(int v){
		Node result = this;
		while (result != null  && result.value != v){
			if (v > result.getValue()){
				result = result.getDroite();
			}else if (v < result.getValue()){
				result = result.getGauche();
			}
		}
		return result;
	}
	
	
	@Override
	public String toString() {
		return "Node " + this.value;
	}
}
