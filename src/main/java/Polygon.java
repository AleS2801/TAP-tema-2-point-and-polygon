public class Polygon { 
    private int N;        // numarul de puncte
    private Point[] a;    // vecxtorul de puncte
   
    // default buffer = 4
    public Polygon(int n) {
        N = n;
        a = new Point[N];
    }


    private void schimbaDimensiune() {
        Point[] temp = new Point[2*N+1];
        for (int i = 0; i <= N; i++) temp[i] = a[i];
        a = temp;
    }

    public int dimensiune() { return N; }

    public void adauga(Point p) {
        if (N >= a.length - 1) schimbaDimensiune();   // schimba dimesiunea vectorului
        a[N++] = p;                        // se adauga puncte
        a[N] = a[0];
    }

    // returneaza perimetrul
    public double perimetru() {
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + a[i].distanceTo(a[i+1]);
        return sum;
    }

    // returneaza aria
    public double arie() {
        double sum = 0.0;
        for (int i = 0; i < N; i++) {
            sum = sum + (a[i].x() * a[i+1].y()) - (a[i].y() * a[i+1].x());
        }
        return 0.5 * sum;
    }

    // se verifica daca deja exista punctul P
    public boolean exista(Point p) {
        int crossings = 0;
        for (int i = 0; i < N; i++) {
            int j = i + 1;
            boolean cond1 = (a[i].y() <= p.y()) && (p.y() < a[j].y());
            boolean cond2 = (a[j].y() <= p.y()) && (p.y() < a[i].y());
            if (cond1 || cond2) {
                if (p.x() < (a[j].x() - a[i].x()) * (p.y() - a[i].y()) / (a[j].y() - a[i].y()) + a[i].x())
                    crossings++;
            }
        }
        if (crossings % 2 == 1) 
            return true;
        else                    
            return false; 
    }

    // string-ul corespunzator punctului curent
    public String toString() {
        if (N == 0) return "[ ]";
        String s = "";
        s = s + "[ ";
        for (int i = 0; i <= N; i++)
            s = s + a[i] + " ";
        s = s + "]";
        return s;
    }


    // exemplu pentru demo
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);

        Polygon poly = new Polygon(4); // obicet de tip poligon care are 4 puncte
        poly.adauga(new Point(5, 5));
        poly.adauga(new Point(9, 5));
        poly.adauga(new Point(9, 9));
        poly.adauga(new Point(5, 9));

        System.out.println("polygon    = " + poly);
        System.out.println("perimetru  = " + poly.perimetru());
        System.out.println("arie       = " + poly.arie());

        System.out.println("exista(5, 5) = " + poly.exista(new Point(5, 5)));
        System.out.println("exista(9, 5) = " + poly.exista(new Point(9, 5)));
        System.out.println("exista(9, 9) = " + poly.exista(new Point(9, 9)));
        System.out.println("exista(5, 9) = " + poly.exista(new Point(5, 9)));
        System.out.println("exista(7, 5) = " + poly.exista(new Point(7, 5)));
        System.out.println("exista(5, 7) = " + poly.exista(new Point(5, 7)));
        System.out.println("exista(7, 9) = " + poly.exista(new Point(7, 9)));
        System.out.println("exista(9, 7) = " + poly.exista(new Point(9, 7)));
    }
}