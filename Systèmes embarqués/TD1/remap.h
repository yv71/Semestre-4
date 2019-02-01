/** V E C T O R  R E M A P P I N G *******************************************/
extern void _startup (void);        // See c018i.c in your C18 compiler dir
#pragma code reset = 0x1000
	void _reset (void)
	{
	    _asm goto _startup _endasm
	}

#pragma code high_vector=0x08
void interrupt_at_high_vector(void)
{
    _asm goto 0x1008 _endasm
}
#pragma code low_vector=0x18
void interrupt_at_low_vector(void)
{
    _asm goto 0x1018 _endasm
}
#pragma code
