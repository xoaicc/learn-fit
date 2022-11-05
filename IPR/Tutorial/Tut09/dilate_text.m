clc;
clear all;

A = imread('lab09-pics\broken_text.tif');
B = [0 1 0;
    1 1 1;
    0 1 0];

D = imdilate(A,B);

h_window{1} = figure('NumberTitle','off','Name','Dilate broken text');
figure(h_window{1});

subplot(1,2,1);
imshow(A);
title('Origin');

subplot(1,2,2);
imshow(D);
title('Dilate');