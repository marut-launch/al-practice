package code.marut.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {

	private static class Solution2 {
		public boolean isSymmetric(TreeNode root) {
			return isMirror(root, root);
		}

		private boolean isMirror(TreeNode t1, TreeNode t2) {
			if (t1 == null && t2 == null)
				return true;
			if (t1 == null || t2 == null)
				return false;
			return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
		}
	}

	private static class Solution1 {
		List<TreeNode> level;

		public boolean isSymmetric(TreeNode root) {
			if (root == null) {
				return true;
			}
			level = new ArrayList<>();
			level.add(root);
			while (!addLevel()) {
				if (!compareLevelSymmetry()) {
					return false;
				}
			}
			return true;
		}

		private boolean addLevel() {
			System.out.println(level);
			boolean allNull = true;
			List<TreeNode> current = new ArrayList<>();
			for (int i = 0; i < level.size(); i++) {
				if (level.get(i) != null) {
					allNull = false;
					current.add(level.get(i).left);
					current.add(level.get(i).right);
				} else {
					current.add(null);
					current.add(null);
				}
			}
			level = current;
			return allNull;
		}

		private boolean compareLevelSymmetry() {
			int l = 0, r = level.size() - 1;
			while (l < r) {
				if (level.get(l) != null && level.get(r) != null) {
					if (!level.get(l).val.equals(level.get(r).val))
						return false;
				} else if (level.get(l) != level.get(r)) {
					return false;
				}
				l++;
				r--;
			}
			return true;
		}

	}

	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		t.left = new TreeNode(2);
		t.left.right = new TreeNode(3);

		t.right = new TreeNode(2);
		t.right.right = new TreeNode(3);
		System.out.println(new Solution1().isSymmetric(t));
		System.out.println(new Solution2().isSymmetric(t));
	}

}
