clc;
clear ALL;
close ALL;

IMG1 = im2double(imread('lab06-pics/testpattern512.tif'));
subplot(2,3,1);
imshow(IMG1), title('Origin');

G1 = imnoise(IMG1,'gaussian',0.05);
subplot(2,3,2);
imshow(G1), title('Mild');

G2 = imnoise(IMG1,'gaussian',0.15);
subplot(2,3,3);
imshow(G2), title('Intermediate');

G3 = imnoise(IMG1,'gaussian',0.5);
subplot(2,3,4);
imshow(G3), title('Heavy');

G4 = imnoise(IMG1,'gaussian',1.5);
subplot(2,3,5);
imshow(G4), title('Extra heavy');