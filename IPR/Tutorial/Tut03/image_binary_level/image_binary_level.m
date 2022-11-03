% Program to demonstrate the concept of "Bit Level Slicing" of a given gray
% level image
clc;
clear all;
close all;
% read an image
a = imread('cameraman.tif');
% Read image size
[m,n] = size(a);
% convert the image class from "uint8" to double
b = double(a);
% convert each pixel into binary using matlab command "de2bi"
c = de2bi(b);
% observe from the matrix "C" from the workspace, the matlab command
% "de2bi" will convert two dimentional array into a colomn matrix and each
% entry of the colomn matrix will be converted to binary 
% Note: while converting to binary using "de2bi", matllab output will be in
% "Big Endian" Format, therefore, the Left most bit will be MSB and
% rightmost bit will be LSB
%%%%%%%%%%%%%%
% calling the LSB Bit of each pixel 
c1 = c(:,1);
% onserve the above value in workspace its an array of Logic 1's and 0's of
% size 65536X1
% converting "C1" into equal size of input image using the matlab function
% "reshape"
r1 = reshape(c1,256,256);
% similarly calling every bit and converting into an arry of size 256X256
% 2nd Bit plane
c2 = c(:,2);
r2 = reshape(c2,256,256);
% 3rd Bit Plane
c3 = c(:,3);
r3 = reshape(c3,256,256);
% 4th Bit Plane
c4 = c(:,4);
r4 = reshape(c4,256,256);
% 5th Bit Plane
c5 = c(:,5);
r5 = reshape(c5,256,256);
% 6th Bit Plane
c6 = c(:,6);
r6 = reshape(c6,256,256);
% 7th Bit Plane
c7 = c(:,7);
r7 = reshape(c7,256,256);
% 8th Bit Plane
c8 = c(:,8);
r8 = reshape(c8,256,256);
% Displaying all the Bit Planes
subplot(241);
imshow(r1);title('LSB Bit Plane');
subplot(242);
imshow(r2);title('2nd Bit Plane');
subplot(243);
imshow(r3);title('3rd Bit Plane');
subplot(244);
imshow(r4);title('4th Bit Plane');
subplot(245);
imshow(r5);title('5th Bit Plane');
subplot(246);
imshow(r6);title('6th Bit Plane');
subplot(247);
imshow(r7);title('7th Bit Plane');
subplot(248);
imshow(r8);title('MSB Bit Plane');
% Hope you enjoyed the Program 
% for anyquestions about this program please contact me at:
% samudrala.naren@gmail.com
% Program Developed by:
% Jagadeesh Samudrala
% Asst. Prof.,
% Dept. of Electronics and Communication Engineering
% Aditya Engineering College
% Surampalem, East Godavari Dist., Andhra Pradesh, India.