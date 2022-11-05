clc;
clear all;

A = imread('lab09-pics\wirebond_mask.tif');
se = strel('disk', 10);
E10 = imerode(A, se);

h_window{1} = figure('NumberTitle', 'off', 'Name' , 'Erode Wirebond');
figure(h_window{1});

subplot(2, 2, 1);
imshow(A) ;
title('Origin');

subplot(2 ,2 ,2);
imshow(E10) ;
title('Erode disk 10');

se = strel('disk' , 5);
E5 = imerode (A, se);

subplot(2, 2, 3);
imshow(E5);
title('Erode disk 5');

E20 = imerode(A, strel('disk' , 20));

subplot(2, 2, 4) ;
imshow(E20);
title('Erode disk 20');