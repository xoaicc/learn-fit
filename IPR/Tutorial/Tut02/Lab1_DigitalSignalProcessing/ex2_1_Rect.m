% Rect function
M = 3;
N = 10; % number of samples
n = -N/2:N/2; % vector
Rect = [zeros(1,N/2-M) ones(1,2*M+1) zeros(1,N/2-M)];
%logic for rect
figure; % display
stem(n,Rect);
xlabel('n');
ylabel('rect');
title('Rect function');
axis([-N/2 N/2 0 1.1]);