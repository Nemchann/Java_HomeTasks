public class PolylineSummary {
    public static BrokenLine sumBrokable(Brokable...brokables){
        BrokenLine bigBrokenLine = new BrokenLine();
        for (Brokable brokable : brokables){
            bigBrokenLine.addDots(brokable.getPolyline().points);
        }
        return bigBrokenLine;
    }
}
