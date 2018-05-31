        .data 
A:	.word 0 #A[4][4]
	.word 1
	.word 0
	.word 0
	.word 2
	.word 0
	.word 0
	.word 0
	.word 0
	.word 0
	.word 0
	.word 3
	.word 0
	.word 0
	.word 4
	.word 0
	
B:	.word 1 #B[4][4]
	.word 2
	.word 3
	.word 4
	.word 5
	.word 6
	.word 7
	.word 8
	.word 9
	.word 10
	.word 11
	.word 12
	.word 13
	.word 14
	.word 15
	.word 16
	
C:	.space 64 #array C space is 64 byte
	
N:  .word 4
D:	.word 32
S:	.word 0
        .text

main:
    la $8,A             #アドレスAを$8にストア
    la $10,C            #アドレスCを$10にストア
    lw $11,N            #アドレスNを$11にストア
	or $12,$0,$0 		#i=0

loopI:
    beq $12,$11,loopend    #if i==4, go to looIend
    la  $9,B                #アドレスBを$9にストア
	or  $13,$0,$0		    #j=0

loopJ:
    beq $13,$11,loopIend    #if j==4, go to loopJend
	or  $14,$0,$0		    #s=0
	or  $15,$0,$0		    #k=0

loopK:
    beq   $15,$11,loopJend	#if k==4 , go to loopKend
	addi  $16,$0,1		    #mask = 1
	lw    $a0,0($8)         # $a0 = 乗数
	lw    $a1,0($10)        # $a1 = 非乗数
    or    $21,$0,$0         #cnt=0
	jal   MUL
MUL:
	addi $17,$0,1	        # 乗数レジスタ用1bit変数
	addi $18,$0,32		    # 32bit
	or $19,$0,$0		    # i=0
	or $v0,$0,$0		    # 積を初期化
loopMUL:
	beq $19,$18,loopKend    # i == 32 のとき、loopendへ移動
	and $20,$a0,$17		    # $12 = 乗数$4の$8ビット目が1だったとき、１ else 0
	beq $20,$0,zero		    # $12 == 0 のとき、zeroへ移動
	addu $v0,$v0,$a1	    # $11(積) = $11 + $5(非乗数)
	j   zero		        # zeroへ移動
zero:
    addu $a1,$a1,$a1	    # 非乗数を1bit左へシフト
	addu $17,$17,$17	    # 乗数用レジスタを1bit左へシフト
	addi $19,$19,1		    # i++
	j    loopMUL		    # loopMUL へ移動

loopKend:
    addi $8,$8,4            # A+4
    addi $9,$9,16           # B+16
    addi $15,$15,1          # k++
    j loopK

loopJend:
    sw $v1,0($10)           # result[i][j]=v1
    addi $10,$10,4          # C+4
    addi $8,$8,-16          #A-16
    addi $9,$9,-60          #B-60
    j   loopJ

loopIend:
    addi $12,$12,1          #i++
    addi $8,$8,16           #A+16
    j   loopI

loopend:    j exit

exit:   j exit
