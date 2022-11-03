clc;
clear all;

% Ex1
A=[1 2 3; 2 3 4; 3 4 5];
B=[-1 2 -1; -3 -4 5; 2 3 -4];
C=[0 -2 -1; -3 4 2; 1 1 -7];

2*A-3*B
A.'
A*B-B*A
inv(B*C)
(A*B).'
(B.')*(A.')
(A.^2)+(B.^3)

% Ex2
det(A)
det(B)
det(C)
inv(A)

% Ex3
x=[0:0.1:10];
plot(x,tan(x))
figure,plot(x,tan(x)),axis([0,10,-10,10])