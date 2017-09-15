package ct;

import java.util.ArrayList;
import java.util.List;

public final class cu
{
  private static double[][] a;
  private static double b;
  private static double c;
  private static double d;
  private static double e;
  private static List<a> f;
  
  static
  {
    double[] arrayOfDouble1 = { 53.540307D, 122.380829D };
    double[] arrayOfDouble2 = { 53.399707D, 120.821285D };
    double[] arrayOfDouble3 = { 52.749594D, 119.919891D };
    double[] arrayOfDouble4 = { 49.95122D, 116.580048D };
    double[] arrayOfDouble5 = { 47.901614D, 115.437469D };
    double[] arrayOfDouble6 = { 47.070122D, 118.381805D };
    double[] arrayOfDouble7 = { 45.213004D, 112.009735D };
    double[] arrayOfDouble8 = { 42.714732D, 107.83493D };
    double[] arrayOfDouble9 = { 42.779275D, 100.100555D };
    double[] arrayOfDouble10 = { 42.90816D, 96.49704D };
    double[] arrayOfDouble11 = { 44.43378D, 95.442352D };
    double[] arrayOfDouble12 = { 47.606163D, 91.003876D };
    double[] arrayOfDouble13 = { 49.439557D, 87.180634D };
    double[] arrayOfDouble14 = { 47.398349D, 82.961884D };
    double[] arrayOfDouble15 = { 44.964798D, 79.753876D };
    double[] arrayOfDouble16 = { 42.358544D, 79.885712D };
    double[] arrayOfDouble17 = { 40.513799D, 73.689423D };
    double[] arrayOfDouble18 = { 36.5626D, 73.758774D };
    double[] arrayOfDouble19 = { 33.760882D, 76.457977D };
    double[] arrayOfDouble20 = { 31.989442D, 77.688446D };
    double[] arrayOfDouble21 = { 28.497661D, 84.280243D };
    double[] arrayOfDouble22 = { 27.166695D, 88.394279D };
    double[] arrayOfDouble23 = { 26.755421D, 92.118645D };
    double[] arrayOfDouble24 = { 27.936181D, 97.379379D };
    double[] arrayOfDouble25 = { 24.166802D, 97.115707D };
    double[] arrayOfDouble26 = { 21.350781D, 99.972153D };
    double[] arrayOfDouble27 = { 21.105D, 101.707993D };
    double[] arrayOfDouble28 = { 23.120154D, 105.355453D };
    double[] arrayOfDouble29 = { 21.915019D, 106.646605D };
    double[] arrayOfDouble30 = { 21.350781D, 107.684555D };
    double[] arrayOfDouble31 = { 16.762468D, 109.002914D };
    double[] arrayOfDouble32 = { 18.729502D, 111.174774D };
    double[] arrayOfDouble33 = { 22.998852D, 117.176743D };
    double[] arrayOfDouble34 = { 25.019304D, 119.973391D };
    double[] arrayOfDouble35 = { 27.117813D, 120.890121D };
    double[] arrayOfDouble36 = { 27.76133D, 121.821041D };
    double[] arrayOfDouble37 = { 30.097613D, 123.451653D };
    double[] arrayOfDouble38 = { 33.155948D, 120.999985D };
    double[] arrayOfDouble39 = { 36.914764D, 122.913322D };
    double[] arrayOfDouble40 = { 41.294317D, 128.272934D };
    double[] arrayOfDouble41 = { 42.815551D, 131.197872D };
    double[] arrayOfDouble42 = { 45.02695D, 133.172836D };
    double[] arrayOfDouble43 = { 48.04871D, 135.040512D };
    double[] arrayOfDouble44 = { 48.618385D, 134.337387D };
    double[] arrayOfDouble45 = { 47.886881D, 131.700668D };
    double[] arrayOfDouble46 = { 49.196064D, 130.536118D };
    double[] arrayOfDouble47 = { 50.708634D, 127.613754D };
    double[] arrayOfDouble48 = { 53.13359D, 125.833969D };
    double[] arrayOfDouble49 = { 53.657661D, 123.329086D };
    a = new double[][] { arrayOfDouble1, arrayOfDouble2, arrayOfDouble3, arrayOfDouble4, arrayOfDouble5, arrayOfDouble6, arrayOfDouble7, arrayOfDouble8, arrayOfDouble9, arrayOfDouble10, arrayOfDouble11, { 45.614037D, 91.091766D }, arrayOfDouble12, arrayOfDouble13, arrayOfDouble14, arrayOfDouble15, arrayOfDouble16, arrayOfDouble17, arrayOfDouble18, arrayOfDouble19, arrayOfDouble20, arrayOfDouble21, arrayOfDouble22, arrayOfDouble23, arrayOfDouble24, arrayOfDouble25, arrayOfDouble26, arrayOfDouble27, arrayOfDouble28, arrayOfDouble29, arrayOfDouble30, arrayOfDouble31, arrayOfDouble32, { 21.2689D, 112.782211D }, arrayOfDouble33, arrayOfDouble34, arrayOfDouble35, arrayOfDouble36, arrayOfDouble37, arrayOfDouble38, { 35.209722D, 120.143051D }, arrayOfDouble39, { 39.842286D, 124.273911D }, arrayOfDouble40, arrayOfDouble41, arrayOfDouble42, arrayOfDouble43, arrayOfDouble44, arrayOfDouble45, arrayOfDouble46, arrayOfDouble47, arrayOfDouble48, arrayOfDouble49 };
    b = 360.0D;
    c = 360.0D;
    d = -360.0D;
    e = -360.0D;
    f = new ArrayList();
    a();
  }
  
  private static void a()
  {
    int i = 0;
    while (i < a.length)
    {
      double d1 = a[i][0];
      double d2 = a[i][1];
      if (d1 < c) {
        c = d1;
      }
      if (d1 > e) {
        e = d1;
      }
      if (d2 < b) {
        b = d2;
      }
      if (d2 > d) {
        d = d2;
      }
      f.add(new a(d1, d2));
      i += 1;
    }
  }
  
  public static boolean a(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 < c) || (paramDouble2 < b) || (paramDouble1 > e) || (paramDouble2 > d)) {
      return false;
    }
    Object localObject = (a)f.get(0);
    int m = f.size();
    int j = 0;
    int i = 1;
    while (i <= m)
    {
      a locala = (a)f.get(i % m);
      int k = j;
      if (paramDouble1 > Math.min(((a)localObject).a, locala.a))
      {
        k = j;
        if (paramDouble1 <= Math.max(((a)localObject).a, locala.a))
        {
          k = j;
          if (paramDouble2 <= Math.max(((a)localObject).b, locala.b))
          {
            k = j;
            if (((a)localObject).a != locala.a)
            {
              double d1 = (paramDouble1 - ((a)localObject).a) * (locala.b - ((a)localObject).b) / (locala.a - ((a)localObject).a);
              double d2 = ((a)localObject).b;
              if (((a)localObject).b != locala.b)
              {
                k = j;
                if (paramDouble2 > d1 + d2) {}
              }
              else
              {
                k = j + 1;
              }
            }
          }
        }
      }
      i += 1;
      localObject = locala;
      j = k;
    }
    if (j % 2 == 0) {}
    for (i = 0; i != 0; i = 1) {
      return true;
    }
    return false;
  }
  
  static final class a
  {
    double a;
    double b;
    
    public a(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/cu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */