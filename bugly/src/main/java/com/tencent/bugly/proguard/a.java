/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.util.Map;
/*     */ 
/*     */ public class a {
/*     */   protected java.util.HashMap<String, java.util.HashMap<String, byte[]>> a;
/*     */   private java.util.HashMap<String, Object> d;
/*     */   
/*   9 */   public static ag a(int paramInt) { if (paramInt == 1)
/*     */     {
/*  11 */       return new af();
/*     */     }
/*  13 */     if (paramInt == 3)
/*     */     {
/*  15 */       return new ae();
/*     */     }
/*  17 */     return null;
/*     */   }
/*     */   
/*  20 */   a() { this.a = new java.util.HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  25 */     new java.util.HashMap();
/*     */     
/*     */ 
/*     */ 
/*  29 */     this.d = new java.util.HashMap();
/*     */     
/*     */ 
/*  32 */     this.b = "GBK";
/*     */     
/*  34 */     this.c = new i();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void a(String paramString)
/*     */   {
/*  49 */     this.b = paramString;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public <T> void a(String paramString, T paramT)
/*     */   {
/*  86 */     if (paramString == null) {
/*  87 */       throw new IllegalArgumentException("put key can not is null");
/*     */     }
/*  89 */     if (paramT == null) {
/*  90 */       throw new IllegalArgumentException("put value can not is null");
/*     */     }
/*  92 */     if ((paramT instanceof java.util.Set)) {
/*  93 */       throw new IllegalArgumentException("can not support Set");
/*     */     }
/*     */     
/*  96 */     (localObject = new j()).a(this.b);
/*  97 */     ((j)localObject).a(paramT, 0);
/*  98 */     Object localObject = l.a(((j)localObject).a());
/*  99 */     java.util.HashMap localHashMap = new java.util.HashMap(1);
/* 100 */     java.util.ArrayList localArrayList = new java.util.ArrayList(1);
/* 101 */     a(localArrayList, paramT);
/* 102 */     paramT = a(localArrayList);
/* 103 */     localHashMap.put(paramT, localObject);
/* 104 */     this.d.remove(paramString);
/* 105 */     this.a.put(paramString, localHashMap);
/*     */   }
/*     */   
/*     */   public static String a(java.util.ArrayList<String> paramArrayList)
/*     */   {
/*  86 */     StringBuffer localStringBuffer = new StringBuffer();
/*  87 */     String str; for (int i = 0; i < paramArrayList.size(); i++) {
/*  88 */       if (str.equals("java.lang.Character")) throw new IllegalArgumentException("can not support java.lang.Character"); paramArrayList.set(i, str.equals("java.util.Map") ? "map" : str.equals("java.util.List") ? "list" : str.equals("java.lang.String") ? "string" : (str.equals("java.lang.Short")) || (str.equals("short")) ? "short" : (str.equals("java.lang.Long")) || (str.equals("long")) ? "int64" : (str.equals("java.lang.Float")) || (str.equals("float")) ? "float" : (str.equals("java.lang.Double")) || (str.equals("double")) ? "double" : (str.equals("java.lang.Byte")) || (str.equals("byte")) ? "char" : (str.equals("java.lang.Boolean")) || (str.equals("boolean")) ? "bool" : ((str = (String)paramArrayList.get(i)).equals("java.lang.Integer")) || (str.equals("int")) ? "int32" : str);
/*     */     }
/*  90 */     java.util.Collections.reverse(paramArrayList);
/*  91 */     for (i = 0; i < paramArrayList.size(); i++)
/*     */     {
/*  93 */       if ((str = (String)paramArrayList.get(i)).equals("list")) {
/*  94 */         paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
/*  95 */         paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
/*  96 */       } else if (str.equals("map")) {
/*  97 */         paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1) + ",");
/*  98 */         paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
/*  99 */       } else if (str.equals("Array")) {
/* 100 */         paramArrayList.set(i - 1, "<" + (String)paramArrayList.get(i - 1));
/* 101 */         paramArrayList.set(0, (String)paramArrayList.get(0) + ">");
/*     */       }
/*     */     }
/* 104 */     java.util.Collections.reverse(paramArrayList);
/* 105 */     for (java.util.Iterator localIterator = paramArrayList.iterator(); localIterator.hasNext();) { str = (String)localIterator.next();
/* 106 */       localStringBuffer.append(str);
/*     */     }
/* 108 */     return localStringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static aq a(com.tencent.bugly.crashreport.biz.UserInfoBean paramUserInfoBean)
/*     */   {
/*  50 */     if (paramUserInfoBean == null) {
/*  51 */       return null;
/*     */     }
/*     */     aq localaq;
/*  54 */     (localaq = new aq()).a = paramUserInfoBean.e;
/*  55 */     localaq.e = paramUserInfoBean.j;
/*  56 */     localaq.d = paramUserInfoBean.c;
/*  57 */     localaq.c = paramUserInfoBean.d;
/*  58 */     localaq.g = com.tencent.bugly.crashreport.common.info.a.b().i();
/*  59 */     localaq.h = (paramUserInfoBean.o == 1);
/*     */     
/*  61 */     switch (paramUserInfoBean.b) {
/*     */     case 1: 
/*  63 */       localaq.b = 1;
/*     */       
/*  65 */       break;
/*     */     case 3: 
/*  67 */       localaq.b = 2;
/*     */       
/*  69 */       break;
/*     */     case 2: 
/*  71 */       localaq.b = 4;
/*     */       
/*  73 */       break;
/*     */     case 4: 
/*  75 */       localaq.b = 3;
/*     */       
/*  77 */       break;
/*     */     
/*     */     default: 
/*  80 */       if ((paramUserInfoBean.b >= 10) && (paramUserInfoBean.b < 20))
/*     */       {
/*  82 */         localaq.b = ((byte)paramUserInfoBean.b);
/*     */       } else {
/*  84 */         x.e("unknown uinfo type %d ", new Object[] { Integer.valueOf(paramUserInfoBean.b) });
/*  85 */         return null;
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/*  91 */     localaq.f = new java.util.HashMap();
/*  92 */     if (paramUserInfoBean.p >= 0) {
/*  93 */       localaq.f.put("C01", paramUserInfoBean.p);
/*     */     }
/*     */     
/*  96 */     if (paramUserInfoBean.q >= 0) {
/*  97 */       localaq.f.put("C02", paramUserInfoBean.q);
/*     */     }
/*     */     java.util.Iterator localIterator;
/* 100 */     if ((paramUserInfoBean.r != null) && (paramUserInfoBean.r.size() > 0)) {
/* 101 */       for (localIterator = paramUserInfoBean.r.entrySet().iterator(); localIterator.hasNext();) { localEntry = (java.util.Map.Entry)localIterator.next();
/* 102 */         localaq.f.put("C03_" + (String)localEntry.getKey(), localEntry.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */     java.util.Map.Entry localEntry;
/* 107 */     if ((paramUserInfoBean.s != null) && (paramUserInfoBean.s.size() > 0)) {
/* 108 */       for (localIterator = paramUserInfoBean.s.entrySet().iterator(); localIterator.hasNext();) { localEntry = (java.util.Map.Entry)localIterator.next();
/* 109 */         localaq.f.put("C04_" + (String)localEntry.getKey(), localEntry.getValue());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 115 */     localaq.f.put("A36", !paramUserInfoBean.l);
/*     */     
/* 117 */     localaq.f.put("F02", paramUserInfoBean.g);
/*     */     
/* 119 */     localaq.f.put("F03", paramUserInfoBean.h);
/*     */     
/* 121 */     localaq.f.put("F04", paramUserInfoBean.j);
/*     */     
/* 123 */     localaq.f.put("F05", paramUserInfoBean.i);
/*     */     
/* 125 */     localaq.f.put("F06", paramUserInfoBean.m);
/*     */     
/* 127 */     localaq.f.put("F10", paramUserInfoBean.k);
/*     */     
/* 129 */     x.c("summary type %d vm:%d", new Object[] { Byte.valueOf(localaq.b), Integer.valueOf(localaq.f.size()) });
/* 130 */     return localaq;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static ar a(java.util.List<com.tencent.bugly.crashreport.biz.UserInfoBean> paramList, int paramInt)
/*     */   {
/* 138 */     if ((paramList == null) || (paramList.size() == 0)) {
/* 139 */       return null;
/*     */     }
/*     */     com.tencent.bugly.crashreport.common.info.a locala;
/* 142 */     if ((locala = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
/* 143 */       return null;
/*     */     }
/* 145 */     locala.t();
/*     */     ar localar;
/* 147 */     (localar = new ar()).b = locala.d;
/* 148 */     localar.c = locala.h();
/* 149 */     java.util.ArrayList localArrayList = new java.util.ArrayList();
/* 150 */     for (paramList = paramList.iterator(); paramList.hasNext();)
/*     */     {
/* 152 */       if ((localObject2 = a(localObject1 = (com.tencent.bugly.crashreport.biz.UserInfoBean)paramList.next())) != null)
/* 153 */         localArrayList.add(localObject2); }
/*     */     Object localObject1;
/*     */     Object localObject2;
/* 156 */     localar.d = localArrayList;
/* 157 */     localar.e = new java.util.HashMap();
/* 158 */     localar.e.put("A7", locala.f);
/* 159 */     localar.e.put("A6", locala.s());
/* 160 */     localar.e.put("A5", locala.r());
/* 161 */     localar.e.put("A2", locala.p());
/* 162 */     localar.e.put("A1", locala.p());
/* 163 */     localar.e.put("A24", locala.h);
/* 164 */     localar.e.put("A17", locala.q());
/* 165 */     localar.e.put("A15", locala.w());
/* 166 */     localar.e.put("A13", locala.x());
/*     */     
/*     */ 
/*     */ 
/* 170 */     localar.e.put("F08", locala.v);
/*     */     
/* 172 */     localar.e.put("F09", locala.w);
/*     */     
/*     */ 
/* 175 */     if (((paramList = locala.E()) != null) && (paramList.size() > 0)) {
/* 176 */       for (localObject1 = paramList.entrySet().iterator(); ((java.util.Iterator)localObject1).hasNext();) { localObject2 = (java.util.Map.Entry)((java.util.Iterator)localObject1).next();
/* 177 */         localar.e.put("C04_" + (String)((java.util.Map.Entry)localObject2).getKey(), ((java.util.Map.Entry)localObject2).getValue());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 182 */     switch (paramInt) {
/*     */     case 1: 
/* 184 */       localar.a = 1;
/* 185 */       break;
/*     */     case 2: 
/* 187 */       localar.a = 2;
/* 188 */       break;
/*     */     default: 
/* 190 */       x.e("unknown up type %d ", new Object[] { Integer.valueOf(paramInt) });
/* 191 */       return null;
/*     */     }
/* 193 */     return localar;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <T extends k> T a(byte[] paramArrayOfByte, Class<T> paramClass)
/*     */   {
/* 205 */     if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
/* 206 */       return null;
/*     */     }
/*     */     try {
/* 209 */       paramClass = (k)paramClass.newInstance();
/* 210 */       (
/* 211 */         paramArrayOfByte = new i(paramArrayOfByte)).a("utf-8");
/* 212 */       paramClass.a(paramArrayOfByte);
/*     */       
/* 214 */       return paramClass;
/*     */     } catch (Throwable localThrowable) {
/* 216 */       if (!x.b(paramClass = localThrowable)) {
/* 217 */         paramClass.printStackTrace();
/*     */       }
/*     */     }
/* 220 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected String b;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   i c;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void a(java.util.ArrayList<String> paramArrayList, Object paramObject)
/*     */   {
/* 278 */     if (paramObject.getClass().isArray()) {
/* 279 */       if (!paramObject.getClass().getComponentType().toString().equals("byte")) {
/* 280 */         throw new IllegalArgumentException("only byte[] is supported");
/*     */       }
/* 282 */       if (java.lang.reflect.Array.getLength(paramObject) > 0) {
/* 283 */         paramArrayList.add("java.util.List");
/* 284 */         a(paramArrayList, java.lang.reflect.Array.get(paramObject, 0));return;
/*     */       }
/* 286 */       paramArrayList.add("Array");
/* 287 */       paramArrayList.add("?");return;
/*     */     }
/*     */     
/* 290 */     if ((paramObject instanceof java.lang.reflect.Array))
/* 291 */       throw new IllegalArgumentException("can not support Array, please use List");
/* 292 */     if ((paramObject instanceof java.util.List)) {
/* 293 */       paramArrayList.add("java.util.List");
/*     */       
/* 295 */       if ((paramObject = (java.util.List)paramObject).size() > 0) {
/* 296 */         a(paramArrayList, ((java.util.List)paramObject).get(0));
/*     */       } else {
/* 298 */         paramArrayList.add("?");
/*     */       }
/*     */     }
/* 301 */     else if ((paramObject instanceof Map)) {
/* 302 */       paramArrayList.add("java.util.Map");
/*     */       
/* 304 */       if ((paramObject = (Map)paramObject).size() > 0)
/*     */       {
/* 306 */         Object localObject = (localObject = ((Map)paramObject).keySet().iterator()).next();
/* 307 */         paramObject = ((Map)paramObject).get(localObject);
/* 308 */         paramArrayList.add(localObject.getClass().getName());
/* 309 */         a(paramArrayList, paramObject);
/*     */       } else {
/* 311 */         paramArrayList.add("?");
/* 312 */         paramArrayList.add("?");
/*     */       }
/*     */     }
/*     */     else {
/* 316 */       paramArrayList.add(paramObject.getClass().getName());
/*     */     }
/*     */   }
/*     */   
/*     */   public byte[] a() {
/*     */     j localj;
/* 322 */     (localj = new j(0)).a(this.b);
/* 323 */     localj.a(this.a, 0);
/* 324 */     return l.a(localj.a());
/*     */   }
/*     */   
/*     */   public void a(byte[] paramArrayOfByte) {
/* 328 */     this.c.a(paramArrayOfByte);
/* 329 */     this.c.a(this.b);
/* 330 */     paramArrayOfByte = new java.util.HashMap(1);
/*     */     java.util.HashMap localHashMap;
/* 332 */     (localHashMap = new java.util.HashMap(1)).put("", new byte[0]);
/* 333 */     paramArrayOfByte.put("", localHashMap);
/* 334 */     this.a = this.c.a(paramArrayOfByte, 0, false);
/*     */   }
/*     */   
/*     */   public static am a(android.content.Context paramContext, int paramInt, byte[] paramArrayOfByte)
/*     */   {
/* 230 */     com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
/* 231 */     com.tencent.bugly.crashreport.common.strategy.StrategyBean localStrategyBean = com.tencent.bugly.crashreport.common.strategy.a.a().c();
/*     */     
/* 233 */     if ((locala == null) || (localStrategyBean == null)) {
/* 234 */       x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
/* 235 */       return null;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 240 */       localObject1 = new am();
/*     */       
/* 242 */       synchronized (locala) {
/* 243 */         ((am)localObject1).a = 1;
/* 244 */         ((am)localObject1).b = locala.f();
/* 245 */         ((am)localObject1).c = locala.c;
/* 246 */         ((am)localObject1).d = locala.j;
/* 247 */         ((am)localObject1).e = locala.l;
/* 248 */         locala.getClass();((am)localObject1).f = "2.6.5";
/* 249 */         ((am)localObject1).g = paramInt;
/* 250 */         ((am)localObject1).h = (paramArrayOfByte == null ? "".getBytes() : paramArrayOfByte);
/* 251 */         ((am)localObject1).i = locala.g;
/* 252 */         ((am)localObject1).j = locala.h;
/* 253 */         ((am)localObject1).k = new java.util.HashMap();
/* 254 */         ((am)localObject1).l = locala.e();
/* 255 */         ((am)localObject1).m = localStrategyBean.p;
/* 256 */         ((am)localObject1).o = locala.h();
/* 257 */         ((am)localObject1).p = com.tencent.bugly.crashreport.common.info.b.e(paramContext);
/* 258 */         ((am)localObject1).q = System.currentTimeMillis();
/* 259 */         ((am)localObject1).r = locala.k();
/* 260 */         ((am)localObject1).s = locala.j();
/* 261 */         ((am)localObject1).t = locala.m();
/* 262 */         ((am)localObject1).u = locala.l();
/* 263 */         ((am)localObject1).v = locala.n();
/* 264 */         ((am)localObject1).w = ((am)localObject1).p;
/* 265 */         locala.getClass();((am)localObject1).n = "com.tencent.bugly";
/*     */         
/*     */ 
/* 268 */         ((am)localObject1).k.put("A26", locala.y());
/*     */         
/*     */ 
/* 271 */         ((am)localObject1).k.put("F11", locala.z);
/*     */         
/*     */ 
/*     */ 
/* 275 */         ((am)localObject1).k.put("F12", locala.y);
/*     */         
/*     */ 
/*     */ 
/* 279 */         ((am)localObject1).k.put("G1", locala.u());
/*     */         
/*     */ 
/* 282 */         if (locala.B)
/*     */         {
/* 284 */           ((am)localObject1).k.put("G2", locala.K());
/*     */           
/*     */ 
/* 287 */           ((am)localObject1).k.put("G3", locala.L());
/*     */           
/*     */ 
/* 290 */           ((am)localObject1).k.put("G4", locala.M());
/*     */           
/*     */ 
/* 293 */           ((am)localObject1).k.put("G5", locala.N());
/*     */           
/*     */ 
/* 296 */           ((am)localObject1).k.put("G6", locala.O());
/*     */           
/*     */ 
/* 299 */           ((am)localObject1).k.put("G7", Long.toString(locala.P()));
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 304 */         ((am)localObject1).k.put("D3", locala.k);
/*     */         
/*     */ 
/*     */ 
/* 308 */         if (com.tencent.bugly.b.b != null)
/*     */         {
/* 310 */           for (paramContext = com.tencent.bugly.b.b.iterator(); paramContext.hasNext();) {
/* 311 */             if (((paramInt = (com.tencent.bugly.a)paramContext.next()).versionKey != null) && (paramInt.version != null)) {
/* 312 */               ((am)localObject1).k.put(paramInt.versionKey, paramInt.version);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 318 */         ((am)localObject1).k.put("G15", z.b("G15", ""));
/*     */         
/*     */ 
/* 321 */         ((am)localObject1).k.put("D4", z.b("D4", "0"));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 326 */       if (((??? = u.a()) != null) && (!((u)???).a) && 
/* 327 */         (paramArrayOfByte != null))
/*     */       {
/* 329 */         ((am)localObject1).h = z.a(((am)localObject1).h, 2, 1, localStrategyBean.u);
/*     */         
/*     */ 
/* 332 */         if (((am)localObject1).h == null) {
/* 333 */           x.e("reqPkg sbuffer error!", new Object[0]);
/* 334 */           return null;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 340 */       if ((paramContext = locala.D()) != null) {
/* 341 */         for (paramInt = paramContext.entrySet().iterator(); paramInt.hasNext();) { paramContext = (java.util.Map.Entry)paramInt.next();
/* 342 */           ((am)localObject1).k.put(paramContext.getKey(), paramContext.getValue());
/*     */         }
/*     */       }
/*     */       
/* 346 */       return (am)localObject1;
/*     */     } catch (Throwable localThrowable) { Object localObject1;
/* 348 */       if (!x.b(localObject1 = localThrowable))
/* 349 */         ((Throwable)localObject1).printStackTrace();
/*     */     }
/* 351 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static byte[] a(Object paramObject)
/*     */   {
/*     */     try
/*     */     {
/* 361 */       (localObject = new d()).b();
/* 362 */       ((d)localObject).a("utf-8");
/* 363 */       ((d)localObject).b(1);
/* 364 */       ((d)localObject).b("RqdServer");
/* 365 */       ((d)localObject).c("sync");
/* 366 */       ((d)localObject).a("detail", paramObject);
/* 367 */       return ((d)localObject).a();
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 369 */       if (!x.b(localObject = localThrowable)) {
/* 370 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 373 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static an a(byte[] paramArrayOfByte, boolean paramBoolean)
/*     */   {
/* 381 */     if (paramArrayOfByte != null) {
/*     */       try
/*     */       {
/* 384 */         (localObject = new d()).b();
/* 385 */         ((d)localObject).a("utf-8");
/* 386 */         ((d)localObject).a(paramArrayOfByte);
/* 387 */         paramArrayOfByte = ((d)localObject).b("detail", new an());
/*     */         
/* 389 */         localObject = null;
/* 390 */         if (an.class.isInstance(paramArrayOfByte)) {
/* 391 */           localObject = (an)an.class.cast(paramArrayOfByte);
/*     */         }
/* 393 */         if ((!paramBoolean) && 
/* 394 */           (localObject != null) && (((an)localObject).c != null) && (((an)localObject).c.length > 0)) {
/* 395 */           x.c("resp buf %d", new Object[] { Integer.valueOf(((an)localObject).c.length) });
/*     */           
/* 397 */           ((an)localObject).c = z.b(((an)localObject).c, 2, 1, com.tencent.bugly.crashreport.common.strategy.StrategyBean.d);
/*     */           
/*     */ 
/* 400 */           if (((an)localObject).c == null) {
/* 401 */             x.e("resp sbuffer error!", new Object[0]);
/* 402 */             return null;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 407 */         return (an)localObject;
/*     */       } catch (Throwable localThrowable) { Object localObject;
/* 409 */         if (!x.b(localObject = localThrowable)) {
/* 410 */           ((Throwable)localObject).printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 415 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static byte[] a(k paramk)
/*     */   {
/*     */     try
/*     */     {
/* 424 */       (localObject = new j()).a("utf-8");
/* 425 */       paramk.a((j)localObject);
/* 426 */       return ((j)localObject).b();
/*     */     } catch (Throwable localThrowable) { Object localObject;
/* 428 */       if (!x.b(localObject = localThrowable)) {
/* 429 */         ((Throwable)localObject).printStackTrace();
/*     */       }
/*     */     }
/* 432 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */