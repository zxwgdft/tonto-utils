package other;

import java.util.Arrays;


public class RunPath {


	/**
	 * 修正点位置
	 * @param points
	 * @return
	 */
	public Point[] correct(Point[] points) {
		// 修正点的位置

		if (points == null)
			return null;

		int size = points.length;

		if (size < 3)
			return Arrays.copyOf(points, size);
		
		
		Point[] newPoints = new Point[size];
		
		
		Point a, b, c;
		
		a = points[0];
		
		int i = 0;
		int j = 0;
		do{
			
			if(i+2 >= size) break;
			
			b = points[i+1];
			c = points[i+2];
						
			Point d = makeLine(a,b,c);
			if(d!=null){
				
				//不为空，则3点一线
				
				newPoints[j++]=a;
				newPoints[j++]=d;
				
				a = d;	
				i+=2;
			}
			else
			{
				//为空，则不是一条线，继续修正下3个点
				
				newPoints[j++]=a;
				a = b;
				i++;
			}
			
		}while(true);
		
		
		return newPoints;
	}

	private Point makeLine(Point a, Point b, Point c) {

		/**
		 * 确定三点是不是直线，A为确定点，B和C为不确定点，尝试找到一条以A为起点，到B和C的垂直距离均小于10的直线
		 * 并返回一个这条直线上的点，如果没有返回NULL
		 * 
		 */

		return new Point();
	}

	public double point2line(Point toPoint, Point linePointA, Point linePointB) {
		// 点到直线距离
		return 0;
	}

	public double point2line(Point toPoint, double sin) {
		// 点到直线距离
		return 0;
	}

	public static class Point {

		double x;
		double y;

	}

}
