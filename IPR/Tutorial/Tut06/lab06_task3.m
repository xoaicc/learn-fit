clc;
close ALL;

a = imread('lab06-pics/polymercell-pepper.tif');
subplot(3,2,1);
imshow(a), title('Pepper');

a1 = medfilt2(a,[7 7],'symmetric');
subplot(3,2,2);
imshow(a1), title('Restore pepper');

b = imread('lab06-pics/polymercell-salt.tif');
subplot(3,2,3);
imshow(b), title('Salt');

b1 = adpmedian(b,7);
subplot(3,2,4);
imshow(b1), title('Restore salt');

c = imread('lab06-pics/polymercell-salt&pepper.tif');
subplot(3,2,5);
imshow(c), title('Salt&Pepper');

c1 = adpmedian(c,9);
subplot(3,2,6);
imshow(c1), title('Restore pepper');