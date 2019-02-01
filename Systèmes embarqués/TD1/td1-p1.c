
#include<p18f4550.h>
#include"remap.h"
#include<delays.h>


void Delayms(int time)
{

	Delay1KTCYx(time);
}


void main(void)
{
OSCCON=0x66;
TRISB=0x00;
PORTBbits.RB1=~PORTBbits.RB1;
while(1)
	{	
	//Delay10KTCYx(100);  // voir dans C:\MCC18\doc l'aide hlpC18Lib
	Delayms(1000);
	PORTB=0x55;
	Delayms(1000);  // voir dans C:\MCC18\doc l'aide hlpC18Lib
	PORTB=0xAA;
	}
	
}