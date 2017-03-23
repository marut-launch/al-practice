package code.marut.practice.graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Heap<T> {
	private PriorityQueue<T> values;

	public Heap(Comparator<T> cmp) {
		values = new PriorityQueue<T>(cmp);
	}

	public T getNode(T node) {
		if (values.contains(node)) {
			Iterator<T> itr = values.iterator();
			while (itr.hasNext()) {
				T cur = itr.next();
				if (node.equals(cur)) {
					return cur;
				}
			}
		}
		return null;
	}

	public void add(T mem) {
		if (values.contains(mem)) {
			values.remove(mem);
		}
		values.add(mem);
	}

	public T getTop() {
		if (values.isEmpty()) {
			return null;
		}
		return values.remove();
	}
}
