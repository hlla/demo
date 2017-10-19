/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import android.content.Context;
/*     */ import android.content.SharedPreferences;
/*     */ import android.content.SharedPreferences.Editor;
/*     */ import android.text.TextUtils;
/*     */ import com.tencent.bugly.crashreport.common.info.a;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class n
/*     */ {
/*  30 */   private static n b = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Context c;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  40 */   public static final long a = System.currentTimeMillis();
/*     */   
/*     */ 
/*     */   private String d;
/*     */   
/*     */ 
/*     */   private Map<Integer, Map<String, m>> e;
/*     */   
/*     */ 
/*     */   private SharedPreferences f;
/*     */   
/*     */ 
/*     */ 
/*     */   private n(Context paramContext)
/*     */   {
/*  55 */     this.c = paramContext;
/*  56 */     this.e = new HashMap();
/*  57 */     this.d = a.b().d;
/*  58 */     this.f = paramContext.getSharedPreferences("crashrecord", 0);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized n a(Context paramContext)
/*     */   {
/*  68 */     if (b == null) {
/*  69 */       b = new n(paramContext);
/*     */     }
/*  71 */     return b;
/*     */   }
/*     */   
/*     */   public static synchronized n a() {
/*  75 */     return b;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private synchronized boolean b(int paramInt)
/*     */   {
/*     */     try
/*     */     {
/*     */       List localList;
/*     */       
/*     */ 
/*  88 */       if ((localList = c(paramInt)) == null) {
/*  89 */         return false;
/*     */       }
/*  91 */       long l = System.currentTimeMillis();
/*  92 */       ArrayList localArrayList1 = new ArrayList();
/*  93 */       ArrayList localArrayList2 = new ArrayList();
/*  94 */       for (Iterator localIterator = localList.iterator(); localIterator.hasNext();) { m localm;
/*  95 */         if (((localm = (m)localIterator.next()).b != null) && (localm.b.equalsIgnoreCase(this.d)) && (localm.d > 0))
/*     */         {
/*  97 */           localArrayList1.add(localm);
/*     */         }
/*     */         
/* 100 */         if (localm.c + 86400000L < l) {
/* 101 */           localArrayList2.add(localm);
/*     */         }
/*     */       }
/* 104 */       Collections.sort(localArrayList1);
/* 105 */       if (localArrayList1.size() >= 2) {
/* 106 */         if ((localArrayList1.size() > 0) && (((m)localArrayList1.get(localArrayList1.size() - 1)).c + 86400000L < l))
/*     */         {
/* 108 */           localList.clear();
/* 109 */           a(paramInt, localList);
/* 110 */           return false;
/*     */         }
/*     */         
/* 113 */         return true;
/*     */       }
/*     */       
/*     */ 
/* 117 */       localList.removeAll(localArrayList2);
/* 118 */       a(paramInt, localList);
/* 119 */       return false;
/*     */     }
/*     */     catch (Exception localException) {
/* 122 */       x.e("isFrequentCrash failed", new Object[0]);
/*     */     }
/* 124 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized void a(int paramInt1, final int paramInt2)
/*     */   {
/* 135 */     w.a().a(new Runnable()
/*     */     {
/*     */       public final void run() {
/*     */         try {
/* 139 */           if (TextUtils.isEmpty(n.a(n.this))) {
/*     */             return;
/*     */           }
/*     */           
/*     */           Object localObject1;
/* 144 */           if ((localObject1 = n.a(n.this, this.a)) == null)
/* 145 */             localObject1 = new ArrayList();
/*     */           Object localObject2;
/* 147 */           if (n.b(n.this).get(Integer.valueOf(this.a)) == null) {
/* 148 */             localObject2 = new HashMap();
/* 149 */             n.b(n.this).put(Integer.valueOf(this.a), localObject2);
/*     */           }
/*     */           
/* 152 */           if (((Map)n.b(n.this).get(Integer.valueOf(this.a))).get(n.a(n.this)) == null)
/*     */           {
/* 154 */             (localObject2 = new m()).a = this.a;
/* 155 */             ((m)localObject2).g = n.a;
/* 156 */             ((m)localObject2).b = n.a(n.this);
/* 157 */             ((m)localObject2).f = a.b().j;
/* 158 */             a.b().getClass();((m)localObject2).e = "2.6.5";
/* 159 */             ((m)localObject2).c = System.currentTimeMillis();
/* 160 */             ((m)localObject2).d = paramInt2;
/* 161 */             ((Map)n.b(n.this).get(Integer.valueOf(this.a))).put(n.a(n.this), localObject2);
/*     */           }
/*     */           else {
/* 164 */             (localObject2 = (m)((Map)n.b(n.this).get(Integer.valueOf(this.a))).get(n.a(n.this))).d = paramInt2;
/*     */           }
/*     */           
/* 167 */           int i = 0;
/* 168 */           ArrayList localArrayList = new ArrayList();
/* 169 */           for (Iterator localIterator = ((List)localObject1).iterator(); localIterator.hasNext();) { m localm;
/* 170 */             if (((localm = (m)localIterator.next()).g == ((m)localObject2).g) && (localm.b != null) && (localm.b.equalsIgnoreCase(((m)localObject2).b)))
/*     */             {
/* 172 */               i = 1;
/* 173 */               localm.d = ((m)localObject2).d;
/*     */             }
/* 175 */             if (((localm.e != null) && (!localm.e.equalsIgnoreCase(((m)localObject2).e))) || ((localm.f != null) && (!localm.f.equalsIgnoreCase(((m)localObject2).f))) || (localm.d <= 0))
/*     */             {
/*     */ 
/* 178 */               localArrayList.add(localm);
/*     */             }
/*     */           }
/*     */           
/* 182 */           ((List)localObject1).removeAll(localArrayList);
/*     */           
/* 184 */           if (i == 0) {
/* 185 */             ((List)localObject1).add(localObject2);
/*     */           }
/* 187 */           n.a(n.this, this.a, (List)localObject1); return;
/*     */         } catch (Exception localException) {
/* 189 */           x.e("saveCrashRecord failed", new Object[0]);
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */   private synchronized <T extends List<?>> T c(int paramInt)
/*     */   {
/*     */     try {
/* 198 */       if (!(paramInt = new File(this.c.getDir("crashrecord", 0), paramInt)).exists()) {
/* 199 */         return null;
/*     */       }
/* 201 */       ObjectInputStream localObjectInputStream = null;
/*     */       
/*     */       try
/*     */       {
/* 205 */         paramInt = paramInt = (List)(localObjectInputStream = new ObjectInputStream(new FileInputStream(paramInt))).readObject();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 211 */         localObjectInputStream.close();return paramInt;
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/* 207 */         x.a("open record file error", new Object[0]);
/*     */       } catch (ClassNotFoundException localClassNotFoundException) {
/* 209 */         x.a("get object error", new Object[0]);
/*     */       } finally {
/* 211 */         if (localObjectInputStream != null) {
/* 212 */           localObjectInputStream.close();
/*     */         }
/*     */       }
/*     */     } catch (Exception paramInt) {
/* 216 */       x.e("readCrashRecord error", new Object[0]);
/*     */     }
/* 218 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   private synchronized <T extends List<?>> void a(int paramInt, T paramT)
/*     */   {
/* 224 */     if (paramT == null)
/* 225 */       return;
/*     */     try {
/* 227 */       paramInt = new File(this.c.getDir("crashrecord", 0), paramInt);
/* 228 */       ObjectOutputStream localObjectOutputStream = null;
/*     */       try
/*     */       {
/* 231 */         (localObjectOutputStream = new ObjectOutputStream(new FileOutputStream(paramInt))).writeObject(paramT);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 236 */         localObjectOutputStream.close();
/*     */       }
/*     */       catch (IOException localIOException)
/*     */       {
/* 234 */         x.a("open record file error", new Object[0]);
/*     */       } finally {
/* 236 */         if (localObjectOutputStream != null)
/* 237 */           localObjectOutputStream.close();
/*     */       }
/*     */       return;
/*     */     } catch (Exception paramInt) {
/* 241 */       x.e("writeCrashRecord error", new Object[0]);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final synchronized boolean a(final int paramInt)
/*     */   {
/* 252 */     boolean bool = true;
/*     */     try {
/* 254 */       bool = this.f.getBoolean(paramInt + "_" + this.d, true);
/* 255 */       w.a().a(new Runnable()
/*     */       {
/*     */         public final void run() {
/* 258 */           boolean bool = n.b(n.this, paramInt);
/* 259 */           n.c(n.this).edit().putBoolean(paramInt + "_" + n.a(n.this), !bool).commit();
/*     */         }
/* 261 */       });
/* 262 */       return bool;
/*     */     } catch (Exception localException) {
/* 264 */       x.e("canInit error", new Object[0]);
/*     */     }
/* 266 */     return bool;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/n.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */