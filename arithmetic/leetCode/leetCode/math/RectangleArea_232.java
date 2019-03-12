package leetCode.math;

/**
 * author： 张亚飞
 * time：2016/7/17  10:40
 */
//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//        Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//Assume that the total area is never beyond the maximum possible value of int.
    //给出矩形的左下角和右上角的坐标，判断两个矩形的面积
public class RectangleArea_232 {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaA = rectangleArea(A,B,C,D);
        int areaB = rectangleArea(E,F,G,H);
        int ca = Math.max(A,E);
        int cb = Math.max(B,F);
        int cc = Math.min(C,G);
        int cd  = Math.min(D,H);
        int commonArea = rectangleArea(ca,cb,cc,cd);
        if (commonArea>=0){
            return areaA+areaB-commonArea;
        }else {
            return areaA+areaB;
        }


    }

    /**
     * 给出一个四边形的四个顶点，求面积
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int rectangleArea(int A,int B,int C,int D){
        if (C<A||D<B)
        return 0;
        return (C-A)*(D-B);

    }

    public static void main(String[] args) {
        int a = -2;
        int b = -2;
        int c = 2;
        int d = 2;
        int e = 3;
        int f =3;
        int g = 4 ;
        int h =4;
        System.out.println(computeArea(a, b, c, d, e, f, g, h));


    }


}
