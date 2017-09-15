package com.tencent.mm.modelcontrol;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.sdk.platformtools.v;

public final class a
{
  private static f[] hzi;
  
  static
  {
    GMTrace.i(4103170162688L, 30571);
    hzi = null;
    f[] arrayOff = new f[2];
    hzi = arrayOff;
    arrayOff[0] = new f(0, 120, 540, 960, 30, 1200000, 1200000);
    hzi[1] = new f(120, 300, 360, 640, 24, 544000, 544000);
    GMTrace.o(4103170162688L, 30571);
  }
  
  public a()
  {
    GMTrace.i(4102901727232L, 30569);
    GMTrace.o(4102901727232L, 30569);
  }
  
  public static int a(f[] paramArrayOff, VideoTransPara paramVideoTransPara1, VideoTransPara paramVideoTransPara2)
  {
    GMTrace.i(4103035944960L, 30570);
    f[] arrayOff;
    if (paramArrayOff != null) {
      arrayOff = paramArrayOff;
    }
    try
    {
      if (paramArrayOff.length <= 0) {
        arrayOff = hzi;
      }
      n = arrayOff.length;
      paramVideoTransPara2.width = paramVideoTransPara1.width;
      paramVideoTransPara2.height = paramVideoTransPara1.height;
      paramVideoTransPara2.gPu = paramVideoTransPara1.gPu;
      paramVideoTransPara2.hzG = paramVideoTransPara1.hzG;
      paramVideoTransPara2.duration = paramVideoTransPara1.duration;
      if (paramVideoTransPara1.width <= paramVideoTransPara1.height) {
        break label456;
      }
      k = 1;
      if (k == 0) {
        break label462;
      }
      i = paramVideoTransPara1.width;
      label95:
      if (k == 0) {
        break label470;
      }
      j = paramVideoTransPara1.height;
      label106:
      i1 = paramVideoTransPara1.duration;
      if (paramVideoTransPara2.duration < arrayOff[(n - 1)].hzA) {
        break label913;
      }
      if (paramVideoTransPara2.duration >= hzi[1].hzA) {
        break label852;
      }
    }
    catch (Exception paramArrayOff)
    {
      for (;;)
      {
        int k;
        int i1;
        int i2;
        label276:
        label456:
        label462:
        label470:
        label494:
        label835:
        label852:
        v.e("MicroMsg.BitrateCalculator", "do calc bitrate error: " + paramArrayOff.toString());
        int i = 0;
        continue;
        int n = i;
        i = j;
        int j = n;
        break label1040;
        n = i;
        i = j;
        j = n;
        break label957;
        int m = 0;
        continue;
        if (i * i2 > j * i1)
        {
          n = 1;
          continue;
          j = j + 8 >> 4 << 4;
          i = i + 8 >> 4 << 4;
          if (k != 0)
          {
            n = j;
            continue;
          }
        }
        else
        {
          n = 0;
          continue;
        }
        n = i;
        continue;
        i = j;
        continue;
        m += 1;
        continue;
        m = 0;
        continue;
        if (i * i2 > j * i1)
        {
          n = 1;
          continue;
          j = j + 8 >> 4 << 4;
          i = i + 8 >> 4 << 4;
          if (k != 0)
          {
            n = j;
            continue;
          }
        }
        else
        {
          n = 0;
          continue;
        }
        n = i;
        continue;
        i = j;
      }
    }
    if (m < n) {
      if ((i1 >= arrayOff[m].hzz) && (i1 < arrayOff[m].hzA))
      {
        i1 = arrayOff[m].hzB;
        i2 = arrayOff[m].hzC;
        if (i <= i1) {
          if (j > i2)
          {
            break label919;
            if (n != 0)
            {
              i = j * i1 / i;
              j = i1;
              break label937;
              paramVideoTransPara2.width = n;
              if (k == 0) {
                break label981;
              }
              paramVideoTransPara2.height = i;
              if (paramVideoTransPara2.gPu <= arrayOff[m].hzD) {
                break label494;
              }
              i = arrayOff[m].hzD;
              paramVideoTransPara2.gPu = i;
              paramVideoTransPara2.hzG = ((int)((arrayOff[m].hzE * arrayOff[m].hzA + arrayOff[m].hzF * paramVideoTransPara2.duration - arrayOff[m].hzE * paramVideoTransPara2.duration - arrayOff[m].hzF * arrayOff[m].hzz) / (arrayOff[m].hzA - arrayOff[m].hzz) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (arrayOff[m].hzB * arrayOff[m].hzC)) * paramVideoTransPara2.gPu / arrayOff[m].hzD * (1.0D + (arrayOff[m].hzD - paramVideoTransPara2.gPu) * 0.015D)));
              i = paramVideoTransPara2.hzG;
            }
            for (;;)
            {
              GMTrace.o(4103035944960L, 30570);
              return i;
              k = 0;
              break;
              i = paramVideoTransPara1.height;
              break label95;
              j = paramVideoTransPara1.width;
              break label106;
              j = i * i2 / j;
              i = i2;
              break label937;
              i = paramVideoTransPara2.gPu;
              break label276;
              for (;;)
              {
                if (m >= 2) {
                  break label852;
                }
                if ((i1 >= hzi[m].hzz) && (i1 < hzi[m].hzA))
                {
                  i1 = hzi[m].hzB;
                  i2 = hzi[m].hzC;
                  if (i > i1) {
                    break label1002;
                  }
                  if (j <= i2) {
                    break label887;
                  }
                  break label1002;
                  if (n != 0)
                  {
                    i = j * i1 / i;
                    j = i1;
                    break label1020;
                    paramVideoTransPara2.width = n;
                    if (k == 0) {
                      break label1064;
                    }
                    paramVideoTransPara2.height = i;
                    if (paramVideoTransPara2.gPu <= hzi[m].hzD) {
                      break label835;
                    }
                  }
                  for (i = hzi[m].hzD;; i = paramVideoTransPara2.gPu)
                  {
                    paramVideoTransPara2.gPu = i;
                    paramVideoTransPara2.hzG = ((int)((hzi[m].hzE * hzi[m].hzA + hzi[m].hzF * paramVideoTransPara2.duration - hzi[m].hzE * paramVideoTransPara2.duration - hzi[m].hzF * hzi[m].hzz) / (hzi[m].hzA - hzi[m].hzz) * Math.sqrt(1.0D * (paramVideoTransPara2.width * paramVideoTransPara2.height) / (hzi[m].hzB * hzi[m].hzC)) * paramVideoTransPara2.gPu / hzi[m].hzD * (1.0D + (hzi[m].hzD - paramVideoTransPara2.gPu) * 0.015D)));
                    i = paramVideoTransPara2.hzG;
                    break;
                    j = i * i2 / j;
                    i = i2;
                    break label1020;
                  }
                }
                m += 1;
              }
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/modelcontrol/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */