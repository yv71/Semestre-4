#include<p18f4550.h>
//#include"remap.h"
#include<delays.h>
#include<adc.h>

unsigned char mise_a_echelle(int Tconv)
{
	unsigned char haha;
	haha = Tconv  / 5;
	return haha;
}

commande_chauffage(unsigned char seuil, unsigned char temp)
{
	if(temp < seuil)
	{
		PORTCbits.RC1 = 0;
	}
	else{
		PORTCbits.RC1 = 1;
	}
}

commande_ventilation(unsigned char seuil, unsigned char temp)
{
	if(temp > seuil)
	{
		PORTCbits.RC2 = 0;
	}
	else{
		PORTCbits.RC2 = 1;
	}
}

void affiche_val(unsigned char val)
{
	PORTD = ((val / 10) << 4) + val % 10; 
}

void main(void)
{
unsigned char Tconv;
unsigned char val;

OSCCON=0x66;
TRISD=0;
TRISC=0;

OpenADC( ADC_FOSC_32      &
         ADC_RIGHT_JUST   &
         ADC_16_TAD,
         ADC_CH0          &
         ADC_REF_VDD_VSS  &
         ADC_INT_OFF, 12  );


Delay10TCYx( 5 );     // Delay for 50TCY

while(1)
	{

  	ConvertADC();         // Start conversion
  	while( BusyADC() );   // Wait for completion

  	Tconv = ReadADC() >> 2;   // Read result
	
	val = mise_a_echelle(Tconv);

	affiche_val(val);
	commande_chauffage(15, val);
	commande_ventilation(28, val);

	}




	
}