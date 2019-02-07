pkg load image;

img = imread('lena.jpg');
%img = inverseHisto(img);
img = normBoucles(img);
imshow(img);