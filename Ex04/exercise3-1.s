1	.data
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
	
N:      .word 4

	.text
main:
	la $8,A   #アドレスAを$8にストア
	la $10,C  #アドレスCを$10にストア
	lw $11 N  #アドレスNを$11にストア
	or $12,$0,$0        #i=0
	
loopI:   
	beq $12,$11,loopend #if i==4,  loopend
	la $9,B             #アドレスBを$9にストア
	or $13,$0,$0 	    #j=0
	
loopJ:
	beq $13,$11, endIloopend   #if(j=4) jump to endI
	or $14,$0,$0 #s=0
	or $15,$0,$0 #k=0
	
loopK:
	beq $15,$11,endJ #if(k=4) jump to endJ
	addi $16,$0,1 #mask=1
	lw $17,0($8) #m1=A[i][k]
	lw $18,0($9) #m2=B[k][j]

	or $19,$0,$0 #cnt=0
loopC:	beq $19,$11,endK #if(cnt==4)endK #(calculate m1xm2)
	and $20,$16,$18 #m2&mask
	beq $20,$0,endC #if $20=0 jump to endC
	addu $14,$14,$17 #s+=m1

endC:	addu $16,$16,$16 #maks($16) left shift
	addu $17,$17,$17 #m1($17)left shift
	addi $19,$19,1 #cnt+=1

	j loopC #jump to loopC

endK:	addi $8,$8,4 #A+4(go to next COLUMN)
	addi $9,$9,16 #B+16 (go to next ROW)
	addi $15,$15,1 #k++

	j loopK #jump to loopK

endJloopend:	sw $14,0($10) #res[i][j]=s
		addi $10,$10,4 # C+4(to go to next adress)
		addi $8,$8,-16 #A-16(go to front COLOMN A[i][0])
		addi $9,$9,-60 #B−60(go to next  COLOMN[0][j])
		addi $13,$13,1 #j++

		j loopJ #jump to loopJ
	
endIloopend:	addi $12,$12,1 #i++
	addi $8,$8,16 #A+16(go to next ROW A[i][0])

	j loopI #jumo to loopI

loopend: j exit
	
exit:	J exit
	
	
	


	
	
	
