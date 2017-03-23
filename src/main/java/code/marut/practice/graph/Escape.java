package code.marut.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
You are playing a video game that involves escaping from a dangerous area. Within the area there are DEADLY regions you can't enter, HARMFUL regions that take 
1 life for every step you make in them, and NORMAL regions that don't affect you in any way. You will start from (0,0) and have to make it to (500,500) using only
 Up, Left, Right, and Down steps. The map will be given as a String[] deadly listing the DEADLY regions and a String[] harmful listing the HARMFUL regions. 
 The elements in each of these parameters will be formatted as follows:

Input format(quotes for clarity): "X1 Y1 X2 Y2" where
(X1,Y1) is one corner of the region and
(X2,Y2) is the other corner of the region

The corners of the region are inclusive bounds (i.e. (4,1) and (2,2) include x-values between 4 and 2 inclusive and y-values between 1 and 2 inclusive). 
All unspecified regions are considered NORMAL. If regions overlap for a particular square, then whichever region is worst takes effect 
(e.g. DEADLY+HARMFUL = DEADLY, HARMFUL+NORMAL = HARMFUL, HARMFUL+HARMFUL = HARMFUL, DEADLY+NORMAL=DEADLY).

Damage taken at each step occurs based on the destination square and not on the starting square (e.g. if the square (500,500) is HARMFUL you WILL take a point of
 damage stepping onto it; if the square (0,0) is HARMFUL you WON'T take a point of damage stepping off of it; this works analogously for DEADLY squares). 

Return the least amount of life you will have to lose in order to reach the destination. Return -1 if there is no path to the destination. Your character is 
not allowed to leave the map (i.e. have X or Y less than 0 or greater than 500). 
 
Definition
Class:	Escape
Method:	lowest
Parameters:	String[], String[]
Returns:	int
Method signature:	int lowest(String[] harmful, String[] deadly)
(be sure your method is public)
 
Notes
-	If two harmful regions overlap, the area where they overlap is exactly the same as non-overlapping harmful regions (i.e. the effect is NOT cumulative, and the overlapping region still takes exactly 1 life)
 
Constraints
-	deadly will contain between 0 and 50 elements inclusive
-	harmful will contain between 0 and 50 elements inclusive
-	Each element of deadly and harmful will be of the form (quotes for clarity): "X1 Y1 X2 Y2"

where X1,Y1,X2, and Y2 are integers between 0 and 500 inclusive and contain no leading zeros
-	Each element of deadly and harfmul will contain no leading, trailing or extra whitespace
 
Examples
0)	
    	
{}
{}
Returns: 0
There are no DEADLY or HARMFUL regions.
1)	
    	
{"500 0 0 500"}
{"0 0 0 0"}
Returns: 1000
(0,0) is DEADLY but that doesn't affect our path since we never step onto it (only from it). The rest of the map is NORMAL.
2)	 	
{"0 0 250 250","250 250 500 500"}
{"0 251 249 500","251 0 500 249"}
Returns: 1000
Just enough space to get around the DEADLY regions.
3)		
{"0 0 250 250","250 250 500 500"}
{"0 250 250 500","250 0 500 250"}
Returns: -1
No way around the DEADLY regions.
4)		
{"468 209 456 32",
 "71 260 306 427",
 "420 90 424 492",
 "374 253 54 253",
 "319 334 152 431",
 "38 93 204 84",
 "246 0 434 263",
 "12 18 118 461",
 "215 462 44 317",
 "447 214 28 475",
 "3 89 38 125",
 "157 108 138 264",
 "363 17 333 387",
 "457 362 396 324",
 "95 27 374 175",
 "381 196 265 302",
 "105 255 253 134",
 "0 308 453 55",
 "169 28 313 498",
 "103 247 165 376",
 "264 287 363 407",
 "185 255 110 415",
 "475 126 293 112",
 "285 200 66 484",
 "60 178 461 301",
 "347 352 470 479",
 "433 130 383 370",
 "405 378 117 377",
 "403 324 369 133",
 "12 63 174 309",
 "181 0 356 56",
 "473 380 315 378"}
{"250 384 355 234",
 "28 155 470 4",
 "333 405 12 456",
 "329 221 239 215",
 "334 20 429 338",
 "85 42 188 388",
 "219 187 12 111",
 "467 453 358 133",
 "472 172 257 288",
 "412 246 431 86",
 "335 22 448 47",
 "150 14 149 11",
 "224 136 466 328",
 "369 209 184 262",
 "274 488 425 195",
 "55 82 279 253",
 "153 201 65 228",
 "208 230 132 223",
 "369 305 397 267",
 "200 145 98 198",
 "422 67 252 479",
 "231 252 401 190",
 "312 20 0 350",
 "406 72 207 294",
 "488 329 338 326",
 "117 264 497 447",
 "491 341 139 438",
 "40 413 329 290",
 "148 245 53 386",
 "147 70 186 131",
 "300 407 71 183",
 "300 186 251 198",
 "178 67 487 77",
 "98 158 55 433",
 "167 231 253 90",
 "268 406 81 271",
 "312 161 387 153",
 "33 442 25 412",
 "56 69 177 428",
 "5 92 61 247"}
