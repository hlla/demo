package ct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class f
{
  public String a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public ArrayList h;
  public int i;
  public int j;
  public int k;
  public String l;
  public String m;
  public s n;
  public boolean o;
  public int p;
  public int q;
  public int r;
  public int s;
  public int t;
  
  public final g a()
  {
    long l1 = System.currentTimeMillis();
    Object localObject1 = new bi();
    bc.b();
    if (!bc.e())
    {
      this.k = -4;
      this.l = "Network fail before schedule";
      return null;
    }
    this.f = be.b(this.h.toString());
    Object localObject2 = new HashMap();
    ((Map)localObject2).put("imei", be.a());
    ((Map)localObject2).put("reqKey", this.f);
    localObject2 = new ak(this.a, this.b, this.h, this.e, this.c, this.d, this.i, this.j, this.g, (Map)localObject2);
    ((bi)localObject1).b("#halley-proxy.HalleyDispatchService");
    ((bi)localObject1).a("srvDispatch");
    ((bi)localObject1).a("request", localObject2);
    localObject1 = i.a((bi)localObject1);
    ((aw)localObject1).b();
    this.o = bc.e();
    this.n = ((aw)localObject1).e();
    this.p = ((aw)localObject1).h();
    this.q = ((aw)localObject1).f();
    this.r = ((aw)localObject1).i();
    this.s = ((aw)localObject1).g();
    if ((((aw)localObject1).c() == 0) && (((aw)localObject1).a() != null))
    {
      localObject1 = ((aw)localObject1).a();
      localObject2 = new al();
      try
      {
        localObject1 = (al)((bi)localObject1).b("response", localObject2);
        if (localObject1 == null)
        {
          this.k = -8;
          this.l = "Response is Null";
          return null;
        }
      }
      catch (Exception localException)
      {
        bd.d();
        this.k = -8;
        this.m = localException.getClass().getSimpleName();
        this.l = be.a(localException);
        return null;
      }
      localObject2 = new g();
      Object localObject3 = bc.a();
      long l2 = System.currentTimeMillis();
      if ((!((String)localObject3).equals("unkonwn")) && (((String)localObject3).equals(this.g)))
      {
        localObject3 = localException.a;
        if ((localObject3 != null) && (((Map)localObject3).size() > 0))
        {
          t localt = new t(this.g);
          Iterator localIterator = ((Map)localObject3).keySet().iterator();
          while (localIterator.hasNext())
          {
            Object localObject4 = (String)localIterator.next();
            if (((Map)localObject3).get(localObject4) != null)
            {
              Object localObject5 = ((am)((Map)localObject3).get(localObject4)).a;
              localObject4 = new t.a((String)localObject4, l2, ((am)localException.a.get(localObject4)).b);
              localObject5 = ((ArrayList)localObject5).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                String str = (String)((Iterator)localObject5).next();
                s locals = new s();
                if (locals.a(str)) {
                  ((t.a)localObject4).c.add(locals);
                }
              }
              localt.a((t.a)localObject4);
            }
          }
          ((g)localObject2).a = localt;
        }
      }
      for (;;)
      {
        if (localException.c != null) {
          ((g)localObject2).b = new d(localException.c);
        }
        if (localException.b != null) {
          ((g)localObject2).c = new c(localException.b);
        }
        this.t = ((int)(System.currentTimeMillis() - l1));
        return (g)localObject2;
        ((g)localObject2).a = null;
        this.k = -9;
        this.l = ("req apn:" + this.g + ",current apn:" + (String)localObject3);
      }
    }
    this.k = localException.c();
    this.m = localException.d();
    return null;
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */