.class public Lcom/example/testbreakpoint/Testsmail;
.super Ljava/lang/Object;
.source "Testsmail.java"


# direct methods
.method public constructor <init>()V
    .registers 1

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private test(I)I
    .registers 11
    .param p1, "a"    # I

    .prologue
    const/4 v8, 0x3

    const/4 v7, 0x2

    .line 11
    new-array v0, v8, [I

    fill-array-data v0, :array_3e

    .line 12
    .local v0, "aa":[I
    array-length v2, v0

    .line 13
    .local v2, "bb":I
    if-lez v2, :cond_11

    .line 14
    const-string v5, "gfdg"

    const-string v6, "sdsaff: "

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 16
    :cond_11
    invoke-direct {p0, v7}, Lcom/example/testbreakpoint/Testsmail;->testone(I)Z

    move-result v4

    .line 17
    .local v4, "isOne":Z
    mul-int/lit8 v1, p1, 0x2

    .line 18
    .local v1, "b":I
    if-eqz v4, :cond_3c

    .line 19
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1a
    const/4 v5, 0x4

    if-ge v3, v5, :cond_1f

    .line 20
    if-ne v3, v8, :cond_34

    .line 24
    :cond_1f
    const/4 p1, 0x1

    .line 25
    const-string v5, "gfdg"

    const-string v6, "test: "

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 26
    if-ne v1, v7, :cond_37

    .line 27
    const-string v5, "gfdg"

    const-string v6, "abc: "

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 28
    const/16 v1, 0xa

    move v5, v1

    .line 36
    .end local v3    # "i":I
    :goto_33
    return v5

    .line 19
    .restart local v3    # "i":I
    :cond_34
    add-int/lit8 v3, v3, 0x1

    goto :goto_1a

    .line 31
    :cond_37
    const/16 v1, 0xa

    .line 36
    .end local v3    # "i":I
    :goto_39
    mul-int v5, p1, v1

    goto :goto_33

    .line 34
    :cond_3c
    const/4 p1, 0x2

    goto :goto_39

    .line 11
    :array_3e
    .array-data 4
        0xa
        0x2
        0x3
    .end array-data
.end method

.method private testone(I)Z
    .registers 3
    .param p1, "i"    # I

    .prologue
    .line 40
    const/4 v0, 0x2

    if-ne p1, v0, :cond_5

    .line 41
    const/4 v0, 0x1

    .line 43
    :goto_4
    return v0

    :cond_5
    const/4 v0, 0x0

    goto :goto_4
.end method
