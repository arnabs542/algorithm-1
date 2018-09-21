## Binary Search 
* 2分法 O(logN) 
* 停在start, end 不交錯
* 最後判斷應該取start 還是 end

```java
while(start + 1 < end){
  int mid = start + (end - start)/2;
  if (A[mid] == target){
    return A[mid];
  } else if (A[mid] > target) {
    start = A[mid];
  } else {
    end = A[mid];
  }
}

if (A[start] == target){
  return A[start];
}

if (A[end] == target){
  return A[end];
}
```

## Quick Sort
*O(NlogN), 最壞O(N^2)</br>

143. Sort Colors II</br>
31. Partition Array</br>

```java
//////////////////////////////////////
// Quick Sort O(NlogN), 最壞O(N^2)
// 目標left, right 交錯 
// (left <= right)
// 等於pivot 需交換, 以避免 1,1,1,1,1,1 
// (A[left] < pivot, A[right] > pivot)
//////////////////////////////////////
if (start >= end){
  return;
}
int pivot = A[(start + end)/2];
int left = start; right = end;
while (left <= right){
  while (left <= right && A[left] < pivot){
    left ++;
  }
  
  while (left <= right && A[right] > pivot){
    right --;
  }
  
  if (left <= right){
    int temp = A[right];
    A[right] = A[left];
    A[left] = temp;
    left ++;
    right --;
  }
}

QuickSort(A, start, right);
QuickSort(A, left, end);
```
``` java
//////////////////////////////////////
// Quick Select 
// 找第K大的數, The Kth element
// 一樣進行quick sort, 不過不用排全部, 只要排k個
// quick sort結果:
// start....right.left....end
// 判斷第K大的數在左邊還是右邊
// 在左邊判斷
// if (start + k - 1 < right){
//  quickSelect(nums, start, right, k);
// }
// 在右邊, 只要找k - (left - start)個數
// if (start + k - 1 > left){
//  quickSelect(nums, left, end, k - (left - start));
// }
// 不在左邊也不在右邊, 那只可能在right.left中間
// return nums[right+1];
//////////////////////////////////////
```
