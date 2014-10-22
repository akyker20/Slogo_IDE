package gui.turtlescreenwrap;

public class TesselationMapper {
    public static final float XMAX = TurtleScreenWrap.XMAX;
    public static final float YMAX = TurtleScreenWrap.YMAX;

    public static Point2DPair map (Point2DPair pointPair) {
        //if origin is on-screen, no mapping to be done
        if (!TurtleScreenWrap.checkOffScreen(pointPair.origin))
            return pointPair;

        float xsign = Math.signum(pointPair.origin.x);
        float ysign = Math.signum(pointPair.origin.y);
        float xsignD = Math.signum(pointPair.dest.x);
        float ysignD = Math.signum(pointPair.dest.y);

        float xabs = Math.abs(pointPair.origin.x)-XMAX;
        float yabs = Math.abs(pointPair.origin.y)-YMAX;
        float xabsD = Math.abs(pointPair.dest.x)-XMAX;
        float yabsD = Math.abs(pointPair.dest.y)-YMAX;

        int xcount = Math.floorDiv( (int) xabs, (int) XMAX*2);
        int ycount = Math.floorDiv( (int) yabs, (int) YMAX*2);

        float xadjusted = xabs-2*XMAX*xcount;
        float yadjusted = yabs-2*YMAX*ycount;
        float xadjustedD = xabsD-2*XMAX*xcount;
        float yadjustedD = yabsD-2*YMAX*ycount;               

        if (xsign>0) {
            pointPair.origin.x = -XMAX+xadjusted;
        } else if (xsign<0) {
            pointPair.origin.x = XMAX-xadjusted;
        }

        if (ysign>0) {
            pointPair.origin.y = -YMAX+yadjusted;
        } else if (ysign<0) {
            pointPair.origin.y = YMAX-yadjusted;
        }        
        
        if (xsignD>0) {
            pointPair.dest.x = -XMAX+xadjustedD;
        } else if (xsignD<0) {
            //pointPair.dest.x = XMAX-xadjustedD;
        }

        if (ysignD>0) {
            pointPair.dest.y = -YMAX+yadjustedD;
        } else if (ysignD<0) {
            //pointPair.dest.y = YMAX-yadjustedD;
        }

        return pointPair;
    }
}
