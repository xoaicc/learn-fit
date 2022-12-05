clc, clear ALL, close ALL;

A = imread('sphere-with-embedded-white-point.tif');
figure(1), imshow(A);
figure(2), imhist(A);