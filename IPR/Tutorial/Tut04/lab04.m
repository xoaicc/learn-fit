clc;
clear all;

% Task 1
IMG1 = imread('lab04-pics/Lena256orig.jpg');
figure, imshow(IMG1), title('Origin');
h = ones(5,5) / 25;

PF1 = imfilter(IMG1, h);
figure, imshow(PF1), title('Zero-padding');

PF2 = imfilter(IMG1, h, 'replicate');
figure, imshow(PF2), title('Replication');

PF3 = imfilter(IMG1, h, 'symmetric');
figure, imshow(PF3), title('Symmetric');

% Task 2
%H = [0.3679 0.6065 0.3679; 0.6065 1.0000 0.6065; 0.3679 0.6065 0.3679];
%Y = filter2(H,IMG1,'full');
%mesh(Y)

% Task 3
H = imread('lab04-pics\text-spotshade.tif');
figure,imshow(H), title("before")
x= fspecial("sobel");
g2 = imfilter( H , x, 'symmetric' );
figure,imshow(g2 , [] ), title("after")

% Task 4
IMG2 = imread('lab04-pics/“checkerboard1024-shaded.tif');

IMG3 = imread('lab04-pics/text-spotshade.tif');