public class ClosestPairNaive {
    
    public final static double INF = java.lang.Double.POSITIVE_INFINITY;
    
    //
    // findClosestPair()
    //
    // Given a collection of nPoints points, find and ***print***
    //  * the closest pair of points
    //  * the distance between them
    // in the form "NAIVE (x1, y1) (x2, y2) distance"
    //
    
    // INPUTS:
    //  - points sorted in nondecreasing order by X coordinate
    //  - points sorted in nondecreasing order by Y coordinate
    //
    
    public static void findClosestPair(XYPoint points[], boolean print)
    {
    	
    	int nPoints = points.length;
    	double minDist = INF;
    	XYPoint[] closestPair = new XYPoint[2];
    	
    	
    	for(int j = 0; j <= nPoints-2; j++) //go through each point
    	{
    		for(int k = j + 1; k <= nPoints-1; k++)
    		{
    			double xyDist = points[j].dist(points[k]);
    			
    			if(xyDist < minDist)
    			{
    				minDist = xyDist;
    				closestPair[0] = points[j];
    				closestPair[1] = points[k];
    			}
    			
    		}
    	}
    	
    	if(print)
    	{
    		if(minDist == INF)
    		{
    			System.out.println("NAIVE " + minDist);
    		}
    		else
    			System.out.println("NAIVE " + closestPair[0].toString() + " " + closestPair[1].toString() + " " + minDist);
    	}
    			
    }
}