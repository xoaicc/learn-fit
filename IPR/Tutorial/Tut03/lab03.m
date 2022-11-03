clc;
clear all;

% Task 1
I = imread('spillway.tif');
imshow(I);
title('Original Image');

J = imadjust(I,stretchlim(I),[]);
figure,imshow(J);
title('Stretchlim Transformation');

% Task 3
N = imcomplement (I);
imshow(N);
title('Negative Transformation');

r=double(I);
C=1;
S=C*log(1+r);
Temp=255/(C*log(256));
L=uint8(Temp*S);
figure,imshow(L);
title('Log Transformation');

G=0.40;
S=C*(r.^G);
Temp=255/(C*(255.^G));
GM=uint8(Temp*S);
figure,imshow(GM);
title('Gamma Transformation');

H = histeq(I);
figure,imhist(I,64);