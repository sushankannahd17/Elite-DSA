import java.util.* ;
import java.io.*; 
public class RangeSumQuery {
    SegmentTree tree;
    int N;

    RangeSumQuery(int[] arr) {
        // Constructor.
        this.tree=new SegmentTree(arr);
        N=1;
        while (N<arr.length) {
            N<<=1;
        }
     }

    void update(int ind, int val) {
        // Update operation.
        tree.update(1, 0, N-1, ind, ind, val);
    }
    
    int sumOfRange(int l, int r) {
        // Find the sum of range [l,r].
        return tree.find(1, 0, N-1, l, r);
    }
}

class SegmentTree {
    int[] arr;

    SegmentTree(int[] temp) {
        int N=temp.length;
        int newN=1;
        while (newN<N) {
            newN<<=1;            
        }

        this.arr=new int[newN+newN+1];
        for (int idx=0; idx<N; idx++) {
            this.arr[idx+newN]=temp[idx];
        }

        for (int idx=newN-1; idx>0; idx--) {
            this.arr[idx]=this.arr[idx*2]+this.arr[idx*2+1];
        }
    }

    public int find(int node, int nlt, int nrt, int qlt, int qrt) {
        if (nrt<qlt || nlt>qrt) {
            return 0;
        }

        if (qlt<=nlt && nrt<=qrt) {
            return this.arr[node];
        }

        int mid=nlt+(nrt-nlt)/2;
        int ltVal=find(node*2, nlt, mid, qlt, qrt);
        int rtVal=find(node*2+1, mid+1, nrt, qlt, qrt);

        return ltVal+rtVal;
    }

    public void update(int node, int nlt, int nrt, int qlt, int qrt, int val) {
        if (nrt<qlt || nlt>qrt) {
            return;
        }

        if (qlt<=nlt && nrt<=qrt) {
            this.arr[node]=val;
            return;
        }

        int mid=nlt+(nrt-nlt)/2;
        update(node*2, nlt, mid, qlt, qrt, val);
        update(node*2+1, mid+1, nrt, qlt, qrt, val);
        this.arr[node]=this.arr[node*2]+this.arr[node*2+1];
    }
}