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

public int getNth(int num){
	int[] result = new int[num];
	result[0] = 0;
	result[1] = 1;
	for (int i = 2; i <num; i ++){
		result[i] = result[i - 1] + result[i - 2];
}

return result[num - 1];
}


public int getNth(int num){
	if (num == 1){
	    return 0;
}

 if (num == 2){
return 1;
}
    
	return getNth(num - 2) + getNth(num - 1);
}


int[] result = new int[num];
int[0] = 0;
int[1] = 1;

static int getNth(int num, int[] result){
        if (num == 1 || num == 2){
            return num - 1;
        }
        if (result[num - 1] == 0){
            result[num - 1] = getNth(num - 2, result) + getNth(num - 1, result);
        } 
    	return result[num - 1];
}


