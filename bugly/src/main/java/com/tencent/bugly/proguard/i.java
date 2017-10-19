/*     */ package com.tencent.bugly.proguard;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.lang.reflect.Array;
/*     */ import java.nio.BufferUnderflowException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
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
/*     */ public final class i
/*     */ {
/*     */   private ByteBuffer a;
/*     */   
/*     */   public i() {}
/*     */   
/*     */   public i(byte[] paramArrayOfByte)
/*     */   {
/*  50 */     this.a = ByteBuffer.wrap(paramArrayOfByte);
/*     */   }
/*     */   
/*     */   public i(byte[] paramArrayOfByte, int paramInt) {
/*  54 */     this.a = ByteBuffer.wrap(paramArrayOfByte);
/*  55 */     this.a.position(4);
/*     */   }
/*     */   
/*     */   public final void a(byte[] paramArrayOfByte)
/*     */   {
/*  60 */     if (this.a != null) {
/*  61 */       this.a.clear();
/*     */     }
/*  63 */     this.a = ByteBuffer.wrap(paramArrayOfByte);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int a(a parama, ByteBuffer paramByteBuffer)
/*     */   {
/*  73 */     int i = paramByteBuffer.get();
/*  74 */     parama.a = ((byte)(i & 0xF));
/*  75 */     parama.b = ((i & 0xF0) >> 4);
/*  76 */     if (parama.b == 15) {
/*  77 */       parama.b = paramByteBuffer.get();
/*  78 */       return 2;
/*     */     }
/*  80 */     return 1;
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
/*     */   private boolean a(int paramInt)
/*     */   {
/*     */     try
/*     */     {
/* 100 */       a locala1 = new a();
/*     */       for (;;) {
/* 102 */         a locala3 = locala1;i locali1 = this;a locala2 = a(locala3, locali1.a.duplicate());
/* 103 */         if ((paramInt <= locala1.b) || (locala1.a == 11))
/* 104 */           return paramInt == locala1.b;
/* 105 */         locala3 = locala2;i locali2 = this;this.a.position(locali2.a.position() + locala3);
/* 106 */         a(locala1.a);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 111 */       return false;
/*     */     } catch (g localg) {}catch (BufferUnderflowException localBufferUnderflowException) {}
/*     */   }
/*     */   
/*     */   private void a() {
/* 116 */     a locala1 = new a();
/*     */     do {
/* 118 */       a locala2 = locala1;i locali = this;a(locala2, locali.a);
/* 119 */       a(locala1.a);
/* 120 */     } while (locala1.a != 11);
/*     */   }
/*     */   
/*     */   private void a(byte paramByte)
/*     */   {
/*     */     int i;
/*     */     i locali1;
/*     */     byte b1;
/*     */     Object localObject1;
/*     */     Object localObject2;
/*     */     i locali2;
/* 131 */     switch (paramByte) {
/*     */     case 0: 
/* 133 */       i = 1;locali1 = this;this.a.position(locali1.a.position() + i);
/* 134 */       return;
/*     */     case 1: 
/* 136 */       i = 2;locali1 = this;this.a.position(locali1.a.position() + i);
/* 137 */       return;
/*     */     case 2: 
/* 139 */       i = 4;locali1 = this;this.a.position(locali1.a.position() + i);
/* 140 */       return;
/*     */     case 3: 
/* 142 */       i = 8;locali1 = this;this.a.position(locali1.a.position() + i);
/* 143 */       return;
/*     */     case 4: 
/* 145 */       i = 4;locali1 = this;this.a.position(locali1.a.position() + i);
/* 146 */       return;
/*     */     case 5: 
/* 148 */       i = 8;locali1 = this;this.a.position(locali1.a.position() + i);
/* 149 */       return;
/*     */     
/*     */     case 6: 
/* 152 */       if ((b1 = this.a.get()) < 0)
/* 153 */         b1 += 256;
/* 154 */       i = b1;locali1 = this;this.a.position(locali1.a.position() + i);
/* 155 */       return;
/*     */     
/*     */     case 7: 
/* 158 */       i = this.a.getInt();locali1 = this;this.a.position(locali1.a.position() + i);
/* 159 */       return;
/*     */     
/*     */     case 8: 
/* 162 */       b1 = a(0, 0, true);
/* 163 */       for (paramByte = 0; paramByte < b1 << 1; paramByte++) {
/* 164 */         locali1 = this;localObject1 = new a();localObject2 = localObject1;locali2 = locali1;a((a)localObject2, locali2.a);locali1.a(((a)localObject1).a); }
/* 165 */       return;
/*     */     
/*     */     case 9: 
/* 168 */       b1 = a(0, 0, true);
/* 169 */       for (paramByte = 0; paramByte < b1; paramByte++) {
/* 170 */         locali1 = this;localObject1 = new a();localObject2 = localObject1;locali2 = locali1;a((a)localObject2, locali2.a);locali1.a(((a)localObject1).a); }
/* 171 */       return;
/*     */     
/*     */     case 13: 
/* 174 */       a locala = new a();
/* 175 */       localObject1 = locala;locali1 = this;a((a)localObject1, locali1.a);
/* 176 */       if (locala.a != 0) {
/* 177 */         throw new g("skipField with invalid type, type value: " + paramByte + ", " + locala.a);
/*     */       }
/* 179 */       paramByte = a(0, 0, true);
/* 180 */       int j = paramByte;locali1 = this;this.a.position(locali1.a.position() + j);
/* 181 */       return;
/*     */     
/*     */     case 10: 
/* 184 */       a();
/* 185 */       return;
/*     */     case 11: 
/*     */     case 12: 
/* 188 */       return;
/*     */     }
/* 190 */     throw new g("invalid type.");
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean a(int paramInt, boolean paramBoolean)
/*     */   {
/* 196 */     return (paramInt = a((byte)0, paramInt, paramBoolean)) != 0;
/*     */   }
/*     */   
/*     */   public final byte a(byte paramByte, int paramInt, boolean paramBoolean) {
/* 200 */     if (a(paramInt)) {
/* 201 */       paramByte = new a();
/* 202 */       paramBoolean = paramByte;paramInt = this;a(paramBoolean, paramInt.a);
/* 203 */       switch (paramByte.a) {
/*     */       case 12: 
/* 205 */         paramByte = 0;
/* 206 */         break;
/*     */       case 0: 
/* 208 */         paramByte = this.a.get();
/* 209 */         break;
/*     */       default: 
/* 211 */         throw new g("type mismatch.");
/*     */       }
/* 213 */     } else if (paramBoolean) {
/* 214 */       throw new g("require field not exist.");
/*     */     }
/* 216 */     return paramByte;
/*     */   }
/*     */   
/*     */   public final short a(short paramShort, int paramInt, boolean paramBoolean) {
/* 220 */     if (a(paramInt)) {
/* 221 */       paramShort = new a();
/* 222 */       paramBoolean = paramShort;paramInt = this;a(paramBoolean, paramInt.a);
/* 223 */       switch (paramShort.a) {
/*     */       case 12: 
/* 225 */         paramShort = 0;
/* 226 */         break;
/*     */       case 0: 
/* 228 */         paramShort = (short)this.a.get();
/* 229 */         break;
/*     */       case 1: 
/* 231 */         paramShort = this.a.getShort();
/* 232 */         break;
/*     */       default: 
/* 234 */         throw new g("type mismatch.");
/*     */       }
/* 236 */     } else if (paramBoolean) {
/* 237 */       throw new g("require field not exist.");
/*     */     }
/* 239 */     return paramShort;
/*     */   }
/*     */   
/*     */   public final int a(int paramInt1, int paramInt2, boolean paramBoolean) {
/* 243 */     if (a(paramInt2)) {
/* 244 */       paramInt1 = new a();
/* 245 */       paramBoolean = paramInt1;paramInt2 = this;a(paramBoolean, paramInt2.a);
/* 246 */       switch (paramInt1.a) {
/*     */       case 12: 
/* 248 */         paramInt1 = 0;
/* 249 */         break;
/*     */       case 0: 
/* 251 */         paramInt1 = this.a.get();
/* 252 */         break;
/*     */       case 1: 
/* 254 */         paramInt1 = this.a.getShort();
/* 255 */         break;
/*     */       case 2: 
/* 257 */         paramInt1 = this.a.getInt();
/* 258 */         break;
/*     */       default: 
/* 260 */         throw new g("type mismatch.");
/*     */       }
/* 262 */     } else if (paramBoolean) {
/* 263 */       throw new g("require field not exist.");
/*     */     }
/* 265 */     return paramInt1;
/*     */   }
/*     */   
/*     */   public final long a(long paramLong, int paramInt, boolean paramBoolean) { ;
/* 269 */     if (a(paramInt)) {
/* 270 */       paramLong = new a();
/* 271 */       paramInt = paramLong;??? = this;a(paramInt, ???.a);
/* 272 */       switch (paramLong.a) {
/*     */       case 12: 
/* 274 */         paramLong = 0L;
/* 275 */         break;
/*     */       case 0: 
/* 277 */         paramLong = this.a.get();
/* 278 */         break;
/*     */       case 1: 
/* 280 */         paramLong = this.a.getShort();
/* 281 */         break;
/*     */       case 2: 
/* 283 */         paramLong = this.a.getInt();
/* 284 */         break;
/*     */       case 3: 
/* 286 */         paramLong = this.a.getLong();
/* 287 */         break;
/*     */       case 4: case 5: case 6: case 7: case 8: case 9: case 10: case 11: default: 
/* 289 */         throw new g("type mismatch.");
/*     */       }
/* 291 */     } else if (paramBoolean) {
/* 292 */       throw new g("require field not exist.");
/*     */     }
/* 294 */     return paramLong;
/*     */   }
/*     */   
/*     */   private float a(float paramFloat, int paramInt, boolean paramBoolean) {
/* 298 */     if (a(paramInt)) {
/* 299 */       paramFloat = new a();
/* 300 */       paramBoolean = paramFloat;paramInt = this;a(paramBoolean, paramInt.a);
/* 301 */       switch (paramFloat.a) {
/*     */       case 12: 
/* 303 */         paramFloat = 0.0F;
/* 304 */         break;
/*     */       case 4: 
/* 306 */         paramFloat = this.a.getFloat();
/* 307 */         break;
/*     */       default: 
/* 309 */         throw new g("type mismatch.");
/*     */       }
/* 311 */     } else if (paramBoolean) {
/* 312 */       throw new g("require field not exist.");
/*     */     }
/* 314 */     return paramFloat;
/*     */   }
/*     */   
/*     */   private double a(double paramDouble, int paramInt, boolean paramBoolean) { ;
/* 318 */     if (a(paramInt)) {
/* 319 */       paramDouble = new a();
/* 320 */       paramInt = paramDouble;??? = this;a(paramInt, ???.a);
/* 321 */       switch (paramDouble.a) {
/*     */       case 12: 
/* 323 */         paramDouble = 0.0D;
/* 324 */         break;
/*     */       case 4: 
/* 326 */         paramDouble = this.a.getFloat();
/* 327 */         break;
/*     */       case 5: 
/* 329 */         paramDouble = this.a.getDouble();
/* 330 */         break;
/*     */       default: 
/* 332 */         throw new g("type mismatch.");
/*     */       }
/* 334 */     } else if (paramBoolean) {
/* 335 */       throw new g("require field not exist.");
/*     */     }
/* 337 */     return paramDouble;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final String b(int paramInt, boolean paramBoolean)
/*     */   {
/* 415 */     int i = null;
/* 416 */     String str; if (a(paramInt)) {
/* 417 */       paramInt = new a();
/* 418 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 419 */       switch (paramInt.a)
/*     */       {
/*     */       case 6: 
/* 422 */         if ((paramInt = this.a.get()) < 0)
/* 423 */           paramInt += 256;
/* 424 */         paramInt = new byte[paramInt];
/* 425 */         this.a.get(paramInt);
/*     */         try {
/* 427 */           str = new String(paramInt, this.b);
/*     */         }
/*     */         catch (UnsupportedEncodingException localUnsupportedEncodingException1) {
/* 430 */           str = new String(paramInt);
/*     */           
/*     */ 
/* 433 */           break;
/*     */         }
/*     */       case 7: 
/* 436 */         if (((paramInt = this.a.getInt()) > 104857600) || (paramInt < 0))
/* 437 */           throw new g("String too long: " + paramInt);
/* 438 */         paramInt = new byte[paramInt];
/* 439 */         this.a.get(paramInt);
/*     */         try {
/* 441 */           str = new String(paramInt, this.b);
/*     */         }
/*     */         catch (UnsupportedEncodingException localUnsupportedEncodingException2) {
/* 444 */           str = new String(paramInt);
/*     */           
/*     */ 
/* 447 */           break;
/*     */         }
/* 449 */       default:  throw new g("type mismatch.");
/*     */       }
/* 451 */     } else if (paramBoolean) {
/* 452 */       throw new g("require field not exist.");
/*     */     }
/* 454 */     return str;
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
/*     */   public final <K, V> HashMap<K, V> a(Map<K, V> paramMap, int paramInt, boolean paramBoolean)
/*     */   {
/* 488 */     return (HashMap)a(new HashMap(), paramMap, paramInt, paramBoolean);
/*     */   }
/*     */   
/*     */   private <K, V> Map<K, V> a(Map<K, V> paramMap1, Map<K, V> paramMap2, int paramInt, boolean paramBoolean)
/*     */   {
/* 493 */     if ((paramMap2 == null) || (paramMap2.isEmpty()))
/*     */     {
/* 495 */       return new HashMap();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 502 */     Object localObject1 = (paramMap2 = (Map.Entry)(paramMap2 = paramMap2.entrySet().iterator()).next()).getKey();
/* 503 */     paramMap2 = paramMap2.getValue();
/*     */     
/* 505 */     if (a(paramInt)) {
/* 506 */       paramInt = new a();
/* 507 */       int i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 508 */       switch (paramInt.a)
/*     */       {
/*     */       case 8: 
/* 511 */         if ((paramInt = a(0, 0, true)) < 0)
/* 512 */           throw new g("size invalid: " + paramInt);
/* 513 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++) {
/* 514 */           Object localObject2 = a(localObject1, 0, true);
/* 515 */           Object localObject3 = a(paramMap2, 1, true);
/* 516 */           paramMap1.put(localObject2, localObject3);
/*     */         }
/*     */         
/* 519 */         break;
/*     */       default: 
/* 521 */         throw new g("type mismatch.");
/*     */       }
/* 523 */     } else if (paramBoolean) {
/* 524 */       throw new g("require field not exist.");
/*     */     }
/* 526 */     return paramMap1;
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
/*     */   private boolean[] d(int paramInt, boolean paramBoolean)
/*     */   {
/* 615 */     boolean[] arrayOfBoolean = null;
/* 616 */     if (a(paramInt)) {
/* 617 */       paramInt = new a();
/* 618 */       int j = paramInt;i locali = this;a(j, locali.a);
/* 619 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 622 */         if ((paramInt = a(0, 0, true)) < 0)
/* 623 */           throw new g("size invalid: " + paramInt);
/* 624 */         arrayOfBoolean = new boolean[paramInt];
/* 625 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++) {
/* 626 */           boolean bool = true;j = 0;locali = this; int i; arrayOfBoolean[paramBoolean] = ((i = a((byte)0, j, bool)) != 0 ? 1 : false); }
/* 627 */         break;
/*     */       
/*     */       default: 
/* 630 */         throw new g("type mismatch.");
/*     */       }
/* 632 */     } else if (paramBoolean) {
/* 633 */       throw new g("require field not exist.");
/*     */     }
/* 635 */     return arrayOfBoolean;
/*     */   }
/*     */   
/*     */   public final byte[] c(int paramInt, boolean paramBoolean) {
/* 639 */     Object localObject1 = null;
/* 640 */     if (a(paramInt)) {
/* 641 */       paramBoolean = new a();
/* 642 */       boolean bool = paramBoolean;localObject1 = this;a(bool, ((i)localObject1).a);
/* 643 */       int j; switch (paramBoolean.a) {
/*     */       case 13: 
/* 645 */         a locala = new a();
/* 646 */         Object localObject2 = locala;localObject1 = this;a((a)localObject2, ((i)localObject1).a);
/* 647 */         if (locala.a != 0) {
/* 648 */           throw new g("type mismatch, tag: " + paramInt + ", type: " + paramBoolean.a + ", " + locala.a);
/*     */         }
/*     */         
/* 651 */         if ((j = a(0, 0, true)) < 0)
/* 652 */           throw new g("invalid size, tag: " + paramInt + ", type: " + paramBoolean.a + ", " + locala.a + ", size: " + j);
/* 653 */         localObject1 = new byte[j];
/* 654 */         this.a.get((byte[])localObject1);
/* 655 */         break;
/*     */       case 9: 
/*     */         int i;
/*     */         
/* 659 */         if ((i = a(0, 0, true)) < 0)
/* 660 */           throw new g("size invalid: " + i);
/* 661 */         localObject1 = new byte[i];
/* 662 */         for (j = 0; j < i; j++)
/* 663 */           localObject1[j] = a(localObject1[0], 0, true);
/* 664 */         break;
/*     */       
/*     */       default: 
/* 667 */         throw new g("type mismatch.");
/*     */       }
/* 669 */     } else if (paramBoolean) {
/* 670 */       throw new g("require field not exist.");
/*     */     }
/* 672 */     return (byte[])localObject1;
/*     */   }
/*     */   
/*     */   private short[] e(int paramInt, boolean paramBoolean) {
/* 676 */     int i = null;
/* 677 */     short[] arrayOfShort; if (a(paramInt)) {
/* 678 */       paramInt = new a();
/* 679 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 680 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 683 */         if ((paramInt = a(0, 0, true)) < 0)
/* 684 */           throw new g("size invalid: " + paramInt);
/* 685 */         arrayOfShort = new short[paramInt];
/* 686 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++)
/* 687 */           arrayOfShort[paramBoolean] = a(arrayOfShort[0], 0, true);
/* 688 */         break;
/*     */       
/*     */       default: 
/* 691 */         throw new g("type mismatch.");
/*     */       }
/* 693 */     } else if (paramBoolean) {
/* 694 */       throw new g("require field not exist.");
/*     */     }
/* 696 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   private int[] f(int paramInt, boolean paramBoolean) {
/* 700 */     int i = null;
/* 701 */     int[] arrayOfInt; if (a(paramInt)) {
/* 702 */       paramInt = new a();
/* 703 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 704 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 707 */         if ((paramInt = a(0, 0, true)) < 0)
/* 708 */           throw new g("size invalid: " + paramInt);
/* 709 */         arrayOfInt = new int[paramInt];
/* 710 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++)
/* 711 */           arrayOfInt[paramBoolean] = a(arrayOfInt[0], 0, true);
/* 712 */         break;
/*     */       
/*     */       default: 
/* 715 */         throw new g("type mismatch.");
/*     */       }
/* 717 */     } else if (paramBoolean) {
/* 718 */       throw new g("require field not exist.");
/*     */     }
/* 720 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   private long[] g(int paramInt, boolean paramBoolean) {
/* 724 */     int i = null;
/* 725 */     long[] arrayOfLong; if (a(paramInt)) {
/* 726 */       paramInt = new a();
/* 727 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 728 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 731 */         if ((paramInt = a(0, 0, true)) < 0)
/* 732 */           throw new g("size invalid: " + paramInt);
/* 733 */         arrayOfLong = new long[paramInt];
/* 734 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++)
/* 735 */           arrayOfLong[paramBoolean] = a(arrayOfLong[0], 0, true);
/* 736 */         break;
/*     */       
/*     */       default: 
/* 739 */         throw new g("type mismatch.");
/*     */       }
/* 741 */     } else if (paramBoolean) {
/* 742 */       throw new g("require field not exist.");
/*     */     }
/* 744 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   private float[] h(int paramInt, boolean paramBoolean) {
/* 748 */     int i = null;
/* 749 */     float[] arrayOfFloat; if (a(paramInt)) {
/* 750 */       paramInt = new a();
/* 751 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 752 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 755 */         if ((paramInt = a(0, 0, true)) < 0)
/* 756 */           throw new g("size invalid: " + paramInt);
/* 757 */         arrayOfFloat = new float[paramInt];
/* 758 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++)
/* 759 */           arrayOfFloat[paramBoolean] = a(arrayOfFloat[0], 0, true);
/* 760 */         break;
/*     */       
/*     */       default: 
/* 763 */         throw new g("type mismatch.");
/*     */       }
/* 765 */     } else if (paramBoolean) {
/* 766 */       throw new g("require field not exist.");
/*     */     }
/* 768 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   private double[] i(int paramInt, boolean paramBoolean) {
/* 772 */     int i = null;
/* 773 */     double[] arrayOfDouble; if (a(paramInt)) {
/* 774 */       paramInt = new a();
/* 775 */       i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 776 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 779 */         if ((paramInt = a(0, 0, true)) < 0)
/* 780 */           throw new g("size invalid: " + paramInt);
/* 781 */         arrayOfDouble = new double[paramInt];
/* 782 */         for (paramBoolean = false; paramBoolean < paramInt; paramBoolean++)
/* 783 */           arrayOfDouble[paramBoolean] = a(arrayOfDouble[0], 0, true);
/* 784 */         break;
/*     */       
/*     */       default: 
/* 787 */         throw new g("type mismatch.");
/*     */       }
/* 789 */     } else if (paramBoolean) {
/* 790 */       throw new g("require field not exist.");
/*     */     }
/* 792 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   private <T> T[] a(T[] paramArrayOfT, int paramInt, boolean paramBoolean)
/*     */   {
/* 797 */     if ((paramArrayOfT == null) || (paramArrayOfT.length == 0))
/* 798 */       throw new g("unable to get type of key and value.");
/* 799 */     return b(paramArrayOfT[0], paramInt, paramBoolean);
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
/*     */   private <T> T[] b(T paramT, int paramInt, boolean paramBoolean)
/*     */   {
/* 818 */     if (a(paramInt)) {
/* 819 */       paramInt = new a();
/* 820 */       int i = paramInt;paramBoolean = this;a(i, paramBoolean.a);
/* 821 */       switch (paramInt.a)
/*     */       {
/*     */       case 9: 
/* 824 */         if ((paramInt = a(0, 0, true)) < 0)
/* 825 */           throw new g("size invalid: " + paramInt);
/* 826 */         paramBoolean = (Object[])Array.newInstance(paramT.getClass(), paramInt);
/* 827 */         for (i = 0; i < paramInt; i++) {
/* 828 */           Object localObject = a(paramT, 0, true);
/* 829 */           paramBoolean[i] = localObject;
/*     */         }
/* 831 */         return paramBoolean;
/*     */       }
/*     */       
/* 834 */       throw new g("type mismatch.");
/*     */     }
/* 836 */     if (paramBoolean) {
/* 837 */       throw new g("require field not exist.");
/*     */     }
/* 839 */     return null;
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
/*     */   public final k a(k paramk, int paramInt, boolean paramBoolean)
/*     */   {
/* 919 */     k localk = null;
/* 920 */     if (a(paramInt)) {
/*     */       try {
/* 922 */         localk = (k)paramk.getClass().newInstance();
/*     */       } catch (Exception paramk) {
/* 924 */         throw new g(paramk.getMessage());
/*     */       }
/*     */       
/* 927 */       paramk = new a();
/* 928 */       paramBoolean = paramk;paramInt = this;a(paramBoolean, paramInt.a);
/* 929 */       if (paramk.a != 10)
/* 930 */         throw new g("type mismatch.");
/* 931 */       localk.a(this);
/* 932 */       a();
/* 933 */     } else if (paramBoolean) {
/* 934 */       throw new g("require field not exist.");
/*     */     }
/* 936 */     return localk;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public final <T> Object a(T paramT, int paramInt, boolean paramBoolean)
/*     */   {
/* 945 */     if ((paramT instanceof Byte))
/* 946 */       return Byte.valueOf(a((byte)0, paramInt, paramBoolean));
/* 947 */     if ((paramT instanceof Boolean)) {
/* 948 */       paramBoolean = paramBoolean;paramInt = paramInt;paramT = this;return Boolean.valueOf((paramT = a((byte)0, paramInt, paramBoolean)) != 0); }
/* 949 */     if ((paramT instanceof Short))
/* 950 */       return Short.valueOf(a((short)0, paramInt, paramBoolean));
/* 951 */     if ((paramT instanceof Integer))
/*     */     {
/* 953 */       return Integer.valueOf(paramT = a(0, paramInt, paramBoolean)); }
/* 954 */     if ((paramT instanceof Long))
/* 955 */       return Long.valueOf(a(0L, paramInt, paramBoolean));
/* 956 */     if ((paramT instanceof Float))
/* 957 */       return Float.valueOf(a(0.0F, paramInt, paramBoolean));
/* 958 */     if ((paramT instanceof Double))
/* 959 */       return Double.valueOf(a(0.0D, paramInt, paramBoolean));
/* 960 */     if ((paramT instanceof String))
/* 961 */       return String.valueOf(b(paramInt, paramBoolean));
/* 962 */     boolean bool; if ((paramT instanceof Map)) {
/* 963 */       bool = paramBoolean;paramBoolean = paramInt;paramInt = (Map)paramT;paramT = this;return (HashMap)a(new HashMap(), paramInt, paramBoolean, bool); }
/* 964 */     if ((paramT instanceof List)) {
/* 965 */       bool = paramBoolean;paramBoolean = paramInt;paramInt = (List)paramT;paramT = this; if ((paramInt == null) || (paramInt.isEmpty())) return new ArrayList(); if ((paramT = paramT.b(paramInt.get(0), paramBoolean, bool)) == null) return null; paramInt = new ArrayList(); for (paramBoolean = false; paramBoolean < paramT.length; paramBoolean++) paramInt.add(paramT[paramBoolean]); return paramInt; }
/* 966 */     if ((paramT instanceof k))
/* 967 */       return a((k)paramT, paramInt, paramBoolean);
/* 968 */     if (paramT.getClass().isArray()) {
/* 969 */       if (((paramT instanceof byte[])) || ((paramT instanceof Byte[])))
/* 970 */         return c(paramInt, paramBoolean);
/* 971 */       if ((paramT instanceof boolean[]))
/* 972 */         return d(paramInt, paramBoolean);
/* 973 */       if ((paramT instanceof short[]))
/* 974 */         return e(paramInt, paramBoolean);
/* 975 */       if ((paramT instanceof int[]))
/* 976 */         return f(paramInt, paramBoolean);
/* 977 */       if ((paramT instanceof long[]))
/* 978 */         return g(paramInt, paramBoolean);
/* 979 */       if ((paramT instanceof float[]))
/* 980 */         return h(paramInt, paramBoolean);
/* 981 */       if ((paramT instanceof double[])) {
/* 982 */         return i(paramInt, paramBoolean);
/*     */       }
/* 984 */       return a((Object[])paramT, paramInt, paramBoolean);
/*     */     }
/*     */     
/* 987 */     throw new g("read object error: unsupport type.");
/*     */   }
/*     */   
/*     */ 
/* 991 */   private String b = "GBK";
/*     */   
/* 993 */   public final int a(String paramString) { this.b = paramString;
/* 994 */     return 0;
/*     */   }
/*     */   
/*     */   public static class a
/*     */   {
/*     */     public byte a;
/*     */     public int b;
/*     */   }
/*     */ }


/* Location:              /Users/chengjian/.gradle/caches/modules-2/files-2.1/com.tencent.bugly/crashreport/2.6.5/1a76df6177a2b84007012e84a34b056d2ca54f57/crashreport-2.6.5/classes.jar!/com/tencent/bugly/proguard/i.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */