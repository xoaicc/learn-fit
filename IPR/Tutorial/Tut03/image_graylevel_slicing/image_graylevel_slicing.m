% Matlab program to demonstrate the concept of "Gray Level Slicing or
% Intensity Slicing". This program depends on image histogram.
clc;
clear all;
close all;
a = imread('football.jpg'); % Note: "football.jpg" is a Matlab image, for 
% better idea of matlab images, "help imdemos" in command window.
% converting the above color image into a gray level image
b = rgb2gray(a);
% calling the image size 
[m,n] = size(b);
% analyzing the above gray level image histogram using "imhist"
imshow(b); title('input image in gray level');
figure;
imhist(b);title('histogram of the input image at gray level');
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Note: Observe the "white colored stiches" on the "foot ball image" and
% corresponding "pixel intensities" in the histogram, we found that, white
% gray level pixels will be in the range from 240 to 255 therefore by using
% gray level slicing from 240 i.e., if the image intensity is greater than
% or equal to 240 make it equal to 255, else make it equal to 0 
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% initialing a null two dimentional array "c" with size equal to input imag
% using matlab command "zeros"
c = zeros(m,n);
% initialing the for loop
for i = 1:m
    for j = 1:n
        % use the condition 
        if b(i,j) >= 227  % try with defferent intensity levels in the range from 227 to 245 for better understanding
            c(i,j) = 255;
        else
            c(i,j) = 0;
        end
    end
end
% end of for loop
% here the logic is completed for "gray level" or "Intensity" Slicing
% Now showing the result 
% Here you will observe an excellent result and it will be very useful for
% the class room display 
figure;
imshow(c);title('gray level sliced image from an intensity level 240 onwards');
% hope you enjoyed the program please dont forget to give rating to my
% program and comments. for any questions please contact me at :
% samudrala.naren@gmail.com 
% S Jagadeesh, 
% Asst. Prof., Dept. of ECE, Aditya Engineering College, Surampalem, East
% Godavari Dist., Andhra Pradeh State, India. 

        