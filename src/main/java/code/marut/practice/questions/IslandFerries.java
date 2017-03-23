package code.marut.practice.questions;

import java.util.*;

public class IslandFerries {
	static class State implements Comparable {
		int island;
		int tickets;
		int cost;

		public State(int i, int t, int c) {
			island = i;
			tickets = t;
			cost = c;
		}

		public int compareTo(Object o) {
			State that = (State) o;
			if (this.cost != that.cost)
				return this.cost - that.cost;
			if (this.island != that.island)
				return this.island - that.island;
			return this.tickets - that.tickets;
		}
	}

	public static final int INF = 400000;

	public int[] costs(String[] legs, String[] prices) {
		int I = prices.length;
		int F = legs.length;
		boolean[][][] edge = new boolean[F][I][I];
		for (int i = 0; i < F; ++i) {
			StringTokenizer t = new StringTokenizer(legs[i], "- ");
			while (t.hasMoreTokens()) {
				int a = Integer.parseInt(t.nextToken());
				int b = Integer.parseInt(t.nextToken());
				edge[i][a][b] = true;
			}
		}
		int[][] prize = new int[F][I];
		for (int i = 0; i < I; ++i) {
			StringTokenizer t = new StringTokenizer(prices[i]);
			for (int f = 0; f < F; ++f) {
				prize[f][i] = Integer.parseInt(t.nextToken());
			}
		}
		int[][] cost = new int[I][1 << F];
		for (int i = 0; i < I; ++i) {
			Arrays.fill(cost[i], INF);
		}
		// cost[0][0] = 0;
		TreeSet q = new TreeSet();
		q.add(new State(0, 0, 0));
		while (!q.isEmpty()) {
			State s = (State) q.first();
			q.remove(s);
			if (cost[s.island][s.tickets] <= s.cost)
				continue;
			cost[s.island][s.tickets] = s.cost;
			// buy ticket
			if (count(s.tickets) < 3) {
				for (int f = 0; f < F; ++f) {
					if (cost[s.island][s.tickets | (1 << f)] >= INF) {
						q.add(new State(s.island, s.tickets | (1 << f), s.cost + prize[f][s.island]));
					}
				}
			}
			// take ride
			for (int i = 0; i < I; ++i) {
				if (i == s.island)
					continue;
				for (int f = 0; f < F; ++f) {
					if ((s.tickets & (1 << f)) != 0 && edge[f][s.island][i]) {
						int tt = s.tickets - (1 << f);
						if (cost[i][tt] > s.cost) {
							q.add(new State(i, tt, s.cost));
						}
					}
				}
			}
		}
		int[] result = new int[I - 1];
		Arrays.fill(result, -1);
		for (int i = 1; i < I; ++i) {
			int best = INF;
			for (int t = 0; t < cost[i].length; ++t) {
				best = Math.min(best, cost[i][t]);
			}
			if (best < INF)
				result[i - 1] = best;
		}
		return result;
	}

	public int count(int v) {
		int result = 0;
		while (v != 0) {
			result += v & 1;
			v >>= 1;
		}
		return result;
	}

}