Returns: 254
 */

public class Escape {

	int max = 500;
	int cnt = 0;
	int[][] visited = null;
	int[][] route = null;

	public static class Node {
		public int x, y, lifeUsed = 0;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Node(int x, int y, int lifeUsed) {
			this.x = x;
			this.y = y;
			this.lifeUsed = lifeUsed;
		}
	}

	public void fillValues(String[] values, int fillin) {
		for (String value : values) {
			String[] tok = value.split(" ");
			int start_x, start_y, end_x, end_y;
			start_x = new Integer(tok[0]);
			end_x = new Integer(tok[2]);
			if (new Integer(tok[0]) > new Integer(tok[2])) {
				start_x = new Integer(tok[2]);
				end_x = new Integer(tok[0]);
			}
			start_y = new Integer(tok[1]);
			end_y = new Integer(tok[3]);

			if (new Integer(tok[1]) > new Integer(tok[3])) {
				start_x = new Integer(tok[3]);
				end_x = new Integer(tok[1]);
			}

			start_x = start_x >= max ? max - 1 : start_x;
			start_y = start_y >= max ? max - 1 : start_y;
			end_x = end_x >= max ? max - 1 : end_x;
			end_y = end_y >= max ? max - 1 : end_y;
			for (int i = start_x; i <= end_x; i++) {
				for (int j = start_y; j <= end_y; j++) {
					route[i][j] = fillin;
				}
			}
		}
	}

	public void printLowest(String[] harmful, String[] deadly, int expectedLowest) {
		System.out.println(String.format("HARMFUL ## %s", Arrays.asList(harmful)));
		System.out.println(String.format("DEADLY ## %s", Arrays.asList(deadly)));
		int lowest = lowest(harmful, deadly);
		System.out.println(String.format("EXPECTED %d >< RESULT %d ", expectedLowest, lowest));
		System.out.println("=============");

	}

	public int lowest(String[] harmful, String[] deadly) {
		int lowest = -1;
		visited = new int[max][max];
		route = new int[max][max];

		for (int i = 0; i < max; i++) {
			Arrays.fill(visited[i], -2);
		}
		for (int i = 0; i < max; i++) {
			Arrays.fill(route[i], 0);
		}
		fillValues(harmful, 1);
		fillValues(deadly, -1);
		System.out.println(route[499][499] + "");
		Queue<Node> nodes = new LinkedList<Escape.Node>();
		nodes.add(new Node(0, 0, (route[0][0] > -1 ? route[0][0] : 0)));
		visited[0][0] = 0;
		while (!nodes.isEmpty()) {
			Node cur = nodes.poll();
			List<Node> neigbhors = getValidNeigbhors(cur);
			for (Node neigbhor : neigbhors) {
				if (neigbhor.x == (max - 1) && neigbhor.y == (max - 1)) {
					System.out.println("new_x " + neigbhor.x + " new_y " + neigbhor.x + "  neigbhor.lifeUsed "
							+ neigbhor.lifeUsed);
					if (lowest == -1 || lowest > neigbhor.lifeUsed) {
						lowest = neigbhor.lifeUsed;
					}
				} else {
					visited[neigbhor.x][neigbhor.y] = 0;
					nodes.add(neigbhor);
				}
			}
		}
		return lowest;
	}

	public List<Node> getValidNeigbhors(Node cur) {
		int cur_x = cur.x;
		int cur_y = cur.y;
		List<Node> neigbhors = new ArrayList<Escape.Node>();
		Node curr_node = getValidNeigbhor(cur_x, cur_y + 1, cur.lifeUsed);
		if (curr_node != null)
			neigbhors.add(curr_node);
		curr_node = getValidNeigbhor(cur_x, cur_y - 1, cur.lifeUsed);
		if (curr_node != null)
			neigbhors.add(curr_node);
		curr_node = getValidNeigbhor(cur_x + 1, cur_y, cur.lifeUsed);
		if (curr_node != null)
			neigbhors.add(curr_node);
		curr_node = getValidNeigbhor(cur_x - 1, cur_y, cur.lifeUsed);
		if (curr_node != null)
			neigbhors.add(curr_node);
		return neigbhors;
	}

