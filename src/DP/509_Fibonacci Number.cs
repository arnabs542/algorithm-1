Find the Nth number in Fibonacci sequence.

The first two numbers are 0 and 1.
The i th number is the sum of i-1 th number and i-2 th number.
The first ten numbers in Fibonacci sequence is:

0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

// 0, 1, 1, 2, 3, 5, 8, 13, 21 …. 

// num = 1 => 0
// num = 2 => 1
// num = 3 => 1
// num = 4 => 2
// num = 5 => 3

// iterative way O(n)
public int getNth(int num){
	int[] result = new int[num];
	result[0] = 0;
	result[1] = 1;
	for (int i = 2; i <num; i ++){
		result[i] = result[i - 1] + result[i - 2];
	}

	return result[num - 1];
}

/*
	int[] fib = new int[n + 1];
	fib[1] = 0;
        
        if (n >= 2){
            fib[2] = 1;    
        }
        
        for (int i = 3; i <= n; i ++){
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        return fib[n];
*/

/*
	public int fibonacci(int num) {
        int[] result = new int[2];
        result[0] = 1; 
        result[1] = 0;
        
        for (int i = 3; i <= num; i ++){
            result[i % 2] = result[(i-1) % 2] + result[(i - 2) % 2];
        }
        
        return result[num % 2];
    }
*/

// recursive O(2 ^ n)
public int fibonacci(int num) {
        if (num == 1){
            return 0;
        }
        
        if (num == 2){
            return 1;
        }
        
        return fibonacci(num - 1) + fibonacci(num - 2);
    }

// recursive + memo

int[] result = new int[1000];
    
    public int fibonacci(int num) {
        if (num == 1){
            result[0] = 0;
            return result[0];
        }
        
        if (num == 2){
            result[1] = 1;
            return result[1];
        }
        
        if (result[num - 1]  == 0){
		    result[num - 1] = fibonacci(num - 1) + fibonacci(num - 2);
	    }        
	
        return result[num - 1];
    }

    

