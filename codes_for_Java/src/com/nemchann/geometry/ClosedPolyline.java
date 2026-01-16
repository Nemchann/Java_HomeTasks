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
//            Line line = new Line(points[i - 1], points[i]);
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

    /**
     * Возвращает итератор для замкнутой полилинии
     * @param startFromIndex индекс точки, с которой начать итерацию (по умолчанию 0)
     */
    @Override
    public PolylineIterator iterator(int startFromIndex) {
        PolylineIterator iterator = new PolylineIteratorImpl(points, true); // isCyclic = true
        if (startFromIndex >= 0 && startFromIndex < points.length) {
            iterator.setPosition(startFromIndex);
        }
        return iterator;
    }

    @Override
    public PolylineIterator iterator() {
        return iterator(0);
    }
}
