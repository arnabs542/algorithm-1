// LC: 973
// Quick Select: O(n)
// worst case: O(n^2)

class Point{
    int[] coordinate;
    int dist;
    public Point(int[] coordinate, int dist){
        this.coordinate = coordinate;
        this.dist = dist;
    }
}
class Solution {
    
    public int[][] kClosest(int[][] points, int K) {
        List<Point> pointList = new ArrayList<Point>();
        for (int i = 0; i < points.length; i ++){
            int dist = (points[i][0] - 0) * (points[i][0] - 0) + (points[i][1] - 0) * (points[i][1] - 0);
            pointList.add(new Point(points[i], dist));
        }
        
        quickSelect(pointList, 0, pointList.size() - 1, K);
        
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i ++){
            result[i][0] = pointList.get(i).coordinate[0];
            result[i][1] = pointList.get(i).coordinate[1];
        }
        
        return result;
    }
    
    private void quickSelect(List<Point> pointList, int start, int end, int K){
        if (start >= end){
            return;
        }
        
        int l = start;
        int r = end;
        int mid = l + (r - l)/2;
        int pivot = pointList.get(mid).dist;
        while (l <= r){
            while (pointList.get(l).dist < pivot){
                l ++;
            }
            
            while (pointList.get(r).dist > pivot){
                r --;
            }
            
            if (l <= r){
                Point temp = pointList.get(l);
                pointList.set(l, pointList.get(r));
                pointList.set(r, temp);
                l ++;
                r --;
            }
        }
        
        
        if (r >= start + K - 1){
            quickSelect(pointList, start, r, K);
        } else if (l <= start + K - 1) { 
            quickSelect(pointList, l, end, K - (l - start));
        }
        
        
    }
}
