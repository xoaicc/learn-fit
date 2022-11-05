clc;
clear all;

f = imread('lab09-pics\Fig0911(a).tif');
se = strel('square',5);
fo = imopen(f,se);

h_window{1} = figure('NumberTitle','off','Name','Erode Wirebond');
figure(h_window{1});

subplot(1,3,1);
imshow(f);
title('Origin');

subplot(1,3,2);
imshow(fo);
title('Open');

foc = imclose(f,se);

subplot(1,3,3);
imshow(foc);
title('Close');