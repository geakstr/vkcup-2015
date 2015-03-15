import java.io.*;
import java.util.*;

public class Main {
	BufferedReader in;
	PrintWriter out;
	StringTokenizer st;
	
	void solve() throws IOException {
		
	}
	
	Main() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		in.close();
		out.close();
	}
	
	String ns() throws IOException {
		while (st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(in.readLine());
		}
		return st.nextToken();
	}
	
	int ni() throws IOException {
		return Integer.parseInt(ns());
	}
	
	double nd() throws IOException {
		return Double.parseDouble(ns());
	}
	
	long nl() throws IOException {
		return Long.parseLong(ns());
	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}
}