	public Node getValidNeigbhor(int new_x, int new_y, int usedLife) {
		if (new_x < max && new_x >= 0 && new_y < max && new_y >= 0 && visited[new_x][new_y] == -2
				&& route[new_x][new_y] != -1) {
			if (new_x == 499 && new_y == 499) {
				System.out.println("");
			}
			return new Node(new_x, new_y, usedLife + route[new_x][new_y]);
		}
		return null;
	}

	public static void main(String[] args) {
		String[] harmful = {};
		String[] deadly = {};
		// new Escape().printLowest(harmful, deadly, 0);
		String[] harmful2 = { "500 0 0 500" };
		String[] deadly2 = { "0 0 0 0" };
		new Escape().printLowest(harmful2, deadly2, 1000);
		String[] harmful3 = { "172 234 426 284", "214 471 366 291", "320 408 76 446", "223 131 323 470",
				"415 231 341 6", "298 442 222 269", "133 200 146 383", "453 76 222 108", "269 106 390 459",
				"235 291 398 113", "350 140 294 359", "377 430 265 260", "388 436 336 87", "208 281 122 36",
				"32 139 291 144", "155 423 339 323", "24 245 63 371", "275 369 306 309", "461 18 109 421",
				"413 401 431 373", "16 493 367 326", "181 122 148 10", "399 130 253 315", "102 408 65 477",
				"402 374 391 123", "352 16 475 473", "116 422 373 163", "196 278 97 312", "402 213 482 72",
				"330 393 42 129", "410 207 417 262", "430 499 93 326", "43 181 200 206", "399 289 62 54",
				"375 397 63 364", "366 90 62 202", "153 94 236 232", "150 429 200 416", "185 428 184 146",
				"24 255 281 371", "473 42 483 98", "232 94 287 101", "118 154 95 430" };
		String[] deadly3 = { "325 44 463 317", "160 98 24 418", "49 145 14 281", "84 438 337 372", "89 288 27 443",
				"415 359 277 499", "139 431 337 125", "409 196 239 405", "368 48 212 222", "476 60 38 247",
				"500 337 352 461", "116 157 22 155", "322 336 281 413", "251 31 198 172", "95 243 405 94",
				"467 66 175 101", "425 348 74 56", "325 220 351 254", "314 98 149 63", "492 97 373 220",
				"225 470 165 33", "88 55 76 430", "102 412 351 54", "282 224 171 363", "431 295 350 422",
				"248 382 118 429", "50 371 137 255", "285 293 240 123", "44 420 238 393", "464 235 231 232",
				"157 360 488 369", "341 49 380 443", "329 239 194 416", "360 189 421 383", "41 117 186 62" };
		new Escape().printLowest(harmful3, deadly3, 0);

		String[] harmful4 = {};
		String[] deadly4 = { "499 499 499 499" };
		new Escape().printLowest(harmful4, deadly4, -1);
		String[] harmful5 = { "0 0 250 250", "250 250 500 500" };
		String[] deadly5 = { "0 250 250 500", "250 0 500 250" };
		new Escape().printLowest(harmful5, deadly5, -1);

		String[] harmful6 = { "468 209 456 32", "71 260 306 427", "420 90 424 492", "374 253 54 253", "319 334 152 431",
				"38 93 204 84", "246 0 434 263", "12 18 118 461", "215 462 44 317", "447 214 28 475", "3 89 38 125",
				"157 108 138 264", "363 17 333 387", "457 362 396 324", "95 27 374 175", "381 196 265 302",
				"105 255 253 134", "0 308 453 55", "169 28 313 498", "103 247 165 376", "264 287 363 407",
				"185 255 110 415", "475 126 293 112", "285 200 66 484", "60 178 461 301", "347 352 470 479",
				"433 130 383 370", "405 378 117 377", "403 324 369 133", "12 63 174 309", "181 0 356 56",
				"473 380 315 378" };
		String[] deadly6 = { "250 384 355 234", "28 155 470 4", "333 405 12 456", "329 221 239 215", "334 20 429 338",
				"85 42 188 388", "219 187 12 111", "467 453 358 133", "472 172 257 288", "412 246 431 86",
				"335 22 448 47", "150 14 149 11", "224 136 466 328", "369 209 184 262", "274 488 425 195",
				"55 82 279 253", "153 201 65 228", "208 230 132 223", "369 305 397 267", "200 145 98 198",
				"422 67 252 479", "231 252 401 190", "312 20 0 350", "406 72 207 294", "488 329 338 326",
				"117 264 497 447", "491 341 139 438", "40 413 329 290", "148 245 53 386", "147 70 186 131",
				"300 407 71 183", "300 186 251 198", "178 67 487 77", "98 158 55 433", "167 231 253 90",
				"268 406 81 271", "312 161 387 153", "33 442 25 412", "56 69 177 428", "5 92 61 247" };
		new Escape().printLowest(harmful6, deadly6, 254);
	}
}
