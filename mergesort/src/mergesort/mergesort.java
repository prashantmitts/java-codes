package mergesort;

public class mergesort {
	public static int[] merge(int[] a, int i , int j , int k){
		int len = k - i + 1;
		int b[] = new int[len];
		int ind = 0;
		int mid = j;
		int str = i;
		while (ind < len){
			if (i < mid){
				if (j < k){
					if (a[i] < a[j]){
						b[ind] = a[i];
						i += 1;
					}
					else{
						b[ind] = a[j];
						j += 1;
					}
				}
				else{
					b[ind] = a[i];
					i += 1;
				}
			}
			else{
				b[ind] = a[j];
				j += 1;
			}
			ind += 1;
		}
		ind = 0;
		while (ind < len){
			a[str] = b[ind];
			ind += 1;
			str += 1;
		}
		return a;
	}
	
	public static int[] mergesort(int a[],int i , int k){
		int n = k - i + 1;
		if (n <= 1){
			return a;
		}
		else if (n == 2){
			if (a[i] > a[k]){
				int t = a[k];
				a[k] = a[i];
				a[i] = t;
			}
			return a;
		}
		else{
			int j = (k + i)/2;
			a = mergesort(a,i,j);
			a = mergesort(a,j+1,k);
			return merge(a,i,j+1,k);
		}
	}
	public static void main(String args[]){
		int a[] = {1,3,5,7,2,4,6,8};
		System.out.println(a[0] + " " + a[1] + " "  + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
		a = mergesort(a,0,7);
		System.out.println(a[0] + " " + a[1] + " "  + a[2] + " " + a[3] + " " + a[4] + " " + a[5] + " " + a[6] + " " + a[7]);
	}
}
