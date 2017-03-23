package code.marut.practice.tree;

public class ValidBST {
	public static class BruteForce {
		public static boolean isValidBST(DTree root) {
			if (root == null)
				return true;
			return isSubTreeLessThan(root.left, root.data) && isSubTreeGreaterThan(root.right, root.data)
					&& isValidBST(root.left) && isValidBST(root.right);
		}

		private static boolean isSubTreeLessThan(DTree p, int val) {
			if (p == null)
				return true;
			return p.data < val && isSubTreeLessThan(p.left, val) && isSubTreeLessThan(p.right, val);
		}

		private static boolean isSubTreeGreaterThan(DTree p, int val) {
			if (p == null)
				return true;
			return p.data > val && isSubTreeGreaterThan(p.left, val) && isSubTreeGreaterThan(p.right, val);
		}
	}

	public static class TopDownRecursion {
		public static boolean isValidBST(DTree root) {
			if (root == null)
				return true;
			return valid(root, null, null);
		}

		private static boolean valid(DTree p, Integer low, Integer high) {
			if (p == null)
				return true;
			return (low == null || low < p.data) && (high == null || high > p.data) && valid(p.left, low, p.data)
					&& valid(p.right, p.data, high);
		}
	}
	
	public static class InorderTranversalCheck{
		static DTree prev = null; 
		public static boolean isValidBST (DTree root){
			if(root == null) return true;
			prev = null;
			return isMonotonicIncreasing(root);
		}
		
		private static boolean isMonotonicIncreasing(DTree p){
			if(p==null) return true;
			if(isMonotonicIncreasing(p.left)){
				if(prev!=null && prev.data>p.data){
					return false;
				}
				prev=p;
				return isMonotonicIncreasing(p.right);
			}
			return false;
		}
	}

	public static void main(String[] args) {
		DTree t = TreeUtils.exValidBST1();
		DTree t2 = TreeUtils.exInvalidBST1();
		System.out.println("(Brute force) Tree is valid T1# " + BruteForce.isValidBST(t));
		System.out.println("(Brute force) Tree is valid T2# " + BruteForce.isValidBST(t2));
		
		System.out.println("(Top down) Tree is valid T1# " + TopDownRecursion.isValidBST(t));
		System.out.println("(Top down) Tree is valid T2# " + TopDownRecursion.isValidBST(t2));
		
		System.out.println("(Top down) Tree is valid T1# " + InorderTranversalCheck.isValidBST(t));
		System.out.println("(Top down) Tree is valid T2# " + InorderTranversalCheck.isValidBST(t2));
	}
}
