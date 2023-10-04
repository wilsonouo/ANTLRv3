@.str0 = private unnamed_addr constant [8 x i8] c"a = %d\0A\00", align 1
@.str1 = private unnamed_addr constant [8 x i8] c"c = %d\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)
define dso_local i32 @main()
{
%t0 = alloca i32, align 4
%t1 = alloca i32, align 4
%t2 = alloca i32, align 4
%t3 = alloca i32, align 4
store i32 1, i32* %t0, align 4
store i32 1, i32* %t2, align 4
%t4 = load i32, i32* %t2, align 4
%t5 = add nsw i32 %t4, 198
store i32 %t5, i32* %t3, align 4
store i32 1, i32* %t1, align 4
br label %L1
L1:
%t6 = load i32, i32* %t1, align 4
%t7 = icmp slt i32 %t6, 5
br i1 %t7, label %L2, label %L4
L3:
%t8 = load i32, i32* %t1, align 4
%t9 = add nsw i32 %t8, 1
store i32 %t9, i32* %t1, align 4
br label %L1
L2:
br label %L5
L5:
%t10 = load i32, i32* %t0, align 4
%t11 = icmp slt i32 %t10, 4
br i1 %t11, label %L6, label %L7
L6:
%t12 = load i32, i32* %t3, align 4
%t13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str0, i64 0, i64 0), i32 %t12)
%t14 = load i32, i32* %t0, align 4
%t15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([8 x i8], [8 x i8]* @.str1, i64 0, i64 0), i32 %t14)
%t16 = load i32, i32* %t0, align 4
%t17 = add nsw i32 %t16, 1
store i32 %t17, i32* %t0, align 4
br label %L5
L7:
store i32 1, i32* %t0, align 4
br label %L3
L4:

; === epilogue ===
ret i32 0
}
