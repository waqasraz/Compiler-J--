BINDIR	= /usr/bin

KERNEL	= a.out

run:	$(KERNEL)
	$(BINDIR)/qemu-system-arm -nographic -monitor null -cpu any -serial null -semihosting -kernel $(KERNEL)

clean:
	$(RM) *.o a.out
