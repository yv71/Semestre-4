pkg load image;

%Q1

img = imread('dog.png');
%imshow(img);

%Q2

[m,n,p] = size(img)

%Q3
imgGrey = rgb2gray(img);
%imshow(imgGrey);

%Q4

nb = sum(sum(imgGrey(:,:)==150))


%Q5
img2 = imread('fruits.jpg');
%pour extraire la matrice des composantes rouges de I
%R = img2(:,:,1)
%pour extraire la matrice des composantes vertes de I
%G = img2(:,:,2)
%pour extraire la matrice des composantes bleues de I
%B = img2(:,:,3)

%6
img2(50:59,50:59,1)=255;
img2(50:59,50:59,2)=0;
img2(50:59,50:59,3)=140;
imshow(img2);

%7
imwrite(img2,'fruits.jpg');



