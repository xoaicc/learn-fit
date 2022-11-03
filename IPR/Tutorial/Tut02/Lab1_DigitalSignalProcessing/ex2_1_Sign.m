% Sign function
N = 10; % number of samples
n = -N/2:N/2; % vector
u = [zeros(1,N/2) 1 ones(1,N/2)]; %logic for sign function
x = 2.*u-1;
figure; % display
stem(n,x);
xlabel('n');
ylabel('x(n)');
title('Sign function');
axis([-N/2 N/2 -1 1]);