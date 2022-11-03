clc;
clear all;

% Task 1
IMG1 = imread('lab05-pics/cassini-interference.tif');
figure, imshow(IMG1), title('Origin');

notchSpecs  = fdesign.notch('N,F0,Q,Ap',6,0.5,10,1);
SystemObject = true;
notchFilt = design(notchSpecs,SystemObject);
fvtool(notchFilt)

% Task 2
