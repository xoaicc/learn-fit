%Contrast Sretching

clc;
close all;
clear all;

F=imread('bitplane.bmp');
G=F;

[rows cols]=size(F);

T1=input('Enter value of t1(Threshold 1) ');
T2=input('Enter value of t2(Threshold 2) ');
s1=input('Enter value of slope 1 ');
s2=input('Enter value of slope 2 ');
s3=input('Enter value of slope 3 ');
coeffT1=s1.*T1;
coeffT2=s2.*(T2-T1)+coeffT1;
 for i=1:rows
    for j=1:cols
        if(F(i,j)< T1)
            G(i,j)=floor(s1.*F(i,j));
        elseif(F(i,j)>= T1 && F(i,j)< T2)
            G(i,j)=floor(s2.*(F(i,j)-T1)+coeffT1);
            elseif(F(i,j)>= T2)
            G(i,j)=floor(s3.*(F(i,j)-T2)+coeffT2);
        end
    end
 end

figure(1);
subplot(2,1,1);
imshow(F);
title('Original image');
subplot(2,1,2);
imshow(G);
text=sprintf('Result of Contrast Stretching with T1=%d, T2=%d, s1=%1.1f, s2=%1.1f, s3=%1.1f',T1,T2,s1,s2,s3);
title(text);

figure(2);
subplot(2,1,1);
imhist(F);
title('Histogram for original Image');

subplot(2,1,2);
imhist(G);
text1=sprintf('Histogram for Contrast Stretching with T1=%d, T2=%d, s1=%1.1f, s2=%1.1f, s3=%1.1f',T1,T2,s1,s2,s3);
title(text1);

  