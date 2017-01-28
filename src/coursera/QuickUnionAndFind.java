package coursera;

import java.util.Arrays;

public class QuickUnionAndFind {

	public static void main(String[] args) {
		
//		QUnion qunion = new QUnion(10);
//		qunion.union(4, 3);
//		qunion.union(3, 8);
//		qunion.union(6, 5);
//		qunion.union(9, 4);
//		qunion.union(2, 1);
//		qunion.union(5, 0);
//		qunion.union(7, 2);
//		qunion.union(6, 1);
//		System.out.println(qunion.isConnected(2, 3));

		
		QFind qfind = new QFind(10);
		qfind.union(2, 9);
		qfind.union(4, 9);
		qfind.union(9, 3);
		//qfind.union(6, 5);
		//System.out.println(qfind.isConnected(3, 5));
		//qfind.union(3, 5);
		
		//System.out.println(qfind.isConnected(3, 5));
	}
	
	
	static class QFind{
		
		int[] id;
		int[] size;
		
		public QFind(int N){
			id = new int[N];
			size = new int[N];
			
			for(int i=0; i<N; i++)
				id[i] = i;
			
			Arrays.fill(size, 1);
		
			System.out.println(Arrays.toString(id));
		}
		
		private int root(int e){
			while(id[e] != e){
				
				id[e] = id[id[e]];
				
				e = id[e];
			}
				
			
			return e;
		}
		
		public boolean isConnected(int p, int q){
			
			int proot=root(p), qroot=root(q);
				
			return proot == qroot;
		}
		
		
		public void union(int p, int q){
			
			int proot=root(p), qroot=root(q);
			
			if(size[proot] < size[qroot]){
				id[proot] = qroot;
				size[proot] +=size[qroot];
			}
			else{
				id[qroot] = proot;
				size[qroot] += size[proot];
			}
				
			
			System.out.println(Arrays.toString(id));
			
		}
		
	}
	
	
	static class QUnion{
		
		int[] id;
		
		public QUnion(int N){
			id = new int[N];
			
			for(int i=0; i<N; i++)
				id[i] = i;
		
			System.out.println(Arrays.toString(id));
		}
		
		public boolean isConnected(int p, int q){
			return id[p]==id[q];
		}
		
		public void union(int p, int q){
			
			int pid = id[p];
			int qid = id[q];
			
			for(int i=0; i<id.length; ++i){
				if(id[i] == pid)
					id[i] = qid;
			}
			
			System.out.println(Arrays.toString(id));
			
		}
		
	}

}
