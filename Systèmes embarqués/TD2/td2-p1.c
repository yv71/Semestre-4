#include<p18f452.h>
#include<timers.h>
#include"it.h"
#include<delays.h>
#include<usart.h>
#include<stdio.h>


int val_timer;
void init_appli(void)
{
OSCCON=0x66;
OpenTimer1( TIMER_INT_ON    &

            T1_16BIT_RW      &

            T1_SOURCE_INT   &

            T1_PS_1_1       &

            T1_OSC1EN_OFF   &

            T1_SYNC_EXT_OFF );

TRISB = 0xff ;
TRISC=0;
PORTC=0;
TRISD=0;
PORTD=0;
init_it_int0();

}

void affich_kmh(int vitesse)
{
if (vitesse > 99)
	{ 
	PORTCbits.RC0 = vitesse / 100;
	vitesse = vitesse -100;
	}
	else PORTCbits.RC0 = 0; 
PORTD = ((vitesse / 10) << 4) + vitesse % 10; 

}

void it_int0()
{
val_timer = ReadTimer1();
WriteTimer1(0);
}


void it_int1()
{
}

void it_tmr0()
{
}

void main(void)
{
long vitesse;
long vitesse_prec =0;
long K=1500000; /*****  A MODIFIER ********/

init_appli();
while(1)
	{	
	vitesse = K/ val_timer; 
	if(vitesse >= 130)
	{
		PORTCbits.RC7= 1;
	}
	else{
		PORTCbits.RC7 = 0;
	}
	if(vitesse_prec > vitesse)
	{
		PORTCbits.RC6= 1;
		PORTCbits.RC5 = 0;
	}
	else if(vitesse_prec < vitesse){
		PORTCbits.RC5= 1;
		PORTCbits.RC6 = 0;
	}
	else{
		PORTCbits.RC6= 0;
		PORTCbits.RC5 = 0;
	}
	vitesse_prec = vitesse;
	if (PORTBbits.RB1 ==0) {
		vitesse = vitesse / 1.609;
	}
 	affich_kmh((int)vitesse);
	}
	Delay10KTCYx(1);
}