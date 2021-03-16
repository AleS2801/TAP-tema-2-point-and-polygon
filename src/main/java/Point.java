public final class Point { 
    private final double x;    // coordonata pe axa Ox
    private final double y;    // cordonata pe axa Oy
   
    // constructor implicit
    public Point() {
        x = 0;
        y = 0;
    }

    // constructor cu 2 parametrii (coordonatele)
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() { return x; }
    public double y() { return y; }
    public double r() { return Math.sqrt(x*x + y*y); }
    public double theta() { return Math.atan2(y, x); }

    // Disteanta euclidiana dintre punctul curent si un punct B
    public double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    // metoda care afiseaza string-ul corespunzator unui punct
    public String toString() {
        return "(" + x + ", " + y + ")";
    } 



    // exemplu pentru demo
    public static void main(String[] args) {
        Point p = new Point();
        System.out.println("p  = " + p);
        System.out.println("   x     = " + p.x());
        System.out.println("   y     = " + p.y());
        System.out.println("   r     = " + p.r());
        System.out.println("   theta = " + p.theta());
        System.out.println();

        Point q = new Point(0.5, 0.5);
        System.out.println("q  = " + q);
        System.out.println("dist(p, q) = " + p.distanceTo(q));
    }
}