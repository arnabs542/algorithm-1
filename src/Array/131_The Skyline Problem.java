class Point implements Comparable<Point>{
    static final int TYPE_START = 0;
    static final int TYPE_END = 1;

    int x;
    int y;
    int type;
    int buildingNo;
    public Point(int x, int y, int type, int buildingNo){
        this.x = x;
        this.y = y;
        this.type = type;
        this.buildingNo = buildingNo;
    }
    
    // x > type > y
    public int compareTo(Point point){
        if (this.x != point.x){
            return this.x - point.x;
        }
        
        if (this.type != point.type){
            return this.type - point.type;
        }
        
        return this.y - point.y;
    }
}

class Building implements Comparable<Building>{
    public int y;
    public int buildingNo;
    
    public Building(int buildingNo, int y){
        this.buildingNo = buildingNo;
        this.y = y;
    }
    
    public int compareTo(Building building){
        if (this.y == building.y){
            return this.buildingNo - building.buildingNo;
        }
        
        return this.y - building.y;
    }
}

public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public List<List<Integer>> buildingOutline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        if (buildings.length == 0 || buildings[0].length == 0){
            return result;
        }

        List<Point> pointList = new ArrayList<Point>();
        Point startPoint;
        Point endPoint;
        for(int i = 0; i < buildings.length; i ++){
            startPoint = new Point(buildings[i][0], buildings[i][2], Point.TYPE_START, i);
            endPoint = new Point(buildings[i][1], buildings[i][2], Point.TYPE_END, i);
            pointList.add(startPoint);
            pointList.add(endPoint);
        }
        
        Collections.sort(pointList);
        
        TreeSet<Building> ts = new TreeSet<>();
        ts.add(new Building(pointList.get(0).buildingNo, pointList.get(0).y));
        int currStart = pointList.get(0).x;
        for (Point p: pointList){
            
            int currY = ts.isEmpty() ? 0 : ts.last().y;
            int currEnd = p.x; 
            
            List<Integer> interval = new ArrayList<Integer>(Arrays.asList(new Integer[]{currStart, currEnd, currY}));
            mergeToResult(result, interval);
            
            if (p.type == Point.TYPE_START){
                ts.add(new Building(p.buildingNo, p.y));    
            }
            
            if (p.type == Point.TYPE_END){
                ts.remove(new Building(p.buildingNo, p.y));
            }
            
            currStart = p.x;
        }
        
        return result;
    }
    
    private void mergeToResult(List<List<Integer>> result, List<Integer> interval){
        // if start == end; return;
        if ((int)interval.get(0) == (int)interval.get(1) || (int)interval.get(2) == 0){
            return;
        }
        
        if (result.size() == 0){
            result.add(interval);
            return;
        }
        
        // check last to see if we need to merge
        List<Integer> last = result.get(result.size() - 1);
        // if new Y == last Y && new Start == last End => merge
        
        if ((int)interval.get(2) == (int)last.get(2) && (int)interval.get(0) == (int)last.get(1)){ 
            last.set(1, interval.get(1));
        } else {
            result.add(interval);
        }
        
        return;
    }
}
