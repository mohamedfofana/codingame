package main.java.codingame.arbre;

public class TreeNode {
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int v) {
		this.left = left;
		this.right = right;
		this.val = v;
	}
	
	public TreeNode getGauche() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getDroite() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public int getValue() {
		return val;
	}

	public void setValue(int value) {
		this.val = value;
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
	TreeNode rechercheRecursive(int v){
		TreeNode result = null;
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
	
	TreeNode recherche(int v){
		TreeNode result = null;
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
	TreeNode rechercheIteratif(int v){
		TreeNode result = this;
		while (result != null  && result.val != v){
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
		return "Node " + this.val;
	}
}
