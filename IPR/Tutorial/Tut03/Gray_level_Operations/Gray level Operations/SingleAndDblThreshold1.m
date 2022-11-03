%Single and multiple gray level thresholding
clc;
close all;
clear all;
F=rgb2gray(imread('home1.bmp')); %convert 24 bit to 8 bit
G=F; %initialize G
[rows cols]=size(F);

option=input('Enter 1 for single thresholding and 2 for double thresholding ');

if(option==1) 
T=input('Enter value for single thresholding ');
    for i=1:rows
        for j=1:cols
            if(F(i,j)< T)
            G(i,j)=0;
            else
            G(i,j)=255;
            end
        end
    end  
figure(1);
subplot(2,1,1);
imshow(F);
title('Original Image');
subplot(2,1,2);
imshow(G);
text=sprintf('After thresholding with T=%d',T);
title(text);

elseif(option==2)
T1=input('Enter value of T1(lower threshold gray level) ');
T2=input('Enter value of T2(higher threshold gray level) ');
    for i=1:rows
        for j=1:cols
            if(F(i,j)< T2 && F(i,j)>T1)
            G(i,j)=255;
            else
            G(i,j)=0;
            end
        end   
    end
figure(1);
subplot(2,1,1);
imshow(F);
title('Original Image');
subplot(2,1,2);
imshow(G);
text=sprintf('After thresholding with T1=%d and T2=%d',T1,T2);
title(text);

else
display(' Wrong Choice Entered!!! ');
end