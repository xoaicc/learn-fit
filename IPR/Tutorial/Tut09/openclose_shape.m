clc;
clear all;

f = imread('lab09-pics\shapes.tif');
se = strel('square',40);
fo = imopen(f,se);

h_window{1} = figure('NumberTitle','off','Name','Erode Wirebond');
figure(h_window{1});

subplot(2,2,1);
imshow(f);
title('Origin');

subplot(2,2,2);
imshow(fo);
title('Open');

fc = imclose(f,se);

subplot(2,2,3);
imshow(fc);
title('Close');

foc = imclose(fo,se);

subplot(2,2,4);
imshow(foc);
title('Close of (b)');