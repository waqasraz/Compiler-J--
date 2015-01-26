.text
.global _start
	add	 sp,#28 
	ldmfd sp!,{r4-r11,pc} 
_start:
	mov	r0,#1
	lsl	r0,#20			@ 2^20 bytes o' stack, no heap
	add	sp,r0 
	bl	rtsinit
	bl	M
	b	Lhalt
M:
	stmfd sp!,{r4-r11,lr} 
	 sub sp,#28 
	ldr	r4, =123
	str	r4, [ip,#0]		@:i
	ldr	r5, =456
	str	r5, [sp,#0]		@:j
	ldr	r4, [ip,#4]
	ldr	r6, =789
	str	r6, [ip,#4]		@:k
	ldr	r6, =42
	str	r6, [ip,#4]		@:k
	ldr	r5, =42
	str	r5, [sp,#0]			@:j
	ldr	r4, [ip,#8]
	ldr	r7, =42
	str	r7, [ip,#8]		@:i
	ldr	r8, =10
	str	r8, [sp,#4]		@:NL
	ldr	r7, [ip,#8]
	mov	 r0, r7
	bl	 Lprinti
	ldr	r8, [sp,#4]
	mov	 r0, r8
	bl	 Lprintc
	ldr	r5, [sp,#0]
	mov	 r0, r5
	bl	 Lprinti
	ldr	r8, [sp,#4]
	mov	 r0, r8
	bl	 Lprintc
	ldr	r6, [ip,#4]
	mov	 r0, r6
	bl	 Lprinti
	ldr	r8, [sp,#4]
	mov	 r0, r8
	bl	 Lprintc
	add sp,#28 
	ldmfd sp!, {r4-r11,pc} 


