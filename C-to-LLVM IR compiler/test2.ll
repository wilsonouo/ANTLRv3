@.str0 = private unnamed_addr constant [15 x i8] c"t is equals 2\0A\00", align 1
@.str1 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
; === prologue ====
declare dso_local i32 @printf(i8*, ...)
define dso_local i32 @main()
{
%t0 = alloca i32, align 4
store i32 10, i32* %t0, align 4
br label %L1
L1:
%t1 = load i32, i32* %t0, align 4
%t2 = icmp ne i32 %t1, 1
br i1 %t2, label %L2, label %L3
L2:
%t3 = load i32, i32* %t0, align 4
%t4 = icmp eq i32 %t3, 2
br i1 %t4, label %L4, label %L5
L4:
%t5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([15 x i8], [15 x i8]* @.str0, i64 0, i64 0))
br label %L6
L5:
%t6 = load i32, i32* %t0, align 4
%t7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str1, i64 0, i64 0), i32 %t6)
br label %L6
L6:
%t8 = load i32, i32* %t0, align 4
%t9 = sub nsw i32 %t8, 1
store i32 %t9, i32* %t0, align 4
br label %L1
L3:

; === epilogue ===
ret i32 0
}
