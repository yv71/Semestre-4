
#include<p18f4550.h>
#include"remap.h"
#include<delays.h>

char gest_clav(void)
{
	unsigned char masques[]={0b0111,0b1011,0b1101,0b1110};
	int ligne=0;
	int nb_lignes = sizeof(masques)/sizeof(unsigned char);
	unsigned char lecture;
	unsigned char colonnes[]={0b1110,0b1101,0b1011,0b0111};
	int nb_colonnes = sizeof(colonnes)/sizeof(unsigned char);
	int colonne;
	char clavier[4][4]={{'C','0','=', '+'},
						{'1','2','3', '-'},	
						{'4','5','6', '*'},
						{'7','8','9','/'}						

	};
	char touche=0;

	for(ligne=0;ligne<nb_lignes;ligne++)
	{
	// test de la ligne
		PORTD = masques[ligne]; // quartet faible = les lignes
		lecture = PORTD>>4; // quartet fort = les colonnes

		for(colonne=0;colonne<nb_colonnes;colonne++)
		{
			if (lecture == colonnes[colonne])  // touche appuyée
			{
				touche = clavier[ligne][colonne];
				break;	
			}
		}
		if(touche!=0) break;
	}				
	return touche;
}


void main(void)
{
OSCCON=0x66;
TRISB=0x00;
TRISD=0xF0;

while(1)
	{	
		PORTB= gest_clav();
	}	
}