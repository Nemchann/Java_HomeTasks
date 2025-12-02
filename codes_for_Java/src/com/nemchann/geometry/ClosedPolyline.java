package com.nemchann.geometry;

public class ClosedPolyline extends BrokenLine{

    public ClosedPolyline(){
        super();
    }

    public ClosedPolyline(Dot...points){
        super(points);
    }

    public double splineLength(){
        double space = super.splineLength();
//        if (points.length <= 1 || points == null){
//            return 0;
//        }
//        for (int i = 1; i < points.length; i++){
//            com.sstu.war.geometry.Line line = new com.sstu.war.geometry.Line(points[i - 1], points[i]);
//            space += line.getSpace();
//        }
        Line<Dot> lastLine = new Line<>(points[0], points[points.length - 1]);
        double lastSpace = lastLine.getSpace();
        space += lastSpace;
        return space;
    }

    @Override
    public BrokenLine getPolyline() {
        ClosedPolyline closedPolyline = new ClosedPolyline(points);
        closedPolyline.addDots(points[0]);
        return closedPolyline;
    }
}
