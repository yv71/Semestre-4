
#include<p18f4550.h>
#include"remap.h"
#include<delays.h>
#define push_button PORTCbits.RC6
#define push_button2 PORTCbits.RC7

void main(void)
{
unsigned char val = 0x01;
int i;

OSCCON=0x66;
TRISB=0x00;

while(1)
	{	
	if(push_button == 0){
		if (val==0x80)
				val = 0x01;
		else val = val << 1;
		PORTB=val;
		
	}
	else {
		if (val==0x01)
				val = 0x80;
		else val = val >> 1;
		PORTB=val;
	}
	if(push_button2 == 0){
		Delay10KTCYx(20);
	}
	else{
		Delay10KTCYx(2);
	}
			
	}
	
}