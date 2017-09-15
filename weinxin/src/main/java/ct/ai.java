package ct;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Map;

public final class ai
  implements Runnable
{
  private ag a;
  
  public ai(ag paramag)
  {
    this.a = paramag;
  }
  
  public final void run()
  {
    try
    {
      if (this.a != null)
      {
        localObject1 = InetAddress.getByName(this.a.a);
        this.a.v = ((InetAddress)localObject1).getHostAddress();
        this.a.h = new s(this.a.v, 80);
      }
      if ((this.a.n < -9) && (!i.b("info.3g.qq.com"))) {
        this.a.n = -17;
      }
      if (this.a.n != 0) {
        break label177;
      }
      localObject1 = this.a;
      if ((((ag)localObject1).h == null) || (!((ag)localObject1).h.a(((ag)localObject1).i))) {
        break label733;
      }
      i = 1;
    }
    catch (Exception localException1)
    {
      try
      {
        label177:
        if (!this.a.w) {
          break label295;
        }
        Object localObject3 = this.a;
        Object localObject1 = h.a();
        if (localObject1 == null) {
          break label770;
        }
        Object localObject4 = ((a)localObject1).a();
        if ((localObject4 == null) || (((ao)localObject4).a == null)) {
          break label770;
        }
        Object localObject2 = (Byte)((ao)localObject4).a.get(Integer.valueOf(((ag)localObject3).n));
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label260;
        }
        localObject1 = Byte.valueOf((byte)((ao)localObject4).b);
        label260:
        if (localObject3 == null) {
          break label274;
        }
        ((ag)localObject3).u = ((Byte)localObject1).byteValue();
        label274:
        if (Math.random() * 100.0D <= ((Byte)localObject1).floatValue()) {
          break label770;
        }
        int i = 0;
        for (;;)
        {
          label295:
          if (p.a()) {}
          label371:
          label516:
          label624:
          label637:
          label651:
          label733:
          label738:
          label770:
          label785:
          label796:
          label801:
          label806:
          label811:
          label816:
          do
          {
            localObject1 = this.a;
            localObject2 = new ap();
            ((ap)localObject2).a = p.b;
            ((ap)localObject2).b = p.c;
            ((ap)localObject2).c = p.d;
            ((ap)localObject2).d = p.g;
            ((ap)localObject2).e = p.e;
            ((ap)localObject2).h = bc.c();
            if (((ap)localObject2).h == 1)
            {
              ((ap)localObject2).g = bc.a();
              ((ap)localObject2).i = bc.d();
              if (!bc.e()) {
                break label825;
              }
              i = 1;
              ((ap)localObject2).m = i;
              if (localObject1 != null)
              {
                ((ap)localObject2).j = ((ag)localObject1).a;
                ((ap)localObject2).k = ((ag)localObject1).h;
                ((ap)localObject2).n = ((ag)localObject1).n;
                ((ap)localObject2).o = ((ag)localObject1).q;
                ((ap)localObject2).p = ((ag)localObject1).p;
                ((ap)localObject2).y = ((ag)localObject1).G;
                ((ap)localObject2).z = ((ag)localObject1).H;
                ((ap)localObject2).A = ((ag)localObject1).I;
                ((ap)localObject2).B = ((ag)localObject1).J;
                ((ap)localObject2).C = ((ag)localObject1).K;
                ((ap)localObject2).E = ((ag)localObject1).L;
                if (((ag)localObject1).l <= 0) {
                  break label785;
                }
                ((ap)localObject2).D = (((ag)localObject1).E - ((ag)localObject1).F);
                ((ap)localObject2).q = ((ag)localObject1).c;
                ((ap)localObject2).F = ((ag)localObject1).f;
                ((ap)localObject2).G = ((ag)localObject1).b;
                ((ap)localObject2).r = ((ag)localObject1).o;
                ((ap)localObject2).M = ((ag)localObject1).k;
                ((ap)localObject2).P = ((ag)localObject1).r;
                ((ap)localObject2).O = ((ag)localObject1).v;
                ((ap)localObject2).Q = ((ag)localObject1).t;
                ((ap)localObject2).K = ((ag)localObject1).u;
                ((ap)localObject2).s = ((ag)localObject1).l;
                ((ap)localObject2).H = 1;
                if (!((ag)localObject1).m) {
                  break label796;
                }
                i = 0;
                ((ap)localObject2).I = i;
                if (!h.a) {
                  break label801;
                }
                i = 1;
                ((ap)localObject2).J = i;
                if (!((ag)localObject1).e) {
                  break label806;
                }
                i = 1;
                ((ap)localObject2).R = i;
                if (!((ag)localObject1).s) {
                  break label811;
                }
              }
            }
            for (i = 1;; i = 0)
            {
              ((ap)localObject2).S = i;
              ((ap)localObject2).L = ((ag)localObject1).g;
              ((ap)localObject2).l = ((ag)localObject1).i;
              ((ap)localObject2).N = ((ag)localObject1).d;
              ((ap)localObject2).toString();
              bd.a();
              if (r.a() != null)
              {
                r.a();
                r.a((ap)localObject2);
              }
              bd.b();
              return;
              i = 0;
              break;
              ((u)localObject1).a.a((String)localObject4, (String)localObject2, ((s)localObject3).a());
              ((u)localObject1).a(true);
              bd.b();
              break label177;
              localException1 = localException1;
              break label177;
              i = 1;
              break label816;
              ((ap)localObject2).f = bc.a();
              break label371;
              ((ap)localObject2).D = ((ap)localObject2).E;
              break label516;
              i = 1;
              break label624;
              i = 0;
              break label637;
              i = 0;
              break label651;
            }
          } while (i != 0);
        }
        i = 0;
      }
      catch (Exception localException2)
      {
        return;
      }
    }
    if (i == 0)
    {
      localObject3 = this.a;
      if (localObject3 != null)
      {
        localObject1 = u.a();
        localObject2 = ((ag)localObject3).a;
        localObject3 = ((ag)localObject3).h;
        localObject4 = bc.a();
        if ((!TextUtils.isEmpty((CharSequence)localObject4)) && (!((String)localObject4).equals("unknown"))) {
          break label738;
        }
        bd.c();
      }
    }
    label825:
    for (;;) {}
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/ct/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */